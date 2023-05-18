package domein;

import java.util.Map;
import java.util.Objects;

/**
 * De Kaartklasse vertegenwoordigt een abstracte klasse die wordt gebruikt voor het aanmaken van 
 * de nodige kaarten die zullen worden gebruikt in het spel Splendor
 * @author G109
 */
public abstract class Kaart {
	
	private Map<EdelsteenType, Integer> kost;
	private int prestige;
	
	
	/**
	 * Declaratie van een nieuwe Kaart constructor
	 * @param kost - kost van een kaart
	 * @param prestige - prestige van een kaart
	 */
	public Kaart(Map<EdelsteenType, Integer> kost, int prestige) {
		this.kost = kost;
		this.prestige = prestige;
	}
	
	/**
	 * Declaratie van het ophalen van de kost
	 */
	public Map<EdelsteenType, Integer> getKost() {
		return kost;
	}

	/**
	 * Declaratie voor het ophalen van de prestige
	 */
	public int getPrestige() {
		return prestige;
	}

	@Override
	public int hashCode() {
		return Objects.hash(kost, prestige);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kaart other = (Kaart) obj;
		return Objects.equals(kost, other.kost) && prestige == other.prestige;
	}
	
	
}
