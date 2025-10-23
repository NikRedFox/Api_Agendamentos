package com.oficina.agendamentos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oficina.agendamentos_api.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{
}
