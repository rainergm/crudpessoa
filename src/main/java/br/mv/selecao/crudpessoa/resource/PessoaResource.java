package br.mv.selecao.crudpessoa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.mv.selecao.crudpessoa.model.Pessoa;
import br.mv.selecao.crudpessoa.repository.PessoaRepository;
import br.mv.selecao.crudpessoa.service.PessoaService;

/**
 * @author Rainer
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/pessoa")
public class PessoaResource {
		
	@Autowired
	PessoaRepository pessoaRepository; 
	
	@Autowired
	PessoaService pessoaService; 
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Pessoa>> pesquisarPessoas() {
		//return pessoaRepository.findAll();
		//return ResponseEntity.status(HttpStatus.OK).body(pessoaRepository.findAll());
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.pesquisar(null, null));
	}
	
	/*@GetMapping(value = {"/nome/{nome}", "/cpf/{cpf}", "/filtro/{nome}/{cpf}"})*/
	@GetMapping(value = "/{nome}/{cpf}")
	public List<Pessoa> pesquisarPessoasFiltradas(@PathVariable(required = false) String nome, 
			@PathVariable(required = false) String cpf) {
	
		return pessoaRepository.findByNomeContainingIgnoreCaseAndCpf(nome, cpf);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
	}
}
