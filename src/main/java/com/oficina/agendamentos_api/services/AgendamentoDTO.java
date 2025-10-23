package com.oficina.agendamentos_api.services;

public class AgendamentoDTO {
    private Long clienteId;
    private Long servicoId;
    private String dataAgendada;
    private String observacoes;
    private String status; // você pode usar String aqui e depois converter para o enum

    // Getters e Setters
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public Long getServicoId() { return servicoId; }
    public void setServicoId(Long servicoId) { this.servicoId = servicoId; }

    public String getDataAgendada() { return dataAgendada; }
    public void setDataAgendada(String dataAgendada) { this.dataAgendada = dataAgendada; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
