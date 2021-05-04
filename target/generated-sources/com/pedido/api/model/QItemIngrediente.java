package com.pedido.api.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QItemIngrediente is a Querydsl query type for ItemIngrediente
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItemIngrediente extends EntityPathBase<ItemIngrediente> {

    private static final long serialVersionUID = -355757236L;

    public static final QItemIngrediente itemIngrediente = new QItemIngrediente("itemIngrediente");

    public final StringPath descricao = createString("descricao");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> ingrediente_id = createNumber("ingrediente_id", Long.class);

    public final NumberPath<Long> pedidoItemId = createNumber("pedidoItemId", Long.class);

    public final NumberPath<Long> quantidade = createNumber("quantidade", Long.class);

    public final NumberPath<java.math.BigDecimal> valor = createNumber("valor", java.math.BigDecimal.class);

    public QItemIngrediente(String variable) {
        super(ItemIngrediente.class, forVariable(variable));
    }

    public QItemIngrediente(Path<? extends ItemIngrediente> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItemIngrediente(PathMetadata metadata) {
        super(ItemIngrediente.class, metadata);
    }

}

