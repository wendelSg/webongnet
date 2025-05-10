package com.itb.tcc.mif3an.ongnet.controller;

import com.itb.tcc.mif3an.ongnet.exceptions.BadRequest;
import com.itb.tcc.mif3an.ongnet.model.entity.Ong;
import com.itb.tcc.mif3an.ongnet.model.services.OngService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/representante-ong")
public class RepresentanteOngController {

	//blabla

    private final OngService ongService;

    public RepresentanteOngController(OngService ongService) {
        this.ongService = ongService;
    }

    @GetMapping("/ong")
    public ResponseEntity<List<Ong>> listarOngs(){
        return ResponseEntity.ok().body(ongService.findAll());
    }

    @GetMapping("/ong/{id}")
    public ResponseEntity<Ong> findAllById
            (@PathVariable(value = "id") String id) {
        try{        Long idLong = Long.parseLong(id);
            return ResponseEntity.ok().body(ongService.findById(idLong));
        } catch (NumberFormatException e) {
            throw new BadRequest("'"+id+"' não é um número inteiro válido. Por favor, forneça um valor inteiro.");    }
    }

    @PostMapping("/ong")
    public ResponseEntity<Ong> saveColeta(@RequestBody Ong ong) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/ongCrud").toUriString());
        return ResponseEntity.created(uri).body(ongService.save(ong));}


}
