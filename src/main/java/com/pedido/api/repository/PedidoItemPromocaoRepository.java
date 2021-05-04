package com.pedido.api.repository;

import com.pedido.api.model.PedidoItemPromocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItemPromocaoRepository extends JpaRepository<PedidoItemPromocao, Long> {
}
