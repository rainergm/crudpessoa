package br.mv.selecao.crudpessoa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.mv.selecao.crudpessoa.dao.PessoaDAO;
import br.mv.selecao.crudpessoa.model.Pessoa;

/**
 * @author Rainer
 */
@Component
public class PessoaDAOImpl implements PessoaDAO{
	
	@PersistenceContext
	private EntityManager entityManager; 
	
	@Override
	public Pessoa salvar(Pessoa pessoa) {
		
		return null;
	}

	@Override
	public List<Pessoa> pesquisar(String nome, String cpf) {
		
		Session session = entityManager.unwrap(Session.class);
		StringBuilder hql = new StringBuilder(" FROM Pessoa p where p.id is not null "); 
		
		if(!StringUtils.isEmpty(nome)) {
			hql.append(" and p.nome like :pNome ");
		}		
		
		if(!StringUtils.isEmpty(nome)) {
			hql.append(" and p.cpf like :pCpf ");
		}
		
		Query query = session.createQuery(hql.toString());
		return query.list();
	}

}
