package com.itb.tcc.mif3an.ongnet.model.services;

import com.itb.tcc.mif3an.ongnet.exceptions.BadRequest;
import com.itb.tcc.mif3an.ongnet.exceptions.NotFound;
import com.itb.tcc.mif3an.ongnet.model.entity.Item;
import com.itb.tcc.mif3an.ongnet.model.entity.ItemDoacao;
import com.itb.tcc.mif3an.ongnet.model.entity.OngItem;
import com.itb.tcc.mif3an.ongnet.model.repository.ItemDoacaoRepository;
import com.itb.tcc.mif3an.ongnet.model.repository.OngItemRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDoacaoServiceImpl implements ItemDoacaoService {

    private final ItemDoacaoRepository itemDoacaoRepository;


    public ItemDoacaoServiceImpl(ItemDoacaoRepository itemDoacaoRepository, OngItemRepository ongItemRepository) {
        this.itemDoacaoRepository = itemDoacaoRepository;

    }


    @Override
    public ItemDoacao save(ItemDoacao itemDoacao) {
        if (!itemDoacao.validarItemDoacao()) {
            throw new BadRequest(itemDoacao.getMensagemErro());
        }
        return itemDoacaoRepository.save(itemDoacao);
    }

    @Override
    public List<ItemDoacao> findAll() {
        return itemDoacaoRepository.findAll();
    }

    @Override
    public ItemDoacao findById(Long id) {
        try {
            ItemDoacao itemDoacao = itemDoacaoRepository.findById(id).get();
            return itemDoacao;
        }catch (Exception e) {
            throw new NotFound("Item não encontrado" + id);
        }
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public ItemDoacao update(ItemDoacao itemDoacao, Long id) {
        if(!itemDoacao.validarItemDoacao()) {
            throw new BadRequest(itemDoacao.getMensagemErro());
        }
        if(!itemDoacaoRepository.existsById(id)){
            throw new NotFound("Item não encontrado com o id " + id);
        }
        // Agora posso atualizar o item

        ItemDoacao itemDoacaoDb = itemDoacaoRepository.findById(id).get();
        itemDoacaoDb.setQuantidade(itemDoacao.getQuantidade());



//       if(item.getCategoria() != null) {
        //  Categoria categoriaDb = categoriaService.findById(produto.getCategoria().getId());
        //  if(categoriaDb == null ){
        //      throw new NotFound("Categoria não encontrada com o id " + id);
        //  }
        // produtoDb.setCategoria(categoriaDb);

//        }
        return itemDoacaoRepository.save(itemDoacaoDb);
    }
}
