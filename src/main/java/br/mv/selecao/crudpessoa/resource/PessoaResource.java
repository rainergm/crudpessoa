package br.mv.selecao.crudpessoa.resource;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.mv.selecao.crudpessoa.model.Pessoa;
import br.mv.selecao.crudpessoa.service.PessoaService;

/**
 * @author Rainer
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/pessoa")
public class PessoaResource {
		
	@Autowired
	private PessoaService pessoaService; 
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Pessoa>> pesquisarPessoas() {

		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.pesquisar(null, null));
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Pessoa> pesquisarPessoa(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.pesquisarPorId(id));
	}
	
	@GetMapping("/filtro")
	public ResponseEntity<List<Pessoa>> pesquisarPessoasFiltradas(@RequestParam(required = false) String nome, 
			@RequestParam(required = false) String cpf) {
		
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.pesquisar(nome, cpf));
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> salvar(@RequestBody @Valid Pessoa pessoa) {
		
		Pessoa pessoaSalva = pessoaService.salvar(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {

		pessoaService.remover(id);
	}
}
