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

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPedidoItem pedidoItem = new QPedidoItem("pedidoItem");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<ItemIngrediente, QItemIngrediente> itemIngredientes = this.<ItemIngrediente, QItemIngrediente>createList("itemIngredientes", ItemIngrediente.class, QItemIngrediente.class, PathInits.DIRECT2);

    public final ListPath<PedidoItemPromocao, QPedidoItemPromocao> itemPromocoes = this.<PedidoItemPromocao, QPedidoItemPromocao>createList("itemPromocoes", PedidoItemPromocao.class, QPedidoItemPromocao.class, PathInits.DIRECT2);

    public final QLanche lanche;

    public final NumberPath<Long> lanche_id = createNumber("lanche_id", Long.class);

    public final NumberPath<Long> pedido_id = createNumber("pedido_id", Long.class);

    public QPedidoItem(String variable) {
        this(PedidoItem.class, forVariable(variable), INITS);
    }

    public QPedidoItem(Path<? extends PedidoItem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPedidoItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPedidoItem(PathMetadata metadata, PathInits inits) {
        this(PedidoItem.class, metadata, inits);
    }

    public QPedidoItem(Class<? extends PedidoItem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lanche = inits.isInitialized("lanche") ? new QLanche(forProperty("lanche")) : null;
    }

}

