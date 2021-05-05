package com.pedido.api.model;

import com.pedido.api.model.dto.request.RequestEnviarPedido;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ApiModel
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pedido implements Serializable {

    @ApiModelProperty(example = "1")
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(example = "2019-12-01T20:34:04Z")
    @CreationTimestamp
    @Column(columnDefinition = "timestamp")
    private OffsetDateTime data;

    @OneToMany(mappedBy = "pedido_id")
    private List<PedidoItem> pedidoItem = new ArrayList<>();

    private void addPedidoItem(PedidoItem item){
        this.pedidoItem.add(item);
    }

    public static Pedido converterParaPedidos(RequestEnviarPedido request){
        Pedido pedido = new Pedido();
        request.getLanchesDTO()
                .forEach(LancheDTO -> {
                    PedidoItem item = new PedidoItem();
                    item.setLanche_id(LancheDTO.getId());
                    if(TipoLanche.valueOf(LancheDTO.getTipo()).equals(TipoLanche.PERSONALIZADO)){
                        LancheDTO.getIngredientes()
                                .forEach(ingredienteDTO -> item.addItemIngredientes(new ItemIngrediente(ingredienteDTO.getId(), ingredienteDTO.getDescricao(), ingredienteDTO.getQuantidade())));
                    }
                    pedido.addPedidoItem(item);
                });

        return pedido;
    }
}
