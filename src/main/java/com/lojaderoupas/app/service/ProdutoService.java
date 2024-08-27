package com.lojaderoupas.app.service;

import com.lojaderoupas.app.entity.Produto;
import com.lojaderoupas.app.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) {
        // Verifica se o produto já existe pelo nome
        List<Produto> produtoExistente = produtoRepository.findByNome(produto.getNome());
        if (!produtoExistente.isEmpty()) {
            throw new IllegalArgumentException("Produto já cadastrado");
        }
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNome(nome);
    }
}
