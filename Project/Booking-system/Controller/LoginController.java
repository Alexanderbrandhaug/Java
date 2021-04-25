package project_reservation;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Stage window1 = new Stage();
    Stage window2 = new Stage();
    HotelControllerApp app = new HotelControllerApp();
   
    
    
    


    
    @FXML
    void loginBtn(ActionEvent event) throws Exception {
    	window1.setScene(new Scene(FXMLLoader.load(getClass().getResource("login.fxml"))));
    	window2.setTitle("Booking-manager");
    	window2.setScene(new Scene(FXMLLoader.load(getClass().getResource("Reservation1.fxml"))));
    	
    	
    	try {
			conn = MySQLconnect.DBconnect();
			String query = "SELECT * FROM users WHERE username=? and password = ?";
			pst = conn.prepareStatement(query);
			pst.setString(1, usernameField.getText());
			pst.setString(2, passwordField.getText());
			rs = pst.executeQuery();
			if(rs.next()) {
				this.window1.close();
				Alertbox.display("Success", "successfully logged in");
				window2.show();
			
	
			}
    	else {
				Alertbox.display("Failed", "password or username did not match");
			}
    	
			
			
			
			
    	} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}
