package com.org.carro.repository;

import com.org.carro.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

    List<Carro> findbyUsuario(int usuarioId);

}
