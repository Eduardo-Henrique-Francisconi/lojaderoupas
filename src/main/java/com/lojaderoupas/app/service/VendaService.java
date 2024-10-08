package com.lojaderoupas.app.service;

import com.lojaderoupas.app.entity.Venda;
import com.lojaderoupas.app.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda salvar(Venda venda) {
        return vendaRepository.save(venda);
    }

    public List<Venda> listarTodas() {
        return vendaRepository.findAll();
    }

    public Venda buscarPorId(Long id) {
        return vendaRepository.findById(id).orElseThrow(() -> new RuntimeException("Venda não encontrada"));
    }

    public void deletar(Long id) {
        vendaRepository.deleteById(id);
    }

    //query por nome do cliente
    public List<Venda> buscarPorNomeCliente(String nome) {
        return vendaRepository.findByClienteNome(nome);
    }

    //findyby quantidade de vendas feitas por um funcionario pelo nome somente numero de vendas
    public List<Venda> buscarPorNomeFuncionario(String nome) {
        return vendaRepository.findByFuncionarioNome(nome);
    }

}
