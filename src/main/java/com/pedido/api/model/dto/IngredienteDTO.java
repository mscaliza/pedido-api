package com.pedido.api.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class IngredienteDTO implements Serializable {
    @ApiModelProperty(value = "Código do ingrediente", required = true)
    private Long id;
    private String descricao;
    @ApiModelProperty(value = "Quantidade", required = true)
    private Long quantidade;
}
