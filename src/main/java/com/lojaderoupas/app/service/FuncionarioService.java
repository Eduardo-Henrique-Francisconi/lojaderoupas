package com.lojaderoupas.app.service;

import com.lojaderoupas.app.entity.Funcionario;
import com.lojaderoupas.app.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario salvar(Funcionario funcionario) {
        // Verifica se o funcionário já existe pela matrícula
        List<Funcionario> funcionarioExistente = funcionarioRepository.findByMatricula(funcionario.getMatricula());
        if (!funcionarioExistente.isEmpty()) {
            throw new IllegalArgumentException("Funcionário já cadastrado");
        }
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }

    public void deletar(Long id) {
        funcionarioRepository.deleteById(id);
    }

    // buscar por nome
    public List<Funcionario> buscarPorNome(String nome) {
        return funcionarioRepository.findByNome(nome);
    }

    // buscar por matricula
    public List<Funcionario> buscarPorMatricula(String matricula) {
        return funcionarioRepository.findByMatricula(matricula);
    }

    // buscar por idade
    public List<Funcionario> buscarPorIdade(int idade) {
        return funcionarioRepository.findByIdade(idade);
    }
}
