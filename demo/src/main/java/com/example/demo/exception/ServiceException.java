package com.example.demo.exception;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ServiceException(final String mensagem) {
        super(mensagem);
    }
}