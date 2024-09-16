package com.prova.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prova.domains.Usuario;
import com.prova.domains.dtos.UsuarioDTO;
import com.prova.services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/usuario")
@Tag(name = "Usuario", description = "API para gerenciamento de usuários")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Listar usuários", description = "Retorna lista com todos os usuários")
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        return ResponseEntity.ok().body(usuarioService.findAll());
    }

    @Operation(summary = "Buscar usuário por ID", description = "Retorna um usuário com base no ID fornecido")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id) {
        Usuario obj = usuarioService.findById(id);
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }

    @Operation(summary = "Criar novo usuário", description = "Cria um novo usuário")
    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO objDto) {
        Usuario newObj = usuarioService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDTO(newObj));
    }

    @Operation(summary = "Atualizar usuário", description = "Atualiza um usuário existente com base no ID fornecido")
    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Integer id, @Valid @RequestBody UsuarioDTO objDto) {
        Usuario obj = usuarioService.update(id, objDto);
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }

    @Operation(summary = "Excluir usuário", description = "Exclui um usuário com base no ID fornecido")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
