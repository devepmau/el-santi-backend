package com.elsanty.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CategoriaTrabajo {
	
	JARDIN("Jardin"),
	PISCINA("Piscina"),
	PODA("Poda"),
	ELECTRICIDAD("Electricidad"),
	ALBAÑILERIA("Albañilería"),
	MANTENIMIENTO_GENERAL("Mantenimiento general"),
	OTROS("Otros");
	
	private final String valor;
	
	CategoriaTrabajo(String valor){
		this.valor = valor;
	}
	
	@JsonValue
	public String getValor() {
		return valor;
	}
	
	@JsonCreator
	public static CategoriaTrabajo fromValue(String value) {
		for(CategoriaTrabajo ct : values()) {
			if(ct.valor.equalsIgnoreCase(value)) {
				return ct;
			}
		}
		throw new IllegalArgumentException("Categoria de trabajo invalida: " + value);
	}

}
