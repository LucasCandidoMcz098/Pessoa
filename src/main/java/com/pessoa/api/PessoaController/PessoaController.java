package com.pessoa.api.PessoaController;

import com.pessoa.api.dtos.PessoaDTO;
import com.pessoa.api.models.PessoaModel;
import com.pessoa.api.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<Object> savePessoa(@RequestBody @Valid PessoaDTO pessoaDTO){
        if(pessoaService.existsByCpf(pessoaDTO.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este cpf já está cadastrado");
        }

        PessoaModel pessoaModel = new PessoaModel();
        BeanUtils.copyProperties(pessoaDTO, pessoaModel);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.save(pessoaModel));
    }

    @GetMapping
    public ResponseEntity<Object> getAllPessoas(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePessoa(@PathVariable(value = "id")UUID id){
        Optional<PessoaModel> pessoaModelOptional = pessoaService.findById(id);
        if(!pessoaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoaModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePessoa(@PathVariable(value = "id") UUID id){
        Optional<PessoaModel> pessoaModelOptional = pessoaService.findById(id);
        if(!pessoaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        pessoaService.delete(pessoaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa deletada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePessoa(@PathVariable(value = "id") UUID id,
                                               @RequestBody @Valid PessoaDTO pessoaDTO){
        Optional<PessoaModel> pessoaModelOptional = pessoaService.findById(id);
        if(!pessoaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        PessoaModel pessoaModel = pessoaModelOptional.get();
        BeanUtils.copyProperties(pessoaDTO, pessoaModel);
        pessoaModel.setId(pessoaModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.save(pessoaModel));
    }
}
