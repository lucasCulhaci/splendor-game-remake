package gui;

import java.util.Locale;

import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import language.Language;

public class ChooseLanguage extends BorderPane {

	DomeinController dc = new DomeinController();

	public ChooseLanguage(DomeinController dc) {

		this.dc = dc;
		buildGui();

	}
	
	private void buildGui() {
		
		HBox box;
		Region blank;

		Label lblWelcome = new Label("WELCOME");
		lblWelcome.getStyleClass().add("title");
		lblWelcome.setMaxWidth(Double.MAX_VALUE);
		lblWelcome.setAlignment(Pos.CENTER);
		

		Label lblSpeel = new Label("Speel!");
		lblSpeel.getStyleClass().add("labelsLanguages");
		Button btnDutch = new Button("Dutch");
		lblSpeel.setMaxWidth(Double.MAX_VALUE);
		lblSpeel.setAlignment(Pos.CENTER);
		btnDutch.setOnAction(this::buttonPushed);

		Label lblPlay = new Label("Play!");
		lblPlay.getStyleClass().add("labelsLanguages");
		Button btnEnglish = new Button("English");
		lblPlay.setMaxWidth(Double.MAX_VALUE);
		lblPlay.setAlignment(Pos.CENTER);
		btnEnglish.setOnAction(this::buttonPushed);

		Label lblJouer = new Label("Jouer!");
		lblJouer.getStyleClass().add("labelsLanguages");
		Button btnFrench = new Button("French");
		lblJouer.setMaxWidth(Double.MAX_VALUE);
		lblJouer.setAlignment(Pos.CENTER);
		btnFrench.setOnAction(this::buttonPushed);

		// Vertical per Language
		VBox left = new VBox();
		left.setSpacing(5);
		left.getChildren().addAll(lblSpeel, btnDutch);

		VBox middle = new VBox();
		middle.setSpacing(5);
		middle.getChildren().addAll(lblPlay, btnEnglish);

		VBox right = new VBox();
		right.setSpacing(5);
		right.getChildren().addAll(lblJouer, btnFrench);


		// Horizontal for all the languages
		box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.setSpacing(20);

		box.getChildren().addAll(left, middle, right);

		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		
		grid.setHgap(20);
		grid.setVgap(20);

		grid.add(lblWelcome, 0, 0, 3, 2);
		grid.add(box, 0, 3, 3, 1);

		this.setCenter(grid);
	
	}

	public void buttonPushed(ActionEvent event) {

		Language.keuzeTaal(((Button) event.getSource()).getText().trim().toLowerCase());

		nextScene();

	}

	public void nextScene() {
		
		AddingPlayers root = new AddingPlayers(dc);
		Scene scene = new Scene(root, 1400, 800);
		Stage stage = (Stage) this.getScene().getWindow();
		stage.setTitle("Splendor - Spelers");
		stage.setScene(scene);
		stage.show();
		
	}
}
