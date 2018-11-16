package br.mv.selecao.crudpessoa.dao;

import java.util.List;

import br.mv.selecao.crudpessoa.model.Pessoa;

/**
 * @author Rainer
 *
 */

public interface PessoaDAO {
	
	Pessoa salvar(Pessoa pessoa);

	List<Pessoa> pesquisar(String nome, String cpf);
}
