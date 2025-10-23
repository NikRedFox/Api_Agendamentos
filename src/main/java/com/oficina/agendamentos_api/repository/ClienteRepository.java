package com.oficina.agendamentos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oficina.agendamentos_api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
