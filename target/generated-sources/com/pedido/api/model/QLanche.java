package com.pedido.api.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLanche is a Querydsl query type for Lanche
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLanche extends EntityPathBase<Lanche> {

    private static final long serialVersionUID = -214681508L;

    public static final QLanche lanche = new QLanche("lanche");

    public final StringPath descricao = createString("descricao");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<LancheIngrediente, QLancheIngrediente> lancheIngredientes = this.<LancheIngrediente, QLancheIngrediente>createList("lancheIngredientes", LancheIngrediente.class, QLancheIngrediente.class, PathInits.DIRECT2);

    public final EnumPath<TipoLanche> tipo = createEnum("tipo", TipoLanche.class);

    public QLanche(String variable) {
        super(Lanche.class, forVariable(variable));
    }

    public QLanche(Path<? extends Lanche> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLanche(PathMetadata metadata) {
        super(Lanche.class, metadata);
    }

}

