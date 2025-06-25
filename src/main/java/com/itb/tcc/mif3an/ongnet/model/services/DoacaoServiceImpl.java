package com.itb.tcc.mif3an.ongnet.model.services;

import com.itb.tcc.mif3an.ongnet.exceptions.BadRequest;
import com.itb.tcc.mif3an.ongnet.exceptions.NotFound;
import com.itb.tcc.mif3an.ongnet.model.entity.Doacao;
import com.itb.tcc.mif3an.ongnet.model.repository.DoacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoacaoServiceImpl implements DoacaoService {

    private final DoacaoRepository doacaoRepository;

    public DoacaoServiceImpl(DoacaoRepository doacaoRepository) {
        this.doacaoRepository = doacaoRepository;
    }

    @Override
    public Doacao save(Doacao doacao) {
        doacao.setCodStatus(true);
        if (!doacao.validarDoacao()) {
            throw new BadRequest(doacao.getMensagemErro());
        }
        return doacaoRepository.save(doacao);
    }

    @Override
    public List<Doacao> findAll() {
        return doacaoRepository.findAll();
    }

    @Override
    public Doacao findById(Long id) {
        try {
            Doacao doacao = doacaoRepository.findById(id).get();
            return doacao;
        } catch (Exception e) {
            throw new NotFound("Doação não encontrada" + id);
        }
    }
}