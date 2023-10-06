package com.pessoa.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;
@Data
@Entity
@Table(name = "TB_PESSOA")
public class PessoaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 50)
    private String nome;
    @Column(nullable = false, length = 11)
    private String cpf;
    @Column(nullable = false, length = 80)
    private String endereco;

}
