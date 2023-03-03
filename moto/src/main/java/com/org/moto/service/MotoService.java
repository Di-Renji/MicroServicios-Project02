package com.org.moto.service;

import com.org.moto.entity.Moto;
import com.org.moto.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    //Obtener lista de todos las Motos
    public List<Moto> getAll(){
        return motoRepository.findAll();
    }

    // Buscar Moto por ID
    public Moto getMotoById(int id){
        return motoRepository.findById(id).orElse(null);
    }

    // Registar Carro
    public Moto save(Moto moto){
        Moto nuevoUsuario = motoRepository.save(moto);
        return nuevoUsuario;
    }

    public List<Moto> byUsuarioId(int usuarioId){
        return motoRepository.findByUsuarioId(usuarioId);
    }

}
