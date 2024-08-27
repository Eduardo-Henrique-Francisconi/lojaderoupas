package com.lojaderoupas.app.controller;

import com.lojaderoupas.app.entity.Funcionario;
import com.lojaderoupas.app.service.FuncionarioService;

import jakarta.validation.Valid;
import lombok.val;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<?> salvarFuncionario(@Valid @RequestBody Funcionario funcionario, BindingResult result) {
        if (result.hasErrors()) {
            // Captura a primeira mensagem de erro de validação
            String errorMessage = result.getFieldError().getDefaultMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
        // Salva o funcionário se não houver erros
        Funcionario novoFuncionario = funcionarioService.salvar(funcionario);
        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        return ResponseEntity.ok(funcionarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarFuncionarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    // buscar por nome
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Funcionario>> buscarFuncionarioPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(funcionarioService.buscarPorNome(nome));
    }
    // buscar por matricula
    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<List<Funcionario>> buscarFuncionarioPorMatricula(@PathVariable String matricula) {
        return ResponseEntity.ok(funcionarioService.buscarPorMatricula(matricula));
    }
    // buscar por idade
    @GetMapping("/idade/{idade}")
    public ResponseEntity<List<Funcionario>> buscarFuncionarioPorIdade(@PathVariable int idade) {
        return ResponseEntity.ok(funcionarioService.buscarPorIdade(idade));
    }
}
