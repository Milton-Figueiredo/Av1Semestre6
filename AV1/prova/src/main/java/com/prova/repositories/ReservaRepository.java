package com.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.domains.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

}
