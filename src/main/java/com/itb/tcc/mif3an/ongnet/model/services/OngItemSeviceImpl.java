package com.itb.tcc.mif3an.ongnet.model.services;

import com.itb.tcc.mif3an.ongnet.exceptions.BadRequest;
import com.itb.tcc.mif3an.ongnet.exceptions.NotFound;
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
        if (!ongItem.validarOngItem()) {
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
        try {
            OngItem ongItem = ongItemRepository.findById(id).get();
            return ongItem;
        } catch (Exception e) {
            throw new NotFound("Item cadastrado não encontrado" + id);
        }
    }

    @Override
    public OngItem update(OngItem ongitem, Long id) {
        if (!ongitem.validarOngItem()) {
            throw new BadRequest(ongitem.getMensagemErro());
        }
        if (!ongItemRepository.existsById(id)) {
            throw new NotFound("Item não encontrado com o id " + id);
        }

        // Agora posso atualizar o item

        OngItem ongItemDb = ongItemRepository.findById(id).get();
        ongItemDb.setMeta(ongitem.getMeta());
        ongItemDb.setDataExpiracao(ongitem.getDataExpiracao());
        ongItemDb.setCodStatus(ongitem.getCodStatus());

        return ongItemRepository.save(ongItemDb);
    }

//       if(item.getCategoria() != null) {
        //  Categoria categoriaDb = categoriaService.findById(produto.getCategoria().getId());
        //  if(categoriaDb == null ){
        //      throw new NotFound("Categoria não encontrada com o id " + id);
        //  }
        // produtoDb.setCategoria(categoriaDb);

//        }


    @Override
    public boolean delete(Long id) {
        return false;
    }


}
