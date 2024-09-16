package com.prova.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.domains.PedidoReserva;
import com.prova.domains.dtos.PedidoReservaDTO;
import com.prova.repositories.PedidoReservaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoReservaService {

    @Autowired
    private PedidoReservaRepository pedidoReservaRepo;

    public List<PedidoReservaDTO> findAll() {
        return pedidoReservaRepo.findAll().stream()
                .map(obj -> new PedidoReservaDTO(obj))
                .collect(Collectors.toList());
    }

    public PedidoReserva findById(Integer id) {
        Optional<PedidoReserva> obj = pedidoReservaRepo.findById(id);
        return obj.orElseThrow(() -> new EntityNotFoundException("PedidoReserva não encontrado no sistema! ID: " + id));
    }

    public PedidoReserva create(PedidoReservaDTO objDto) {
        objDto.setId(null);
        PedidoReserva newObj = new PedidoReserva(objDto);
        return pedidoReservaRepo.save(newObj);
    }

    public PedidoReserva update(Integer id, PedidoReservaDTO objDto) {
        objDto.setId(id);
        PedidoReserva oldObj = findById(id);
        oldObj = new PedidoReserva(objDto);
        return pedidoReservaRepo.save(oldObj);
    }

    public void delete(Integer id) {
        pedidoReservaRepo.deleteById(id);
    }

}
