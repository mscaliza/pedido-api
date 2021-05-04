package com.pedido.api.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PromocaoDTO {

    private BigDecimal desconto;
    private Long quantidadeParaPagar;
    private String promocao;
}
