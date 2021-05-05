package com.pedido.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ItemIngrediente implements Serializable {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pedido_item_id")
    private Long pedidoItemId;

    private Long ingrediente_id;

    private String descricao;

    private Long quantidade;

    private BigDecimal valor;

    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;

    @Column(name = "desconto_promocional")
    private BigDecimal descontoPromocional = new BigDecimal(0);

    @Column(name = "quantidade_promocional")
    private Long quantidadePromocional = 0L;

    @Column(name = "valor_final")
    private BigDecimal valorFinal = new BigDecimal(0);

    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="ingrediente_id", nullable=false, insertable=false, updatable=false)
    private Ingrediente ingrediente;

    public ItemIngrediente() {}

    public ItemIngrediente(Long ingrediente_id, String descricao, Long quantidade){
        this.ingrediente_id = ingrediente_id;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }


}
