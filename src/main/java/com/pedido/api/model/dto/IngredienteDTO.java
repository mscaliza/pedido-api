package com.pedido.api.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class IngredienteDTO implements Serializable {
    private Long id;
    private String descricao;
    private Long quantidade;
}
