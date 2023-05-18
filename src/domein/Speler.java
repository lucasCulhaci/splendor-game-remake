package domein;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * De Speler klasse vertegenwoordigt een speler in het spel Splendor.
 * Deze klasse bevat alle nodige dat moet worden bijgehouden van de speler.
 * 
 * @author G109
 */

public class Speler {


	private String gebruikersnaam;
	private int geboortejaar;
	private List<Edelsteenfiche> edelsteenfiches;
	private List<Edele> edelen;
	private List<Ontwikkelingskaart> ontwikkelingskaarten;
	private int prestigePunten;
	private boolean startSpeler = false;
	private boolean aanDeBeurt = false;

	/**
	 * Bouwt en initialiseert een nieuwe Speler constructor aan met behulp van de gebruikersnaam en de geboortejaar
	 * @param gebruikersnaam is de ingegeven naam van de gebruiker
	 * @param geboortejaar is de ingegeven geboortejaar van de gebruiker
	 */
	public Speler(String gebruikersnaam, int geboortejaar) {
		setGeboortejaar(geboortejaar);
		setGebruikersnaam(gebruikersnaam);
		edelsteenfiches = new ArrayList<>();
		ontwikkelingskaarten = new ArrayList<>();
		edelen = new ArrayList<>();
	}

	/**
	 * Haalt de ingegeven gebruikersnaam op
	 * @return de ingegeven gebruikersnaam, return type: object van String
	 */
	public String getGebruikersnaam() {
		return this.gebruikersnaam;
	}

	/**
	 * Haalt de ingegeven geboortejaar op
	 * @return de ingegeven geboortejaar, return type: primitieve "int"
	 */
	public int getGeboortejaar() {
		return this.geboortejaar;
	}

	/**
	 * Geldiheid controleren van de ingegeven gebruikersnaam en deze vervolgens 
	 * toevoegen aan de instantievariabele "gebruikersnaam"
	 * @param gebruikersnaam - Ingegeven naam van de gebruiker
	 */
	public void setGebruikersnaam(String gebruikersnaam) {
		if (gebruikersnaam.isEmpty()) {
			throw new IllegalArgumentException();
		}

		char firstChar = gebruikersnaam.charAt(0);
		if (!Character.isLetter(firstChar)) {
			throw new IllegalArgumentException();
		}

		for (int i = 1; i < gebruikersnaam.length(); i++) {
			char c = gebruikersnaam.charAt(i);
			if (!Character.isLetterOrDigit(c) && c != '_' && c != ' ') {
				throw new IllegalArgumentException();
			}
		}
		this.gebruikersnaam = gebruikersnaam;
	}

	/**
	 * Controle indien er een geldige geboortejaar word ingegeven
	 * @param geboortejaar - Ingegeven geboortejaar
	 */
	public void setGeboortejaar(int geboortejaar) {
		if (geboortejaar > LocalDate.now().getYear() - 6) {
			throw new IllegalArgumentException();
		}
		this.geboortejaar = geboortejaar;
	}

	/**
	 * Toevoegen van edelsteenfiches aan de speler
	 * @param edelsteenfiche - Edelsteenfiche object die word meegegeven
	 */
	public void addEdelsteenfiche(Edelsteenfiche edelsteenfiche) {
		this.edelsteenfiches.add(edelsteenfiche);
	}
	
	/**
	 * Verwijderen van de edelsteenfiche van de speler
	 * @param edelsteenfiche - Edelsteenfiche object die word meegegeven
	 */
	public void removeEdelsteenfiche(Edelsteenfiche edelsteenfiche) {
		this.edelsteenfiches.remove(edelsteenfiche);
	}

	/**
	 * Ophalen van alle edelsteenfiches van de speler
	 * @return lijst van edelsteenficheobjecten
	 */
	public List<Edelsteenfiche> geefEdelsteenfiches() {
		return this.edelsteenfiches;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(geboortejaar, gebruikersnaam);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Speler other = (Speler) obj;
		return geboortejaar == other.geboortejaar && Objects.equals(gebruikersnaam, other.gebruikersnaam);
	}

	/**
	 * Ophalen van alle edelen van de speler
	 * @return lijst van alle edelobjecten
	 */
	public List<Edele> getEdelen() {
		return edelen;
	}

	/**
	 * Ophalen van alle ontwikkelingskaarten van de speler
	 * @return lijst van ontwikkelingskaartobjecten
	 */
	public List<Ontwikkelingskaart> getOntwikkelingskaarten() {
		return this.ontwikkelingskaarten;
	}


	/**
	 * Ophalen van de totaal aantal prestigepunten van de gebruiker
	 * @return een int waarde met de totaal aantal prestigepunten
	 */
	public int getPrestigePunten() {
		return prestigePunten;
	}

	/**
	 * Toevoegen van een bepaald aantal prestigepunten aan de gebruiker
	 * @param prestigePunten - Ingegeven hoeveelheid aan prestigepunten
	 */
	public void addPrestigePunten(int prestigePunten) {
		this.prestigePunten += prestigePunten;
	}

	/**
	 * Aangeven indien de huidige speler de startspeler is
	 * @return true indien de huidige speler de startspeler is, indien niet return het een false
	 */
	public boolean isStartSpeler() {
		return startSpeler;
	}

	/**
	 * Initialiseren van de startspeler
	 * @param startSpeler - boolean waarde, indien deze de startspeler is wordt een boolean waarde van true meegegeven
	 */
	public void setStartSpeler(boolean startSpeler) {
		this.startSpeler = startSpeler;
	}

	/**
	 * Bepaalt indien de speler aan de beurt is
	 * @return true indien de speler aan de beurt is, indien niet retourneerd deze een false
	 */
	public boolean isAanDeBeurt() {
		return aanDeBeurt;
	}

	/**
	 * Stelt de huidige speler in
	 * @param aanDeBeurt - boolean waarde die word meegegeven om te bepalen indien de huidige speler aan de beurt is
	 */
	public void setAanDeBeurt(boolean aanDeBeurt) {
		this.aanDeBeurt = aanDeBeurt;
	}

	/**
	 * Toevoegen van een ontwikkelingskaart aan de speler
	 * @param kaart - Ontwikkelingskaart object dat wordt toegevoed aan de speler
	 */
	public void addOntwikkelingskaarten(Ontwikkelingskaart kaart) {
		this.ontwikkelingskaarten.add(kaart);
	}
	

	/**
	 * Verwijderen van de edelsteenfiche van de speler
	 * @param type - EdelsteenType object dat word meegegeven
	 */
	public Edelsteenfiche verwijderEdelsteenfiche(EdelsteenType type) {
	    for (Edelsteenfiche fiche : edelsteenfiches) {
	        if (fiche.getType() == type) {
	            edelsteenfiches.remove(fiche);
	            return fiche;
	        }
	    }
	    return null;
	}

	

}
