package dto;

import java.util.Map;

import domein.EdelsteenType;

public record KaartDTO(Map<EdelsteenType, Integer> kost, int prestige) {
	public KaartDTO(Map<EdelsteenType, Integer> kost, int prestige) {
		this.kost = kost;
		this.prestige = prestige;
	}

}