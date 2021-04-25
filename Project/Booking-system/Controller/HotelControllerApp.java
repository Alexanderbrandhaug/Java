package project_reservation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HotelControllerApp extends Application {

	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("Bookify");
		primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Login.fxml"))));
		primaryStage.show();
		
		
		
	}
	

	
	public static void main(String[] args) {
		Application.launch(args);
	}
	}
