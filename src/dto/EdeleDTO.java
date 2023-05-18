package dto;

import java.util.Map;

import domein.EdelsteenType;

public record EdeleDTO(Map<EdelsteenType, Integer> kost, int prestige) {
	public EdeleDTO(Map<EdelsteenType, Integer> kost, int prestige) {
		this.kost = kost;
		this.prestige = prestige;
	}

}