package com.prova.domains;

import java.time.LocalDate;

import com.prova.domains.dtos.PedidoReservaDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidoreserva")
public class PedidoReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private Integer Situacao;
    private LocalDate data;
    private Double Valor;

    @ManyToOne
    @JoinColumn(name = "idreserva")
    private Reserva reserva; 

    @ManyToOne
    @JoinColumn(name = "iddesconto")
    private Desconto desconto;

    @ManyToOne
    @JoinColumn(name = "idcarro")
    private Carro carro;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    public PedidoReserva(PedidoReservaDTO obj) {
        this.Id = obj.getId();
        this.data = obj.getData();
        this.reserva = obj.getReserva();
        this.desconto = obj.getDesconto();
        this.carro = obj.getCarro();
        this.usuario = obj.getUsuario();
    }

    public PedidoReserva() {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Id == null) ? 0 : Id.hashCode());
        result = prime * result + ((reserva == null) ? 0 : reserva.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PedidoReserva other = (PedidoReserva) obj;
        if (Id == null) {
            if (other.Id != null)
                return false;
        } else if (!Id.equals(other.Id))
            return false;
        if (reserva == null) {
            if (other.reserva != null)
                return false;
        } else if (!reserva.equals(other.reserva))
            return false;
        return true;
    }

    


}
