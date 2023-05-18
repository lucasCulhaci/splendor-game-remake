package domein;

import java.util.Map;

/**
 * De Edeleklasse vertegenwoordigt de implementatie voor het aanmaken van de Edelen die worden gebruikt
 * in de spel Splendor
 * @author G109
 */
public class Edele extends Kaart {

	/**
	 * Bouwt en initialiseert een nieuwe Edele constructor
	 * @param kost - kost van de Edele
	 * @param prestige - prestige van de Edele
	 */
	public Edele(Map<EdelsteenType, Integer> kost, int prestige) {
		super(kost, prestige);
	}

}
	