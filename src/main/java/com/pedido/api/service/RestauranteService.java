package com.pedido.api.service;

import com.pedido.api.model.Restaurante;
import com.pedido.api.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<Restaurante> findAll(){
        return restauranteRepository.findAll();
    }
}
