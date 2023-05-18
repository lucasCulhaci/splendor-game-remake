package gui;

import domein.DomeinController;
import domein.EdelsteenType;
import dto.EdelsteenficheDTO;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Edelsteenfiches extends BorderPane {

	public Image imgDiamond = new Image(getClass().getResourceAsStream("/images/diamond.png"));
	public Image imgEmerald = new Image(getClass().getResourceAsStream("/images/emerald.png"));
	public Image imgGold = new Image(getClass().getResourceAsStream("/images/gold.png"));
	public Image imgOnyx = new Image(getClass().getResourceAsStream("/images/onyx.png"));
	public Image imgRuby = new Image(getClass().getResourceAsStream("/images/ruby.png"));
	public Image imgSapphire = new Image(getClass().getResourceAsStream("/images/sapphire.png"));
	public Image imgCrown = new Image(getClass().getResourceAsStream("/images/crown.png"));

	Image[] listTypes = {
			imgGold, 
			imgDiamond,
			imgRuby,
			imgSapphire,
			imgEmerald,
			imgOnyx};

	private DomeinController dc;

	private Card card;
	private EdelsteenFiche edelsteenFiche;
	int indexOfPlayer;
	private RoundUIPlayer rup;
	private GridPane center;

	public Edelsteenfiches(DomeinController dc, int indexOfPlayer) {

		this.indexOfPlayer = indexOfPlayer;
		this.dc = dc;
		this.getStylesheets().add(getClass()
				.getResource("/css/style.css").toExternalForm());

		buildGui();

	}

	public void buildGui() {
		
		centerPanel();
		bottomPanel();
		
	}


	public void bottomPanel() {
		HBox bottom = new HBox();
		bottom.setAlignment(Pos.CENTER);
		bottom.setPrefHeight(150);
		this.setBottom(bottom);
		
		Button btnStartSpel = new Button("bevestigKeuze");
		btnStartSpel.setOnAction(event -> {
			nextScene();
			
		});

		ToolBar toolbar = new ToolBar(btnStartSpel);
		this.setBottom(toolbar);
	}
	public void nextScene() {
		indexOfPlayer++;
		if(indexOfPlayer >= dc.geefAlleSpelers().size())
			indexOfPlayer = 0;
		BeurtSpeler root = new BeurtSpeler(dc, indexOfPlayer);
		Scene scene = new Scene(root, 1400, 800);
		Stage stage = (Stage) this.getScene().getWindow();
		stage.setTitle("Splendor - Speler");
		stage.setScene(scene);
		stage.show();
		
	}
		
	
	public Image getImageOfEdelsteenType(EdelsteenType type) {
		if(type == EdelsteenType.SMARAGD) {
			return imgEmerald;
		}
		else if(type == EdelsteenType.DIAMANT) {
			return imgDiamond;
		}
		else if(type == EdelsteenType.SAFFIER) {
			return imgSapphire;
		}
		else if(type == EdelsteenType.ONYX) {
			return imgOnyx;
		}
		else {
			return imgRuby;
		}
		
		
	}
	public void centerPanel() {
		
		GridPane center = new GridPane();
		center.setAlignment(Pos.CENTER);
		center.setHgap(10);
		center.setVgap(10);
		center.setPrefWidth(200);

		final String[] arrayTypes = {"gold", "diamond", "ruby", "sapphire", "emerald", "onyx"};

		int index;
		for(index = 0; index < listTypes.length; index++) {
			
			int amount = dc.geefAlleSpelers().size() == 2 ? 4 : dc.geefAlleSpelers().size() == 3 ? 5 : 7; 
			
			Image img= listTypes[index];
			String naamType = arrayTypes[index].toUpperCase();
			edelsteenFiche = new EdelsteenFiche(amount, listTypes[index]);

//			EdelsteenficheDTO edelsteenficheDTO = new EdelsteenficheDTO(EdelsteenType.DIAMANT);
			int temp = index;
			edelsteenFiche.setOnMouseClicked(event -> {
				
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(naamType);
				alert.showAndWait();
				//dc.kiesEdelsteenfische(edelsteenficheDTO, dc.getSpelers().get(temp));

			});

			center.add(edelsteenFiche, 0, index);
		}


		this.setCenter(center);

	}



}
