package com.pedido.api.regra_promocional;

import com.pedido.api.model.Consts;
import com.pedido.api.model.PedidoItem;
import com.pedido.api.model.PedidoItemPromocao;
import com.pedido.api.model.Promocoes;
import com.pedido.api.model.dto.LancheDTO;
import com.pedido.api.model.dto.PromocaoDTO;

import java.util.stream.Collectors;

public class PromocaoMuitaCarne implements AnalisarPromocao {
    @Override
    public LancheDTO analisar(LancheDTO dto) {

        dto.getIngredientes()
                .stream()
                .filter(ingredienteDTO -> ((ingredienteDTO.getDescricao().equals("Hambúrguer")) &&
                        (ingredienteDTO.getQuantidade() >= 3)))
                .collect(Collectors.toList()).forEach(ingredienteDTO -> {
            PromocaoDTO promocao = new PromocaoDTO();
            promocao.setPromocao(Promocoes.MUITA_CARNE.getDescricao());
            promocao.setQuantidadeParaPagar(analisarQuantidadeDeItensQueIraPagar(ingredienteDTO.getQuantidade()));
            dto.addPromocao(promocao);
        });
        return dto;
    }

    @Override
    public PedidoItem analisarPedido(PedidoItem pedidoItem) {

         pedidoItem.getItemIngredientes()
                        .stream()
                        .filter(ingrediente -> ((ingrediente.getIngrediente_id().equals(Consts.HAMBURGUER)) &&
                                (ingrediente.getQuantidade() >= 3)))
                        .collect(Collectors.toList()).forEach(ingrediente -> {
                            ingrediente.setQuantidadePromocional(analisarQuantidadeDeItensQueIraPagar(ingrediente.getQuantidade()));
             pedidoItem.getItemPromocoes().add(new PedidoItemPromocao(pedidoItem.getId(), Promocoes.MUITA_CARNE.getId()));
                        });

        return pedidoItem;
    }
}
