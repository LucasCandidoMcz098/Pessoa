package com.pessoa.api.PessoaController;

import com.pessoa.api.service.PessoaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class PessoaControllerTest {
    @InjectMocks
    private PessoaController pessoaController;
    @Mock
    private PessoaService pessoaService;
    @Test
    void savePessoa() {
    }
}