package com.prova.domains.dtos;

import com.prova.domains.Carro;

import jakarta.validation.constraints.NotNull;

public class CarroDTO {

    protected Integer id;

    @NotNull(message = "Numero Obrigatorio")
    protected Integer numero;
    
    @NotNull(message = "Modelo Obrigatorio")
    protected String modelo;
    
    @NotNull(message = "Marca Obrigatorio")
    protected String marca;

    @NotNull(message = "Placa Obrigatorio")
    protected String placa;

    public CarroDTO() {
    }

    public CarroDTO(Carro obj) {
        this.id = obj.getId();
        this.numero = obj.getNumero();
        this.modelo = obj.getModelo();
        this.marca = obj.getMarca();
        this.placa = obj.getPlaca();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    
}
