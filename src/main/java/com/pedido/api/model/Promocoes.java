package com.pedido.api.model;

public enum Promocoes {
    LIGHT(1L, "Light"),
    MUITA_CARNE(2L,"Muita Carne"),
    MUITO_QUEIJO(3L,"Muito Queijo"),
    NENHUM(4L, "Nenhuma Promoção");

    private final String descricao;
    private final Long id;

    Promocoes(Long id, String descricao) {
        this.descricao = descricao;
        this.id = id;

    }

    public String getDescricao(){
        return descricao;
    }

    public Long getId(){
        return id;
    }
}
