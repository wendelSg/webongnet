package com.itb.tcc.mif3an.ongnet.model.repository;

import com.itb.tcc.mif3an.ongnet.model.entity.Doador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoadorRepository extends JpaRepository<Doador, Long> {
}
