package com.itb.tcc.mif3an.ongnet.controller;

import com.itb.tcc.mif3an.ongnet.exceptions.BadRequest;
import com.itb.tcc.mif3an.ongnet.model.entity.Item;
import com.itb.tcc.mif3an.ongnet.model.entity.Ong;
import com.itb.tcc.mif3an.ongnet.model.services.ItemService;
import com.itb.tcc.mif3an.ongnet.model.services.OngService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final OngService ongService;
    private final ItemService itemService;

    public AdminController(OngService ongService, ItemService itemService) {
        this.ongService = ongService;
        this.itemService = itemService;
    }

    @GetMapping("/ong")
    public ResponseEntity<List<Ong>> findAllOng() {
        return ResponseEntity.ok().body(ongService.findAll());
    }

    //Busca ong por id
    @GetMapping("/ong/{id}")
    public ResponseEntity<Ong> findById
    (@PathVariable(value = "id") String id) {
        try {
            Long idLong = Long.parseLong(id);
            return ResponseEntity.ok().body(ongService.findById(idLong));
        } catch (NumberFormatException e) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro.");
        }
    }

    //Busca todos itens
    @GetMapping("/item")
    public ResponseEntity<List<Item>> findAllItens() {
        return ResponseEntity.ok().body(itemService.findAll());
    }

    //Busca item por id
    @GetMapping("/item/{id}")
    public ResponseEntity<Item> findByIdItem
    (@PathVariable(value = "id") String id) {
        try {
            Long idLong = Long.parseLong(id);
            return ResponseEntity.ok().body(itemService.findById(idLong));
        } catch (NumberFormatException e) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro.");
        }
    }

    //Salva um item
    @PostMapping("/item")
    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/admin").toUriString());
        return ResponseEntity.created(uri).body(itemService.save(item));
    }

    ///////////////////////

    //Atualiza item
    @PutMapping("/item/{id}")
    public ResponseEntity<Item> updateByIdItem(@RequestBody Item item, @PathVariable(value = "id") String id) {
        try {
            Long idLong = Long.parseLong(id);
            return ResponseEntity.ok().body(itemService.update(item, idLong));
        } catch (NumberFormatException e) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 17.");
        }

    }
    //Atualiza ong
    @PutMapping("/ong/{id}")
    public ResponseEntity<Ong> updateByIdOng(@RequestBody Ong ong, @PathVariable(value = "id") String id) {
        try {
            Long idLong = Long.parseLong(id);
            return ResponseEntity.ok().body(ongService.update(ong, idLong));
        } catch (NumberFormatException e) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 17.");
        }

    }

    /////////////////

    //Deleção de Item
    @DeleteMapping("/item/{id}")
    public ResponseEntity<Object> deleteByIdItem(@PathVariable (value = "id") String id) {
        try {
            Long idLong = Long.parseLong(id);
            if(itemService.delete(idLong)){
                return ResponseEntity.ok().body("Produto com o id " + id + " excluído com sucesso");
            }
        } catch (NumberFormatException e) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 17.");
        }
        return ResponseEntity.ok().body("Não foi possível a exclusão do produto com o id " + id);
    }

    //Deleção de Ong
    @DeleteMapping("ong/{id}")
    public ResponseEntity<Object> deleteByIdOng(@PathVariable (value = "id") String id) {
        try {
            Long idLong = Long.parseLong(id);
            if(ongService.delete(idLong)){
                return ResponseEntity.ok().body("ong com o id " + id + " excluído com sucesso");
            }
        } catch (NumberFormatException e) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 17.");
        }
        return ResponseEntity.ok().body("Não foi possível a exclusão da ong com o id " + id);
    }

}