package com.oficina.agendamentos_api.Controller;

import com.oficina.agendamentos_api.model.Servico;
import com.oficina.agendamentos_api.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/servicos")

public class ServicoController {
    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping
    public List<Servico> listar(){ return servicoRepository.findAll();}

    @PostMapping
    public Servico criar(@RequestBody Servico servico){
        servico.setCriado_em(LocalDateTime.now());
        return servicoRepository.save(servico);
    }

}
