package model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		PreparedStatement preparedStatement = null;
		try {
			
			preparedStatement = conn.prepareStatement(
					"INSERT INTO oficial "
					+ "(nome, email, nascimento, equipe, departamentoId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, oficial.getNome());
			preparedStatement.setString(2, oficial.getEmail());
			preparedStatement.setDate(3, new Date(oficial.getNascimento().getTime()));
			preparedStatement.setString(4, oficial.getEquipe());
			preparedStatement.setInt(5, oficial.getDepartamento().getId());
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					int id = resultSet.getInt(1);
					oficial.setId(id);
				}
				
				DBConnector.cloaseResultSet(resultSet);
			} else {
				throw new DBException("ERRO INESPERADO, NENHUMA LINHA FOI AFETADA");
			}
			
			
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DBConnector.cloaseStatment(preparedStatement);
		}
		
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
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			preparedStatement = conn.prepareStatement(
					"SELECT oficial.*,departamento.nome as departamento "
					+ "FROM oficial INNER JOIN departamento "
					+ "ON oficial.departamentoId = departamento.id "
					+ "ORDER BY nome");
			
			resultSet = preparedStatement.executeQuery();
			
			List<Oficial> list = new ArrayList<>();
			
			Map<Integer, Departamento> map = new HashMap<>();
			
			while (resultSet.next()) {
				
				Departamento dep = map.get(resultSet.getInt("departamentoId"));
				
				if (dep == null) {
					dep = instantiateDepartamento(resultSet);
					map.put(resultSet.getInt("id"), dep);
				}
				
				Oficial oficial = instantiateOficial( resultSet, dep );
				
				list.add(oficial);
			}
			return list;
			
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DBConnector.cloaseStatment(preparedStatement);
			DBConnector.cloaseResultSet(resultSet);
		}
	}

	@Override
	public List<Oficial> findByDepartamento(Departamento departamento) {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			preparedStatement = conn.prepareStatement(
					"SELECT oficial.*,departamento.nome as departamento "
					+ "FROM oficial INNER JOIN departamento "
					+ "ON oficial.departamentoId = departamento.id "
					+ "WHERE departamentoId = ? "
					+ "ORDER BY nome");
			
			preparedStatement.setInt(1, departamento.getId());
			resultSet = preparedStatement.executeQuery();
			
			List<Oficial> list = new ArrayList<>();
			
			Map<Integer, Departamento> map = new HashMap<>();
			
			while (resultSet.next()) {
				
				Departamento dep = map.get(resultSet.getInt("departamentoId"));
				
				if (dep == null) {
					dep = instantiateDepartamento(resultSet);
					map.put(resultSet.getInt("id"), dep);
				}
				
				Oficial oficial = instantiateOficial( resultSet, dep );
				
				list.add(oficial);
			}
			return list;
			
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DBConnector.cloaseStatment(preparedStatement);
			DBConnector.cloaseResultSet(resultSet);
		}
	}

}
