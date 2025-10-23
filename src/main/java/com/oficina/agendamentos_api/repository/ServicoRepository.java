package com.oficina.agendamentos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oficina.agendamentos_api.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
