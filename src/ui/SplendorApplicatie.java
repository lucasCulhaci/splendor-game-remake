package ui;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

import domein.DomeinController;
import domein.EdelsteenType;
import dto.EdelsteenficheDTO;
import dto.KaartDTO;
import dto.OntwikkelingskaartDTO;
import dto.SpelerDTO;
import language.Language;

public class SplendorApplicatie {
	DomeinController dc;
	Scanner invoer;
	int aantalSpelers = 0;

	public SplendorApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		try {
			dc = new DomeinController();
			
			Language.keuzeTaal("dutch");
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}
//		meldSpelersAan();
		meldAan();
		configureerSpel();
		toonOverzicht(dc.geefAlleSpelers());
		do {
			List<SpelerDTO> spelers = dc.startRonde();
			int indexOfSpelerAanDeBeurt = IntStream.range(0, spelers.size()).filter((i) -> spelers.get(i).IsStartspeler()).findFirst().orElse(0)		;	
			
			toonOverzicht(dc.geefAlleSpelers());
			do {
				//dc.startBeurt(indexOfSpelerAanDeBeurt);
				SpelerDTO SpelerAanDeBeurt = spelers.get(indexOfSpelerAanDeBeurt);
				SpelerDTO temp = new SpelerDTO(SpelerAanDeBeurt.gebruikerNaam(), SpelerAanDeBeurt.geboorteJaar(), SpelerAanDeBeurt.edelsteenfiches(), false, SpelerAanDeBeurt.IsStartspeler(), SpelerAanDeBeurt.prestigepunten(), SpelerAanDeBeurt.ontwikkelingsKaarten(), SpelerAanDeBeurt.edelen());
				
				spelers.set(indexOfSpelerAanDeBeurt, temp); //instellen in lijst speler niet meer aan de beurt
//				startSpeler.setAanDeBeurt(false);
				spelers.remove(temp);
				indexOfSpelerAanDeBeurt = 0; //zal na het verwijderen van de startspeler terug op volgorde van ingave gaan
//				do {
//					Speler beurtSpeler = (rondeSpelers.size() - 1) >= indexStartSpeler ? rondeSpelers.get(indexStartSpeler) : rondeSpelers.get(0);  
//					beurtSpeler.setAanDeBeurt(true);
//					toonOverzicht(spelers);
//					startBeurt(beurtSpeler);
//					beurtSpeler.setAanDeBeurt(false);
//					rondeSpelers.remove(beurtSpeler);
//				}while(rondeSpelers.size() != 0);
			}while(spelers.size() != 0);
		}while(!dc.eindeSpel());
		toonOverzicht(dc.geefWinnaars());
		toonScoreOverzicht(dc.geefWinnaars());
		//toonSpelers();
		//toonSpeelKaarten();
	}

	public void toonOverzicht(List<SpelerDTO> spelers) {
	    // Toon overzicht per speler
	    for (SpelerDTO speler : spelers) {
	        System.out.println("Speler: " + speler.gebruikerNaam());
	        System.out.println("Prestigepunten: " + speler.prestigepunten());
	        System.out.println("Aan de beurt: " + speler.IsAanDeBeurt());
	        System.out.println("Startspeler: " + speler.IsStartspeler());
	        System.out.println("Ontwikkelingskaarten:");
	        for (OntwikkelingskaartDTO kaart : speler.ontwikkelingsKaarten()) {
	            System.out.println("- " + kaart.type() + " (" + kaart.niveau() + ")");
	        }
	        System.out.println("Edelsteenfiches:");
	        for (EdelsteenType type : EdelsteenType.values()) {
	        	int aantalPerType = (int) speler.edelsteenfiches().stream().filter(e -> e.type().equals(type)).count();
	            System.out.println("- " + type + ": " + aantalPerType);
	        }
	        System.out.println("Edelen:");
	        for (KaartDTO edel : speler.edelen()) {
	            System.out.println("- " + edel.prestige() + " (" + edel.kost() + ")");
	        }
	        System.out.println();
	    }

	    // Toon overzicht van het spel
	    System.out.println("Spel:");
	    System.out.println("Beschikbare edelen:");
	    
		    for (KaartDTO edel : dc.geefAlleEdelen()) {
		        System.out.println("- " + edel.prestige() + " (" + edel.kost() + ")");
		    }
		    for (int niveau = 1; niveau <= 3; niveau++) {
		        System.out.println("Ontwikkelingskaarten niveau " + niveau + ":");
		        List<OntwikkelingskaartDTO> zichtbareKaarten = getZichtbareOntwikkelingskaarten(niveau);
		        for (int i = 0; i < zichtbareKaarten.size(); i++) {
		            OntwikkelingskaartDTO kaart = zichtbareKaarten.get(i);
		            System.out.println("- " + kaart.type() + " (" + kaart.niveau() + ")" + " (" + kaart.kost() + ")");
		        }
		        if (zichtbareKaarten.size() < 4) {
		            System.out.println("- Gedekte stapel (" + getOntwikkelingskaarten(niveau).size() + " kaarten)");
		        }
		    }
	    System.out.println("Edelsteenfiches:");
	    for (EdelsteenType type : EdelsteenType.values()) {
	    	int aantalPerType = (int) getEdelsteenfische().stream().filter(e -> e.type().equals(type)).count();
	        System.out.println("- " + type + ": " + aantalPerType);
	    }
	}
	private Stack<EdelsteenficheDTO> getEdelsteenfische() {
		return dc.geefAlleEdelsteenfiches();
	}

	private List<OntwikkelingskaartDTO> getOntwikkelingskaarten(int niveau) {
		return dc.geefOntwikkelingskaarten(niveau);
		
	}

	private List<OntwikkelingskaartDTO> getZichtbareOntwikkelingskaarten(int niveau) {
		return dc.geefZichtbareOntwikkelingskaarten(niveau);
	}

	private void toonScoreOverzicht(List<SpelerDTO> spelers) {
		int soortWin = dc.bepaalSoortWin();
		SpelerDTO winnaar = dc.bepaalWinnaar();
		if(soortWin == 0) { //als er maar één winnaar is
			System.out.println("WINNAAR");
			System.out.println("-----------");
		}
		if(soortWin == 2) {
			System.out.println("GELIJKSPEL");
		}
		 for (SpelerDTO speler : spelers) {
			 if(soortWin == 1 && speler.gebruikerNaam().equals(winnaar.gebruikerNaam())) {
		        	System.out.println("deze speler is de WINNAAR");
		        }
			 
		        System.out.println("Speler: " + speler.gebruikerNaam());
		        System.out.println("Prestigepunten: " + speler.prestigepunten());
		        System.out.println("aantal ontwikkelingsKaarten: " + speler.ontwikkelingsKaarten().size());
		       
		    }
	}
//	public void toonSpeelKaarten() {
//		String[] kaarten = dc.uitvoerKaarten();
//		for (String kaart : kaarten) {
//			System.out.println(kaart);
//		}
//	}

// NOTE: Mag verwijderd worden
//	public void meldSpelersAan() {
//		String[] speler = new String[2];
//		int i = 0;
//		do {
//			speler = meldAan();
//
//			this.aantalSpelers++;
//		} while (!magStoppen(this.aantalSpelers, speler[0]));
//	}

	public void meldAan() {

		String[] speler = new String[2];
		String gebruikersNaam;

		invoer = new Scanner(System.in);
// 		NOTE: Mag verwijderd worden
//		boolean invalidPlayer = false;
		boolean stoppen = false;


		do {
			System.out.println(Language.bundle.getString("naamIngeven"));
			gebruikersNaam = invoer.next();
			
			if (gebruikersNaam.equals("stop")) {
				stoppen = true;
			}
			else {				
				stoppen = false;
				System.out.println(Language.bundle.getString("geboortejaarIngeven"));
				int geboortejaar = invoer.nextInt();
				boolean playerExists = false;
				
				try {
					playerExists = dc.meldAan(gebruikersNaam, geboortejaar);
					if (playerExists) { // TODO remove the double call to dc.meldAan();
						speler[0] = gebruikersNaam;
						speler[1] = String.valueOf(geboortejaar);
						aantalSpelers++;
// 						NOTE: Mag verwijderd worden
//						invalidPlayer = false;
						
					} else {
// 						NOTE: Mag verwijderd worden
//						invalidPlayer = true;
					}
					
					System.out.printf(Language.bundle.getString("spelerZitInDeDatabank"),
							playerExists ? Language.bundle.getString("true") : Language.bundle.getString("false"));				
					
				} catch (Exception e) {
					System.err.println(Language.bundle.getString("foutAanmelden"));
					e.printStackTrace();
					//invalidPlayer = true;
				}
			}

		} while (!magStoppen(this.aantalSpelers, stoppen));

		
	}

	public boolean magStoppen(int amountOfPlayers, boolean stoppen) {
		if (amountOfPlayers < 2) {
			return false;
		}
		else if (stoppen == true && amountOfPlayers <= 4){
			return true;
		}
		else {
			return false;
		}
	}
	/*
	 
	private void toonSpelers() {
		for (SpelerDTO speler : dc.geefSpelers()) {
			System.out.printf("%s:", speler.gebruikerNaam());
			Map<String, Integer> edelsteenAantal = updateEdelsteenAantal(speler.edesteenfiches());
			for (Map.Entry<String, Integer> entry : edelsteenAantal.entrySet()) {
				System.out.printf(" %s(%d)", entry.getKey(), entry.getValue());
			}
			System.out.println();
		}
	}

	private Map<String, Integer> updateEdelsteenAantal(List<EdelsteenficheDTO> edelsteenFiches) {
		Map<String, Integer> edelsteenAantal = new HashMap<>();
		for (EdelsteenficheDTO edelsteen : edelsteenFiches) {
			String edelsteenNaam = edelsteen.type().name();
			if (edelsteenAantal.containsKey(edelsteenNaam)) {
				// If the edelsteen is already in the map, increase its count by 1
				int count = edelsteenAantal.get(edelsteenNaam);
				edelsteenAantal.put(edelsteenNaam, count + 1);
			} else {
				// If the edelsteen is not in the map, add it with a count of 1
				edelsteenAantal.put(edelsteenNaam, 1);
			}
		}
		return edelsteenAantal;
	}
	 
	 */

	// Moet verder geimplementeert worden
	private void configureerSpel() {
		dc.configuratieSpel();
	}
}
