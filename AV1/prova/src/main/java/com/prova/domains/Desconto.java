package com.prova.domains;

import java.util.HashSet;
import java.util.Set;

import com.prova.domains.dtos.DescontoDTO;
import com.prova.domains.enums.TipoDesconto;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "desconto")
public class Desconto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    protected Integer tipo;
    protected Double valor;
    protected Integer cliente;
    
    @Column(unique = true)
    protected Integer reserva;

    @ElementCollection(fetch = FetchType.EAGER)
    protected Set<Integer> tipoDesconto = new HashSet<>();

    public Desconto(DescontoDTO obj) {
        this.id = obj.getId();
        this.tipo = obj.getTipo();
        this.valor = obj.getValor();
        this.cliente = obj.getCliente();
        this.reserva = obj.getReserva();
        addTipoDesconto(TipoDesconto.AVISTA);
    }

    public Desconto() {
        super();
        addTipoDesconto(TipoDesconto.AVISTA);
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

    public void setTipoDesconto(Set<Integer> tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
        Desconto other = (Desconto) obj;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        if (reserva == null) {
            if (other.reserva != null)
                return false;
        } else if (!reserva.equals(other.reserva))
            return false;
        return true;
    }

    public void addTipoDesconto(TipoDesconto tipoDesconto){
            this.tipoDesconto.add(tipoDesconto.getId());
        }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    

}
