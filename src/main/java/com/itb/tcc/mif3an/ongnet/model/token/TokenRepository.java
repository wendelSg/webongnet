package com.itb.tcc.mif3an.ongnet.model.token;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    @Query(value = """
    select t from Token t inner join Usuario u\s 
    on t.usuario.id = u.id\s
    where u.id = :id and (t.expired = false or t.revoked = false)\s
""")
    List<Token> findAllValidTokenByUser(Long id);

    Optional<Token> findByToken(String token);

}
