package domein;

/**
 * De Edelsteenficheklasse vertegenwoordigd de implementatie voor het aanmaken van een
 * Edelsteenfiche in de spel Splendor
 */
public class Edelsteenfiche {

	private EdelsteenType type;

	/**
	 * Bouwt en initialiseert een nieuwe Edelsteenfiche constructor
	 * @param type - Edelsteentype van de EdelsteenFiche
	 */
	public Edelsteenfiche(EdelsteenType type) {
		this.type = type;
	}
	
	/**
	 * Ophalen van de type van het type van de huidige Edelsteefiche
	 * @return type van het Edelsteenfiche als EdelsteenType object
	 */
	public EdelsteenType getType() {
		return this.type;
	}

}
