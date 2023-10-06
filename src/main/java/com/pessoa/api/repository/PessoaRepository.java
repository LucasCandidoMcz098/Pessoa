package com.pessoa.api.repository;

import com.pessoa.api.models.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, UUID> {

    boolean existsByCpf(String cpf);
}
