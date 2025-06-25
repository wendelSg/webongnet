package com.itb.tcc.mif3an.ongnet.controller;

import com.itb.tcc.mif3an.ongnet.exceptions.BadRequest;
import com.itb.tcc.mif3an.ongnet.model.entity.Item;
import com.itb.tcc.mif3an.ongnet.model.entity.Ong;
import com.itb.tcc.mif3an.ongnet.model.entity.OngItem;
import com.itb.tcc.mif3an.ongnet.model.services.ItemService;
import com.itb.tcc.mif3an.ongnet.model.services.OngItemService;
import com.itb.tcc.mif3an.ongnet.model.services.OngService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/representante-ong")
public class RepresentanteOngController {


    private final OngService ongService;
    private final ItemService itemService;
    private final OngItemService ongItemService;

    public RepresentanteOngController(OngService ongService, ItemService itemService, OngItemService ongItemService) {
        this.ongService = ongService;
        this.itemService = itemService;
        this.ongItemService = ongItemService;
    }

    //Busca todas ongs no bd
    @GetMapping("/ong")
    public ResponseEntity<List<Ong>> listarOngs() {
        return ResponseEntity.ok().body(ongService.findAll());
    }

    //Busca ong por id no bd
    @GetMapping("/ong/{id}")
    public ResponseEntity<Ong> listarOng
    (@PathVariable(value = "id") String id) {
        try {
            Long idLong = Long.parseLong(id);
            return ResponseEntity.ok().body(ongService.findById(idLong));
        } catch (NumberFormatException e) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro.");
        }
    }

    //Busca todos itens no bd
    @GetMapping("/item")
    public ResponseEntity<List<Item>> listarItens() {
        return ResponseEntity.ok().body(itemService.findAll());
    }

    //Busca item por id no bd
    @GetMapping("/item/{id}")
    public ResponseEntity<Item> listarItem
    (@PathVariable(value = "id") String id) {
        try {
            Long idLong = Long.parseLong(id);
            return ResponseEntity.ok().body(itemService.findById(idLong));
        } catch (NumberFormatException e) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro.");
        }
    }

    @GetMapping("/itemSelecionado")
    public ResponseEntity<List<OngItem>> listarOngItens() {
        return ResponseEntity.ok().body(ongItemService.findAll());
    }


    //Salva uma ong
    @PostMapping("/ong")
    public ResponseEntity<Ong> saveOng(@RequestBody Ong ong) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/representante-ong").toUriString());
        return ResponseEntity.created(uri).body(ongService.save(ong));
    }

    //Salva um item
    @PostMapping("/item")
    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/representante-ong").toUriString());
        return ResponseEntity.created(uri).body(itemService.save(item));
    }

    //Salva um item
    @PostMapping("/itemSelecionado")
    public ResponseEntity<OngItem> saveOngItem(@RequestBody OngItem ongItem) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/representante-ong").toUriString());
        return ResponseEntity.created(uri).body(ongItemService.save(ongItem));
    }


    //Atualiza item
    @PutMapping("/itemSelecionado/{id}")
    public ResponseEntity<OngItem> updateByIdOngItem(@RequestBody OngItem ongItem, @PathVariable(value = "id") String id) {
    try {
    Long idLong = Long.parseLong(id);
      return ResponseEntity.ok().body(ongItemService.update(ongItem, idLong));
    } catch (NumberFormatException e) {
        throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 17.");
      }

    }

    //Atualiza item
    //@PutMapping("/item/{id}")
    //public ResponseEntity<Item> updateByIdItem(@RequestBody Item item, @PathVariable(value = "id") String id) {
    //    try {
    //        Long idLong = Long.parseLong(id);
    //        return ResponseEntity.ok().body(itemService.update(item, idLong));
    //    } catch (NumberFormatException e) {
    //        throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 17.");
    //    }

    //}    Atualiza item
    //@PutMapping("/ong/{id}")
    //public ResponseEntity<Ong> updateByIdOng(@RequestBody Ong ong, @PathVariable(value = "id") String id) {
        //try {
            //Long idLong = Long.parseLong(id);
          //  return ResponseEntity.ok().body(ongService.update(ong, idLong));
        //} catch (NumberFormatException e) {
        //    throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 17.");
      //  }

    }

