package model.dao;

import db.DBConnector;
import model.dao.impl.OficialDAOJDBC;

/**
 * Classe responsável por prover nossa fabrica de DAO, cvontem operações statics para instanciar o DAO.
 * @author Vinicius-PC - Vinicius Pascucci.
 */
public class DAOFactory {

	public static OficialDAO createOficialDao() {
		return new OficialDAOJDBC( DBConnector.getConnection() );
	}
}
