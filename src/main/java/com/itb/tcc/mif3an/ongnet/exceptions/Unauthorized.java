package com.itb.tcc.mif3an.ongnet.exceptions;



public class Unauthorized extends RuntimeException {

    public Unauthorized(String message) {
        // super: acessando o construtor da classe pai
        super(message);
    }
}
