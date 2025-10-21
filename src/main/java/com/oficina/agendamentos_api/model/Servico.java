package com.oficina.agendamentos_api.model;

import jakarta.persistence. *;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="servico")

public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long servicoId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(nullable = false)
    private LocalDateTime criado_em;

    public Servico(){}

    public Servico(String nome, String descricao, BigDecimal preco, LocalDateTime criado_em){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.criado_em = criado_em;
    }

    public Long getServicoId(){return servicoId;}
    public void setServicoId(Long servicoId) {this.servicoId = servicoId;}

    public String getNome(){return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getEmail(){return descricao;}
    public void setEmail(String descricao) {this.descricao = descricao;}

    public BigDecimal getPreco(){return preco;}
    public void setPreco(BigDecimal preco) {this.preco = preco;}

    public LocalDateTime getCriado_em(){return criado_em;}
    public void setCriado_em(LocalDateTime criado_em) {this.criado_em = criado_em;}
}
