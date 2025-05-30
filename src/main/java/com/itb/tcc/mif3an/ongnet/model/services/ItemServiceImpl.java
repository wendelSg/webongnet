package com.itb.tcc.mif3an.ongnet.model.services;

import com.itb.tcc.mif3an.ongnet.exceptions.BadRequest;
import com.itb.tcc.mif3an.ongnet.exceptions.NotFound;
import com.itb.tcc.mif3an.ongnet.model.entity.Item;
import com.itb.tcc.mif3an.ongnet.model.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item) {
        item.setCodStatus(true);
        if (!item.validarItem()) {
            throw new BadRequest(item.getMensagemErro());
        }
        return itemRepository.save(item);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findById(Long id) {
        try {
            Item item = itemRepository.findById(id).get();
            return item;
        }catch (Exception e) {
            throw new NotFound("Item não encontrado" + id);
        }
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Item update(Item item) {
        return null;
    }


}
