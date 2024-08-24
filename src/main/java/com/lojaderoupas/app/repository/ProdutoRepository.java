package com.lojaderoupas.app.repository;

import com.lojaderoupas.app.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;   

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}