package main;
	
import java.util.Locale;

import domein.DomeinController;
import gui.ChooseLanguage;
import gui.Commands;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class StartUpGUI extends Application {


	@Override
	public void start(Stage primaryStage) {

		ChooseLanguage root = new ChooseLanguage(new DomeinController());
		Scene scene = new Scene(root, 1400, 800);
		scene.getStylesheets().add(getClass()
				.getResource("/css/style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Splendor");
		primaryStage.show();
		
		primaryStage.setOnCloseRequest(Commands::closeCurrentWindow);

	}
	
	public static void main(String[] args) {
		
		Locale.setDefault(new Locale("en", "GB"));

		launch(args);
	}
	
}
