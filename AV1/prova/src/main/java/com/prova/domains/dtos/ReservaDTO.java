package com.prova.domains.dtos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.prova.domains.Reserva;

import jakarta.validation.constraints.NotNull;


public class ReservaDTO {

    protected Integer numero;

    @NotNull(message = "Hora Saida Obrigatorio")
    protected LocalDate horaSaida;

    @NotNull(message = "Hora Chegada Obrigatorio")
    protected LocalDate horaChegada;

    @NotNull(message = "Tempo Reserva Obrigatorio")
    protected Integer tempoReseva;

    @NotNull(message = "Agenda Saida Obrigatorio")
    protected String agendaSaida;
    
    @NotNull(message = "Agencia Chegada Obrigatorio")
    protected String agenciaChegada;

    protected Set<Integer> tipoDespesa = new HashSet<>();

    protected Set<Integer> statusReserva = new HashSet<>();

    public ReservaDTO() {
    }

    public ReservaDTO(Reserva obj) {
        this.numero = obj.getNumero();
        this.horaSaida = obj.getHoraSaida();
        this.horaChegada = obj.getHoraChegada();
        this.tempoReseva = obj.getTempoReseva();
        this.agendaSaida = obj.getAgendaSaida();
        this.agenciaChegada = obj.getAgenciaChegada();
        this.tipoDespesa = obj.getTipoDespesa();
        this.statusReserva = obj.getStatusReserva();
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

    

    
}
