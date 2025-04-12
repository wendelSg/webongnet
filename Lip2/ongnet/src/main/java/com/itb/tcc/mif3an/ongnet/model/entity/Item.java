package com.itb.tcc.mif3an.ongnet.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "item")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = true, length = 15)
    private String descricao;
    @Column(nullable = true, length = 100)
    private int qtdEstoque;
    @Column(nullable = true, length = 100)
    private int meta;
    private Boolean codStatus;


    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)  // 1:N Item para itensDoacao
    @JsonIgnore
    private List<ItemDoacao> itensDoacao = new ArrayList<>();


    @Transient
    @JsonIgnore
    private String mensagemErro = "";

    @Transient
    @JsonIgnore
    private boolean isValid = true;

    public boolean validarItem() {
        return isValid;
    }
}
