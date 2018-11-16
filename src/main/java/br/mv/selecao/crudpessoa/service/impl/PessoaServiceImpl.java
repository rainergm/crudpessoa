package br.mv.selecao.crudpessoa.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.mv.selecao.crudpessoa.dao.PessoaDAO;
import br.mv.selecao.crudpessoa.model.Pessoa;
import br.mv.selecao.crudpessoa.service.PessoaService;

/**
 * @author Rainer
 */
@Component
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	private PessoaDAO pessoaDAO;
	
	@Override
	public Pessoa salvar(Pessoa pessoa) {
		
		return null;
	}

	@Override
	public List<Pessoa> pesquisar(String nome, String cpf) {
		return pessoaDAO.pesquisar(nome, cpf);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
