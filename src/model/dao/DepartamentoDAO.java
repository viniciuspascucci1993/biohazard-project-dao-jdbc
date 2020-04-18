package model.dao;

import java.util.List;

import model.entities.Departamento;

/**
 * Interface para conter nossos contrator de CRUD.
 * @author Vinicius-PC - Vinicius Pascucci.
 */
public interface DepartamentoDAO {

	// operação de inserção
	void insert( Departamento departamento );
	
	// operação de atualização
	void updtae( Departamento departamento );
	
	// operação de exclusão
	void deleteById( Integer id );
	
	// operação por consultar o departamento pelo id
	Departamento findById( Integer id );
	
	// operação que retorna todos os departamento
	List<Departamento> findAll();
}
