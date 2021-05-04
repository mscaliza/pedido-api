package com.pedido.api.regra_promocional;

import com.pedido.api.model.PedidoItem;
import com.pedido.api.model.dto.LancheDTO;

public interface AnalisarPromocao {

    LancheDTO analisar(LancheDTO dto);

    //BigDecimal analisarPedido(PedidoItem pi);

    PedidoItem analisarPedido(PedidoItem pi);


    default Long analisarQuantidadeDeItensQueIraPagar(Long quantidadeComprada){
        long quantidadeParaPagar = 0L;

        do {
            if (quantidadeComprada % 3 == 0){
                quantidadeComprada -= 3;
                quantidadeParaPagar += 2;
            }else{
                quantidadeComprada -= 1;
                quantidadeParaPagar += 1;
            }
        } while (quantidadeComprada > 0);
        return quantidadeParaPagar;
    }
}