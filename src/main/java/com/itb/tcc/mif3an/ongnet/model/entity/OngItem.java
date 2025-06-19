package com.itb.tcc.mif3an.ongnet.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "Ong_item")
@Data
@NoArgsConstructor
public class OngItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private int qtdEstoque;
    @Column(nullable = false)
    private int meta;
    @Column(nullable = false)
    private LocalDate dataExpiracao;
    private Boolean codStatus;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)   // N:1 OngItem para doacao
    @JoinColumn (name = "ong_id", referencedColumnName = "id", nullable = false)
    private Ong ong;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)   // N:1 ItemDoacao para doacao
    @JoinColumn (name = "item_id", referencedColumnName = "id", nullable = false)
    private Item item;

    @Transient
    @JsonIgnore
    private String mensagemErro = "";

    @Transient
    @JsonIgnore
    private boolean isValid = true;

    public boolean validarOngItem() {
        return isValid;
    }
}
