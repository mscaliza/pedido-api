package com.pedido.api.resource;

import com.pedido.api.model.Ingrediente;
import com.pedido.api.service.IngredienteService;
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

@Api("Ingredientes")
@RestController
@RequestMapping(path = "/v1/ingredientes")
public class IngredienteResource {

    @Autowired
    private IngredienteService ingredienteService;

    @ApiOperation("ingredientes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de ingredientes"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção não tratada"),
    })

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ingrediente>> findAll(){
        List<Ingrediente> ingredientes = ingredienteService.findAll();
        return ingredientes.size() > 0 ? ResponseEntity.ok(ingredientes) : ResponseEntity.notFound().build();
    }
}
