package com.pedido.api.repository;

import com.pedido.api.model.Lanche;
import com.pedido.api.model.LancheIngrediente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancheIngredienteRepository extends CrudRepository<LancheIngrediente, Long> {
    Iterable<LancheIngrediente> findByLanche(Lanche lanche);
}


