package com.itb.tcc.mif3an.ongnet.model.services;

import com.itb.tcc.mif3an.ongnet.model.entity.Item;

import java.util.List;

public interface ItemService {

    public Item save(Item item);
    public List<Item> findAll();
    public Item findById(Long id);
    public boolean delete(Long id);
    public Item update(Item item, Long id);
}
