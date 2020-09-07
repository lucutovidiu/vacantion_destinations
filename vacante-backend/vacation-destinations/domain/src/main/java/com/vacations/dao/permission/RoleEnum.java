package com.vacations.dao.permission;

import lombok.Getter;

@Getter
public enum RoleEnum {
	ADMIN("ADMIN"), USER("USER"), BUSINESS_ADMIN("BUSINESS_ADMIN");

	private String label;

	RoleEnum(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
}
