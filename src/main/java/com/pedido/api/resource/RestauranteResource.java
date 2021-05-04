package com.pedido.api.resource;

import com.pedido.api.model.Restaurante;
import com.pedido.api.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteResource {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public ResponseEntity<List<Restaurante>> findAll(){
        List<Restaurante> restaurantes = restauranteService.findAll();
        return restaurantes.size() > 0 ? ResponseEntity.ok(restaurantes) : ResponseEntity.notFound().build();
    }
}
