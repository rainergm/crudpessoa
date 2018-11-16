package br.mv.selecao.crudpessoa.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.mv.selecao.crudpessoa.model.Pessoa;

/**
 * @author Rainer
 *
 */
public interface PessoaService {
	
	Pessoa salvar(Pessoa pessoa);
	
	List<Pessoa> pesquisar(String nome, String cpf);
	
	void excluir(Long id);

}
