package gui;

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

public class Cards extends Stage {

	FlowPane flow = new FlowPane(Orientation.HORIZONTAL);
	BorderPane card;
	Region spring;

	HBox top;
	Pane center;
	HBox bottom;
	HBox gemRow;
	StackPane stackingGems;

	Image imgDiamond = new Image(getClass().getResourceAsStream("/images/diamond.png"));
	Image imgEmerald = new Image(getClass().getResourceAsStream("/images/emerald.png"));
	Image imgGold = new Image(getClass().getResourceAsStream("/images/gold.png"));
	Image imgOnyx = new Image(getClass().getResourceAsStream("/images/onyx.png"));
	Image imgRuby = new Image(getClass().getResourceAsStream("/images/ruby.png"));
	Image imgSapphire = new Image(getClass().getResourceAsStream("/images/sapphire.png"));

	private double 
		setCardWidth = 0,
		setCardHeight = 0;

	public Cards() {

		// DECK
		
		flow.setHgap(10);
		flow.setVgap(10);
		flow.setAlignment(Pos.CENTER);

		createCard("5", imgGold, imgGold, "2", "1");
		createCard("3", imgOnyx, imgRuby, "1", "2");
		createCard("3", imgOnyx, imgRuby, "1", "2");
		createCard("3", imgOnyx, imgRuby, "1", "2");
		createCard("3", imgOnyx, imgRuby, "1", "2");
		createCard("3", imgOnyx, imgRuby, "1", "2");
		createCard("3", imgOnyx, imgRuby, "1", "2");
		createCard("3", imgOnyx, imgRuby, "1", "2");
		createCard("3", imgOnyx, imgRuby, "1", "2");
		createCard("3", imgOnyx, imgRuby, "1", "2");
		createCard("3", imgOnyx, imgRuby, "1", "2");
		createCard("3", imgOnyx, imgRuby, "1", "2");
		createCard("3", imgOnyx, imgRuby, "1", "2");
		createCard("3", imgOnyx, imgRuby, "1", "2");
		createCard("3", imgOnyx, imgRuby, "1", "2");
		createCard("3", imgOnyx, imgRuby, "1", "2");
		createCard("3", imgOnyx, imgRuby, "1", "2");
		createCard("3", imgOnyx, imgRuby, "1", "2");
		createCard("3", imgOnyx, imgRuby, "1", "2");
		createCard("1", imgRuby, imgEmerald, "3", "3");

		new Commands().sceneConfig(flow, this);

	}

	public void createCard(
			String prestigePoints, 
			Image bonus, 
			Image tokenName, 
			String tokenAmount, 
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
		Label lblAmount = new Label(tokenAmount);
		ImageView genType = new ImageView(tokenName);
		genType.setFitHeight(20);
		genType.setFitWidth(20);
		gemRow.getChildren().addAll(genType, lblAmount);
		
		stackingGems = new StackPane();
		stackingGems.getChildren().add(gemRow);

		// RIGHT
		Label lblLevel = new Label(levelCard);
		lblLevel.setUnderline(true);
		lblLevel.getStyleClass().add("bottomLabelLevelCards");

		bottom.setStyle("-fx-background-color: lightblue");
		bottom.getChildren().addAll(gemRow, spring, lblLevel);

		card.setBottom(bottom);
		//--------//
		
		// CENTER //
		center = new Pane();
		center.setPrefSize(setCardWidth, setCardHeight);
		card.setCenter(center);
		//-------//

		card.getStyleClass().add("cardCards");

		
		flow.getChildren().add(card);
		
	}

}
