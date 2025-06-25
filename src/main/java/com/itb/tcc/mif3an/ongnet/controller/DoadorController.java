package com.itb.tcc.mif3an.ongnet.controller;

import com.itb.tcc.mif3an.ongnet.model.entity.Ong;
import com.itb.tcc.mif3an.ongnet.model.entity.Usuario;
import com.itb.tcc.mif3an.ongnet.model.services.DoacaoService;
import com.itb.tcc.mif3an.ongnet.model.services.ItemDoacaoService;
import com.itb.tcc.mif3an.ongnet.model.services.OngService;
import com.itb.tcc.mif3an.ongnet.model.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doador")
public class DoadorController {

    private final OngService ongService;


    public DoadorController(OngService ongService, DoacaoService doacaoService, ItemDoacaoService itemDoacaoService) {
        this.ongService = ongService;

    }


    //Busca todas ongs no bd
    @GetMapping("/ong")
    public ResponseEntity<List<Ong>> listarOngs() {
       return ResponseEntity.ok().body(ongService.findAll());
    }


}



