package com.itb.tcc.mif3an.ongnet.controller;

import com.itb.tcc.mif3an.ongnet.exceptions.BadRequest;
import com.itb.tcc.mif3an.ongnet.model.entity.Item;
import com.itb.tcc.mif3an.ongnet.model.entity.Ong;
import com.itb.tcc.mif3an.ongnet.model.entity.Usuario;
import com.itb.tcc.mif3an.ongnet.model.services.ItemService;
import com.itb.tcc.mif3an.ongnet.model.services.OngService;
import com.itb.tcc.mif3an.ongnet.model.services.UsuarioService;
import com.itb.tcc.mif3an.ongnet.model.services.UsuarioServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    //blabla

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    //Busca todas ongs no bd
    @GetMapping()
    public ResponseEntity<Usuario> findByEmail(@RequestParam String email) {

        return ResponseEntity.ok().body(usuarioService.findByEmail(email));
    }
}



