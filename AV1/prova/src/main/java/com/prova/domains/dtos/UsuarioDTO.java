package com.prova.domains.dtos;

import java.util.HashSet;
import java.util.Set;

import com.prova.domains.Usuario;
import com.prova.domains.enums.TipoUsuario;

import jakarta.validation.constraints.NotNull;

public class UsuarioDTO {

    protected Integer id;

    @NotNull(message = "Nome Obrigatorio")
    protected String nome;

    @NotNull(message = "CPF Obrigatorio")
    protected Integer cpf;

    @NotNull(message = "E-mail Obrigatorio")
    protected String email;

    @NotNull(message = "senha Obrigatorio")
    protected String senha;

    protected Set<Integer> tipoUsuario = new HashSet<>();

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCPF();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();;
        this.tipoUsuario = obj.getTipoUsuario();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Integer> getTipoUsuario() {
        return tipoUsuario;
    }

    public void addTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario.add(tipoUsuario.getId());
    }

}
