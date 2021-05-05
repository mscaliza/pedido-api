package com.pedido.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class PedidoItemPromocao {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pedido_item_id")
    private Long pedidoItemId;

    @Column(name = "promocao_id")
    private Long promocaoId;

    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="promocao_id", nullable=false, insertable=false, updatable=false)
    private Promocao promocao;

    public PedidoItemPromocao() {}

    public PedidoItemPromocao(Long pedidoItemId, Long promocaoId) {
        this.pedidoItemId = pedidoItemId;
        this.promocaoId = promocaoId;
    }

}



