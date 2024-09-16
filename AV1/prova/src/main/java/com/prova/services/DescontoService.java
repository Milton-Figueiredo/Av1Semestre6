package com.prova.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.domains.Desconto;
import com.prova.domains.dtos.DescontoDTO;
import com.prova.repositories.DescontoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DescontoService {

    @Autowired
    private DescontoRepository descontoRepo;

    public List<DescontoDTO> findAll() {
        return descontoRepo.findAll().stream()
                .map(obj -> new DescontoDTO(obj))
                .collect(Collectors.toList());
    }

    public Desconto findById(Integer id) {
        Optional<Desconto> obj = descontoRepo.findById(id);
        return obj.orElseThrow(() -> new EntityNotFoundException("Desconto não encontrado no sistema! ID: " + id));
    }

    public Desconto create(DescontoDTO objDto) {
        objDto.setId(null);
        Desconto newObj = new Desconto(objDto);
        return descontoRepo.save(newObj);
    }

    public Desconto update(Integer id, DescontoDTO objDto) {
        objDto.setId(id);
        Desconto oldObj = findById(id);
        oldObj = new Desconto(objDto);
        return descontoRepo.save(oldObj);
    }

    public void delete(Integer id) {
        descontoRepo.deleteById(id);
    }

}
