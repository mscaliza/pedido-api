package com.pedido.api.regra_promocional;

import com.pedido.api.model.*;
import com.pedido.api.model.dto.LancheDTO;
import com.pedido.api.model.dto.PromocaoDTO;

import java.math.BigDecimal;
import java.util.stream.Collectors;

public class PromocaoLight implements AnalisarPromocao {
    @Override
    public LancheDTO analisar(LancheDTO dto) {

        dto.getIngredientes()
                .stream()
                .filter(ingredienteDTO -> ((ingredienteDTO.getDescricao().equals("Alface")) &&
                        (!ingredienteDTO.getDescricao().equals("Bacon"))))
                .collect(Collectors.toList()).forEach(ingredienteDTO -> {
            PromocaoDTO promocao = new PromocaoDTO();
            promocao.setPromocao(Promocoes.LIGHT.getDescricao());
            promocao.setDesconto(new BigDecimal("0.01"));
            promocao.setQuantidadeParaPagar(ingredienteDTO.getQuantidade());
            dto.addPromocao(promocao);
        });
        return dto;
    }

    public PedidoItem analisarPedido(PedidoItem pi) {
        if ((
                (pi.getItemIngredientes()
                        .stream().anyMatch((ingrediente -> ingrediente.getIngrediente_id().equals(Consts.ALFACE)))) &&
                        (pi.getItemIngredientes()
                                .stream().noneMatch((ingrediente -> ingrediente.getIngrediente_id().equals(Consts.BACON)))))) {
            pi.getItemIngredientes().forEach(i -> i.setDescontoPromocional(BigDecimal.valueOf(10))

            );

            pi.getItemPromocoes().add(new PedidoItemPromocao(pi.getId(), Promocoes.LIGHT.getId()));
        }


        return pi;
    }
}
