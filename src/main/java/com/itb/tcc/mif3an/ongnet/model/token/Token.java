package com.itb.tcc.mif3an.ongnet.model.token;

import com.itb.tcc.mif3an.ongnet.model.entity.Usuario;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "tokens")
@Data
public class Token {

    @Id
    @GeneratedValue
    public Long id;
    public String token;
    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;
    public boolean revoked;
    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    public Usuario usuario;

    public Token() {
    }

    public Token(Long id, Usuario usuario, boolean expired, boolean revoked, TokenType tokenType, String token) {
        this.id = id;
        this.usuario = usuario;
        this.expired = expired;
        this.revoked = revoked;
        this.tokenType = tokenType;
        this.token = token;
    }
}