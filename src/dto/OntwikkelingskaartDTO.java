package dto;

import java.util.Map;

import domein.EdelsteenType;

public record OntwikkelingskaartDTO(Map<EdelsteenType, Integer> kost, int prestige,EdelsteenType type, int niveau) {
	public OntwikkelingskaartDTO(Map<EdelsteenType, Integer> kost, int prestige,EdelsteenType type, int niveau) {
		this.kost = kost;
		this.type = type;
		this.niveau = niveau;
		this.prestige = prestige;
	}


}