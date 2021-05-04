package com.pedido.api.repository;

import com.pedido.api.model.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Long> {

    Promocao getById(Long id);
}
