package com.lojaderoupas.app.controller;

import com.lojaderoupas.app.entity.Produto;
import com.lojaderoupas.app.service.ProdutoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<?> salvarProduto(@Valid @RequestBody Produto produto, BindingResult result) {
        if (result.hasErrors()) {
            // Captura a primeira mensagem de erro de validação
            String errorMessage = result.getFieldError().getDefaultMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
        // Se não houver erros, salva o produto
        Produto novoProduto = produtoService.salvar(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscarnome/{nome}")
    public ResponseEntity<List<Produto>> buscarProdutoPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(produtoService.buscarPorNome(nome));
    }

}
