package com.itb.tcc.mif3an.ongnet.model.services;

import com.itb.tcc.mif3an.ongnet.model.entity.Usuario;

import java.util.List;


public interface UsuarioService {

    Usuario findByEmail(String email);
    List<Usuario> findAll();
}
