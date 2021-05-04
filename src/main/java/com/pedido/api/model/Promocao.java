package com.pedido.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Promocao implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    private Long id;

    private String descricao;


}
