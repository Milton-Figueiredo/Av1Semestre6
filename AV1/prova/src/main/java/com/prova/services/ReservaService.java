package com.prova.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.domains.Reserva;
import com.prova.domains.dtos.ReservaDTO;
import com.prova.repositories.ReservaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepo;

    public List<ReservaDTO> findAll() {
        return reservaRepo.findAll().stream()
                .map(obj -> new ReservaDTO(obj))
                .collect(Collectors.toList());
    }

    public Reserva findById(Integer id) {
        Optional<Reserva> obj = reservaRepo.findById(id);
        return obj.orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada no sistema! ID: " + id));
    }

    public Reserva create(ReservaDTO objDto) {
        objDto.setNumero(null);
        Reserva newObj = new Reserva(objDto);
        return reservaRepo.save(newObj);
    }

    public Reserva update(Integer id, ReservaDTO objDto) {
        objDto.setNumero(id);
        Reserva oldObj = findById(id);
        oldObj = new Reserva(objDto);
        return reservaRepo.save(oldObj);
    }

    public void delete(Integer id) {
        reservaRepo.deleteById(id);
    }
}
