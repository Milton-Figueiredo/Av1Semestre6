package com.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.domains.PedidoReserva;

@Repository
public interface PedidoReservaRepository extends JpaRepository<PedidoReserva, Integer>{

}
