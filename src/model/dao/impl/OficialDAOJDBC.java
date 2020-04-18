package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DBConnector;
import db.DBException;
import model.dao.OficialDAO;
import model.entities.Departamento;
import model.entities.Oficial;

/**
 * Classe responsável por implementar os contratos em DAO.
 * @author Vinicius-PC - Vinicius Pascucci.
 */
public class OficialDAOJDBC implements OficialDAO {

	private Connection conn;
	
	public OficialDAOJDBC( Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Oficial oficial) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updtae(Oficial oficial) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Oficial findById(Integer id) {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			preparedStatement = conn.prepareStatement(
					"SELECT oficial.*, departamento.nome as departamento "
					+ "FROM oficial INNER JOIN departamento "
					+ "ON oficial.departamentoId = departamento.id "
					+ "WHERE oficial.Id = ?");
			
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				Departamento dep = instantiateDepartamento( resultSet );
				
				Oficial oficial = instantiateOficial( resultSet, dep );
				
				return oficial;
			}
			return null;
			
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DBConnector.cloaseStatment(preparedStatement);
			DBConnector.cloaseResultSet(resultSet);
		}
		
	}

	private Oficial instantiateOficial(ResultSet resultSet, Departamento dep) throws SQLException {
		 Oficial oficial = new Oficial();
			oficial.setId(resultSet.getInt("id"));
			oficial.setNome(resultSet.getString("nome"));
			oficial.setEmail(resultSet.getString("email"));
			oficial.setEquipe(resultSet.getString("equipe"));
			oficial.setNascimento(resultSet.getDate("nascimento"));
			oficial.setDepartamento(dep);
		
			return oficial;
	}

	private Departamento instantiateDepartamento(ResultSet resultSet) throws SQLException {
		Departamento dep = new Departamento();
		dep.setId(resultSet.getInt("id"));
		dep.setNome(resultSet.getString("departamento"));
		
		return dep;
	}

	@Override
	public List<Oficial> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
