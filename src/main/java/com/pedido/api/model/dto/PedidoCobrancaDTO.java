package com.pedido.api.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
public class PedidoCobrancaDTO implements Serializable {
    private Long PedidoId;
    private OffsetDateTime data;
    private List<LancheDTO> lanches;
    private BigDecimal valor;
    private BigDecimal descontoPromocional;
    private BigDecimal valorFinal;

}
