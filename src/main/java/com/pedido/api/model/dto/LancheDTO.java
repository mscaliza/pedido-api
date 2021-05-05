package com.pedido.api.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class LancheDTO implements Serializable {

    @ApiModelProperty(value = "Código da lanche", required = true)
    private Long id;

    @ApiModelProperty(value ="Nome do lanche", hidden = true)
    private String descricao;

    @ApiModelProperty(value = "Quantidade", hidden = true)
    private Long quantidade = 1L;

    @ApiModelProperty(value = "NORMAL ou PERSONALIZADO", required = true)
    private String tipo;

    private List<IngredienteDTO> ingredientes;

    @ApiModelProperty(value ="Promoções aplicadas", hidden = true)
    private List<PromocaoDTO> promocao = new ArrayList<>();

    @ApiModelProperty(value ="Valor", hidden = true)
    private BigDecimal valor;

    @ApiModelProperty(value ="Valor promocional", hidden = true)
    private BigDecimal valorPromocional;

    public void addPromocao(PromocaoDTO promocao){
        this.promocao.add(promocao);
    }
}
