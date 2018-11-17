package br.mv.selecao.crudpessoa.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.mv.selecao.crudpessoa.dao.PessoaDAO;
import br.mv.selecao.crudpessoa.model.Pessoa;

/**
 * @author Rainer
 */
@Repository
public class PessoaDAOImpl implements PessoaDAO{
	
	@PersistenceContext
	private EntityManager entityManager; 
	
	@Override
	@Transactional
	public Pessoa salvar(Pessoa pessoa) {
		Session session = entityManager.unwrap(Session.class);
		return (Pessoa) session.merge(pessoa);
	}

	@Override
	public List<Pessoa> pesquisar(String nome, String cpf) {
		
		Map<String, String> parametros = new HashMap<>();
		
		Session session = entityManager.unwrap(Session.class);
		StringBuilder hql = new StringBuilder(" FROM Pessoa p where p.id is not null "); 
		
		if(!StringUtils.isEmpty(nome)) {
			hql.append(" and lower(p.nome) like lower(:pNome) ");
			parametros.put("pNome", "%"+nome+"%");
		}		
		
		if(!StringUtils.isEmpty(cpf)) {
			hql.append(" and p.cpf = :pCpf ");
			parametros.put("pCpf", cpf);
		}
		
		Query query = session.createQuery(hql.toString());
		
		for (String nomeParametro : parametros.keySet()) {
			query.setParameter(nomeParametro, parametros.get(nomeParametro));
		}
		
		return query.list();
	}

	@Override
	public Pessoa pesquisarPorId(Long id) {
		Session session = entityManager.unwrap(Session.class);
		return session.find(Pessoa.class, id);
	}
	
	@Override
	@Transactional
	public void remover(Long id) {
		Session session = entityManager.unwrap(Session.class);
		session.remove(pesquisarPorId(id));
	}

}
