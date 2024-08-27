package com.lojaderoupas.app.repository;

import com.lojaderoupas.app.entity.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
    //query por nome do cliente
    @Query("SELECT v FROM Venda v WHERE v.cliente.nome = ?1")
    List<Venda> findByClienteNome(String nome);
    //findyby quantidade de vendas feitas por um funcionario sem query
    List<Venda> findByFuncionarioNome(String nome);
    
    
}
