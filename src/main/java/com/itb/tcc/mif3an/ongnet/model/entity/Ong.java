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
    @Column(nullable = true, length = 100)
    private String site;
    @Column(nullable = true, length = 150)
    private String atividade;
    @Column(nullable = true, length = 150)
    private String missao;
    @Lob
    @Column(name = "imagem", columnDefinition = "VARBINARY(MAX)")
    private byte[] imagem;
    private Boolean codStatus;

    @OneToMany(mappedBy = "ong", cascade = CascadeType.ALL, fetch = FetchType.LAZY)  // 1:N Ong para doacoes
    @JsonIgnore
    private List<Doacao> doacoes = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "ong", cascade = CascadeType.ALL, fetch = FetchType.LAZY)  // 1:N Ong para doacoes
    private List<RepresentanteOng> representanteOngs = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "ong", cascade = CascadeType.ALL, fetch = FetchType.LAZY)  // 1:N Ong para doacoes
    private List<OngItem> ongItems = new ArrayList<>();

    @Transient
    @JsonIgnore
    private String mensagemErro = "";

    @Transient
    @JsonIgnore
    private boolean isValid = true;

    public boolean validarOng() {
        return isValid;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getMissao() {
        return missao;
    }

    public void setMissao(String missao) {
        this.missao = missao;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setCodStatus(Boolean codStatus) {
        this.codStatus = codStatus;
    }
}
