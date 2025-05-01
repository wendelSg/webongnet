package com.itb.tcc.mif3an.ongnet.exceptions;


public class NotFound extends RuntimeException {

    public NotFound(String message) {
        // super: acessando o construtor da classe pai
        super(message);
    }
}
