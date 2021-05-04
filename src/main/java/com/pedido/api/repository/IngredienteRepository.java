package com.pedido.api.repository;

import com.pedido.api.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

    Ingrediente getById(Long id);
}
