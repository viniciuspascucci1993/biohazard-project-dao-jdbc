package model.dao;

import java.util.List;

import model.entities.Oficial;

/**
 * Interface para conter nossos contrator de CRUD.
 * @author Vinicius-PC - Vinicius Pascucci.
 */
public interface OficialDAO {

	// opera��o de inser��o
	void insert( Oficial oficial );
	
	// opera��o de atualiza��o
	void updtae( Oficial oficial );
	
	// opera��o de exclus�o
	void deleteById( Integer id );
	
	// opera��o por consultar o oficial pelo id
	Oficial findById( Integer id );
	
	// opera��o que retorna todos os oficiais
	List<Oficial> findAll();
}
