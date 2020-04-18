package application;

import java.text.ParseException;

import model.dao.DAOFactory;
import model.dao.OficialDAO;
import model.entities.Oficial;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		OficialDAO dao = DAOFactory.createOficialDao();
		
		Oficial oficial = dao.findById(2);
		
		System.out.println(oficial);

	}

}
