package gui;

import java.util.List;
import java.util.Map.Entry;

import domein.DomeinController;
import domein.EdelsteenType;
import dto.EdelsteenficheDTO;
import dto.KaartDTO;
import dto.OntwikkelingskaartDTO;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import language.Language;

public class StatusRonde extends BorderPane {

	DomeinController dc;

	HBox hboxTop = new HBox();

	// Status alle spelers
	HBox hbox = new HBox();
	HBox hboxBottom = new HBox();

	public StatusRonde(DomeinController dc) {

		this.dc = dc;
		buildGUI();

	}

	public void buildGUI() {

		this.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());

		buildTop();
		buildCenter();
		buildBottom();

	}

	public void buildTop() {

		hboxTop.setAlignment(Pos.CENTER);
		hboxTop.setPrefHeight(250);
		Label lblStatusHuidigeRonde = new Label(Language.bundle.getString("spelerStatus").toUpperCase());
		lblStatusHuidigeRonde.getStyleClass().add("labelTitelStatusRonde");
		lblStatusHuidigeRonde.setUnderline(true);
		;
		hboxTop.getChildren().add(lblStatusHuidigeRonde);

		this.setTop(hboxTop);

	}

	public void buildCenter() {

		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(50);

		for (int index = 0; index < dc.geefAlleSpelers().size(); index++) {

			Pane pane = new Pane();
			GridPane grid = new GridPane();
			grid.setVgap(5);

			// GEBRUIKERSNAAM
			String gebruikersnaam = dc.geefAlleSpelers().get(index).gebruikerNaam();
			Label lblWaardeGebruikersnaam = new Label(gebruikersnaam.toUpperCase());
			lblWaardeGebruikersnaam.getStyleClass().add("labelGebruikersnaamStatusRonde");
			grid.setHalignment(lblWaardeGebruikersnaam, HPos.CENTER);
			grid.add(lblWaardeGebruikersnaam, 0, 0);

			// EDELSTEENFICHES
			Label lblEdelsteenfiches = new Label(Language.bundle.getString("edelsteenfiches"));
			lblEdelsteenfiches.getStyleClass().add("labelTitelLabelStatusRonde");

			List<EdelsteenficheDTO> edelsteenfiches = dc.geefAlleSpelers().get(index).edelsteenfiches();
			Label lblWaardeEdelsteenfiche;

			if (edelsteenfiches.size() == 0) {
				lblWaardeEdelsteenfiche = new Label(Language.bundle.getString("leeg"));
			} else {
				String output = "";
				for (EdelsteenficheDTO type : edelsteenfiches) {
					output += type.toString() + "\n";
				}

				lblWaardeEdelsteenfiche = new Label(output);
			}

			grid.setHalignment(lblEdelsteenfiches, HPos.CENTER);
			grid.setHalignment(lblWaardeEdelsteenfiche, HPos.CENTER);
			grid.add(lblEdelsteenfiches, 0, 3);
			grid.add(lblWaardeEdelsteenfiche, 0, 4);

			// PRESTIGEPUNTEN
			Label lblPrestigepunten = new Label(Language.bundle.getString("prestigepunten"));
			lblPrestigepunten.getStyleClass().add("labelTitelLabelStatusRonde");

			String prestigepunten = Integer.toString(dc.geefAlleSpelers().get(index).prestigepunten());
			Label lblWaardePrestigepunten = new Label(prestigepunten);

			grid.setHalignment(lblPrestigepunten, HPos.CENTER);
			grid.setHalignment(lblWaardePrestigepunten, HPos.CENTER);
			grid.add(lblPrestigepunten, 0, 6);
			grid.add(lblWaardePrestigepunten, 0, 7);

			// ONTWIKKELINGSKAART
			Label lblOntwikkelingskaarten = new Label(Language.bundle.getString("ontwikkelingskaarten"));
			lblOntwikkelingskaarten.getStyleClass().add("labelTitelLabelStatusRonde");

			List<OntwikkelingskaartDTO> ontwikkelingskaarten = dc.geefAlleSpelers().get(index).ontwikkelingsKaarten();
			Label lblWaardeOntwikkelingskaart;

			if (ontwikkelingskaarten.size() == 0) {
				lblWaardeOntwikkelingskaart = new Label("Leeg");
			} else {
				String output = "";

				List<OntwikkelingskaartDTO> values = dc.geefAlleSpelers().get(index).ontwikkelingsKaarten();

				for (OntwikkelingskaartDTO value : values) {
					output += Language.bundle.getString("kost");
					for (Entry<EdelsteenType, Integer> waarden : value.kost().entrySet()) {
						output += waarden.toString() + "\n";
					}

					output += Language.bundle.getString("prestige");
					output += Integer.toString(value.prestige()) + "\n";

					output += Language.bundle.getString("edelsteentype");
					output += value.type().name() + "\n";

					output += Language.bundle.getString("niveau");
					output += Integer.toString(value.niveau());

					output += "\n \n";
				}

				lblWaardeOntwikkelingskaart = new Label(output);
			}

			grid.setHalignment(lblOntwikkelingskaarten, HPos.CENTER);
			grid.setHalignment(lblWaardeOntwikkelingskaart, HPos.CENTER);
			grid.add(lblOntwikkelingskaarten, 0, 9);
			grid.add(lblWaardeOntwikkelingskaart, 0, 10);

			// EDELEN
			Label lblEdelen = new Label(Language.bundle.getString("edelen"));
			lblEdelen.getStyleClass().add("labelTitelLabelStatusRonde");

			List<KaartDTO> edelen = dc.geefAlleSpelers().get(index).edelen();
			Label lblWaardeEdelen;

			if (edelen.size() == 0) {
				lblWaardeEdelen = new Label("Leeg");
			} else {
				String output = "";

				output += Language.bundle.getString("kost");

				for (KaartDTO value : edelen) {

					for (Entry<EdelsteenType, Integer> waarde : value.kost().entrySet()) {
						output += waarde.toString() + "\n";
					}

					output += Language.bundle.getString("prestige");
					output += Integer.toString(value.prestige());

				}

				lblWaardeEdelen = new Label(output);
			}

			grid.setHalignment(lblEdelen, HPos.CENTER);
			grid.setHalignment(lblWaardeEdelen, HPos.CENTER);
			grid.add(lblEdelen, 0, 12);
			grid.add(lblWaardeEdelen, 0, 13);

			pane.getChildren().add(grid);
			hbox.getChildren().add(pane);
		}

		this.setCenter(hbox);
	}

	public void buildBottom() {

		hboxBottom.setAlignment(Pos.CENTER);
		hboxBottom.setPrefHeight(100);

		Button btnSpeelBeurt = new Button(Language.bundle.getString("startRonde"));
		btnSpeelBeurt.setPrefWidth(200);
		btnSpeelBeurt.setPrefHeight(50);

		btnSpeelBeurt.setOnAction(event -> {
			nextScene();
		});

		hboxBottom.getChildren().add(btnSpeelBeurt);
		this.setBottom(hboxBottom);

	}

	public void nextScene() {
		BeurtSpeler root = new BeurtSpeler(dc, 0);
		Scene scene = new Scene(root, 1400, 800);
		Stage stage = (Stage) this.getScene().getWindow();
		stage.setTitle("Splendor - Beurt");
		stage.setScene(scene);
		stage.show();
	}

}
