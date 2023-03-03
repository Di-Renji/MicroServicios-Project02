package com.org.usuario.service;

import com.org.usuario.entity.Usuario;
import com.org.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

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
