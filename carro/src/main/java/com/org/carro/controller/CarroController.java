package com.org.carro.controller;

import com.org.carro.entity.Carro;
import com.org.carro.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;


    @GetMapping("/listar")
    public ResponseEntity<List<Carro>> listarCarros(){
        List<Carro> carros = carroService.getAll();
        if (carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Carro> obtenerCarro(@PathVariable("id") int id){
        Carro carro = carroService.getCarroById(id);
        if (carro == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Carro> registrarCarro(@RequestBody Carro carro){
        Carro nuevoCarro = carroService.save(carro);
        return ResponseEntity.ok(carro);
    }

    @GetMapping("/buscaruser/{usuarioId}")
    public ResponseEntity<List<Carro>> listarCarrosPorUsuarioId(@PathVariable("usuarioId") int id){
        List<Carro> carros = carroService.byUsuarioId(id);
        if (carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }

}
