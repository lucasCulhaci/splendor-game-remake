package dto;

import domein.EdelsteenType;

public record EdelsteenficheDTO(EdelsteenType type) {

	// NOTE: Dit constructor wordt ook intern gegeneerd bij een record,
	// de intern gegenereerde constructor noemen we een "canonical" constructor 
	public EdelsteenficheDTO(EdelsteenType type) {
		this.type = type;
	}

}