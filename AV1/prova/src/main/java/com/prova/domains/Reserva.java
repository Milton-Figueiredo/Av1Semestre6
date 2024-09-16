package com.prova.domains;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.prova.domains.dtos.ReservaDTO;
import com.prova.domains.enums.StatusReserva;
import com.prova.domains.enums.TipoDespesa;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer numero;
    protected LocalDate horaSaida;
    protected LocalDate horaChegada;
    protected Integer tempoReseva;
    protected String agendaSaida;
    protected String agenciaChegada;

    @ElementCollection(fetch = FetchType.EAGER)
    protected Set<Integer> tipoDespesa = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    protected Set<Integer> statusReserva = new HashSet<>();

    public Reserva(ReservaDTO obj) {
        this.numero = obj.getNumero();
        this.horaSaida = obj.getHoraSaida();
        this.horaChegada = obj.getHoraChegada();
        this.tempoReseva = obj.getTempoReseva();
        this.agendaSaida = obj.getAgendaSaida();
        this.agenciaChegada = obj.getAgenciaChegada();
        this.tipoDespesa = obj.getTipoDespesa();
        this.statusReserva = obj.getStatusReserva();
    }

    public Reserva() {
        super();
    }

    public void addStatusReserva(StatusReserva statusReserva){
            this.statusReserva.add(statusReserva.getId());
    }

    public void addTipORerserva(TipoDespesa tipoDespesa){
        this.tipoDespesa.add(tipoDespesa.getId());
}

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public LocalDate getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalDate horaSaida) {
        this.horaSaida = horaSaida;
    }

    public LocalDate getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(LocalDate horaChegada) {
        this.horaChegada = horaChegada;
    }

    public Integer getTempoReseva() {
        return tempoReseva;
    }

    public void setTempoReseva(Integer tempoReseva) {
        this.tempoReseva = tempoReseva;
    }

    public String getAgendaSaida() {
        return agendaSaida;
    }

    public void setAgendaSaida(String agendaSaida) {
        this.agendaSaida = agendaSaida;
    }

    public String getAgenciaChegada() {
        return agenciaChegada;
    }

    public void setAgenciaChegada(String agenciaChegada) {
        this.agenciaChegada = agenciaChegada;
    }

    public Set<Integer> getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(Set<Integer> tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public Set<Integer> getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(Set<Integer> statusReserva) {
        this.statusReserva = statusReserva;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
        Reserva other = (Reserva) obj;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }

    

}
