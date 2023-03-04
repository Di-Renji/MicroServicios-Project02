package com.org.carro.service;

import com.org.carro.entity.Carro;
import com.org.carro.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    //Obtener lista de todos los Carros
    public List<Carro> getAll(){
        return carroRepository.findAll();
    }

    // Buscar Carro por ID
    public Carro getCarroById(int id){
        return carroRepository.findById(id).orElse(null);
    }

    // Registar Carro
    public Carro save(Carro carro){
        Carro nuevoCarro = carroRepository.save(carro);
        return nuevoCarro;
    }

    public List<Carro> byUsuarioId(int usuarioId){
        return carroRepository.findByUsuarioId(usuarioId);
    }

}
