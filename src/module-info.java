module splendor {
	exports persistentie;
	exports ui;
	exports gui;
	exports language;
	exports main;
	exports domein;
	exports testen;
	exports dto;


	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	requires org.junit.jupiter.api;
	requires org.junit.jupiter.params;
	requires java.sql;

	opens gui to javafx.graphics;
}