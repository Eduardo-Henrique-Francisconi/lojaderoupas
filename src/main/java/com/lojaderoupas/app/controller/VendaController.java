package com.lojaderoupas.app.controller;

import com.lojaderoupas.app.entity.Venda;
import com.lojaderoupas.app.service.VendaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<?> criarVenda(@Valid @RequestBody Venda venda, BindingResult result) {
        if (result.hasErrors()) {
            // Captura a primeira mensagem de erro de validação
            String errorMessage = result.getFieldError().getDefaultMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
        // Se não houver erros, salva a venda
        Venda novaVenda = vendaService.salvar(venda);
        return new ResponseEntity<>(novaVenda, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Venda>> listarVendas() {
        return ResponseEntity.ok(vendaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> buscarVendaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(vendaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVenda(@PathVariable Long id) {
        vendaService.deletar(id);
        return ResponseEntity.noContent().build();
    }    

    //query por nome do cliente
    @GetMapping("/buscarcliente/{nome}")
    public ResponseEntity<List<Venda>> buscarVendaPorNomeCliente(@PathVariable String nome) {
        return ResponseEntity.ok(vendaService.buscarPorNomeCliente(nome));
    }
    
    //findyby quantidade de vendas feitas por um funcionario pelo nome
    @GetMapping("/ventasfuncionario/{nome}")
    public ResponseEntity<String> buscarVendaPorNomeFuncionario(@PathVariable String nome) {
        long quantidadeVendas = vendaService.buscarPorNomeFuncionario(nome).size();
        return ResponseEntity.ok("vendas feitas:" + quantidadeVendas);
    }

    
}
