package br.mv.selecao.crudpessoa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mv.selecao.crudpessoa.dao.PessoaDAO;
import br.mv.selecao.crudpessoa.model.Pessoa;
import br.mv.selecao.crudpessoa.service.PessoaService;

/**
 * @author Rainer
 */
@Service
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	private PessoaDAO pessoaDAO;
	
	@Override
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaDAO.salvar(pessoa);
	}

	@Override
	public List<Pessoa> pesquisar(String nome, String cpf) {
		return pessoaDAO.pesquisar(nome, cpf);
	}

	@Override
	public void remover(Long id) {
		pessoaDAO.remover(id);
	}

	@Override
	public Pessoa pesquisarPorId(Long id) {
		return pessoaDAO.pesquisarPorId(id);
	}
	
	
}
