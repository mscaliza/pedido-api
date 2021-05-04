package com.pedido.api.model.dto.request;

import com.pedido.api.model.TipoLanche;
import com.pedido.api.model.dto.LancheDTO;
import com.pedido.api.service.AnalisarPromocaoService;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RequestEnviarPedido implements Serializable {

    private List<LancheDTO> lanchesDTO;

    public static RequestEnviarPedido analisarPedido(RequestEnviarPedido request){
        request.getLanchesDTO()
                .forEach(lancheDTO -> {
                    if (lancheDTO.getTipo().equals(TipoLanche.PERSONALIZADO.name())) {
                        AnalisarPromocaoService service = new AnalisarPromocaoService();
                        service.analisarPromocaoLight(lancheDTO);
                        service.analisarPromocaoMuitaCarne(lancheDTO);
                        service.analisarPromocaoMuitoQueijo(lancheDTO);
                    }
                });

        return request;
    }
}
