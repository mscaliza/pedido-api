package com.pedido.api.resource;

import com.pedido.api.model.LancheIngrediente;
import com.pedido.api.service.LancheIngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lanchesingredientes")
public class LancheIngredienteResource {

    @Autowired
    private LancheIngredienteService lancheIngredienteService;

    @GetMapping
    public ResponseEntity<List<LancheIngrediente>> findAll(){
        List<LancheIngrediente> lanchesingredientes = lancheIngredienteService.findAll();
        return lanchesingredientes.size() > 0 ? ResponseEntity.ok(lanchesingredientes) : ResponseEntity.notFound().build();
    }
}