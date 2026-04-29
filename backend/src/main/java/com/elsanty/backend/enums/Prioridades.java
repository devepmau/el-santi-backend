package com.elsanty.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Prioridades {

    BAJA("Baja"),
    MEDIA("Media"),
    ALTA("Alta");

    private final String valor;

    Prioridades(String valor) {
        this.valor = valor;
    }

    @JsonValue
    public String getValor() {
        return valor;
    }

    @JsonCreator
    public static Prioridades fromValue(String value) {
        for (Prioridades p : values()) {
            if (p.valor.equalsIgnoreCase(value)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Prioridad inválida: " + value);
    }
}