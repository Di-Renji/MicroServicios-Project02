package com.org.moto.controller;

import com.org.moto.entity.Moto;
import com.org.moto.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {

    @Autowired
    private MotoService motoService;


    @GetMapping("/listar")
    public ResponseEntity<List<Moto>> listarCarros(){
        List<Moto> motos = motoService.getAll();
        if (motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Moto> obtenerMoto(@PathVariable("id") int id){
        Moto moto = motoService.getMotoById(id);
        if (moto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Moto> registrarCarro(@RequestBody Moto moto){
        Moto nuevaMoto = motoService.save(moto);
        return ResponseEntity.ok(nuevaMoto);
    }

    @GetMapping("/buscaruser/{usuarioId}")
    public ResponseEntity<List<Moto>> listarMotosPorUsuarioId(@PathVariable("usuarioId") int id){
        List<Moto> motos = motoService.byUsuarioId(id);
        if (motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }


}
