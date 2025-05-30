package com.itb.tcc.mif3an.ongnet.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Ong")
@Data
@NoArgsConstructor
public class Ong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 60)
    private String nome;
    @Column(nullable = false, length = 18)
    private String cnpj;
    @Column(nullable = false, length = 60)
    private String responsavel;
    @Column(nullable = false, length = 9)
    private String cep;
    @Column(nullable = false, length = 5)
    private String numero;
    @Column(nullable = false, length = 14)
    private String telefone;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 255)
    private String password;
    @Column(nullable = true, length = 100)
    private String site;
    @Column(nullable = true, length = 150)
    private String atividade;
    @Column(nullable = true, length = 150)
    private String objetivo;
    private Boolean codStatus;

    @OneToMany(mappedBy = "ong", cascade = CascadeType.ALL, fetch = FetchType.LAZY)  // 1:N Ong para doacoes
    @JsonIgnore
    private List<Doacao> doacoes = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "ong", cascade = CascadeType.ALL, fetch = FetchType.LAZY)  // 1:N Ong para doacoes
    private List<RepresentanteOng> representanteOngs = new ArrayList<>();

    @Transient
    @JsonIgnore
    private String mensagemErro = "";

    @Transient
    @JsonIgnore
    private boolean isValid = true;

    public boolean validarOng() {
        return isValid;
    }
}
