package model.dao;

import java.util.List;

import model.entities.Departamento;

/**
 * Interface para conter nossos contrator de CRUD.
 * @author Vinicius-PC - Vinicius Pascucci.
 */
public interface DepartamentoDAO {

	// opera��o de inser��o
	void insert( Departamento departamento );
	
	// opera��o de atualiza��o
	void updtae( Departamento departamento );
	
	// opera��o de exclus�o
	void deleteById( Integer id );
	
	// opera��o por consultar o departamento pelo id
	Departamento findById( Integer id );
	
	// opera��o que retorna todos os departamento
	List<Departamento> findAll();
}
