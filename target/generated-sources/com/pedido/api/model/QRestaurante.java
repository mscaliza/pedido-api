package com.pedido.api.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRestaurante is a Querydsl query type for Restaurante
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRestaurante extends EntityPathBase<Restaurante> {

    private static final long serialVersionUID = -487661069L;

    public static final QRestaurante restaurante = new QRestaurante("restaurante");

    public final DateTimePath<java.time.OffsetDateTime> dataAtualizacao = createDateTime("dataAtualizacao", java.time.OffsetDateTime.class);

    public final DateTimePath<java.time.OffsetDateTime> dataCadastro = createDateTime("dataCadastro", java.time.OffsetDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nome = createString("nome");

    public QRestaurante(String variable) {
        super(Restaurante.class, forVariable(variable));
    }

    public QRestaurante(Path<? extends Restaurante> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRestaurante(PathMetadata metadata) {
        super(Restaurante.class, metadata);
    }

}

