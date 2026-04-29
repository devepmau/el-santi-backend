package com.elsanty.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Cortes {

	MUY_BAJO("Muy bajo"),
    BAJO("Bajo"),
    MEDIO("Medio"),
    ALTO("Alto");

    private final String valor;

    Cortes(String valor) {
        this.valor = valor;
    }

    @JsonValue
    public String getValor() {
        return valor;
    }

    @JsonCreator
    public static Cortes fromValue(String value) {
        for (Cortes c : values()) {
            if (c.valor.equalsIgnoreCase(value)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Preferencia de corte inválida: " + value);
    }
}