package domein;

import persistentie.SpelerMapper;


/**
 * SpelerRepo vertegenwoordigt een repository die de spelers in een bestaande database bevat
 * 
 * Deze bevat de link tussen het domeinlaag (SpelerRepo) en de persistentielaag (SpelerMapper)
 * 
 * @author G109
 */
public class SpelerRepo {
	
	private final SpelerMapper mapper;

	/**
	 * Bouwt een nieuwe SpelerMapper
	 */
	public SpelerRepo(){
		mapper = new SpelerMapper();
	}

	/**
	 * Zoekt de ingevoerde speler in de mapper
	 * @param speler is de ingevoerde speler
	 * @return true indien speler is gevonden, anders retourneert de methode een false
	 * @see boolean persistentie.SpelerMapper.zoekSpeler(Speler speler)
	 */
	public boolean zoekSpeler(Speler speler){
		return mapper.zoekSpeler(speler);
	}

	/**
	 * Voegt de ingevoerde speler toe aan de databank
	 * @param speler is de speler die zal worden toegevoegd
	 * @see void persistentie.SpelerMapper.addSpeler(Speler speler)
	 */
	public void addSpeler(Speler speler){
		mapper.addSpeler(speler);
	}
}
