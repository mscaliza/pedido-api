package com.pedido.api.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QIngrediente is a Querydsl query type for Ingrediente
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QIngrediente extends EntityPathBase<Ingrediente> {

    private static final long serialVersionUID = 815500767L;

    public static final QIngrediente ingrediente = new QIngrediente("ingrediente");

    public final StringPath descricao = createString("descricao");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<java.math.BigDecimal> valor = createNumber("valor", java.math.BigDecimal.class);

    public QIngrediente(String variable) {
        super(Ingrediente.class, forVariable(variable));
    }

    public QIngrediente(Path<? extends Ingrediente> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIngrediente(PathMetadata metadata) {
        super(Ingrediente.class, metadata);
    }

}

