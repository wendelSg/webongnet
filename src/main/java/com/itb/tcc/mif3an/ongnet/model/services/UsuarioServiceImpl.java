package com.itb.tcc.mif3an.ongnet.model.services;

import com.itb.tcc.mif3an.ongnet.exceptions.BadRequest;
import com.itb.tcc.mif3an.ongnet.exceptions.NotFound;
import com.itb.tcc.mif3an.ongnet.model.entity.Usuario;
import com.itb.tcc.mif3an.ongnet.model.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email).get();
/*  @Override
        public Usuario save(Usuario usuario) {
            usuario.setCodStatus(true);
            if (!usuario.validarUsuario()){
                throw new BadRequest(usuario.getMensagemErro());
            }
            return usuarioRepository.save(usuario);
        }

        @Override
        public List<Usuario> findAll() {
            return usuarioRepository.findAll();
        }

        @Override
        public Usuario findById(Long id) {
            try {
                Usuario usuario = usuarioRepository.findById(id).get();
                return usuario;
            }catch (Exception e){
                throw new NotFound("Usuario não encontrado" + id);
            }
        }
*/
    }
}
