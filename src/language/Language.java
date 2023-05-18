package language;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Language {
	
	private static Scanner invoer;
	

	// Resourcebundle
	public static ResourceBundle bundle = ResourceBundle.getBundle("language.MessageBundle");

	public static void keuzeTaal(String input) {

		String[] geldigeLijstVanTalen = { "english", "dutch", "french" };
		boolean geldig = false;

		do {

			try {

				// Kan weggehaald worden indien geen gebruik zal
				// gemaakt worden van manuele taalinvoer
				for (String check : geldigeLijstVanTalen) {
					if (input.toLowerCase().equals(check)) {
						geldig = true;
					}
				}

				if (!geldig)
					throw new IllegalArgumentException();
				else {
					switch (input) {
					case "dutch" -> Locale.setDefault(new Locale("nl", "BE"));
					case "french" -> Locale.setDefault(new Locale("fr", "BE"));
					case "english" -> Locale.setDefault(new Locale("en", "GB"));
					}
					
					// De gecachete waardes overschrijven
					bundle = ResourceBundle.getBundle("language.MessageBundle");
				}

				// invoer.close
			} catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
				System.err.println("Gelieve een geldige taal in te geven");
				break;
			}

		} while (!geldig);

	}
	

}
