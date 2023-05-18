package domein;

import java.util.List;

import persistentie.OntwikkelingskaartMapper;

/**
 * OntwikkelingskaartRepo vertegenwoordigt een repository die de ontwikkelingskaarten in een bestaande database bevat
 * 
 * Deze bevat de link tussen het domeinlaag (OntwikkelingskaartRepo) en de persistentielaag (SpelerMapper)
 *  
 * @author G109
 */
public class OntwikkelingskaartRepo {
	
	private final OntwikkelingskaartMapper mapper;

	/**
	 * Bouwt een nieuwe OntwikkelingskaartMapper
	 */
	public OntwikkelingskaartRepo() {
		this.mapper = new OntwikkelingskaartMapper();
	}

	/**
	 * Maakt een lijst van ontwikkelingskaarten van een bepaald level
	 * @param level - het level waarvan de ontwikkelingskaarten moeten gemaakt worden
	 * @return lijst van ontwikkelingskaarten van een bepaald level
	 */
	public List<Ontwikkelingskaart> maakOntwikkelingskaarten(int level) {
		return mapper.maakOntwikkelingskaarten(level);
	}
}
