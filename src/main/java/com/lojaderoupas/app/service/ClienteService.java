package com.lojaderoupas.app.service;

import com.lojaderoupas.app.entity.Cliente;
import com.lojaderoupas.app.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        // Verifica se o cliente já existe pelo CPF
        Cliente clienteExistente = clienteRepository.findByCpf(cliente.getCpf());
        if (clienteExistente != null) {
            throw new IllegalArgumentException("Cliente já cadastrado");
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente buscarPorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }
    
    public Cliente buscarPorTelefone(String telefone) {
        return clienteRepository.findByTelefone(telefone);
    }

    public Cliente buscarPorIdade(int idade) {
        return clienteRepository.findByIdade(idade);
    }
}
