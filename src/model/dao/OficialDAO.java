package model.dao;

import java.util.List;

import model.entities.Oficial;

/**
 * Interface para conter nossos contrator de CRUD.
 * @author Vinicius-PC - Vinicius Pascucci.
 */
public interface OficialDAO {

	// operação de inserção
	void insert( Oficial oficial );
	
	// operação de atualização
	void updtae( Oficial oficial );
	
	// operação de exclusão
	void deleteById( Integer id );
	
	// operação por consultar o oficial pelo id
	Oficial findById( Integer id );
	
	// operação que retorna todos os oficiais
	List<Oficial> findAll();
}
