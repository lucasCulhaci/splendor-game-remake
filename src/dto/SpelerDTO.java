package dto;

import java.util.List;

import domein.Ontwikkelingskaart;

public record SpelerDTO(String gebruikerNaam, int geboorteJaar, List<EdelsteenficheDTO> edelsteenfiches, boolean IsAanDeBeurt, boolean IsStartspeler,int prestigepunten, List<OntwikkelingskaartDTO> ontwikkelingsKaarten, List<KaartDTO> edelen) {

	public SpelerDTO(String gebruikerNaam, int geboorteJaar, List<EdelsteenficheDTO> edelsteenfiches,
			boolean IsAanDeBeurt, boolean IsStartspeler,int prestigepunten,  List<OntwikkelingskaartDTO> ontwikkelingsKaarten,
			List<KaartDTO> edelen) {
		this.prestigepunten = prestigepunten;
		this.gebruikerNaam = gebruikerNaam;
		this.geboorteJaar = geboorteJaar;
		this.edelsteenfiches = edelsteenfiches;
		this.IsAanDeBeurt = IsAanDeBeurt;
		this.IsStartspeler = IsStartspeler;
		this.ontwikkelingsKaarten = ontwikkelingsKaarten;
		this.edelen = edelen;
		
	}


}