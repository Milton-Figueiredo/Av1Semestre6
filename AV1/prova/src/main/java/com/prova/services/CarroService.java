package com.prova.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.domains.Carro;
import com.prova.domains.dtos.CarroDTO;
import com.prova.repositories.CarroRepository;
import com.prova.services.exceptions.ObjectNotFoundException;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepo;

    public List<CarroDTO> findAll() {
        return carroRepo.findAll().stream().map(obj -> new CarroDTO(obj)).collect(Collectors.toList());
    }

    public Carro findById(Integer id) {
        Optional<Carro> obj = carroRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado no sistema! ID: " + id));
    }

    public Carro findByNumero(Integer numero) {
        Optional<Carro> obj = carroRepo.findByNumero(numero);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado no sistema! Número: " + numero));
    }

    public Carro findByModeloString(String modelo) {
        Optional<Carro> obj = carroRepo.findByModelo(modelo);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado no sistema! Modelo: " + modelo));
    }
    public Carro findByMarca(String marca) {
        Optional<Carro> obj = carroRepo.findByMarca(marca);
        return obj.orElseThrow(() -> new ObjectNotFoundException("hgfd"+ marca));
    }
    public Carro findByPlaca(String placa) {
        Optional<Carro> obj = carroRepo.findByPlaca(placa);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado no sistema! Placa: " + placa));
    }

    public Carro create(CarroDTO objDto) {
        objDto.setId(null);
        Carro newObj = new Carro(objDto);
        return carroRepo.save(newObj);
    }

    public Carro update(Integer id, CarroDTO objDto) {
        objDto.setId(id);
        Carro oldObj = findById(id);
        oldObj = new Carro(objDto);
        return carroRepo.save(oldObj);
    }

    public void delete(Integer id) {
        carroRepo.deleteById(id);
    }

}
