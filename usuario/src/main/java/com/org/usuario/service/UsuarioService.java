package com.org.usuario.service;

import com.org.usuario.entity.Usuario;
import com.org.usuario.models.Carro;
import com.org.usuario.models.Moto;
import com.org.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Carro> getCarros(int usuarioId){
        List<Carro> carros = restTemplate.getForObject("http://localhost:8082/carro/usuario/"+ usuarioId, List.class);
        return carros;
    }

    public List<Moto> getMotos(int usuarioId){
        List<Moto> motos = restTemplate.getForObject("http://localhost:8083/moto/usuario/"+ usuarioId, List.class);
        return motos;
    }


    //Obtener listad de todos los Usuarios
    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    // Buscar Usuario por ID
    public Usuario getUsuarioById(int id){
        return usuarioRepository.findById(id).orElse(null);
    }

    // Registar Usuario
    public Usuario save(Usuario usuario){
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return nuevoUsuario;
    }

}
