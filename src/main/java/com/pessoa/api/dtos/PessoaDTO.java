package com.pessoa.api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PessoaDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String endereco;
}
