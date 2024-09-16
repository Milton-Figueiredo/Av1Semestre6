package com.prova.domains.dtos;

import java.util.HashSet;
import java.util.Set;

import com.prova.domains.Desconto;
import com.prova.domains.enums.TipoDesconto;

import jakarta.validation.constraints.NotNull;

public class DescontoDTO {

    protected Integer id;

    //@NotNull(message = "Campo Obrigatorio")
    protected Integer tipo;

    //@NotNull(message = "Campo Obrigatorio")
    protected Double valor;

    //@NotNull(message = "Campo Obrigatorio")
    protected Integer cliente;

    //@NotNull(message = "Campo Obrigatorio")
    protected Integer reserva;

    protected Set<Integer> tipoDesconto = new HashSet<>();

    public DescontoDTO() {
    }

    public DescontoDTO(Desconto obj) {
        this.id = obj.getId();
        this.tipo = obj.getTipo();
        this.valor = obj.getValor();
        this.cliente = obj.getCliente();
        this.reserva = obj.getReserva();
        this.tipoDesconto = obj.getTipoDesconto();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getReserva() {
        return reserva;
    }

    public void setReserva(Integer reserva) {
        this.reserva = reserva;
    }

    public Set<Integer> getTipoDesconto() {
        return tipoDesconto;
    }

    public void addTipoDesconto(TipoDesconto tipoDesconto){
        this.tipoDesconto.add(tipoDesconto.getId());
    }

}
