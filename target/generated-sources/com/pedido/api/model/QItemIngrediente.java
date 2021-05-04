package com.pedido.api.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QItemIngrediente is a Querydsl query type for ItemIngrediente
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItemIngrediente extends EntityPathBase<ItemIngrediente> {

    private static final long serialVersionUID = -355757236L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QItemIngrediente itemIngrediente = new QItemIngrediente("itemIngrediente");

    public final NumberPath<java.math.BigDecimal> descontoPromocional = createNumber("descontoPromocional", java.math.BigDecimal.class);

    public final StringPath descricao = createString("descricao");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QIngrediente ingrediente;

    public final NumberPath<Long> ingrediente_id = createNumber("ingrediente_id", Long.class);

    public final NumberPath<Long> pedidoItemId = createNumber("pedidoItemId", Long.class);

    public final NumberPath<Long> quantidade = createNumber("quantidade", Long.class);

    public final NumberPath<Long> quantidadePromocional = createNumber("quantidadePromocional", Long.class);

    public final NumberPath<java.math.BigDecimal> valor = createNumber("valor", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> valorFinal = createNumber("valorFinal", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> valorUnitario = createNumber("valorUnitario", java.math.BigDecimal.class);

    public QItemIngrediente(String variable) {
        this(ItemIngrediente.class, forVariable(variable), INITS);
    }

    public QItemIngrediente(Path<? extends ItemIngrediente> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QItemIngrediente(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QItemIngrediente(PathMetadata metadata, PathInits inits) {
        this(ItemIngrediente.class, metadata, inits);
    }

    public QItemIngrediente(Class<? extends ItemIngrediente> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ingrediente = inits.isInitialized("ingrediente") ? new QIngrediente(forProperty("ingrediente")) : null;
    }

}

