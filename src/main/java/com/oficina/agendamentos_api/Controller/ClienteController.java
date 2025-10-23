package com.oficina.agendamentos_api.Controller;

import com.oficina.agendamentos_api.model.Cliente;
import com.oficina.agendamentos_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")

public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar(){ return clienteRepository.findAll();}

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
