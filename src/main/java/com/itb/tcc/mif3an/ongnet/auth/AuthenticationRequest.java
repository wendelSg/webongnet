package com.itb.tcc.mif3an.ongnet.auth;

import lombok.Data;



    @Data
    public class AuthenticationRequest {

        private String email;
        private String password;

        public AuthenticationRequest(){
    }
    public AuthenticationRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
