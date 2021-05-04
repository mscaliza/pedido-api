package com.pedido.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class PedidoItem {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pedido_id;

    private Long lanche_id;



    @OneToMany(mappedBy = "pedidoItemId")
    private List<ItemIngrediente> itemIngredientes = new ArrayList<>();

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="lanche_id", nullable=false, insertable=false, updatable=false)
    private Lanche lanche;

    @Transient
    private List<Promocao> promocoes;

    @OneToMany(mappedBy = "pedidoItemId")
    private List<PedidoItemPromocao> itemPromocoes = new ArrayList<>();

    public void addItemIngredientes(ItemIngrediente item){
        this.itemIngredientes.add(item);
    }
}
