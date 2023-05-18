// SPLENDOR

package domein;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import dto.EdelsteenficheDTO;
import dto.KaartDTO;
import dto.OntwikkelingskaartDTO;
import dto.SpelerDTO;
//import dto.SpelerDTO;

/**
 * De DomeinController klasse vertegenwoordigt de link tussen de presentatielaag en de domeinlaag
 * Deze klasse bevat alle methodes die kunnen worden gebruikt in de presentatielaag
 * 
 * @author G109
 */
public class DomeinController {

	// Referentievariabelen
	private Spel spel;
	private SpelerRepo repo;

	/**
	 * Bouwt en initialiseert een controller voor de communicatie tussen het domein en de applicatie 
	 * met behulp van de "SpelerRepo" en de "Spel"
	 */
	// Constructor
	public DomeinController() {
		this.repo = new SpelerRepo();
		this.spel = new Spel();
	}

	/**
	 * Configureert en maakt een instantie van spel aan
	 * 
	 * @see void domein.Spel.buildSpel()
	 */
	// Instantie van spel aanmaken
	public void configuratieSpel() {
		//spel = new Spel(spelers);
		spel.buildSpel();
	}
	public void startBeurt(Speler startSpeler, Edelsteenfiche edelsteenfiche) {
		   spel.startBeurt(startSpeler, edelsteenfiche);
		}
	public void kiesEdelsteenfische(EdelsteenficheDTO edelsteen, Speler speler) {
		
		spel.kiesEdelsteenfische(new Edelsteenfiche(edelsteen.type()), speler);
	}
	public void geefEdelsteenfischeTerug(EdelsteenficheDTO edelsteen, Speler speler) {
		spel.geefEdelsteenfischeTerug(new Edelsteenfiche(edelsteen.type()), speler);
	}
	/**
	 * Zoekt naar de bestaande spelers in de database en vergelijkt ze met de gegeven waarden.

	 * @param gebruikersnaam van de ingegeven gebruiker
	 * @param geboortejaar van de ingegeven gebruiker
	 * @return true als de ingevoerde speler in de database bestaat, anders zal de methode een false retourneren
	 */
	public boolean meldAan(String gebruikersnaam, int geboortejaar) {

		// Checken indien de speler in de databank bestaat
		boolean gebruikerGevonden = repo.zoekSpeler(new Speler(gebruikersnaam, geboortejaar));
		if (gebruikerGevonden) {
//			spelers.add(new Speler(gebruikersnaam, geboortejaar));
			spel.voegSpelerToe(gebruikersnaam, geboortejaar);
			return true;
		}
		return false;

	}

	/**
	 * Retourneert een lijst met spelers
	 * @return lijst van de toegevoegde spelers
	 */
	public List<Speler> getSpelers() {
		return spel.getSpelers();
	}


	/**
	 * Retourneert een lijst met SpelerDTO's
	 * @param spelers - lijst van spelers
	 * @return
	 */
	public List<SpelerDTO> geefSpelers(List<Speler> spelers){
		List<SpelerDTO> spelersDTO= new ArrayList<SpelerDTO>();
		for(Speler s : spelers) {
			spelersDTO.add(new SpelerDTO(s.getGebruikersnaam(), s.getGeboortejaar(), getEdelsteenfiches(s), s.isAanDeBeurt(),s.isStartSpeler(),s.getPrestigePunten() , getOntwikkelingsKaarten(s), getEdele(s)));
		}
		return spelersDTO;
		
		
	}

	/**
	 * Bepaalt welke speler aan de beurt is
	 * @param index - index van de speler aan de beurt
	 */
	public void kiesOntwikkelingskaart(int indexOfKaart, int indexOfPlayer, int niveau) {
		spel.kiesOntwikkelingskaart(spel.getOntwikkelingskaarten(niveau).get(indexOfKaart),spel.getSpelers().get(indexOfPlayer));
		spel.VerwijderZichtbareKaart(indexOfKaart,spel.getOntwikkelingskaarten(niveau).get(indexOfKaart).getNiveau());
	}
	
	public void startBeurt(int index) {
		//spel.startBeurt(spel.getSpelers().get(index));
	}
//	public void VerwijderZichtbareKaart(OntwikkelingskaartDTO kaart, int niveau) {
//		spel.VerwijderZichtbareKaart(new Ontwikkelingskaart(kaart.kost(), kaart.prestige(), kaart.type(), kaart.niveau()), niveau);
//	}
	/**
	 * Retourneert een lijst van ontwikkelingskaartDTO's  objecten
	 * @param s - speler waarvan die de ontwikkelingskaarten bevat 
	 * @return lijst van ontwikkelingskaartDTO's
	 */
	public List<OntwikkelingskaartDTO> getOntwikkelingsKaarten(Speler s){
		List<OntwikkelingskaartDTO> ontwikkelingskaart = new ArrayList<OntwikkelingskaartDTO>();
		for(Ontwikkelingskaart ontwkaart : s.getOntwikkelingskaarten()) {
			ontwikkelingskaart.add(new OntwikkelingskaartDTO(ontwkaart.getKost(), ontwkaart.getNiveau(), ontwkaart.getType(), ontwkaart.getPrestige()));
		}
		return ontwikkelingskaart;
	}

	/**
	 * Geeft een lijst van EdelsteenficheDTO objecten terug die overeenkomen met de edelsteenfiches van de opgegeven speler
	 * @param s - speler waarvan de edelsteenfiches worden omgezet naar EdelsteenficheDTO objecten
	 * @return lijst van EdelsteenficheDTO objecten die overeenkomen met de edelsteenfiches van de opgegeven speler
	 */
	public List<EdelsteenficheDTO> getEdelsteenfiches(Speler s){
		List<EdelsteenficheDTO> edelsteenen = new ArrayList<EdelsteenficheDTO>();
		for(Edelsteenfiche edelsteen : s.geefEdelsteenfiches()) {
			edelsteenen.add(new EdelsteenficheDTO(edelsteen.getType()));
		}
		return edelsteenen;
	}

	/**
	 * Geeft een lijst van KaartDTO's objecten terug die overeenkomen met de edelen van de opgegeven speler
	 * @param s - speler waarvan de edelen worden omgezet naar KaartDTO objecten
	 * @return lijst van KaartDTO's objecten die overeenkomen met de edelen van de opgegeven speler
	 */
	public List<KaartDTO> getEdele(Speler s){
		List<KaartDTO> edele = new ArrayList<KaartDTO>();
		for(Kaart edel : s.getEdelen()) {
			edele.add(new KaartDTO(edel.getKost(), edel.getPrestige()));
		}
		return edele;
	}
	
	/**
	 * Start een nieuwe ronde in het huidige spel
	 */
	public void speelRonde() {
		spel.speelRonde();
	}
//	public String[] uitvoerKaarten() {
//	String[] kaarten = new String[spel.getOntwikkelingskaarten1().size()];
//		int counter = 0;
//		for (Iterator iterator = spel.getOntwikkelingskaarten1().iterator(); iterator.hasNext();) {
//			Ontwikkelingskaart type = (Ontwikkelingskaart) iterator.next();
//			kaarten[counter] = type.toString();
//			counter++;
//			
//		}
//		
//		return kaarten;
//	}
	
	/**
	 * Start een nieuwe ronde van het spel en geeft een lijst van SpelerDTO's terug voor elke speler
	 * @return lijst van SpelerDTO's voor elke speler
	 */
	public List<SpelerDTO> startRonde() {
		return geefSpelers(spel.startRonde());
	}

	/**
	 * Geeft een lijst terug van alle edelen in het spel, inclusief hun kosten en prestige punten
	 * @return lijst van KaartDTO's met de kosten en prestigepunten van alle edelen in het spel
	 */
	public List<KaartDTO> geefAlleEdelen(){
		List<KaartDTO> edelen = new ArrayList<KaartDTO>();
		for(Kaart edele : spel.getEdelen()){
			edelen.add(new KaartDTO(edele.getKost(), edele.getPrestige()));
		}
		return edelen;
	}

	/**
	 * Bepaalt het type win dat de spelers hebben behaald in het spel
	 * @return type win in int vorm
	 */
	public int bepaalSoortWin() {
		return spel.bepaalSoortWin(spel.geefWinnaars());
	}

	/**
	 * Geeft een lijst van SpelerDTO's terug met daarin de winnaars van het spel
	 * @return lijst van SpelerDTO's terug met daarin de winnaars van het spel
	 */
	public List<SpelerDTO> geefWinnaars(){
		return geefSpelers(spel.geefWinnaars());
	}

	/**
	 * Controleert indien het spel beeïndigt is
	 * @return true indien het beeïndigt is, indien niet return false
	 */
	public boolean eindeSpel() {
		return spel.eindeSpel();
	}

	/**
	 * Geeft een lijst van SpelerDTO's terug met alle spelers van het huidige spel
	 * @return lijst van SpelerDTO's met alle spelers van het huidige spel
	 */
	public List<SpelerDTO> geefAlleSpelers() {
		return geefSpelers(spel.getSpelers());
	}

	/**
	 * Geeft een SpelerDTO object terug met de informatie van een specifieke speler
	 * @param s - speler waarvan de informatie wordt opgevraagd
	 * @return SpelerDTO object met de informatie van een specifieke speler
	 *
	 */
	public SpelerDTO geefSpeler(Speler s) {
		return new SpelerDTO(s.getGebruikersnaam(), s.getGeboortejaar(), getEdelsteenfiches(s), s.isAanDeBeurt(),s.isStartSpeler(),s.getPrestigePunten() , getOntwikkelingsKaarten(s), getEdele(s));
	}

	/**
	 * Bepaalt de winnaar van het spel en geeft de bijbehorende spelerinformatie terug in de vorm van een SpelerDTO object.
	 * @return SpelerDTO object met de gegevens van de winnende speler
	 */
	public SpelerDTO bepaalWinnaar() {
		return geefSpeler(spel.bepaalWinnaar(spel.geefWinnaars()));
	}

	/**
	 * Geeft een lijst van zichtbare ontwikkelingskaarten van een bepaald niveau als OntwikkelingskaartDTO-objecten terug.
	 * @param niveau - het niveau van de zichtbare ontwikkelingskaarten
	 * @return jst van zichtbare ontwikkelingskaarten van een bepaald niveau als OntwikkelingskaartDTO-objecten 
	 */
	public List<OntwikkelingskaartDTO> geefZichtbareOntwikkelingskaarten(int niveau) {
		List<OntwikkelingskaartDTO> ontwikkelingskaart = new ArrayList<OntwikkelingskaartDTO>();
		for(Ontwikkelingskaart ontwkaart : spel.getZichtbareOntwikkelingskaarten(niveau)) {
			ontwikkelingskaart.add(new OntwikkelingskaartDTO(ontwkaart.getKost(), ontwkaart.getNiveau(),ontwkaart.getType(), ontwkaart.getNiveau()));
		}
		return ontwikkelingskaart;
	}

	/**
	 * Geeft een lijst van DTO-objecten terug die elk een ontwikkelingskaart voorstellen met het gegeven niveau.
	 * @param niveau - niveau van de ontwikkelingskaarten die worden teruggegeven
	 * @return lijst van DTO-objecten die elk een ontwikkelingskaart voorstellen met het gegeven niveau
	 */
	public List<OntwikkelingskaartDTO> geefOntwikkelingskaarten(int niveau) {
		List<OntwikkelingskaartDTO> ontwikkelingskaart = new ArrayList<OntwikkelingskaartDTO>();
		for(Ontwikkelingskaart ontwkaart : spel.getOntwikkelingskaarten(niveau)) {
			ontwikkelingskaart.add(new OntwikkelingskaartDTO(ontwkaart.getKost(), ontwkaart.getNiveau(),ontwkaart.getType(), ontwkaart.getNiveau()));
		}
		return ontwikkelingskaart;
	}

	/**
	 * Geeft alle beschikbare edelsteenfiches terug in een Stack van EdelsteenficheDTO objecten
	 * @return edelsteenfiches in een Stack van EdelsteenficheDTO objecten
	 */
	public Stack<EdelsteenficheDTO> geefAlleEdelsteenfiches() {
		Stack<EdelsteenficheDTO> fiches = new Stack<EdelsteenficheDTO>();
		for(Edelsteenfiche fiche : spel.getEdelsteenfische()) {
			fiches.add(new EdelsteenficheDTO(fiche.getType()));
		}
		return fiches;
	}

	public List<OntwikkelingskaartDTO> getOntwikkelingsKaartenvanSpeler(SpelerDTO s) {
		return getOntwikkelingsKaarten(spel.getSpelers().stream().filter(el -> el.equals(new Speler(s.gebruikerNaam(), s.geboorteJaar()))).findFirst().get());
	}

	public List<KaartDTO> getEdeleVanSpeler(SpelerDTO s) {
		return getEdele(spel.getSpelers().stream().filter(el -> el.equals(new Speler(s.gebruikerNaam(), s.geboorteJaar()))).findFirst().get());
	}
	

}
