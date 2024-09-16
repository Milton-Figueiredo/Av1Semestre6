package com.prova.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.domains.Carro;

@Repository
public interface CarroRepository  extends JpaRepository<Carro, Integer>{
    Optional<Carro> findByNumero(Integer numero);
    Optional<Carro> findByModelo(String modelo);
    Optional<Carro> findByMarca(String marca);
    Optional<Carro> findByPlaca(String placa);
}
