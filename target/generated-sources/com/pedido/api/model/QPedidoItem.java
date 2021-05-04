package com.pedido.api.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPedidoItem is a Querydsl query type for PedidoItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPedidoItem extends EntityPathBase<PedidoItem> {

    private static final long serialVersionUID = -1642707603L;

    public static final QPedidoItem pedidoItem = new QPedidoItem("pedidoItem");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> ingrediente_id = createNumber("ingrediente_id", Long.class);

    public final ListPath<ItemIngrediente, QItemIngrediente> itemIngredientes = this.<ItemIngrediente, QItemIngrediente>createList("itemIngredientes", ItemIngrediente.class, QItemIngrediente.class, PathInits.DIRECT2);

    public final NumberPath<Long> lanche_id = createNumber("lanche_id", Long.class);

    public final NumberPath<Long> pedido_id = createNumber("pedido_id", Long.class);

    public final NumberPath<java.math.BigDecimal> valor = createNumber("valor", java.math.BigDecimal.class);

    public QPedidoItem(String variable) {
        super(PedidoItem.class, forVariable(variable));
    }

    public QPedidoItem(Path<? extends PedidoItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPedidoItem(PathMetadata metadata) {
        super(PedidoItem.class, metadata);
    }

}

