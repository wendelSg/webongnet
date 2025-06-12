package com.itb.tcc.mif3an.ongnet.model.services;

import com.itb.tcc.mif3an.ongnet.model.entity.Ong;

import java.util.List;

public interface OngService {

    public Ong save(Ong ong);
    public List<Ong> findAll();
    public Ong findById(Long id);
    public boolean delete(Long id);
    public Ong update(Ong ong, Long idLong);
}
