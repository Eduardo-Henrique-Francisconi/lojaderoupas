package com.lojaderoupas.app.repository;

import com.lojaderoupas.app.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCpf(String cpf);
    Cliente findByTelefone(String telefone);

    //find by idade
    Cliente findByIdade(int idade);

    
}

