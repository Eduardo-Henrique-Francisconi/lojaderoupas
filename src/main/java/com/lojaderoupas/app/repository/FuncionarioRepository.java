package com.lojaderoupas.app.repository;

import com.lojaderoupas.app.entity.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    //findByNome
    List<Funcionario> findByNome(String nome);
    //findBymatricula
    List<Funcionario> findByMatricula(String matricula);
    //query idade
    @Query("SELECT f FROM Funcionario f WHERE f.idade = :idade")
    List<Funcionario> findByIdade(@Param("idade") int idade);
}
