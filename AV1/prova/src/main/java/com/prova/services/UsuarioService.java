package com.prova.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.domains.Usuario;
import com.prova.domains.dtos.UsuarioDTO;
import com.prova.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    public List<UsuarioDTO> findAll() {
        return usuarioRepo.findAll().stream()
                .map(obj -> new UsuarioDTO(obj))
                .collect(Collectors.toList());
    }

    public Usuario findById(Integer id) {
        Optional<Usuario> obj = usuarioRepo.findById(id);
        return obj.orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado no sistema! ID: " + id));
    }

    public Usuario create(UsuarioDTO objDto) {
        objDto.setId(null);
        Usuario newObj = new Usuario(objDto);
        return usuarioRepo.save(newObj);
    }

    public Usuario update(Integer id, UsuarioDTO objDto) {
        objDto.setId(id);
        Usuario oldObj = findById(id);
        oldObj = new Usuario(objDto);
        return usuarioRepo.save(oldObj);
    }

    public void delete(Integer id) {
        usuarioRepo.deleteById(id);
    }
}
