package com.pedido.api.regra_promocional;

import com.pedido.api.model.*;
import com.pedido.api.model.dto.LancheDTO;
import com.pedido.api.model.dto.PromocaoDTO;

import java.util.stream.Collectors;

public class PromocaoMuitoQueijo implements AnalisarPromocao {
    @Override
    public LancheDTO analisar(LancheDTO dto) {
        dto.getIngredientes()
                .stream()
                .filter(ingredienteDTO -> ((ingredienteDTO.getDescricao().equals("Queijo")) &&
                        (ingredienteDTO.getQuantidade() >= 3)))
                .collect(Collectors.toList()).forEach(ingredienteDTO -> {
            PromocaoDTO promocao = new PromocaoDTO();
            promocao.setPromocao(Promocoes.MUITO_QUEIJO.getDescricao());
            promocao.setQuantidadeParaPagar(analisarQuantidadeDeItensQueIraPagar(ingredienteDTO.getQuantidade()));
            dto.addPromocao(promocao);
        });
        return dto;
    }

    @Override
    public PedidoItem analisarPedido(PedidoItem pedidoItem) {

        pedidoItem.getItemIngredientes()
                .stream()
                .filter(ingrediente -> ((ingrediente.getIngrediente_id().equals(Consts.QUEIJO)) &&
                        (ingrediente.getQuantidade() >= 3)))
                .collect(Collectors.toList()).forEach(ingrediente -> {
            ingrediente.setQuantidadePromocional(analisarQuantidadeDeItensQueIraPagar(ingrediente.getQuantidade()));

            pedidoItem.getItemPromocoes().add(new PedidoItemPromocao(pedidoItem.getId(), Promocoes.MUITO_QUEIJO.getId()));

        });

        return pedidoItem;
    }
}
