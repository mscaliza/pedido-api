package com.pedido.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@ApiModel
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Ingrediente {

    @ApiModelProperty(example = "1")
    @EqualsAndHashCode.Include
    @Id
    private Long id;

    @ApiModelProperty(example = "Alface")
    private String descricao;

    @ApiModelProperty(hidden = true)
    private BigDecimal valor;
}


