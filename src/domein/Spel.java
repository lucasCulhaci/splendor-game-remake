// SPLENDOR

package domein;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * De Spel klasse vertegenwoordigt de spelsituatie van het spel Splendor
 * @author G109
 */
public class Spel {

	/// INSTANTIE ATTRIBUTEN HUIDIGE RONDE
	/// HR -> Huidige Ronde
	// Gebruikersnaam
	private String gebruikersnaamHR;

	// Prestigepunten
	private int prestigePuntenHR;

	// Ontwikkelingskaarten
	private List ontwikkelingskaartTypeHR = new ArrayList<>();
	private List ontwikkelingskaartPrestigeHR = new ArrayList<>();

	// Edelsteenfiches
	private List edelsteenfischeTypeHR = new ArrayList<>();
	private List<Integer> edelsteenfischeAantalHR = new ArrayList<>();
	
	// Edelen
	private List edelPrestigeHR = new ArrayList<>();
	private List edelKostHR = new ArrayList<>();

	// Edelsteenfiches op bord
	private List edelsteenfischeTypeBordHR = new ArrayList<>();
	private List edelsteenfischeAantalBordHR = new ArrayList<>();



	// Instantievariabelen
	private List<Speler> spelers;
	private List<Kaart> edelen;
	private List<Ontwikkelingskaart> ontwikkelingskaarten1; // niveau 1
	private List<Ontwikkelingskaart> ontwikkelingskaarten2; // niveau 2
	private List<Ontwikkelingskaart> ontwikkelingskaarten3; // niveau 3
	private List<Ontwikkelingskaart> zichtbareOntwikkelingskaarten1;
	private List<Ontwikkelingskaart> zichtbareOntwikkelingskaarten2; 
	private List<Ontwikkelingskaart> zichtbareOntwikkelingskaarten3; 
	
	// LIFO
	private Stack<Edelsteenfiche> edelsteenfiches;

	// Ontwikkelingskaarten repo
	private OntwikkelingskaartRepo kaartenRepo;


	/**
	 * Bouwt en initialiseert een nieuwe Spel constructor
	 * waarbij een ArrayList van Spelobjecten wordt aangemaakt
	 */
	public Spel() {
		this.edelsteenfiches = new Stack<>();
		this.kaartenRepo = new OntwikkelingskaartRepo();
		this.spelers = new ArrayList<>();
}
	/**
	 * Bouwt een nieuwe spel op waarbij de spelers, ontwikkelingskaarten, 
	 * edelsteenfiches & edelen worden geïnstantieerd
	 */
	public void buildSpel() {
		// Instantie van edelsteenfiches aanmaken
		int numSpelers = spelers.size();
		int numfiches = numSpelers == 2 ? 4 : numSpelers == 3 ? 5 : 7;
		// voor elke type
		for (EdelsteenType type : EdelsteenType.values()) {
			// x aantal fiches
			for (int i = 0; i < numfiches; i++) {
				edelsteenfiches.push(new Edelsteenfiche(type));
			}
		}

		// Instantie van ontwikkelingskaarten per niveau aanmaken en vier kaarten op het bord plaatsen
		for (int level = 1; level <= 3; level++) {
		    List<Ontwikkelingskaart> ontwikkelingskaarten = new ArrayList<>(kaartenRepo.maakOntwikkelingskaarten(level));
		    Collections.shuffle(ontwikkelingskaarten);
		    List<Ontwikkelingskaart> zichtbareOntwikkelingskaarten = new ArrayList<>();
		    for (int i = 0; i <= 3; i++) {
		        zichtbareOntwikkelingskaarten.add(ontwikkelingskaarten.get(i));
		        ontwikkelingskaarten.remove(i);   
		    }
		    if (level == 1) {
    			this.ontwikkelingskaarten1 = ontwikkelingskaarten;
    			this.zichtbareOntwikkelingskaarten1 = zichtbareOntwikkelingskaarten;
		    }
		    else if(level == 2) {
    			this.ontwikkelingskaarten2 = ontwikkelingskaarten;
    			this.zichtbareOntwikkelingskaarten2 = zichtbareOntwikkelingskaarten;
		    }
		    else {
    			this.ontwikkelingskaarten3 = ontwikkelingskaarten;
    			this.zichtbareOntwikkelingskaarten3 = zichtbareOntwikkelingskaarten;
		    }
		}


		// Instantie van edelen aanmaken
		int numEdelen = numSpelers == 2 ? 3 : numSpelers == 3 ? 4 : 5;
		List<Kaart> alleEdelen = maakEdelen();
		Collections.shuffle(alleEdelen); // geeft een lijst van de 10 edelen met willekurige volgorde terug
		this.edelen = new ArrayList<>(alleEdelen.subList(0, numEdelen)); // een lijst met de nodige aantal edelen
	
	}

	/**
	 * Voegt een nieuwe speler toe aan het spel
	 * @param gebruikersnaam - gebruikersnaam van de speler
	 * @param geboortejaar - geboortejaar van de speler
	 */
	public void voegSpelerToe(String gebruikersnaam, int geboortejaar) {
		this.spelers.add(new Speler(gebruikersnaam, geboortejaar));
	}
	

	/**
	 * Maakt een lijst van edelen die kunnen worden gebruikt in het spel
	 * @return een lijst van edelen
	 */
	public List<Kaart> maakEdelen() {
		List<Kaart> alleEdelen = new ArrayList<>();

		Map<EdelsteenType, Integer> kosten1 = new HashMap<>();
		kosten1.put(EdelsteenType.DIAMANT, 3);
		kosten1.put(EdelsteenType.SAFFIER, 3);
		kosten1.put(EdelsteenType.ONYX, 3);
		Kaart edele1 = new Edele(kosten1, 3);
		alleEdelen.add(edele1);

		Map<EdelsteenType, Integer> kosten2 = new HashMap<>();
		kosten2.put(EdelsteenType.SMARAGD, 4);
		kosten2.put(EdelsteenType.ROBIJN, 4);
		Kaart edele2 = new Edele(kosten2, 3);
		alleEdelen.add(edele2);

		Map<EdelsteenType, Integer> kosten3 = new HashMap<>();
		kosten3.put(EdelsteenType.DIAMANT, 4);
		kosten3.put(EdelsteenType.SAFFIER, 4);
		Kaart edele3 = new Edele(kosten3, 3);
		alleEdelen.add(edele3);

		Map<EdelsteenType, Integer> kosten4 = new HashMap<>();
		kosten4.put(EdelsteenType.SMARAGD, 3);
		kosten4.put(EdelsteenType.ROBIJN, 3);
		kosten4.put(EdelsteenType.ONYX, 3);
		Kaart edele4 = new Edele(kosten4, 3);
		alleEdelen.add(edele4);

		Map<EdelsteenType, Integer> kosten5 = new HashMap<>();
		kosten5.put(EdelsteenType.DIAMANT, 3);
		kosten5.put(EdelsteenType.SAFFIER, 3);
		kosten5.put(EdelsteenType.SMARAGD, 3);
		Kaart edele5 = new Edele(kosten5, 3);
		alleEdelen.add(edele5);

		Map<EdelsteenType, Integer> kosten6 = new HashMap<>();
		kosten6.put(EdelsteenType.ROBIJN, 4);
		kosten6.put(EdelsteenType.ONYX, 4);
		Kaart edele6 = new Edele(kosten6, 3);
		alleEdelen.add(edele6);

		Map<EdelsteenType, Integer> kosten7 = new HashMap<>();
		kosten7.put(EdelsteenType.DIAMANT, 4);
		kosten7.put(EdelsteenType.SAFFIER, 4);
		Kaart edele7 = new Edele(kosten7, 3);
		alleEdelen.add(edele7);

		Map<EdelsteenType, Integer> kosten8 = new HashMap<>();
		kosten8.put(EdelsteenType.SMARAGD, 3);
		kosten8.put(EdelsteenType.ROBIJN, 3);
		kosten8.put(EdelsteenType.ONYX, 3);
		Kaart edele8 = new Edele(kosten8, 3);
		alleEdelen.add(edele8);

		Map<EdelsteenType, Integer> kosten9 = new HashMap<>();
		kosten9.put(EdelsteenType.DIAMANT, 3);
		kosten9.put(EdelsteenType.SAFFIER, 3);
		kosten9.put(EdelsteenType.SMARAGD, 3);
		Kaart edele9 = new Edele(kosten9, 3);
		alleEdelen.add(edele9);

		Map<EdelsteenType, Integer> kosten10 = new HashMap<>();
		kosten10.put(EdelsteenType.ROBIJN, 4);
		kosten10.put(EdelsteenType.ONYX, 4);
		Kaart edele10 = new Edele(kosten10, 3);
		alleEdelen.add(edele10);

		return alleEdelen;

	}

	/**
	 * Geeft een lijst van alle spelers
	 * @return lijst van spelers
	 */
	public List<Speler> getSpelers() {
		return this.spelers;
	}

	/**
	 * Retourneert de lijst van ontwikkelingskaarten voor het opgegeven niveau.
	 *
	 * @param niveau het niveau van de gewenste ontwikkelingskaarten (1, 2 of 3)
	 * @return de lijst van ontwikkelingskaarten voor het opgegeven niveau
	 */
	public List<Ontwikkelingskaart> getOntwikkelingskaarten(int niveau) {
	    if (niveau == 1) {
	        return this.ontwikkelingskaarten1;
	    } else if (niveau == 2) {
	        return this.ontwikkelingskaarten2;
	    } else {
	        return this.ontwikkelingskaarten3;
	    }
	}


	/**
	 * Geeft een lijst van zichtbare ontwikkelingskaarten terug van het opgegeven niveau
	 * @param niveau - opgegeven niveau
	 * @return lijst van zichtbare ontwikkelingskaarten	van het opgegeven niveau
	 */
	public List<Ontwikkelingskaart> getZichtbareOntwikkelingskaarten(int niveau) {
	    if (niveau == 1) {
	        return this.zichtbareOntwikkelingskaarten1;
	    } else if (niveau == 2) {
	        return this.zichtbareOntwikkelingskaarten2;
	    } else if (niveau == 3){
	        return this.zichtbareOntwikkelingskaarten3;
	    }
	    return null;
	}
	
	/**
	 * Geeft een lijst terug van de beschikbare edelen in het spel
	 * @return lijst van edelen
	 */
	public List<Kaart> getEdelen() {
		return this.edelen;
	}
	
	/**
	 * Geeft een stapel van edelsteenfiches
	 * @return stapel van edelsteenfiches
	 */
	public Stack<Edelsteenfiche> getEdelsteenfische() {
		return this.edelsteenfiches;
	}
	
	/**
	 * Bepaalt de startspeler gebruikmakend van de geboortejaar en gebruikersnaam van de ingegeven spelers
	 * @return startspeler
	 */
	public Speler bepaalStartSpeler() {
		List<Speler> spelersList = new ArrayList<>(spelers);
		spelersList.sort(Comparator.comparing(Speler::getGeboortejaar, Comparator.reverseOrder()));
		int jongste = spelersList.get(0).getGeboortejaar();
		List<Speler> jongsteSpelers = new ArrayList<>();
		for (Speler speler : spelersList) {
			if (speler.getGeboortejaar() == jongste) {
				jongsteSpelers.add(speler);
			}
		}

		if (jongsteSpelers.size() == 1) {
			return jongsteSpelers.get(0);			
		} else {
				jongsteSpelers.sort(Comparator.comparingInt(speler -> -speler.getGebruikersnaam().length()));
				
				int langsteNaam = jongsteSpelers.get(0).getGebruikersnaam().length();
				List<Speler> langesteNaamSpelers = new ArrayList<>();
				for (Speler speler : jongsteSpelers) {
					if (speler.getGebruikersnaam().length() == langsteNaam) {
						langesteNaamSpelers.add(speler);
					}
				}
				
				if (langesteNaamSpelers.size() == 1) {
					return langesteNaamSpelers.get(0);
				} else {
						langesteNaamSpelers.sort(Comparator.comparing(Speler::getGebruikersnaam, Comparator.reverseOrder()));
						return langesteNaamSpelers.get(0);		
				}
		}
	}
	
	/**
	 * Start een nieuwe ronde en bepaalt de volgende door gebruik te maken van de startspeler
	 * @return een lijst met de volgorde van de spelers
	 */
	public List<Speler> startRonde() {
		
		List<Speler> rondeSpelers = new ArrayList<>(spelers);
		Speler startSpeler = bepaalStartSpeler();
		int indexStartSpeler = rondeSpelers.indexOf(startSpeler);
		startSpeler.setStartSpeler(true);
		startSpeler.setAanDeBeurt(true);
		rondeSpelers.set(indexStartSpeler, startSpeler); //startspeler updaten in lijst;
		//toonOverzicht(getSpelers());
		return rondeSpelers;
//		startBeurt(startSpeler);
//		startSpeler.setAanDeBeurt(false);
//		rondeSpelers.remove(startSpeler);
//		do {
//			Speler beurtSpeler = (rondeSpelers.size() - 1) >= indexStartSpeler ? rondeSpelers.get(indexStartSpeler) : rondeSpelers.get(0);  
//			beurtSpeler.setAanDeBeurt(true);
//			toonOverzicht(spelers);
//			startBeurt(beurtSpeler);
//			beurtSpeler.setAanDeBeurt(false);
//			rondeSpelers.remove(beurtSpeler);
//		}while(rondeSpelers.size() != 0);

	}

//	public void startSpel() {
//		toonOverzicht(spelers);
//		do {
//			startRonde();
//		}while(!eindeSpel()); //eindeloze loop momenteel wegen sprestigepunten worden nooit aangepast.
//		toonScoreOverzicht(geefWinnaars());
//	}

	/**
	 * Start een nieuwe ronde door de startspeler te bepalen en de spelerslijst aan te passen.
	 */
	public void speelRonde() {
		startRonde();
	}
	

	/**
	 * Bepaalt of het spel geëindigd is door te controleren of er minstens één speler is met 15 of meer prestige punten.
	 * @return true als minstens één speler 15 of meer prestigepunten heeft, indien niet return false
	 */
	public boolean eindeSpel() {
		return this.spelers.stream().filter((speler) -> speler.getPrestigePunten() >= 15).count() >= 1;
	}

	/**
	 * Geeft een lijst terug van spelers die minstens 15 prestige punten hebben.
	 * @return lijst van Speler objecten die minstens 15 prestigepunten hebben.
	 */
	public List<Speler> geefWinnaars(){
		return this.spelers.stream().filter((speler) -> speler.getPrestigePunten()>= 15).collect(Collectors.toList());	}
	
	/**
	 * Bepaald de soort win die er is opgetreden
	 * @param spelers - lijst van spelers
	 * @return een int waarde die de soort win bepaald (0 = 1 speler heeft gewonnen, 1 = speler met het minst aantal prestigepunten heeft gewonnen, 2 = gelijkspel)
	 */
	public int bepaalSoortWin(List<Speler> spelers) {  //0: één speler bestaat/wint, 1: speler met minst prestige wint, 2: gelijkspel
		Speler huidigeWinnaar = spelers.get(0); // anders error dat huidigewinnar may not have been initialized. doet eigenlijk niets
		int eindstand = 0;
		
		if(spelers.size() == 1) {
			return eindstand; //kan  maar één winnaar zijn.
		}
		for(int i = 0; i < spelers.size(); i++) {
			if(huidigeWinnaar.getPrestigePunten() < spelers.get(i).getPrestigePunten())
			huidigeWinnaar = spelers.get(i);
			else {
				if(spelers.get(i).getPrestigePunten() == huidigeWinnaar.getPrestigePunten()) {
					if(huidigeWinnaar.getOntwikkelingskaarten().size() < spelers.get(i).getOntwikkelingskaarten().size()) {
						huidigeWinnaar = spelers.get(i);
						eindstand = 1;
					}
					else
					eindstand = 2;
					
					
				}
				
			}
		}
		return eindstand;
	}

	/**
	 * Bepaalt de winnaar van het spel op basis van het aantal prestige punten en het aantal ontwikkelingskaarten
	 * @param speler - lijst van spelers
	 * @return speler die heeft gewonnen
	 */
	public Speler bepaalWinnaar(List<Speler> speler) {
		Speler huidigeWinnaar = spelers.get(0); // anders error dat huidigewinnar may not have been initialized. doet eigenlijk niets
		// int eindstand = 0;  GEEN GEBRUIK
		
		if(spelers.size() == 1) {
			return huidigeWinnaar; //kan  maar één winnaar zijn.
		}
		for(int i = 0; i < spelers.size(); i++) {
			if(huidigeWinnaar.getPrestigePunten() < spelers.get(i).getPrestigePunten())
			huidigeWinnaar = spelers.get(i);
			else {
				if(spelers.get(i).getPrestigePunten() == huidigeWinnaar.getPrestigePunten()) {
					if(huidigeWinnaar.getOntwikkelingskaarten().size() < spelers.get(i).getOntwikkelingskaarten().size()) {
						huidigeWinnaar = spelers.get(i);
						//eindstand = 1;
					}
					//else
					//eindstand = 2;
				}
				
			}
		}
		return huidigeWinnaar;
	}


	public void startBeurt(Speler startSpeler, Edelsteenfiche edelsteenfiche) {
	//  Doe het uit commentaar om te testen
		  
		
		kiesEdelsteenfische(edelsteenfiche, startSpeler);
		
		Map<EdelsteenType, Integer> kost = new HashMap<>();
		kost.put(EdelsteenType.DIAMANT, 1);
		Ontwikkelingskaart kaart = new Ontwikkelingskaart(kost, 2, EdelsteenType.DIAMANT, 1);
		this.zichtbareOntwikkelingskaarten1.add(kaart);
		this.zichtbareOntwikkelingskaarten1.remove(0);
		kiesOntwikkelingskaart(zichtbareOntwikkelingskaarten1.get(zichtbareOntwikkelingskaarten1.size() - 1), startSpeler);
		 
	}
	
	// Zelfde rol van de getter
//	public List<Edelsteenfiche> startNemenEdelsteenfische() {
//		return this.edelsteenfiches;
//	}

	/**
	 * Geeft het edelsteenfiche voor de ingegeven speler en verwijderd deze vervolgens uit het spel
	 * @param edelsteen - Edelsteenfiche die zal worden verwijderd
	 * @param speler - speler die de edelsteenfiche krijgt
	 */
	public void kiesEdelsteenfische(Edelsteenfiche edelsteen, Speler speler) {
		
		verwijderEdelsteenfiche(edelsteen.getType());
		speler.addEdelsteenfiche(edelsteen);
	}
	
	/**
	 * Geeft het edelsteenfiche terug aan de spel en verwijderd deze van de speler
	 * @param edelsteen - Edelsteenfiche die zal worden teruggegeven
	 * @param speler - speler waarvan de edelsteenfiche zal verwijderd worden
	 */
	public void geefEdelsteenfischeTerug(Edelsteenfiche edelsteen, Speler speler) {
		speler.removeEdelsteenfiche(edelsteen);
		this.edelsteenfiches.add(edelsteen);
	}
	
	/**
	 * Laat de gebruiker een ontwikkelingskaart kiezen. Deze kaart wordt vervolgens toegevoegd aan de speler, 
	 * wordt verwijderd van spel en er wordt een nieuwe kaart in de plaats gezet op het spelbord
	 * @param kaart - Ontwikkelingskaart dat de speler kiest
	 * @param speler - speler die de ontwikkelingskaart kiest
	 */
	public void kiesOntwikkelingskaart(Ontwikkelingskaart kaart, Speler speler) {
		// Check of de speler genoeg edelsteenfisches heeft om de kaart te kopen 
	    //if (heeftGenoegEdelstenen(kaart.getKost(), speler.geefEdelsteenfiches())) {
	    	
	    	// edelstenen verplaatsen vanuit speler voorraad naar de spel voorraad
	        Map<EdelsteenType, Integer> kost = kaart.getKost();
	        for (EdelsteenType type : kost.keySet()) {
	            int vereistAantal = kost.get(type);
	            for (int i = 0; i < vereistAantal; i++) {
	                Edelsteenfiche fiche = speler.verwijderEdelsteenfiche(type);
	                this.edelsteenfiches.add(fiche);
	            }
	        }
	    	
	        // kaart verplaatsen vanuit spel voorraad naar de speler voorraad 
	        // en een nieuwe kaart op het bord leggen indien mogelijk
	        speler.addOntwikkelingskaarten(kaart);
	        speler.addPrestigePunten(kaart.getPrestige());
	    
}
	public void VerwijderZichtbareKaart(int indexOfKaart, int niveau) {
	    if (niveau == 1) {
	         this.zichtbareOntwikkelingskaarten1.remove(indexOfKaart);

	         this.zichtbareOntwikkelingskaarten1.add(ontwikkelingskaarten1.get((int)(Math.random() * (ontwikkelingskaarten1.size()))));
	    } else if (niveau == 2) {
	        this.zichtbareOntwikkelingskaarten2.remove(indexOfKaart);
	         this.zichtbareOntwikkelingskaarten2.add(ontwikkelingskaarten2.get((int)(Math.random() * (ontwikkelingskaarten2.size()))));
	    } else if (niveau == 3){
	        this.zichtbareOntwikkelingskaarten3.remove(indexOfKaart);
	         this.zichtbareOntwikkelingskaarten3.add(ontwikkelingskaarten3.get((int)(Math.random() * (ontwikkelingskaarten3.size()))));
	   }
	}
	
	/**
	 * Controleert indien de speler genoeg edelsteenfiches heeft om een Edelsteenfiche te kopen
	 * @param kost - kost van de kaart
	 * @param edelstenen - edelsteenfiches van de speler
	 * @return true indien de speler genoeg edelsteenfiches heeft, indien niet return false
	 */
	public boolean heeftGenoegEdelstenen(Map<EdelsteenType, Integer> kost, List<Edelsteenfiche> edelstenen) {
	    for (EdelsteenType type : kost.keySet()) {
	        int vereistAantal = kost.get(type);
	        int aantal = 0;
	        for (Edelsteenfiche fiche : edelstenen) {
	            if (fiche.getType() == type) {
	                aantal++;
	            }
	        }
	        if (aantal < vereistAantal) {
	            return false;
	        }
	    }
	    return true;
	}
	
	/**
	 * Verwijderd een edelsteenfiche van de spelvoorraad van het opgegeven type
	 * @param type
	 * @exception NoSuchElementException als er geen edelsteenfiche van het opgegeven type aanwezig is in het spelvoorraad 
	 */
	public void verwijderEdelsteenfiche(EdelsteenType type) {
		try {
			for (Edelsteenfiche fiche : edelsteenfiches) {
				if (fiche.getType() == type) {
					edelsteenfiches.remove(fiche);
					return;
				}
			}
		}
		catch(NoSuchElementException e) {
//			System.err.println("Edelsteenfiche " + e + " van het opgegeven type is niet aanwezig in het spelvoorraad");
		}
		catch(Exception e) {
			//e.printStackTrace();
		}
	}


	/**
	 * Toont overzicht van de huidige speler aan de beurt
	 * @param speler - speler waarvan de overzicht zal getoond worden
	 */
	public void toonOverzichtSpelerAanDeBeurt(Speler speler) {

			this.gebruikersnaamHR = speler.getGebruikersnaam();

			setGebruikersnaamHR(speler.getGebruikersnaam());
			
			this.prestigePuntenHR = speler.getPrestigePunten();


			// Ontwikkelingskaarten
	        for (Ontwikkelingskaart kaart : speler.getOntwikkelingskaarten()) {
	            this.ontwikkelingskaartTypeHR.add(kaart.getType());
	            this.ontwikkelingskaartPrestigeHR.add(kaart.getPrestige());
	        }

	        // Edelsteenfiches Speler
	        for (EdelsteenType type : EdelsteenType.values()) {
	        	int aantalPerType = (int) speler.geefEdelsteenfiches().stream().filter(e -> e.getType().equals(type)).count();
	        	this.edelsteenfischeTypeHR.add(type);
	        	this.edelsteenfischeAantalHR.add(aantalPerType);
	        }
	        
	        // Edelen
	        for (Edele edel : speler.getEdelen()) {
	            this.edelPrestigeHR.add(edel.getPrestige());
	            this.edelKostHR.add(edel.getKost());
	        }

	        // Edelsteenfiches Bord
			for (EdelsteenType type : EdelsteenType.values()) {
				int aantalPerType = (int) getEdelsteenfische().stream().filter(e -> e.getType().equals(type)).count();

				this.edelsteenfischeTypeBordHR.add(type);
				this.edelsteenfischeAantalBordHR.add(aantalPerType);

			}

	}



	/**
	 * Set de gebruikersnaam van de huidige speler
	 * @param gebruikersnaam - gebruikersnaam van de huidige speler
	 */
	public void setGebruikersnaamHR(String gebruikersnaam) {
		this.gebruikersnaamHR = gebruikersnaam;
	}

	
	/**
	 * Geeft de gebruikersnaam van de speler terug
	 * @return gebruikersnaam van de speler in String vorm
	 */
	public String getGebruikersnaamHR() {
		return this.gebruikersnaamHR;
	}

	/**
	 * Geeft de prestigepunten van de speler terug
	 * @return aantal prestigepunten van de speler in int vorm
	 */
	public int getPrestigePuntenHR() {
		return this.prestigePuntenHR;
	}

	/**
	 * Geeft een lijst van ontwikkelingskaarttypes van de speler terug
	 * @return lijst van ontwikkelingskaarttypes
	 */
	public List getOntwikkelingskaartTypeHR() {
		return this.ontwikkelingskaartTypeHR;
	}

	/**
	 * Geeft een lijst van ontwikkelingskaartprestige's terug
	 * @return lijst van ontwikkelingskaartprestiges
	 */
	public List getOntwikkelingskaartPrestigeHR() {
		return this.ontwikkelingskaartPrestigeHR;
	}

	/**
	 * Geeft een lijst van edelsteenfichetypes terug
	 * @return lijst van edelsteenfichetypes
	 */
	public List getEdelsteenfischeTypeHR() {
		return this.edelsteenfischeTypeHR;
	}

	/**
	 * Geeft lijst van het aantal edelsteenfiches terug
	 * @return lijst van het aantal edelsteenfiches
	 */
	public List getEdelsteenfischeAantalHR() {
		return this.edelsteenfischeAantalHR;
	}

	/**
	 * Geeft een lijst van edelprestiges terug
	 * @return lijst van edelprestiges
	 */
	public List getEdelPrestigeHR() {
		return this.edelPrestigeHR;
	}

	/**
	 * Geef een lijst van edelkost terug
	 * @return lijst van edelkost
	 */
	public List getEdelKostHR() {
		return this.edelKostHR;
	}

	/**
	 * Geef een lijst van edelsteenfichetypes op het spelbord terug 
	 * @return lijst van edelsteenfichetypes op het spelbord
	 */
	public List getEdelsteenfischeTypeBordHR() {
		return this.edelsteenfischeTypeBordHR;
	}

	/**
	 * Geeft een lijst van aantal edelsteenfiches van op spelbord terug
	 * @return lijst van aantal edelsteenfiches van op spelbord
	 */
	public List getEdelsteenfischeAantalBordHR() {
		return this.edelsteenfischeAantalBordHR;
	}

}
