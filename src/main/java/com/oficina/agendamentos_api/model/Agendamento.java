package com.oficina.agendamentos_api.model;

import jakarta.persistence. *;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="agendamento")

public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long agendamentoId;

    @ManyToOne
    @JoinColumn(name = "clienteId", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "servicoId", nullable = false)
    private Servico servico;

    @Column(nullable = false)
    private String observacoes;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(nullable = false)
    private LocalDateTime criado_em;

    public Agendamento(){}

    public Agendamento(String observacoes, String descricao, BigDecimal preco, LocalDateTime criado_em){
        this.observacoes = observacoes;
        this.descricao = descricao;
        this.preco = preco;
        this.criado_em = criado_em;
    }

    public Long setAgendamentoId(){return agendamentoId;}
    public void getAgendamentoId(Long agendamentoId) {this.agendamentoId = agendamentoId;}

    public String setObservacoes(){return observacoes;}
    public void getObservacoes(String observacoes) {this.observacoes = observacoes;}

    public String getEmail(){return descricao;}
    public void setEmail(String descricao) {this.descricao = descricao;}

    public BigDecimal getPreco(){return preco;}
    public void setPreco(BigDecimal preco) {this.preco = preco;}

    public LocalDateTime getCriado_em(){return criado_em;}
    public void setCriado_em(LocalDateTime criado_em) {this.criado_em = criado_em;}
}
