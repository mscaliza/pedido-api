package com.pedido.api.repository;

import com.pedido.api.model.ItemIngrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemIngredienteRepository extends JpaRepository<ItemIngrediente, Long> {
}
