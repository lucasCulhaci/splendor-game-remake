package gui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import domein.DomeinController;
import domein.EdelsteenType;
import dto.EdeleDTO;
import dto.KaartDTO;
import dto.OntwikkelingskaartDTO;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BeurtSpeler extends BorderPane {

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

	private RoundUIPlayer rup;
	//private HBox center;
	int indexOfPlayer;

	HBox hboxTop = new HBox();

	public BeurtSpeler(DomeinController dc, int indexOfPlayer) {

		this.dc = dc;
		this.indexOfPlayer = indexOfPlayer;

		buildGui();
		
		this.getStylesheets().add(getClass()
				.getResource("/css/style.css").toExternalForm());

	}

	public void buildGui() {
	
		topPanel();
		centerPanel();
		bottomPanel();
		
	}

	public void topPanel() {

		hboxTop.setAlignment(Pos.CENTER);

		hboxTop.setPrefHeight(200);
		String huidigeSpeler = dc.geefAlleSpelers().get(indexOfPlayer).gebruikerNaam();
		Label lblHuidigeSpelerTitel = new Label(huidigeSpeler.toUpperCase());
		lblHuidigeSpelerTitel.getStyleClass().add("labelHuidigeSpelerTitelPlayerBeurt");
		lblHuidigeSpelerTitel.setUnderline(true);;
		hboxTop.getChildren().add(lblHuidigeSpelerTitel);

		this.setTop(hboxTop);
		
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

	public EdelsteenType getkeyfromset(Set<EdelsteenType> kost) {
		for (Iterator iterator = kost.iterator(); iterator.hasNext();) { // vond geen andere manier om dit te doen
			EdelsteenType type = (EdelsteenType) iterator.next();
			return type;
		}
		return null;
		
	}
	public Map<Image, String> getMapfromOntwikkelingsKaart(OntwikkelingskaartDTO kaart){
		Map<Image, String> kost = new HashMap<Image, String>();
		kost.put(getImageOfEdelsteenType(getkeyfromset(kaart.kost().keySet())), kaart.kost().get(getkeyfromset(kaart.kost().keySet())).toString());
		return kost;
	}
	public void centerPanel() {

		HBox center = new HBox();
		center.setAlignment(Pos.CENTER);

//		
//		List<OntwikkelingskaartDTO> kaarten = dc.getOntwikkelingsKaartenvanSpeler(dc.geefAlleSpelers().get(indexOfPlayer));
		
		List<OntwikkelingskaartDTO> kaarten = dc.geefAlleSpelers().get(indexOfPlayer).ontwikkelingsKaarten();
		// LEVEL 1 CARDS
		for(int index = 0; index < kaarten.size(); index++) {
			OntwikkelingskaartDTO kaart = kaarten.get(index);
			card = new Card(""+kaart.prestige(), getImageOfEdelsteenType(kaart.type()),getMapfromOntwikkelingsKaart(kaart),""+ kaart.niveau() );
			//card = new Card("1", imgRuby, imgEmerald, "3", "1");
			center.getChildren().add(card);
			// card.setOnMouseClicked(this::cardRemove);
		}
		
		List<KaartDTO> edelen = dc.getEdeleVanSpeler(dc.geefAlleSpelers().get(indexOfPlayer));


		// LEVEL 4 CARDS
		for(int index = 0; index < edelen.size(); index++) {
			KaartDTO edele = edelen.get(index);
			EdeleDTO edel;
			card = new Card(""+edele.prestige(), imgCrown,getMapfromKaart(edele), "4" );
			//card = new Card("4", imgSapphire, imgEmerald, "1", "4");
			center.getChildren().add(card);
		//	card.setOnMouseClicked(this::cardRemove);
		}

		this.setCenter(center);
		
	}
	
	public void bottomPanel() {
		HBox bottom = new HBox();
		bottom.setAlignment(Pos.CENTER);
		bottom.setPrefHeight(150);
		this.setBottom(bottom);
		
		Button btnSkipBeurt = new Button("skip beurt");
		btnSkipBeurt.setOnAction(event -> {
			nextScene();
			
		});
		Button btnOntwikkeling = new Button("neem ontwikkelingskaarten");
		btnOntwikkeling.setOnAction(event -> {
			neemOntwikkelingsKaart();
		});
		Button btnfiches = new Button("neem edelsteenfiches");
		btnfiches.setOnAction(event -> {
			neemEdelsteenfiches();
		});
//		btnStartSpel.setOnAction(event -> {
//			dc.eersteRonde();
//
//			rup = new RoundUIPlayer(dc, 
//					dc.getGebruikersnaamHR(), 
//					dc.getOntwikkelingskaartTypeHR(), 
//					dc.getOntwikkelingskaartPrestigeHR(), 
//					dc.getEdelsteenfischeTypeHR(), 
//					dc.getEdelsteenfischeAantalHR(), 
//					dc.getEdelPrestigeHR(), 
//					dc.getEdelKostHR());
//
//			rup.show();
//
//		});
		ToolBar toolbar = new ToolBar(btnSkipBeurt,btnOntwikkeling, btnfiches);
		this.setBottom(toolbar);
	}
	
	private void neemEdelsteenfiches() {
		Edelsteenfiches root = new Edelsteenfiches(dc, indexOfPlayer);
		Scene scene = new Scene(root, 1400, 800);
		Stage stage = (Stage) this.getScene().getWindow();
		stage.setTitle("Splendor - Keuze edelsteenfiches");
		stage.setScene(scene);
		stage.show();
		
	}

	private void neemOntwikkelingsKaart() {

		OntwikkelingsKaarten root = new OntwikkelingsKaarten(dc, indexOfPlayer);
		Scene scene = new Scene(root, 1400, 800);
		Stage stage = (Stage) this.getScene().getWindow();
		stage.setTitle("Splendor - keuze ontwikkelingskaarten");
		stage.setScene(scene);
		stage.show();
		
	}

	private Map<Image, String> getMapfromKaart(KaartDTO edele) {
		Map<Image, String> kost = new HashMap<Image, String>();
		kost.put(getImageOfEdelsteenType(getkeyfromset(edele.kost().keySet())), edele.kost().get(getkeyfromset(edele.kost().keySet())).toString());
		return kost;
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

//	public void cardRemove(MouseEvent event) {
//		
//		center.getChildren().remove(event.getSource());
//		
//	}

//
//	public void logic() {
//
//		rup = new RoundUIPlayer(spel.getGebruikersnaamHR());
//		rup.setTitle("Ronde - " + spel.getGebruikersnaamHR());
//		rup.show();
//		
//		/*
//		 * 1. Check wie de startspeler is
//		 * 2. Open een nieuw scherm waarbij de huidige spelsituatie van de speler wordt getoond
//		 * 3. Druk op een knop en toon de spelsituatie van de eerst volgende speler
//		 * */
//	}

}
