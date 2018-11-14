package br.mv.selecao.crudpessoa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mv.selecao.crudpessoa.model.Pessoa;

/**
 * @author Rainer
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	List<Pessoa> findByNomeContainingIgnoreCaseAndCpf(String nome, String cpf);
}
