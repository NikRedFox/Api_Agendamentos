package com.oficina.agendamentos_api.model;

import jakarta.persistence. *;

import java.time.LocalDateTime;

@Entity
@Table(name="cliente")

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long clienteId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private LocalDateTime criado_em;

    public Cliente(){}

    public Cliente(String nome, String email, String telefone, LocalDateTime criado_em){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.criado_em = criado_em;
    }

    public Long getClienteId(){return clienteId;}
    public void setClienteId(Long clienteId) {this.clienteId = clienteId;}

    public String getNome(){return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getEmail(){return email;}
    public void setEmail(String email) {this.email = email;}

    public String getTelefone(){return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}

    public LocalDateTime getCriado_em(){return criado_em;}
    public void setCriado_em(LocalDateTime criado_em) {this.criado_em = criado_em;}
}
