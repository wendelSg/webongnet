package com.itb.tcc.mif3an.ongnet.model.services;

import com.itb.tcc.mif3an.ongnet.exceptions.BadRequest;
import com.itb.tcc.mif3an.ongnet.model.entity.Ong;
import com.itb.tcc.mif3an.ongnet.model.repository.OngRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OngServiceimpl implements OngService {

    private final OngRepository ongRepository;

    public OngServiceimpl(OngRepository ongRepository) {
        this.ongRepository = ongRepository;
    }

    @Override
    public Ong save(Ong ong) {
        ong.setCodStatus(true);
        if (!ong.validarOng()) {
            throw new BadRequest(ong.getMensagemErro());
        }
        return ongRepository.save(ong);
    }


    @Override
    public List<Ong> findAll() {
        return ongRepository.findAll();
    }
}
