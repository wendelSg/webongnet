package com.itb.tcc.mif3an.ongnet.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "item_doacao")
@Data
public class ItemDoacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name = "doacao_id", referencedColumnName = "id", nullable = false)
    private Doacao doacao;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name = "item_id", referencedColumnName = "id", nullable = false)
    private Item item;

    @Transient
    @JsonIgnore
    private String mensagemErro = "";

    @Transient
    @JsonIgnore
    private boolean isValid = true;

    public boolean validarItemDoacao() {
        return isValid;
    }
}
