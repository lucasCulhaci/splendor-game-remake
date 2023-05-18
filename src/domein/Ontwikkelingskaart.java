package domein;

import java.util.Map;
import java.util.Objects;

/**
 * De Ontwikkelingskaartklasse vertegenwoordigt de Ontwikkelingskaarten die kunnen worden weergegeven en gebruiker in het spel Splendor
 * Deze klasse bevat alle nodige dat moet worden ingesteld en bijgehouden voor het aanmaken van een ontwikkelingskaart
 * 
 * @author G109
 */
public class Ontwikkelingskaart extends Kaart{


	private EdelsteenType type;
	private int niveau;

	/**
	 * Bouwt en initialiseert een nieuwe Ontwikkelingskaart constructor
	 * @param kost - kost van de ontwikkelingskaart
	 * @param prestige - prestigepunten van de ontwikkelingskaart
	 * @param type - Edelsteentype van de ontwikkelingskaart
	 * @param niveau - niveau van de ontwikkelingskaart, deze ligt tussen 1 en 3 (inclusief)
	 */
	public Ontwikkelingskaart(Map<EdelsteenType, Integer> kost, int prestige,EdelsteenType type, int niveau) {
		super(kost, prestige);
		this.type = type;
		this.niveau = niveau;
	}

	/**
	 * Ophalen van de Edelsteentype van de de ontwikkelingskaart
	 * @return een Edelsteentype object van de huidige ontwikkelingskaart
	 */
	public EdelsteenType getType() {
		return this.type;
	}

	/**
	 * Ophalen van de niveau van de huidige ontwikkelingskaart 
	 * @return een int waarde van de niveau
	 */
	public int getNiveau() {
		return this.niveau;
	}
	@Override
	public String toString() {
		String temp = "kost:\n";
		for (Map.Entry<EdelsteenType, Integer> entry : getKost().entrySet()) {
			EdelsteenType key = entry.getKey();
			Integer val = entry.getValue();
			temp += String.format("	%s : %d%n", key, val);
			
		}
		
		return String.format("%s%nprestige : %d%ntype : %s%nniveau : %d", temp, getPrestige(), getType(), getNiveau());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(niveau, type);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ontwikkelingskaart other = (Ontwikkelingskaart) obj;
		return niveau == other.niveau && type == other.type;
	}

	
}
