package com.proiect.vacationdestinations.model;

import lombok.Getter;

@Getter
public enum Role {
	ADMIN("ADMIN"), USER("USER");

	private String label;

	Role(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
}
