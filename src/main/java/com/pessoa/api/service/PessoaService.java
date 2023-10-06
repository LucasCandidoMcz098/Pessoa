package com.pessoa.api.service;

import com.pessoa.api.models.PessoaModel;
import com.pessoa.api.repository.PessoaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {

    final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }
    @Transactional
    public PessoaModel save(PessoaModel pessoaModel){
        return pessoaRepository.save(pessoaModel);
    }

    public Page<PessoaModel> findAll(Pageable pageable){
        return pessoaRepository.findAll(pageable);
    }

    public Optional<PessoaModel> findById(UUID id){
        return pessoaRepository.findById(id);
    }

    public void delete(PessoaModel pessoaModel){
        pessoaRepository.delete(pessoaModel);
    }

    public boolean existsByCpf(String cpf){
        return pessoaRepository.existsByCpf(cpf);
    }
}
