package com.pedido.api.resource;

import com.pedido.api.model.Pedido;
import com.pedido.api.model.dto.PedidoCobrancaDTO;
import com.pedido.api.model.dto.request.RequestEnviarPedido;
import com.pedido.api.service.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Pedidos")
@RestController
@RequestMapping("/v1/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @ApiOperation("pedidos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pedidos"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção não tratada"),
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pedido>> findAll(){
        List<Pedido> pedidos = pedidoService.findAll();
        return pedidos.size() > 0 ? ResponseEntity.ok(pedidos) : ResponseEntity.notFound().build();
    }

    @ApiOperation("enviar")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cadastra novo pedido"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção não tratada"),
    })
    @PostMapping(value = "/enviar", consumes = MediaType.APPLICATION_JSON_VALUE,
                                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PedidoCobrancaDTO> enviarPedido(@RequestBody RequestEnviarPedido request){
        Pedido pedido = Pedido.converterParaPedidos(request);
        PedidoCobrancaDTO pc;
        pc = pedidoService.cadastrar(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pc);
    }


}