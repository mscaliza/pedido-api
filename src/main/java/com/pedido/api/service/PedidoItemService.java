package com.pedido.api.service;

import com.pedido.api.model.PedidoItem;
import com.pedido.api.repository.PedidoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoItemService {

    @Autowired
    private PedidoItemRepository pedidoItemRepository;

    public List<PedidoItem> findAll(){
        return pedidoItemRepository.findAll();
    }
}



