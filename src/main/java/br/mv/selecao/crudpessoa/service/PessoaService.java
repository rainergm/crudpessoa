package br.mv.selecao.crudpessoa.service;

import java.util.List;

import br.mv.selecao.crudpessoa.model.Pessoa;

/**
 * @author Rainer
 *
 */
public interface PessoaService {
	
	Pessoa salvar(Pessoa pessoa);
	
	List<Pessoa> pesquisar(String nome, String cpf);
	
	void remover(Long id);

	Pessoa pesquisarPorId(Long id);

}
