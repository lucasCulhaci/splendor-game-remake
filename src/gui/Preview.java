package gui;
//package gui;
//
//
//import javafx.geometry.Insets;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.ColumnConstraints;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Priority;
//import javafx.stage.Stage;
//
//public class Preview extends GridPane{
//
//	ChooseLanguage chooseLanguage;
//	AddingPlayers addingPlayers;
//	GameBoard gameboard;
//	Cards cards;
//
//	public Preview() {
//
//		chooseLanguage = new ChooseLanguage();
//		addingPlayers = new AddingPlayers();
//		gameboard = new GameBoard();
//		cards = new Cards();
//		
//		/// General Configuration
//		ColumnConstraints col1 = new ColumnConstraints();
//		col1.setHgrow(Priority.ALWAYS);
//		ColumnConstraints col2 = new ColumnConstraints();
//		this.getColumnConstraints().addAll(col1, col2);
//
//		this.setPadding(new Insets(10));
//		this.setVgap(10);
//
//		/// Selecting a language
//		// createPreview(chooseLanguage, "Language", 0, 0);
//
//		// Adding players
//		createPreview(addingPlayers, "Adding players", 0, 1);
//
//		/// Showing the gameboard
//		createPreview(gameboard, "Gameboard", 0, 2);
//
//		/// Showing all the available cards
//		createPreview(cards, "Cards", 0, 3);
//	}
//
//	public void createPreview(Stage stageName, String title, int column, int row) {
//		Label nameLabel = new Label(stageName.getClass().getSimpleName().toString());
//		Button nameButton = new Button("Show");
//
//		nameButton.setOnAction(event -> {
//			stageName.setTitle(title);
//			stageName.show();
//		});
//		
//		this.add(nameLabel, column, row);
//		this.add(nameButton, column + 1, row);
//	}
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
