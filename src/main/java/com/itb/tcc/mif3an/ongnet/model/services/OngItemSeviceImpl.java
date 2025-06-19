package com.itb.tcc.mif3an.ongnet.model.services;

import com.itb.tcc.mif3an.ongnet.exceptions.BadRequest;
import com.itb.tcc.mif3an.ongnet.model.entity.OngItem;
import com.itb.tcc.mif3an.ongnet.model.repository.OngItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OngItemSeviceImpl implements OngItemService {

    private final OngItemRepository ongItemRepository;

    public OngItemSeviceImpl(OngItemRepository ongItemRepository) {
        this.ongItemRepository = ongItemRepository;
    }


    @Override
    public OngItem save(OngItem ongItem) {
        ongItem.setCodStatus(true);
        if (!ongItem.validarOngItem()){
            throw new BadRequest(ongItem.getMensagemErro());
        }
        return ongItemRepository.save(ongItem);
    }

    @Override
    public List<OngItem> findAll() {
        return ongItemRepository.findAll();
    }

    @Override
    public OngItem findById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public OngItem update(OngItem ongitem, Long id) {
        return null;
    }
}
