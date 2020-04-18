package model.dao;

import model.dao.impl.OficialDAOJDBC;

/**
 * Classe respons�vel por prover nossa fabrica de DAO, cvontem opera��es statics para instanciar o DAO.
 * @author Vinicius-PC - Vinicius Pascucci.
 */
public class DAOFactory {

	public static OficialDAO createOficialDao() {
		return new OficialDAOJDBC();
	}
}
