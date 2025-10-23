package com.oficina.agendamentos_api.Controller;

import com.oficina.agendamentos_api.services.AgendamentoDTO;
import com.oficina.agendamentos_api.model.Agendamento;
import com.oficina.agendamentos_api.model.Cliente;
import com.oficina.agendamentos_api.model.Servico;
import com.oficina.agendamentos_api.model.StatusAgendamento;
import com.oficina.agendamentos_api.repository.AgendamentoRepository;
import com.oficina.agendamentos_api.repository.ClienteRepository;
import com.oficina.agendamentos_api.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/agendamentos")

public class AgendamentoController {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping
    public List<Agendamento> listar(){
        return agendamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Agendamento buscarPorId(@PathVariable Long id) {
        return agendamentoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado"));
    }

    @PostMapping
    public Agendamento criar(@RequestBody AgendamentoDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        Servico servico = servicoRepository.findById(dto.getServicoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado"));

        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(cliente);
        agendamento.setServico(servico);
        agendamento.setDataAgendada(dto.getDataAgendada());
        agendamento.setObservacoes(dto.getObservacoes());
        agendamento.setStatus(StatusAgendamento.valueOf(dto.getStatus()));
        agendamento.setCriado_em(LocalDateTime.now());

        return agendamentoRepository.save(agendamento);
    }

    @PutMapping("/{id}")
    public Agendamento atualizar(@PathVariable Long id, @RequestBody AgendamentoDTO dto) {
        Agendamento agendamentoExistente = agendamentoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado"));

        agendamentoExistente.setDataAgendada(dto.getDataAgendada());
        agendamentoExistente.setObservacoes(dto.getObservacoes());
        agendamentoExistente.setStatus(StatusAgendamento.valueOf(dto.getStatus()));

        return agendamentoRepository.save(agendamentoExistente);
    }


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
       Agendamento agendamento = buscarPorId(id);
        agendamentoRepository.delete(agendamento);
    }

}
