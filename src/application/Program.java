package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.dao.DAOFactory;
import model.dao.OficialDAO;
import model.entities.Departamento;
import model.entities.Oficial;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		Departamento dept = new Departamento(1, "S.T.A.R.S");
		
		Oficial oficial = new Oficial(1, "Jill Valentime", "jill.valentime@stars.com", formatter.parse("20/10/1979"), "ALPHA TEAM", dept);
		
		OficialDAO dao = DAOFactory.createOficialDao();
		
		System.out.println(oficial);

	}

}
