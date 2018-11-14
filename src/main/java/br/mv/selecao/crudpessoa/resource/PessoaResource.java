package br.mv.selecao.crudpessoa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mv.selecao.crudpessoa.model.Pessoa;
import br.mv.selecao.crudpessoa.repository.PessoaRepository;

/**
 * @author Rainer
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/pessoa")
public class PessoaResource {
		
	@Autowired
	PessoaRepository pessoaRepository; 
	
	@GetMapping
	public List<Pessoa> pesquisarPessoas() {
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/{nome}/{cpf}")
	public List<Pessoa> pesquisarPessoasFiltradas(@PathVariable(required = false) String nome, @PathVariable(required = false) String cpf) {
		return pessoaRepository.findByNomeContainingIgnoreCaseAndCpf(nome, cpf);
	}
}
