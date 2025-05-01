package com.itb.tcc.mif3an.ongnet.model.services;

import com.itb.tcc.mif3an.ongnet.model.entity.Ong;

import java.util.List;

public interface OngService {

    public Ong save(Ong ong);
    public List<Ong> findAll();
}
