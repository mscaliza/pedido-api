package com.pedido.api.service;

import com.pedido.api.model.Lanche;
import com.pedido.api.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancheService {

    @Autowired
    private LancheRepository lancheRepository;

    public List<Lanche> findAll(){
        return lancheRepository.findAll();
    }
}
