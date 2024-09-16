package com.prova.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prova.domains.Desconto;
import com.prova.domains.dtos.DescontoDTO;
import com.prova.services.DescontoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/desconto")
@Tag(name = "Desconto", description = "API para gerenciamento de descontos")
public class DescontoResource {

    @Autowired
    private DescontoService descontoService;

    @Operation(summary = "Listar descontos", description = "Retorna lista com todos os descontos")
    @GetMapping
    public ResponseEntity<List<DescontoDTO>> findAll() {
        return ResponseEntity.ok().body(descontoService.findAll());
    }

    @Operation(summary = "Buscar desconto por ID", description = "Retorna um desconto com base no ID fornecido")
    @GetMapping(value = "/{id}")
    public ResponseEntity<DescontoDTO> findById(@PathVariable Integer id) {
        Desconto obj = descontoService.findById(id);
        return ResponseEntity.ok().body(new DescontoDTO(obj));
    }

    @Operation(summary = "Criar novo desconto", description = "Cria um novo desconto")
    @PostMapping
    public ResponseEntity<DescontoDTO> create(@Valid @RequestBody DescontoDTO objDto) {
        Desconto newObj = descontoService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).body(new DescontoDTO(newObj));
    }

    @Operation(summary = "Atualizar desconto", description = "Atualiza um desconto existente com base no ID fornecido")
    @PutMapping(value = "/{id}")
    public ResponseEntity<DescontoDTO> update(@PathVariable Integer id, @Valid @RequestBody DescontoDTO objDto) {
        Desconto obj = descontoService.update(id, objDto);
        return ResponseEntity.ok().body(new DescontoDTO(obj));
    }

    @Operation(summary = "Excluir desconto", description = "Exclui um desconto com base no ID fornecido")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        descontoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
