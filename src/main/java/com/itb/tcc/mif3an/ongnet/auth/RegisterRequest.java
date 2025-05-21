package com.itb.tcc.mif3an.ongnet.auth;

import com.itb.tcc.mif3an.ongnet.model.entity.Role;
import lombok.Data;

@Data
class RegisterRequest {
    private String nome;
    private String email;
    private String password;
    private Role role;

    public RegisterRequest() {
    }

    public RegisterRequest(Role role, String password, String email, String nome) {
        this.role = role;
        this.password = password;
        this.email = email;
        this.nome = nome;
    }
}