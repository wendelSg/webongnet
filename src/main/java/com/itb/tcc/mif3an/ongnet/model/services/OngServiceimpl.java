package com.itb.tcc.mif3an.ongnet.model.services;

import com.itb.tcc.mif3an.ongnet.exceptions.BadRequest;
import com.itb.tcc.mif3an.ongnet.exceptions.NotFound;
import com.itb.tcc.mif3an.ongnet.model.entity.Item;
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

    @Override
    public Ong findById(Long id) {
        try {
            Ong ong = ongRepository.findById(id).get();
            return ong;
        }catch (Exception e) {
            throw new NotFound("Ong não encontrada" + id);
        }
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Ong update(Ong ong, Long id) {
        if (!ong.validarOng()) {
            throw new BadRequest(ong.getMensagemErro());
        }
        if (!ongRepository.existsById(id)) {
            throw new NotFound("Item não encontrado com o id " + id);
        }
        // Agora posso atualizar o item

        Ong ongDb = ongRepository.findById(id).get();
        ongDb.setNome(ong.getNome());
        ongDb.setCep(ong.getCep());
        ongDb.setNumero(ong.getNumero());
        ongDb.setTelefone(ong.getTelefone());
        ongDb.setEmail(ong.getEmail());
        ongDb.setSite(ong.getSite());
        ongDb.setAtividade(ong.getAtividade());
        ongDb.setMissao(ong.getMissao());
        ongDb.setImagem(ong.getImagem());
        ongDb.setCodStatus(ong.getCodStatus());

        return ongRepository.save(ongDb);
    }
}


