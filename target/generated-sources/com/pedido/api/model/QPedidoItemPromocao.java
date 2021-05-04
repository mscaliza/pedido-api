package com.pedido.api.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPedidoItemPromocao is a Querydsl query type for PedidoItemPromocao
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPedidoItemPromocao extends EntityPathBase<PedidoItemPromocao> {

    private static final long serialVersionUID = -2086218513L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPedidoItemPromocao pedidoItemPromocao = new QPedidoItemPromocao("pedidoItemPromocao");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> pedidoItemId = createNumber("pedidoItemId", Long.class);

    public final QPromocao promocao;

    public final NumberPath<Long> promocaoId = createNumber("promocaoId", Long.class);

    public QPedidoItemPromocao(String variable) {
        this(PedidoItemPromocao.class, forVariable(variable), INITS);
    }

    public QPedidoItemPromocao(Path<? extends PedidoItemPromocao> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPedidoItemPromocao(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPedidoItemPromocao(PathMetadata metadata, PathInits inits) {
        this(PedidoItemPromocao.class, metadata, inits);
    }

    public QPedidoItemPromocao(Class<? extends PedidoItemPromocao> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.promocao = inits.isInitialized("promocao") ? new QPromocao(forProperty("promocao")) : null;
    }

}

