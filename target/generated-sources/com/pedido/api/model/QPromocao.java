package com.pedido.api.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPromocao is a Querydsl query type for Promocao
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPromocao extends EntityPathBase<Promocao> {

    private static final long serialVersionUID = 471542551L;

    public static final QPromocao promocao = new QPromocao("promocao");

    public final StringPath descricao = createString("descricao");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QPromocao(String variable) {
        super(Promocao.class, forVariable(variable));
    }

    public QPromocao(Path<? extends Promocao> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPromocao(PathMetadata metadata) {
        super(Promocao.class, metadata);
    }

}

