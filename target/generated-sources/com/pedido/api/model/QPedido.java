package com.pedido.api.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPedido is a Querydsl query type for Pedido
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPedido extends EntityPathBase<Pedido> {

    private static final long serialVersionUID = -96763078L;

    public static final QPedido pedido = new QPedido("pedido");

    public final DateTimePath<java.time.OffsetDateTime> data = createDateTime("data", java.time.OffsetDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<PedidoItem, QPedidoItem> pedidoItem = this.<PedidoItem, QPedidoItem>createList("pedidoItem", PedidoItem.class, QPedidoItem.class, PathInits.DIRECT2);

    public final NumberPath<Long> promocao_id = createNumber("promocao_id", Long.class);

    public final NumberPath<Long> quantidadeTotal = createNumber("quantidadeTotal", Long.class);

    public final NumberPath<java.math.BigDecimal> valor_promocional = createNumber("valor_promocional", java.math.BigDecimal.class);

    public QPedido(String variable) {
        super(Pedido.class, forVariable(variable));
    }

    public QPedido(Path<? extends Pedido> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPedido(PathMetadata metadata) {
        super(Pedido.class, metadata);
    }

}

