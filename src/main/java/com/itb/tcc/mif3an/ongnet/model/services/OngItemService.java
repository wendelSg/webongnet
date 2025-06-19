package com.itb.tcc.mif3an.ongnet.model.services;

import com.itb.tcc.mif3an.ongnet.model.entity.OngItem;

import java.util.List;

public interface OngItemService {

    public OngItem save(OngItem ongItem);
    public List<OngItem> findAll();
    public OngItem findById(Long id);
    public boolean delete(Long id);
    public OngItem update(OngItem ongitem, Long id);

}
