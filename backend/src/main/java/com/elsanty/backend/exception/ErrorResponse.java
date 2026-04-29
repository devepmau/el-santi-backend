package com.elsanty.backend.exception;

public class ErrorResponse {

    private String error;
    private String detalle;

    public ErrorResponse(String error, String detalle) {
        this.error = error;
        this.detalle = detalle;
    }

    public String getError() {
        return error;
    }

    public String getDetalle() {
        return detalle;
    }
}