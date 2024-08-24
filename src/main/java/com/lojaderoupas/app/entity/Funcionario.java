package com.lojaderoupas.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Nome inválido.")
    private String nome;

    @Min(value = 0, message = "A idade não pode ser negativa.")
    private int idade;

    @NotBlank(message = "A matrícula é obrigatória.")
    private String matricula;
}
