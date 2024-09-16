package com.prova.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prova.domains.Reserva;
import com.prova.domains.dtos.ReservaDTO;
import com.prova.services.ReservaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/reserva")
@Tag(name = "Reserva", description = "API para gerenciamento de reservas")
public class ReservaResource {

    @Autowired
    private ReservaService reservaService;

    @Operation(summary = "Listar reservas", description = "Retorna lista com todas as reservas")
    @GetMapping
    public ResponseEntity<List<ReservaDTO>> findAll() {
        return ResponseEntity.ok().body(reservaService.findAll());
    }

    @Operation(summary = "Buscar reserva por ID", description = "Retorna uma reserva com base no ID fornecido")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ReservaDTO> findById(@PathVariable Integer id) {
        Reserva obj = reservaService.findById(id);
        return ResponseEntity.ok().body(new ReservaDTO(obj));
    }

    @Operation(summary = "Criar nova reserva", description = "Cria uma nova reserva")
    @PostMapping
    public ResponseEntity<ReservaDTO> create(@Valid @RequestBody ReservaDTO objDto) {
        Reserva newObj = reservaService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getNumero()).toUri();
        return ResponseEntity.created(uri).body(new ReservaDTO(newObj));
    }

    @Operation(summary = "Atualizar reserva", description = "Atualiza uma reserva existente com base no ID fornecido")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ReservaDTO> update(@PathVariable Integer id, @Valid @RequestBody ReservaDTO objDto) {
        Reserva obj = reservaService.update(id, objDto);
        return ResponseEntity.ok().body(new ReservaDTO(obj));
    }

    @Operation(summary = "Excluir reserva", description = "Exclui uma reserva com base no ID fornecido")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
