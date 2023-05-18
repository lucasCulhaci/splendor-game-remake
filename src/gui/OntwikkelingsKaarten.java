package gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import domein.DomeinController;
import domein.EdelsteenType;
import domein.Kaart;
import dto.EdeleDTO;
import dto.KaartDTO;
import dto.OntwikkelingskaartDTO;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class OntwikkelingsKaarten extends BorderPane {

	public Image imgDiamond = new Image(getClass().getResourceAsStream("/images/diamond.png"));
	public Image imgEmerald = new Image(getClass().getResourceAsStream("/images/emerald.png"));
	public Image imgGold = new Image(getClass().getResourceAsStream("/images/gold.png"));
	public Image imgOnyx = new Image(getClass().getResourceAsStream("/images/onyx.png"));
	public Image imgRuby = new Image(getClass().getResourceAsStream("/images/ruby.png"));
	public Image imgSapphire = new Image(getClass().getResourceAsStream("/images/sapphire.png"));
	public Image imgCrown = new Image(getClass().getResourceAsStream("/images/crown.png"));

	Image[] listTypes = { imgGold, imgDiamond, imgRuby, imgSapphire, imgEmerald, imgOnyx };

	private DomeinController dc;

	private Card card;
	private EdelsteenFiche edelsteenFiche;

	private RoundUIPlayer rup;
	private GridPane center;
	private List<OntwikkelingskaartDTO> geselecteerdeKaarten;
	int indexOfPlayer;

	public OntwikkelingsKaarten(DomeinController dc, int indexOfPlayer) {
		this.indexOfPlayer = indexOfPlayer;
		geselecteerdeKaarten = new ArrayList<OntwikkelingskaartDTO>();
		this.dc = dc;

		buildGui();

		this.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());

	}

	public void buildGui() {

		// topPanel();
		// rightPanel(); //spelers

		// leftPanel();
		centerPanel();
		bottomPanel();

	}

	public void bottomPanel() {
		HBox bottom = new HBox();
		bottom.setAlignment(Pos.CENTER);
		bottom.setPrefHeight(150);
		this.setBottom(bottom);

		Button btnStartSpel = new Button("bevestig keuze");
		btnStartSpel.setOnAction(event -> {
			nextScene();

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
		ToolBar toolbar = new ToolBar(btnStartSpel);
		this.setBottom(toolbar);
	}

	public void nextScene() {
		indexOfPlayer++;
		if (indexOfPlayer >= dc.geefAlleSpelers().size())
			indexOfPlayer = 0;
		BeurtSpeler root = new BeurtSpeler(dc, indexOfPlayer);
		Scene scene = new Scene(root, 1400, 800);
		Stage stage = (Stage) this.getScene().getWindow();
		stage.setTitle("Splendor - Speler");
		stage.setScene(scene);
		stage.show();

	}

	public Image getImageOfEdelsteenType(EdelsteenType type) {
		if (type == EdelsteenType.SMARAGD) {
			return imgEmerald;
		} else if (type == EdelsteenType.DIAMANT) {
			return imgDiamond;
		} else if (type == EdelsteenType.SAFFIER) {
			return imgSapphire;
		} else if (type == EdelsteenType.ONYX) {
			return imgOnyx;
		} else {
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

	public Map<Image, String> getMapfromOntwikkelingsKaart(OntwikkelingskaartDTO kaart) {
		Map<Image, String> kost = new HashMap<Image, String>();
		kost.put(getImageOfEdelsteenType(getkeyfromset(kaart.kost().keySet())),
				kaart.kost().get(getkeyfromset(kaart.kost().keySet())).toString());
		return kost;
	}

	private boolean kaartSelecteren(OntwikkelingskaartDTO kaart) {
		int aantalFiches = (int) dc.geefAlleSpelers().get(indexOfPlayer).edelsteenfiches().stream().filter((el) -> {
			return el.type() == getkeyfromset(kaart.kost().keySet());
		}).count();
		// dc.geefAlleSpelers().get(indexOfPlayer).edelsteenfiches().stream().filter((el)
		// -> {return el.type() == getkeyfromset(kaart.kost().keySet());}).count() >
		// kaart.kost().get(getkeyfromset(kaart.kost().keySet()))){
		// if(aantalFiches > kaart.kost().get(getkeyfromset(kaart.kost().keySet()))) {

		dc.kiesOntwikkelingskaart(dc.geefZichtbareOntwikkelingskaarten(kaart.niveau()).indexOf(kaart), indexOfPlayer,
				kaart.niveau());
		// dc.geefEdelsteenfischeTerug(null, null); //TODO
		return true;

//		}
//		else {
//		    Alert alert = new Alert(AlertType.ERROR);
//	        alert.setTitle("Error");
//	        alert.setContentText("Je hebt niet genoeg edelsteenfiches voor deze kaart");
//	        alert.showAndWait();
//	        return false;
//	    }
	}

//		dc.geefAlleSpelers().get(indexOfPlayer).edelsteenfiches().forEach((fiche) -> {
//			if(getkeyfromset(kaart.kost().keySet()).equals(fiche.type()) && kaart.kost().get(getkeyfromset(kaart.kost().keySet())) == fiche.)
//				return true;
//		});

	public void centerPanel() {

		center = new GridPane();
		center.setAlignment(Pos.CENTER);
		center.setHgap(10);
		center.setVgap(10);

		List<OntwikkelingskaartDTO> kaarten = dc.geefZichtbareOntwikkelingskaarten(1);
		// LEVEL 1 CARDS
		for (int index = 0; index < kaarten.size(); index++) {
			OntwikkelingskaartDTO kaart = kaarten.get(index);
			card = new Card("" + kaart.prestige(), getImageOfEdelsteenType(kaart.type()),
					getMapfromOntwikkelingsKaart(kaart), "1");
			// card = new Card("1", imgRuby, imgEmerald, "3", "1");
			center.add(card, index, 3);
			card.setOnMouseClicked((event) -> {

				if (kaartSelecteren(kaart))
					cardRemove(event, kaart);
				centerPanel();

			});
		}
		kaarten = dc.geefZichtbareOntwikkelingskaarten(2);
		// LEVEL 2 CARDS
		for (int index = 0; index < kaarten.size(); index++) {
			OntwikkelingskaartDTO kaart = kaarten.get(index);
			card = new Card("" + kaart.prestige(), getImageOfEdelsteenType(kaart.type()),
					getMapfromOntwikkelingsKaart(kaart), "2");

			// card = new Card("2", imgDiamond, imgOnyx, "1", "2");
			HBox hbox = new HBox();
			center.add(card, index, 2);
			card.setOnMouseClicked((event) -> {

				if (kaartSelecteren(kaart))
					cardRemove(event, kaart);
				centerPanel();

			});
		}
		kaarten = dc.geefZichtbareOntwikkelingskaarten(3);
		// LEVEL 3 CARDS
		for (int index = 0; index < kaarten.size(); index++) {
			OntwikkelingskaartDTO kaart = kaarten.get(index);
			card = new Card("" + kaart.prestige(), getImageOfEdelsteenType(kaart.type()),
					getMapfromOntwikkelingsKaart(kaart), "3");
			// card = new Card("3", imgSapphire, imgEmerald, "1", "3");

			center.add(card, index, 1);

			card.setOnMouseClicked((event) -> {

				if (kaartSelecteren(kaart))
					cardRemove(event, kaart);
				centerPanel();

			});
		}
		List<KaartDTO> edelen = dc.geefAlleEdelen();
		// LEVEL 4 CARDS
		for (int index = 0; index < edelen.size(); index++) { // nog te bekijken.
			KaartDTO edele = edelen.get(index);
			EdeleDTO edel;
			card = new Card("" + edele.prestige(), imgCrown, getMapfromKaart(edele), "4");
			// card = new Card("4", imgSapphire, imgEmerald, "1", "4");
			center.add(card, index, 0);
			card.setOnMouseClicked((event) -> {

				if (kaartSelecteren(new OntwikkelingskaartDTO(edele.kost(), edele.prestige(), null, 4))) //
					center.getChildren().remove(event.getSource());

			});
		}

		this.setCenter(center);

	}

	private Map<Image, String> getMapfromKaart(KaartDTO edele) {
		Map<Image, String> kost = new HashMap<Image, String>();
		kost.put(getImageOfEdelsteenType(getkeyfromset(edele.kost().keySet())),
				edele.kost().get(getkeyfromset(edele.kost().keySet())).toString());
		return kost;
	}

	public void cardRemove(MouseEvent event, OntwikkelingskaartDTO kaart) {
		center.getChildren().remove(event.getSource());

	}

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
