package com.itb.tcc.mif3an.ongnet.model.services;


import com.itb.tcc.mif3an.ongnet.exceptions.NotFound;
import com.itb.tcc.mif3an.ongnet.model.entity.Usuario;
import com.itb.tcc.mif3an.ongnet.model.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceimpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceimpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario findByEmail(String email) {
        try {
            return this.usuarioRepository.findByEmail(email).get();
        } catch (Exception e) {
            throw new NotFound("Usuário não encontrado com o email: " + email);
        }

    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}
