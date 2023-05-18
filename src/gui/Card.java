package gui;

import java.util.Iterator;
import java.util.Map;

import dto.EdelsteenficheDTO;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Card extends Pane{

	BorderPane card;
	Region spring;

	HBox top;
	Pane center;
	HBox bottom;
	HBox gemRow;
	StackPane stackingGems;

	public Image imgDiamond = new Image(getClass().getResourceAsStream("/images/diamond.png"));
	public Image imgEmerald = new Image(getClass().getResourceAsStream("/images/emerald.png"));
	public Image imgGold = new Image(getClass().getResourceAsStream("/images/gold.png"));
	public Image imgOnyx = new Image(getClass().getResourceAsStream("/images/onyx.png"));
	public Image imgRuby = new Image(getClass().getResourceAsStream("/images/ruby.png"));
	public Image imgSapphire = new Image(getClass().getResourceAsStream("/images/sapphire.png"));

	private double 
		setCardWidth = 140,
		setCardHeight = 80;

	public Card(String prestigePoints, Image bonus, Map<Image, String> kost, String levelCard) {

		// createCard("1", imgRuby, imgEmerald, "3", "3");
		createCard(prestigePoints, bonus, kost, levelCard);

	}

	public void createCard(
			String prestigePoints, 
			Image bonus, 
			Map<Image, String> kost,
			//Image tokenName, 
			//String tokenAmount, 
			String levelCard) {
	
		//// Individual cards
		card = new BorderPane();

		// TOP //
		top = new HBox();
		top.setMaxWidth(Double.MAX_VALUE);
		top.getStyleClass().add("topCards");
		
		Label lblPrestigePoints = new Label(prestigePoints);
		lblPrestigePoints.getStyleClass().add("topLabelCards");
		lblPrestigePoints.setPadding(new Insets(0,5,0,10));
		ImageView gem = new ImageView(bonus);
		gem.setFitHeight(30);
		gem.setFitWidth(30);

		spring = new Region();
		HBox.setHgrow(spring, Priority.ALWAYS);
		
		top.setPrefHeight(50);
		top.setAlignment(Pos.CENTER);
		top.getStyleClass().add("topHBoxCards");
		top.getChildren().addAll(lblPrestigePoints, spring, gem);
		
		card.setTop(top);
		//-----//
		

		//// BOTTOM ////  
		bottom = new HBox();
		bottom.setPadding(new Insets(10));
		gemRow = new HBox();
		gemRow.setSpacing(10);
		for (Iterator iterator = kost.keySet().iterator(); iterator.hasNext();) {
			Image tokenName = (Image) iterator.next();
			String tokenAmount = kost.get(tokenName);
		
			Label lblAmount = new Label(tokenAmount);
			ImageView genType = new ImageView(tokenName);
			genType.setFitHeight(20);
			genType.setFitWidth(20);
			gemRow.getChildren().addAll(genType, lblAmount);
			
		}
//		Label lblAmount = new Label(tokenAmount);
//		ImageView genType = new ImageView(tokenName);
//		genType.setFitHeight(20);
//		genType.setFitWidth(20);
//		gemRow.getChildren().addAll(genType, lblAmount);
		
		stackingGems = new StackPane();
		stackingGems.getChildren().add(gemRow);

		// RIGHT
		Label lblLevel = new Label(levelCard);
		lblLevel.setUnderline(true);
		lblLevel.getStyleClass().add("bottomLabelLevelCards");

		bottom.setStyle("-fx-background-color: lightgrey");
		bottom.getChildren().addAll(gemRow, spring, lblLevel);

		card.setBottom(bottom);
		//--------//
		
		// CENTER //
		center = new Pane();
		center.setPrefSize(setCardWidth, setCardHeight);
		card.setCenter(center);
		//-------//

		card.getStyleClass().add("cardCards");

		this.getChildren().add(card);
		
//		this.setOnMouseClicked(event -> {
//			System.out.printf("You clicked on the card with values! %n"
//					+ "Prestigepoints: %s%n"
//					+ "Bonus: %s%n"
//					+ "Tokenname: %s%n"
//					+ "Token amount: %s%n"
//					+ "Level: %s%n%n", 
//					prestigePoints, 
//					bonus, 
//					kost.keySet().iterator().next(),
//					kost.get(kost.keySet().iterator().next()),
//					levelCard);
//	
//			
//		});
	}

}
