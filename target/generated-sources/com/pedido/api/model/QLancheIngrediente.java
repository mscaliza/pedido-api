package com.pedido.api.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLancheIngrediente is a Querydsl query type for LancheIngrediente
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLancheIngrediente extends EntityPathBase<LancheIngrediente> {

    private static final long serialVersionUID = 1247127224L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLancheIngrediente lancheIngrediente = new QLancheIngrediente("lancheIngrediente");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QIngrediente ingrediente;

    public final NumberPath<Long> ingrediente_id = createNumber("ingrediente_id", Long.class);

    public final QLanche lanche;

    public final NumberPath<Long> lanche_id = createNumber("lanche_id", Long.class);

    public QLancheIngrediente(String variable) {
        this(LancheIngrediente.class, forVariable(variable), INITS);
    }

    public QLancheIngrediente(Path<? extends LancheIngrediente> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLancheIngrediente(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLancheIngrediente(PathMetadata metadata, PathInits inits) {
        this(LancheIngrediente.class, metadata, inits);
    }

    public QLancheIngrediente(Class<? extends LancheIngrediente> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ingrediente = inits.isInitialized("ingrediente") ? new QIngrediente(forProperty("ingrediente")) : null;
        this.lanche = inits.isInitialized("lanche") ? new QLanche(forProperty("lanche")) : null;
    }

}

