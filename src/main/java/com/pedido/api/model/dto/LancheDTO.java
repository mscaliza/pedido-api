package com.pedido.api.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class LancheDTO implements Serializable {
    private Long id;
    private String descricao;
    private Long quantidade;
    private String tipo;
    private List<IngredienteDTO> ingredientes;
    private List<PromocaoDTO> promocao = new ArrayList<>();

    private BigDecimal valor;
    private BigDecimal valorPromocional;

    public void addPromocao(PromocaoDTO promocao){
        this.promocao.add(promocao);
    }
}
