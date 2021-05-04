package com.pedido.api.resource;

import com.pedido.api.model.Promocoes;
import com.pedido.api.model.dto.request.RequestEnviarPedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/promocoes")
public class PromocoesResource {

    @GetMapping
    public ResponseEntity<Promocoes[]> buscaPromocoes(){
        return ResponseEntity.status(HttpStatus.OK).body(Promocoes.values());
    }

    @PostMapping("/analisar")
    public ResponseEntity<RequestEnviarPedido>analisar(@RequestBody RequestEnviarPedido request){
        return ResponseEntity.status(HttpStatus.OK).body(RequestEnviarPedido.analisarPedido(request));
    }
}
