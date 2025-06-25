package com.itb.tcc.mif3an.ongnet.model.services;

import com.itb.tcc.mif3an.ongnet.model.entity.Doacao;

import java.util.List;

public interface DoacaoService {

    public Doacao save(Doacao doacao);
    public List<Doacao> findAll();
    public Doacao findById(Long id);

}
