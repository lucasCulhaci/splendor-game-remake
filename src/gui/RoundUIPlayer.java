package gui;

import java.util.List;

import domein.DomeinController;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RoundUIPlayer extends Stage {

	DomeinController dc;

	String gebruikersnaam;
	List ontwikkelingskaartType;
	List ontwikkelingskaartPrestige;
	List edelsteenfischeType;
	List edelsteenfischeAantal;
	List edelPrestige;
	List edelKost;

	// Label
//	Label lblNaamSpeler;
//	Label lblTotaalAantalPrestigePunten;
//	Label lblSmarargd;
//	Label lblDiamant;
//	Label lblSaffier;
//	Label lblRobijn;

	private Label lblEmpty = new Label("Empty: ");
	private Label ZERO = new Label("0");

	BorderPane borderPane;
	GridPane gridPane;
	HBox hboxTop;

	HBox hboxCenter;
	GridPane gridPaneOntwikkelingskaart;
	GridPane gridPaneEdelsteenfiches;
	GridPane gridPaneEdelen;

	HBox hboxBottom;

	public RoundUIPlayer(DomeinController dc, String gebruikersnaam, List ontwikkelingskaartType,
			List ontwikkelingskaartPrestige, List edelsteenfischeType, List edelsteenfischeAantal, List edelPrestige,
			List edelKost) {

		this.dc = dc;

		this.gebruikersnaam = gebruikersnaam;
		this.ontwikkelingskaartType = ontwikkelingskaartType;
		this.ontwikkelingskaartPrestige = ontwikkelingskaartPrestige;
		this.edelsteenfischeType = edelsteenfischeType;
		this.edelsteenfischeAantal = edelsteenfischeAantal;
		this.edelPrestige = edelPrestige;
		this.edelKost = edelKost;

		lblEmpty.getStyleClass().add("labelCenterRoundUIPlayer");
		ZERO.getStyleClass().add("labelCenterRoundUIPlayer");

		buildGui();

		Scene scene = new Scene(borderPane, 1400, 800);
		scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
		this.setScene(scene);

	}

	public void buildGui() {

		borderPane = new BorderPane();
		topPanel();
		centerPanel();

	}

	public void topPanel() {
		hboxTop = new HBox();
		hboxTop.setStyle("-fx-background-color: green;");
		hboxTop.setPrefHeight(200);
		Label lblGebruikersnaam = new Label(gebruikersnaam);
		hboxTop.getChildren().add(lblGebruikersnaam);
		hboxTop.setAlignment(Pos.CENTER);
		borderPane.setTop(hboxTop);
	}

	public void centerPanel() {

		hboxCenter = new HBox();
		hboxCenter.setSpacing(40);
		hboxCenter.setAlignment(Pos.CENTER);

		// ONTWIKKELINGSKAART
		gridPaneOntwikkelingskaart = new GridPane();
		gridPaneOntwikkelingskaart.setVgap(5);

		if (ontwikkelingskaartType.size() == 0) {
			gridPaneOntwikkelingskaart.add(lblEmpty, 0, 0);
			gridPaneOntwikkelingskaart.add(ZERO, 1, 0);
		} else {
			for (int index = 0; index < ontwikkelingskaartType.size(); index++) {

				Label lblType = new Label((ontwikkelingskaartType.get(index).toString() + " - "));
				lblType.getStyleClass().add("labelCenterRoundUIPlayer");
				Label lblPrestige = new Label(Integer.toString((int) ontwikkelingskaartPrestige.get(index)));
				lblPrestige.getStyleClass().add("labelCenterRoundUIPlayer");

				gridPaneOntwikkelingskaart.add(lblType, 0, index);
				gridPaneOntwikkelingskaart.add(lblPrestige, 1, index);
			}
		}

		// EDELSTEENFICHES
		gridPaneEdelsteenfiches = new GridPane();

		for (int index = 0; index < edelsteenfischeType.size(); index++) {

			Label lblType = new Label(edelsteenfischeType.get(index).toString() + ": ");
			lblType.getStyleClass().add("labelCenterRoundUIPlayer");
			Label lblAantal = new Label((Integer.toString((int) edelsteenfischeAantal.get(index))));
			lblAantal.getStyleClass().add("labelCenterRoundUIPlayer");

			gridPaneEdelsteenfiches.add(lblType, 0, index);
			gridPaneEdelsteenfiches.add(lblAantal, 1, index);
		}

		// EDELEN - MOET MOGELIJKS NOG AANGEPAST WORDEN
		gridPaneEdelen = new GridPane();
//		gridPaneEdelen.setStyle("-fx-background-color: red;");

		if (edelPrestige.size() == 0) {
			;
			gridPaneEdelen.add(lblEmpty, 0, 0);
			gridPaneEdelen.add(ZERO, 1, 0);
		} else {
			for (int index = 0; index < ontwikkelingskaartType.size(); index++) {

				Label lblPrestige = new Label(edelPrestige.get(index).toString() + ": ");
				lblPrestige.getStyleClass().add("labelCenterRoundUIPlayer");
				Label lblKost = new Label(Integer.toString((int) edelKost.get(index)));
				lblKost.getStyleClass().add("labelCenterRoundUIPlayer");

				gridPaneEdelen.add(lblPrestige, 0, index);
				gridPaneEdelen.add(lblKost, 1, index);
			}
		}

		hboxCenter.getChildren().addAll(gridPaneOntwikkelingskaart, gridPaneEdelen, gridPaneEdelsteenfiches);

		// BORDERPANE
		borderPane.setCenter(hboxCenter);
	}

}
