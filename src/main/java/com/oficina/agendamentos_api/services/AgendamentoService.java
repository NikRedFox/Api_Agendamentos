package com.oficina.agendamentos_api.services;

import com.oficina.agendamentos_api.model.Agendamento;
import com.oficina.agendamentos_api.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public List<Agendamento> listarTodos(){
        return agendamentoRepository.findAll();
    }

    public Agendamento buscarPorId(Long id) {
        return agendamentoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado"));
    }

    public Agendamento salvar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento atualizar(Long id, Agendamento agendamentoAtualizado) {
        Agendamento agendamentoExistente = buscarPorId(id);

        agendamentoExistente.setDataAgendada(agendamentoAtualizado.getDataAgendada());
        agendamentoExistente.setStatus(agendamentoAtualizado.getStatus());

        return agendamentoRepository.save(agendamentoExistente);
    }

    public void deletar(Long id) {
        Agendamento agendamento = buscarPorId(id);
        agendamentoRepository.delete(agendamento);
    }
}
