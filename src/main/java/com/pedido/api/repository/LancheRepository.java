package com.pedido.api.repository;

import com.pedido.api.model.Lanche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancheRepository extends JpaRepository<Lanche, Long> {

    Lanche getById(Long id);

}
