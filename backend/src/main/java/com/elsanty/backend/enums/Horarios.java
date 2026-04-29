package com.elsanty.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Horarios {

    MANANA("Mañana"),
    TARDE("Tarde"),
    INDISTINTO("Indistinto");

    private final String valor;

    Horarios(String valor) {
        this.valor = valor;
    }

    @JsonValue
    public String getValor() {
        return valor;
    }

    @JsonCreator
    public static Horarios fromValue(String value) {
        for (Horarios h : values()) {
            if (h.valor.equalsIgnoreCase(value)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Preferencia horaria inválida: " + value);
    }
}