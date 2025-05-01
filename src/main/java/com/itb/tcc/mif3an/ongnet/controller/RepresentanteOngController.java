package com.itb.tcc.mif3an.ongnet.controller;

import com.itb.tcc.mif3an.ongnet.model.entity.Ong;
import com.itb.tcc.mif3an.ongnet.model.services.OngService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/representante-ong")
public class RepresentanteOngController {


    private final OngService ongService;

    public RepresentanteOngController(OngService ongService) {
        this.ongService = ongService;
    }

    @GetMapping("/ong")
    public ResponseEntity<List<Ong>> listarOngs(){
        return ResponseEntity.ok().body(ongService.findAll());
    }


}
