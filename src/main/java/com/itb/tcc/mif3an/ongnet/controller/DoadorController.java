package com.itb.tcc.mif3an.ongnet.controller;

import com.itb.tcc.mif3an.ongnet.model.entity.*;
import com.itb.tcc.mif3an.ongnet.model.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doador")
public class DoadorController {

    private final OngService ongService;
    private final DoacaoService doacaoService;
    private final OngItemService ongItemService;
    private final ItemDoacaoService itemDoacaoService;


    public DoadorController(OngService ongService, ItemDoacaoService itemDoacaoService, DoacaoService doacaoService, OngItemService ongItemService) {
        this.ongService = ongService;
        this.doacaoService = doacaoService;
        this.ongItemService = ongItemService;
        this.itemDoacaoService = itemDoacaoService;
    }


    //Busca todas ongs no bd
    @GetMapping("/ong")
    public ResponseEntity<List<Ong>> listarOngs() {
       return ResponseEntity.ok().body(ongService.findAll());
    }

    @GetMapping("/itemSelecionado")
    public ResponseEntity<List<OngItem>> listarOngItens() {
        return ResponseEntity.ok().body(ongItemService.findAll());
    }

    @GetMapping("/doacao")
    public ResponseEntity<List<Doacao>> listarDoacaoes() {
        return ResponseEntity.ok().body(doacaoService.findAll());
    }

    @GetMapping("/itemDoacao")
    public ResponseEntity<List<ItemDoacao>> listarItemDoacao() {
        return ResponseEntity.ok().body(itemDoacaoService.findAll());
    }

    @PostMapping("/Doacao")
    public ResponseEntity<Doacao> saveDoacao(@RequestBody Doacao doacao) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/doador").toUriString());
        return ResponseEntity.created(uri).body(doacaoService.save(doacao));
    }

    


}



