package com.itb.tcc.mif3an.ongnet.exceptions;



public class BadRequest extends RuntimeException {

    public BadRequest(String message) {
        // super: acessando o construtor da classe pai
        super(message);
    }
}
