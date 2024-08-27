package com.lojaderoupas.app.entity;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @Min(value = 0, message = "A idade não pode ser negativa.")
    private int idade;

    @NotBlank(message = "O CPF é obrigatório.")
    @CPF(message = "CPF inválido.")
    @Column(unique = true)  
    private String cpf;

    @NotBlank(message = "O telefone é obrigatório.")
    private String telefone;
}
