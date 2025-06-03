package com.itb.tcc.mif3an.ongnet.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.itb.tcc.mif3an.ongnet.model.token.Token;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;

import java.util.Collection;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "Usuario")
//
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "role")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RepresentanteOng.class, name="REPRESENTANTEONG"),
        @JsonSubTypes.Type(value = Admin.class, name="ADMIN"),
        @JsonSubTypes.Type(value = Doador.class, name="DOADOR"),
})

public class Usuario implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 60)
    private String nome;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 255)
    private String password;
    @Column(nullable = true, length = 9)
    private String cep;
    @Column(nullable = true, length = 14)
    private String telefone;
    @Column(nullable = true, length = 14)
    private String cpf;
    private Boolean codStatus;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Token> tokens;

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private Role role;

    @Transient
    @JsonIgnore
    private String mensagemErro = "";

    @Transient
    @JsonIgnore
    private boolean isValid = true;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Boolean getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(Boolean codStatus) {
        this.codStatus = codStatus;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }




    public boolean validarUsuario() {
        return isValid;
    }
}
