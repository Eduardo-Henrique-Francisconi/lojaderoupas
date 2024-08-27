package com.lojaderoupas.app.controller;

import com.lojaderoupas.app.entity.Cliente;
import com.lojaderoupas.app.service.ClienteService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    

    @PostMapping
    public ResponseEntity<?> criarCliente(@Valid @RequestBody Cliente cliente, BindingResult result) {
    if (result.hasErrors()) {
        // Retorna a primeira mensagem de erro de validação
        String errorMessage = result.getFieldError().getDefaultMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    Cliente novoCliente = clienteService.salvar(cliente);
    return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    //findy by cpf
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Cliente> buscarClientePorCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(clienteService.buscarPorCpf(cpf));
    }
    //find by telefone
    @GetMapping("/telefone/{telefone}")
    public ResponseEntity<Cliente> buscarClientePorTelefone(@PathVariable String telefone) {
        return ResponseEntity.ok(clienteService.buscarPorTelefone(telefone));
    }

    //find by idade
    @GetMapping("/idade/{idade}")
    public ResponseEntity<Cliente> buscarClientePorIdade(@PathVariable int idade) {
        return ResponseEntity.ok(clienteService.buscarPorIdade(idade));
    }

}
