package com.prova.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prova.domains.PedidoReserva;
import com.prova.domains.dtos.PedidoReservaDTO;
import com.prova.services.PedidoReservaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/pedido-reserva")
@Tag(name = "PedidoReserva", description = "API para gerenciamento de pedidos de reservas")
public class PedidoReservaResource {

    @Autowired
    private PedidoReservaService pedidoReservaService;

    @Operation(summary = "Listar pedidos e reservas", description = "Retorna lista com todos os pedidos e reservas")
    @GetMapping
    public ResponseEntity<List<PedidoReservaDTO>> findAll() {
        return ResponseEntity.ok().body(pedidoReservaService.findAll());
    }

    @Operation(summary = "Buscar pedido e reserva por ID", description = "Retorna um pedido e reserva com base no ID fornecido")
    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoReservaDTO> findById(@PathVariable Integer id) {
        PedidoReserva obj = pedidoReservaService.findById(id);
        return ResponseEntity.ok().body(new PedidoReservaDTO(obj));
    }

    @Operation(summary = "Criar novo pedido e reserva", description = "Cria um novo pedido e reserva")
    @PostMapping
    public ResponseEntity<PedidoReservaDTO> create(@Valid @RequestBody PedidoReservaDTO objDto) {
        PedidoReserva newObj = pedidoReservaService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).body(new PedidoReservaDTO(newObj));
    }

    @Operation(summary = "Atualizar pedido e reserva", description = "Atualiza um pedido e reserva existente com base no ID fornecido")
    @PutMapping(value = "/{id}")
    public ResponseEntity<PedidoReservaDTO> update(@PathVariable Integer id, @Valid @RequestBody PedidoReservaDTO objDto) {
        PedidoReserva obj = pedidoReservaService.update(id, objDto);
        return ResponseEntity.ok().body(new PedidoReservaDTO(obj));
    }

    @Operation(summary = "Excluir pedido e reserva", description = "Exclui um pedido e reserva com base no ID fornecido")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        pedidoReservaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
