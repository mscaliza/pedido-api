package com.pedido.api.resource;

import com.pedido.api.model.Lanche;
import com.pedido.api.service.LancheService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("Lanches")
@RestController
@RequestMapping("/v1/lanches")
public class LancheResource {

    @Autowired
    private LancheService ingredienteService;

    @ApiOperation("lanches")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de lanches"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção não tratada"),
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Lanche>> findAll(){
        List<Lanche> lanches = ingredienteService.findAll();
        return lanches.size() > 0 ? ResponseEntity.ok(lanches) : ResponseEntity.notFound().build();
    }
}