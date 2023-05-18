package gui;

import java.util.Optional;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import language.Language;

public class Commands {

	private final int 
		sceneWidth = 1400,
		sceneHeight = 800;

	/// STATIC
	public static void closeCurrentWindow(Event event) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(Language.bundle.getString("afsluiten"));
		alert.setHeaderText(Language.bundle.getString("benJeHetZeker"));
		Optional<ButtonType> result = alert.showAndWait();
		
		if(result.get() == ButtonType.OK) 
			Platform.exit();
		else
			event.consume();
		
	}

	/// NON-STATIC
	public void sceneConfig(Pane pane, Stage stage) {
		Scene scene = new Scene(pane, sceneWidth, sceneHeight);
		scene.getStylesheets().add(getClass()
				.getResource("/css/style.css").toExternalForm());
		stage.setScene(scene);

	}

}
