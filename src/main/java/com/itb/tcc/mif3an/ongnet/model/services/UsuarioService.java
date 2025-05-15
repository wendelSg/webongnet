package com.itb.tcc.mif3an.ongnet.model.services;

import com.itb.tcc.mif3an.ongnet.model.entity.Ong;
import com.itb.tcc.mif3an.ongnet.model.entity.Usuario;

import java.util.List;


public interface UsuarioService {

    public Usuario saveUsuario(Usuario usuario);
    public List<Usuario> findAll();
    public Usuario findById(Long id);
}
