package com.itb.tcc.mif3an.ongnet.model.services;

import com.itb.tcc.mif3an.ongnet.model.entity.Item;
import com.itb.tcc.mif3an.ongnet.model.entity.ItemDoacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ItemDoacaoService {
    public ItemDoacao save(ItemDoacao itemDoacao);
    public List<ItemDoacao> findAll();
    public ItemDoacao findById(Long id);
    public boolean delete(Long id);
    public ItemDoacao update(ItemDoacao itemDoacao, Long id);

}
