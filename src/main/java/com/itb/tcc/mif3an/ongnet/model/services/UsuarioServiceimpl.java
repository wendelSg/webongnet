package com.itb.tcc.mif3an.ongnet.model.services;

import com.itb.tcc.mif3an.ongnet.exceptions.BadRequest;
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
    public Usuario saveUsuario(Usuario usuario) {
        usuario.setCodStatus(true);
        if (!usuario.validarUsuario()){
            throw new BadRequest(usuario.getMensagemErro());
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return List.of();
    }

    @Override
    public Usuario findById(Long id) {
        return null;
    }
}
