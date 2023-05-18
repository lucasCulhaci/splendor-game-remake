package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class EdelsteenFiche extends Pane {

	BorderPane borderPane;

	public Image imgDiamond = new Image(getClass().getResourceAsStream("/images/diamond.png"));
	public Image imgEmerald = new Image(getClass().getResourceAsStream("/images/emerald.png"));
	public Image imgGold = new Image(getClass().getResourceAsStream("/images/gold.png"));
	public Image imgOnyx = new Image(getClass().getResourceAsStream("/images/onyx.png"));
	public Image imgRuby = new Image(getClass().getResourceAsStream("/images/ruby.png"));
	public Image imgSapphire = new Image(getClass().getResourceAsStream("/images/sapphire.png"));
	
	public EdelsteenFiche(int amount, Image type) {

		borderPane = new BorderPane();
		borderPane.setPadding(new Insets(20));
		borderPane.getStyleClass().add("edelsteenFicheEdelsteenFiche");
		createEdelsteenFiche(amount, type);

	}

	public void createEdelsteenFiche(int amount, Image type) {

		HBox center = new HBox();
		center.setPrefWidth(35);
		Label line = new Label("x");
		center.setAlignment(Pos.CENTER);
		center.getChildren().add(line);
		borderPane.setCenter(center);
		
		Pane left = new Pane();
		left.setPrefWidth(30);
		left.getChildren().add(new ImageView(type));
		borderPane.setLeft(left);

		HBox right = new HBox();
		right.setPrefWidth(10);
		Label lblAmount = new Label(Integer.toString(amount));
		lblAmount.getStyleClass().add("lblAmountEdelsteenFiche");
		right.setAlignment(Pos.CENTER);
		right.getChildren().add(lblAmount);
		borderPane.setRight(right);

		
		this.getChildren().add(borderPane);
		

	}


}
