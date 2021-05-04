package com.pedido.api.service;

import com.pedido.api.model.PedidoItem;
import com.pedido.api.model.dto.LancheDTO;
import com.pedido.api.regra_promocional.PromocaoLight;
import com.pedido.api.regra_promocional.PromocaoMuitaCarne;
import com.pedido.api.regra_promocional.PromocaoMuitoQueijo;

public class AnalisarPromocaoService {

    public LancheDTO analisarPromocaoLight(LancheDTO lanche){
        PromocaoLight light = new PromocaoLight();
        return light.analisar(lanche);
    }

    public PedidoItem analisarPromocaoLight(PedidoItem pedidoItem){
        PromocaoLight light = new PromocaoLight();
        return light.analisarPedido(pedidoItem);
    }

    public LancheDTO analisarPromocaoMuitaCarne(LancheDTO lanche){
        PromocaoMuitaCarne muitaCarne = new PromocaoMuitaCarne();
        return muitaCarne.analisar(lanche);
    }

    public PedidoItem analisarPromocaoMuitaCarne(PedidoItem pedidoItem) {
        PromocaoMuitaCarne muitaCarne = new PromocaoMuitaCarne();
        return muitaCarne.analisarPedido(pedidoItem);
    }

    public LancheDTO analisarPromocaoMuitoQueijo(LancheDTO lanche){
        PromocaoMuitoQueijo muitoQueijo = new PromocaoMuitoQueijo();
        return muitoQueijo.analisar(lanche);
    }

    public PedidoItem analisarPromocaoMuitoQueijo(PedidoItem pedidoItem) {
        PromocaoMuitoQueijo muitoQueijo = new PromocaoMuitoQueijo();
        return muitoQueijo.analisarPedido(pedidoItem);
    }


}
