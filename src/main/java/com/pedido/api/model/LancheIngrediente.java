package com.pedido.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class LancheIngrediente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long lanche_id;

    private Long ingrediente_id;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="lanche_id", nullable=false, insertable=false, updatable=false)
    private Lanche lanche;

    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="ingrediente_id", nullable=false, insertable=false, updatable=false)
    private Ingrediente ingrediente;
}