package com.pessoa.api.service;

import com.pessoa.api.models.PessoaModel;
import com.pessoa.api.repository.PessoaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {
    @InjectMocks
    PessoaService pessoaService;
    @Mock
    PessoaRepository pessoaRepository;

    @Test
    @DisplayName("Deve salvar pessoa com sucesso")
    void save() {

        //setup - Arrange
        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setCpf("12345678912");
        pessoaModel.setNome("Teste nome");
        pessoaModel.setEndereco("Teste endereco");

        PessoaModel pessoaModelToBeSaved = this.pessoaRepository.save(pessoaModel);

        // teste - Action


        //validações - assertions



    }
}