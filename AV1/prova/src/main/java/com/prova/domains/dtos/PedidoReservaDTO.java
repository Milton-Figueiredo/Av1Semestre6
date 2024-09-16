package com.prova.domains.dtos;

import java.time.LocalDate;

import com.prova.domains.Carro;
import com.prova.domains.Desconto;
import com.prova.domains.PedidoReserva;
import com.prova.domains.Reserva;
import com.prova.domains.Usuario;

import jakarta.validation.constraints.NotNull;


public class PedidoReservaDTO {

    protected Integer Id;

    //@NotNull(message = "Campo Obrigatorio")
    protected Integer Situacao;

    //@NotNull(message = "Campo Obrigatorio")
    protected LocalDate data;

    //@NotNull(message = "Campo Obrigatorio")
    protected Double Valor;

    //@NotNull(message = "Campo Obrigatorio")
    protected Reserva reserva; 
    protected Desconto desconto;
    protected Carro carro;
    protected Usuario usuario;

    public PedidoReservaDTO() {
    }

    public PedidoReservaDTO(PedidoReserva obj) {
        this.Id = obj.getId();
        this.Situacao = obj.getSituacao();
        this.data = obj.getData();
        this.Valor = obj.getValor();
        this.reserva = obj.getReserva();
        this.desconto = obj.getDesconto();
        this.carro = obj.getCarro();
        this.usuario = obj.getUsuario();
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getSituacao() {
        return Situacao;
    }

    public void setSituacao(Integer situacao) {
        Situacao = situacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double valor) {
        Valor = valor;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Desconto getDesconto() {
        return desconto;
    }

    public void setDesconto(Desconto desconto) {
        this.desconto = desconto;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
