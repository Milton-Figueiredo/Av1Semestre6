package com.prova.resources;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prova.domains.Carro;
import com.prova.domains.dtos.CarroDTO;
import com.prova.services.CarroService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/carro")
@Tag(name = "Carro", description = "API para gerenciamento de carros")
public class CarroResource {

    @Autowired
    private CarroService carroService;

    @Operation(summary = "Listar carros", description = "Retorna lista com todos os carros")
    @GetMapping
    public ResponseEntity<List<CarroDTO>> findAll() {
        return ResponseEntity.ok().body(carroService.findAll());
    }

    @Operation(summary = "Buscar carro por ID", description = "Retorna um carro pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> findById(@PathVariable Integer id) {
        Carro obj = carroService.findById(id);
        return ResponseEntity.ok().body(new CarroDTO(obj));
    }

    @Operation(summary = "Criar carro", description = "Cria um novo carro")
    @PostMapping
    public ResponseEntity<CarroDTO> create(@Valid @RequestBody CarroDTO objDto) {
        Carro newObj = carroService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Atualizar carro", description = "Atualiza um carro existente")
    @PutMapping("/{id}")
    public ResponseEntity<CarroDTO> update(@PathVariable Integer id, @RequestBody CarroDTO objDto) {
        Carro obj = carroService.update(id, objDto);
        return ResponseEntity.ok().body(new CarroDTO(obj));
    }

    @Operation(summary = "Deletar carro", description = "Remove um carro pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        carroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
