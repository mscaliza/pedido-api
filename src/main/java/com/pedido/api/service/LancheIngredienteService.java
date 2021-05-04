package com.pedido.api.service;

import com.pedido.api.model.LancheIngrediente;
import com.pedido.api.repository.LancheIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancheIngredienteService {

    @Autowired
    private LancheIngredienteRepository lancheIngredienteRepository;

    public List<LancheIngrediente> findAll(){
        return (List<LancheIngrediente>) lancheIngredienteRepository.findAll();
    }
}
