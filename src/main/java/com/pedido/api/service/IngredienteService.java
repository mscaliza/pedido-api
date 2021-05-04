package com.pedido.api.service;

import com.pedido.api.model.Ingrediente;
import com.pedido.api.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public List<Ingrediente> findAll(){
        return ingredienteRepository.findAll();
    }
}

