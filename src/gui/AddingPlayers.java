package gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import domein.DomeinController;
import dto.SpelerDTO;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import language.Language;

public class AddingPlayers extends BorderPane {

	DomeinController dc;

	String name;
	String age;

	GridPane grid;
	VBox vbox;
	HBox hbox;
	TextField txfName;
	TextField txfAge;
	Button btnAdd;
	Button btnStop;
	boolean status = false;

	public AddingPlayers(DomeinController dc) {

		this.dc = dc;
		this.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());

		buildGui();

	}

	public void buildGui() {

		vbox = new VBox();
		vbox.setAlignment(Pos.CENTER_RIGHT);
		vbox.setPrefWidth(700);

		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPrefWidth(700);

		final String name;
		String age;

		/// Single Player
		txfName = new TextField();
		txfAge = new TextField();

		btnAdd = new Button(Language.bundle.getString("toevoegen"));
		btnAdd.setMaxWidth(Double.MAX_VALUE);

		btnStop = new Button(Language.bundle.getString("stop"));
		btnStop.setMaxWidth(Double.MAX_VALUE);

		Label lblGebruikersnaamLabel = new Label(Language.bundle.getString("gebruikersnaam"));
		Label lblGeboortejaarLabel = new Label(Language.bundle.getString("geboortejaar"));
		grid.setVgap(5);
		grid.add(lblGebruikersnaamLabel, 0, 0);
		grid.add(txfName, 0, 1);
		grid.add(lblGeboortejaarLabel, 0, 3);
		grid.add(txfAge, 0, 4);
		grid.add(btnAdd, 0, 6);
		grid.add(btnStop, 0, 7);

		btnAdd.setOnAction(event -> {

			try {
				


				this.name = txfName.getText();
				this.age = txfAge.getText();

				meldAan();
				
				if(this.name.equals("") || this.age.equals(""))
					throw new NumberFormatException();

				txfName.clear();
				txfAge.clear();

				vbox.getChildren().clear();

				for (int index = 0; index < dc.geefAlleSpelers().size(); index++) {

					hbox = new HBox();
					hbox.setAlignment(Pos.BASELINE_LEFT);

					String gebruikersnaam = dc.geefAlleSpelers().get(index).gebruikerNaam().substring(0, 1).toUpperCase() + dc.geefAlleSpelers().get(index).gebruikerNaam().substring(1);
					String geboortejaar = Integer.toString(dc.geefAlleSpelers().get(index).geboorteJaar());

					Label lblGebruikersnaam = new Label(gebruikersnaam);
					Label lblGeboortejaar = new Label("(" + geboortejaar + ")");
					lblGebruikersnaam.getStyleClass().add("labelGebruikersnaamAddingPlayers");
					lblGeboortejaar.getStyleClass().add("labelGeboortejaarAddingPlayers");

					hbox.getChildren().addAll(lblGebruikersnaam, new Label(" "), lblGeboortejaar);
					vbox.getChildren().add(hbox);

				}

				txfName.requestFocus();
			} catch (NumberFormatException e) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle(null);
				alert.setHeaderText(Language.bundle.getString("geldigeWaardenIngeven"));
				alert.showAndWait();
				txfName.clear();
				txfAge.clear();
				txfName.requestFocus();
			}
		});

		btnStop.setOnAction(event -> {
			try {
				this.status = true;
				meldAan();
			}
			catch (NumberFormatException e) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle(null);
				alert.setHeaderText(Language.bundle.getString("geldigeWaardenIngeven"));
				alert.showAndWait();
				txfName.clear();
				txfAge.clear();
				txfName.requestFocus();
			}
		});

		this.setLeft(grid);
		this.setRight(vbox);

	}

	public List meldAan() {

		String gebruikersnaam = this.name; 
		if(!this.name.isBlank())
			gebruikersnaam = this.name.toLowerCase();

		int geboortejaar = Integer.parseInt(this.age);
		boolean isAlIngegeven = false;

		List<String> spelers = new ArrayList<>();

			
			if (this.status == false) {
				try {

					for(SpelerDTO speler : dc.geefAlleSpelers())
						if(gebruikersnaam.equals(speler.gebruikerNaam()) && geboortejaar == speler.geboorteJaar())
							isAlIngegeven = true;

					for(String speler: spelers) {
						if(speler.contains(gebruikersnaam))
							throw new IllegalArgumentException();
					}
					
					if(isAlIngegeven == false) {
						dc.meldAan(gebruikersnaam, geboortejaar);
						spelers.add(gebruikersnaam);
					}
				}
				catch(IllegalArgumentException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(Language.bundle.getString("spelerNietInDatabank"));
					alert.showAndWait();
				}
				catch(Exception e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(Language.bundle.getString("foutAanmelden"));
					alert.showAndWait();
				}
			}
			else
			{
				magStoppen();
			}
			
		
		return spelers;
	}

	public boolean magStoppen() {
		if (dc.getSpelers().size() < 2) {
			this.status = false;
			return false;

		}
		if (this.status == true || dc.getSpelers().size() >= 2) {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("");
			alert.setContentText(Language.bundle.getString("zijnAlleSpelersToegevoegd"));
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				configureerSpel();
				nextScene();
			} else {

				this.status = false;

				Alert alertRestart = new Alert(AlertType.CONFIRMATION);
				alertRestart.setTitle("");
				alertRestart.setContentText(Language.bundle.getString("huidigeSpelersVerwijderen"));
				Optional<ButtonType> resultRestart = alertRestart.showAndWait();
				if (resultRestart.get() == ButtonType.OK) {
					dc.getSpelers().clear();
					vbox.getChildren().clear();
				}

			}

			return true;
		}
		return false;
	}

	private void configureerSpel() {
		dc.configuratieSpel();
	}

	public void nextScene() {

		// AddingPlayers scherm -> GameBoard scherm
		GameBoard root = new GameBoard(this.dc);
		Scene scene = new Scene(root, 1400, 800);
		Stage stage = (Stage) this.getScene().getWindow();
		stage.setTitle("Splendor - Gameboard");
		stage.setScene(scene);
		stage.show();

	}

}
