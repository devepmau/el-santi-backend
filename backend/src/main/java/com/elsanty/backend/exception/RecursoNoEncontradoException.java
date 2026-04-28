package com.elsanty.backend.exception;

@SuppressWarnings("serial")
public class RecursoNoEncontradoException extends RuntimeException {
    public RecursoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}