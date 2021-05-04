package com.pedido.api.resource;

import com.pedido.api.model.PedidoItem;
import com.pedido.api.service.PedidoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidositens")
public class PedidoItemResource {

    @Autowired
    private PedidoItemService pedidoItemService;

    @GetMapping
    public ResponseEntity<List<PedidoItem>> findAll(){
        List<PedidoItem> pedidositens = pedidoItemService.findAll();
        return pedidositens.size() > 0 ? ResponseEntity.ok(pedidositens) : ResponseEntity.notFound().build();
    }
}