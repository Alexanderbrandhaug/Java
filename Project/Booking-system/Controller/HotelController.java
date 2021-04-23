
package project_reservation;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

															
		public class HotelController implements Initializable{
		private Hotel hotel = new Hotel();
		private ObservableList<Reservation> observableList = FXCollections.observableArrayList();
		private Reservation nybooking1;
		private int ID;
		private int priceController = 899;

      @FXML private TextField inputLoadFile;
      @FXML private TextField inputFilename;
      @FXML private TextField inputName;
      @FXML private TextField inputEmail;
	    @FXML private TextField inputPhoneNum;
	    @FXML private DatePicker inputFromDate;
	    @FXML private DatePicker inputToDate;
	    @FXML private TableView<Reservation> tableview;
	    @FXML private TableColumn<Reservation, String> name;
	    @FXML private TableColumn<Reservation, String> email;
	    @FXML private TableColumn<Reservation, String> phoneNum;
	    @FXML private TableColumn<Reservation, LocalDate> colFromDate;
	    @FXML private TableColumn<Reservation, LocalDate> colToDate;
	    @FXML private TableColumn<Reservation, Integer> colBookingId;
	    @FXML private TableColumn<Reservation, Integer> priceColumn;
	    @FXML private Text numOfBookingsField;
	    @FXML private TextField inputSearchField;
	    @FXML private TextField nameField;
	    @FXML private TextField emailField;
	    @FXML private TextField phoneField;
	    @FXML private TextField bookedFromField;
	    @FXML private TextField bookedtoField;
	    @FXML private Text custCardId;
	    @FXML private TextField priceCustInfo;
  
   
	    
	    @Override
		public void initialize(URL url, ResourceBundle rb) {
	    
	    name.setCellValueFactory(new PropertyValueFactory<Reservation, String>("name"));
	    email.setCellValueFactory(new PropertyValueFactory<Reservation, String>("email"));
	    phoneNum.setCellValueFactory(new PropertyValueFactory<Reservation, String>("phoneNumber"));
	    colFromDate.setCellValueFactory(new PropertyValueFactory<Reservation, LocalDate>("fromDate"));
	    colToDate.setCellValueFactory(new PropertyValueFactory<Reservation, LocalDate>("toDate"));
	    colBookingId.setCellValueFactory(new PropertyValueFactory <Reservation, Integer> ("id"));
	    priceColumn.setCellValueFactory(new PropertyValueFactory <Reservation, Integer> ("price"));
	    tableview.setItems(observableList);

    
    }
	    public boolean checkIfIdExists(int i, List<Reservation> list) {
	    	for(Reservation booking : list) {
	    		if(i == booking.getId()) {
	    			return true;
	    		}
	    	}
			return false;
	    }
	    
	    @FXML
	    void searchBtn(ActionEvent event) {
	    		
	    	
	    try {	
	    	
	    	
	    if(observableList.isEmpty()) {
	    	System.out.println("TEST1");
	    	throw new IllegalArgumentException("There does not exists any bookings yet");
	    }
	    	
	    	
	    if(inputSearchField.getText().trim().isEmpty()) {
	    	throw new IllegalArgumentException("Please insert a valid customer ID");
	    	
	    }
	    
	    
	    int inputIDasInt = Integer.parseInt(inputSearchField.getText());
	    if(checkIfIdExists(inputIDasInt, observableList)) {
	    
    	String name = hotel.getBooking(Integer.parseInt(inputSearchField.getText())).getName();
    	String phone = hotel.getBooking(Integer.parseInt(inputSearchField.getText())).getPhoneNumber();
    	String email = hotel.getBooking(Integer.parseInt(inputSearchField.getText())).getEmail();
    	LocalDate fromDate = hotel.getBooking(Integer.parseInt(inputSearchField.getText())).getFromDate();
    	LocalDate toDate = hotel.getBooking(Integer.parseInt(inputSearchField.getText())).getToDate();
    	int idCard = hotel.getBooking(Integer.parseInt(inputSearchField.getText())).getId();
    	int price = hotel.getBooking(Integer.parseInt(inputSearchField.getText())).getPrice();
    	nameField.setText(name);
    	emailField.setText(email);
    	phoneField.setText(phone);
    	bookedFromField.setText(fromDate.toString());
    	bookedtoField.setText(toDate.toString());
    	custCardId.setText(String.valueOf(idCard));
    	priceCustInfo.setText(String.valueOf(price));
    	System.out.println(observableList + "OBS LISTA NÅR SØK");
    	System.out.println(hotel.getAllBookings() + "HOTELL LISTA NÅR SØK");
    	
	    
	    }   
	    else{
	    	inputSearchField.clear();
	    throw new IllegalArgumentException("This ID does not exist");
	    
	    }
	    }
	    catch(Exception e) {
	    	Alertbox.display("Error", e.getMessage());
	    	
	    }
    	
    	
    }

	    @FXML
	    void editBtn(ActionEvent event) {
	    if(!nameField.getText().isBlank()) {	
    	nameField.setEditable(true);
    	emailField.setEditable(true);
    	phoneField.setEditable(true);
    	bookedFromField.setEditable(true);
    	bookedtoField.setEditable(true);
	    }
    }
    
    
	    
	    @FXML
	    void saveEditBtn(ActionEvent event)  {
    
    	
    	try {
    		if(nameField.getText().isBlank()) {
    			throw new IllegalArgumentException("There is nothing to save");
    		}
    	
    	int IdToString = Integer.parseInt(inputSearchField.getText());
    	LocalDate fromDate = LocalDate.parse(bookedFromField.getText());
    	LocalDate toDate = LocalDate.parse(bookedtoField.getText());
    	System.out.println(hotel.getBooking(IdToString));
    	
    	nybooking1 = hotel.getBooking(IdToString);
    	nybooking1.setName(nameField.getText());
    	nybooking1.setEmail(emailField.getText());
    	nybooking1.setPhoneNumber(phoneField.getText());
    	nybooking1.setDate(fromDate, toDate);
    	nybooking1.setPrice();
    	observableList.clear();
    	observableList.addAll(hotel.getAllBookings());
    	tableview.setItems(observableList);
    	nameField.setEditable(false);
    	emailField.setEditable(false);
    	phoneField.setEditable(false);
    	bookedFromField.setEditable(false);
    	bookedtoField.setEditable(false);
    	nameField.clear();
    	emailField.clear();
    	phoneField.clear();
    	bookedFromField.clear();
    	bookedtoField.clear();
    	inputSearchField.clear();
    	priceCustInfo.clear();
    	custCardId.setText("");
    	Alertbox.display("Success", "Saved changes");
    	
    	
    	} catch (Exception e) {
    		Alertbox.display("Error!", e.getMessage());
    	}
    }
    	

    
		    
     @FXML
	 void bookNowBtn(ActionEvent event) {
    	 LocalDate dfrom = inputFromDate.getValue();
    	 LocalDate dto = inputToDate.getValue();
    	
    	 
    	 
    	 
    
    	try { 
    		if (inputFromDate.getValue() == null || inputToDate.getValue() == null) {
    			throw new IllegalArgumentException("You must choose dates");
    		}
    	  nybooking1 = new Reservation(this.ID, inputName.getText(), inputEmail.getText(),inputPhoneNum.getText(),dfrom, dto, priceController);
    	  nybooking1.setId(ID);
    	  nybooking1.setDate(dfrom, dto);
    	  nybooking1.setPrice();
    	  hotel.isBooked(nybooking1);
    	  hotel.addBooking(nybooking1); 	 
    	  tableview.getItems().add(nybooking1);
    	  numOfBookingsField.setText(String.valueOf(observableList.size()));
    	  clearFields();
    	
    	}

    	catch (Exception e) {
    		Alertbox.display("Error!", e.getMessage());
    		
    	}
    	 
    	
	 
	 
     }   	
		   public void clearFields() {
			   inputName.clear();
			   inputEmail.clear();
			   inputPhoneNum.clear();
			   
			   
		   }
		  
		    
		   @FXML
		   public void saveBtn(ActionEvent event) {
			   WriteRead writer = new WriteRead();
			   
			   
			   try {
			   if (inputFilename.getText().trim().isEmpty()) {
				   throw new IllegalArgumentException("Input filename"); 
				   
			   }
			   if (observableList.isEmpty()) {
				   throw new IllegalArgumentException("There is nothing to save "); 
				   
			   }
			   
				   
				   
			   
			   writer.writeToFile(inputFilename.getText(), observableList);
			   Alertbox.display("Saved" + inputLoadFile.getText(), "Successfully saved");
			   inputFilename.clear();
			   observableList.clear();
			   hotel.clearList();
			   numOfBookingsField.setText(String.valueOf(observableList.size()));
			   
			   } 
			   
			   catch(Exception e) {
				   Alertbox.display("Error!", e.getMessage());
			   }
			   
			   }
		   
		   
		    
		   @FXML
		    void loadBtn(ActionEvent event)   {
			   		
			   try {
				   
			   if(!observableList.isEmpty()) {
				   inputLoadFile.clear();
			   			throw new IllegalArgumentException("You need to save before you can upload");
			   			
			   		}
			   if(inputLoadFile.getText().isBlank()) {
				   throw new IllegalArgumentException("Input valid Filename");
			   }
			   	
				   WriteRead br = new WriteRead();
				   
					br.getBookingsFromFile(inputLoadFile.getText());
					hotel.getAllBookings().clear();
				
				   for(Reservation ele: br.hotel.getAllBookings()) {
					   if(!observableList.contains(ele));
					   observableList.add(ele);

				   } for(Reservation ele: observableList) {
					   if(!hotel.getAllBookings().contains(ele))
					   hotel.addBookingFromFile(ele);
				   }
				   tableview.setItems(observableList);
				   tableview.getItems();
				   inputLoadFile.clear();
				   numOfBookingsField.setText(String.valueOf(observableList.size()));
			
				   Alertbox.display("Loading" ,  "Bookings successfully loaded from file: " + inputLoadFile.getText());
				
				  
			
		   } catch (Exception e) {
				Alertbox.display("Error!", e.getMessage());
				
		   }
		   }   
		   
		   @FXML
		    void deleteBooking(ActionEvent event) {
			 
			   try {
				   if(nameField.getText().trim().isBlank() || inputSearchField.getText().isBlank()) {
					   throw new IllegalArgumentException("You need to look up a booking before you can delete");
				   }
			   String f = inputSearchField.getText();
			   int k = Integer.parseInt(f);  
			   hotel.deleteBooking(k);	
			   observableList.removeAll(observableList); 
			   observableList.addAll(hotel.getAllBookings());
			 
		   
			   tableview.setItems(observableList);
			   numOfBookingsField.setText(String.valueOf(observableList.size()));
			   nameField.clear();
			   emailField.clear();
			   phoneField.clear();
			   bookedFromField.clear();
			   bookedtoField.clear();
			   inputSearchField.clear();
			   priceCustInfo.clear();
			   custCardId.setText("");
			   
			   
			  
		    } catch(Exception e) {
		    	Alertbox.display("Error!", e.getMessage());
		    }
		   	
		   }
	}
