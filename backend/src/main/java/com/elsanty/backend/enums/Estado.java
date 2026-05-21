package com.elsanty.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Estado {

	PENDIENTE("Pendiente"),
    REALIZADA("Realizada"),
    CANCELADA("Cancelada");

    private final String valor;

    Estado(String valor) {
        this.valor = valor;
    }

    @JsonValue
    public String getValor() {
        return valor;
    }

    @JsonCreator
    public static Estado fromValue(String value) {
        for (Estado ev : values()) {
            if (ev.valor.equalsIgnoreCase(value)) {
                return ev;
            }
        }
        throw new IllegalArgumentException("Estado de visita inválido: " + value);
    }
}
