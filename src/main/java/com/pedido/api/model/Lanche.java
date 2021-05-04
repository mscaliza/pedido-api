package com.pedido.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ApiModel
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Lanche  implements Serializable {

    @ApiModelProperty(example = "1")
    @EqualsAndHashCode.Include
    @Id
    private Long id;

    @ApiModelProperty(example = "X-Tudo")
    private String descricao;

    @ApiModelProperty(allowableValues="NORMAL, PERSONALIZADO", example = "NORMAL")
    @Enumerated(EnumType.STRING)
    private TipoLanche tipo;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @OneToMany(mappedBy = "lanche_id")
    private List<LancheIngrediente> lancheIngredientes;
}
