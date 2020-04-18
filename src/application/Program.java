package application;

import java.text.ParseException;
import java.util.List;

import model.dao.DAOFactory;
import model.dao.OficialDAO;
import model.entities.Departamento;
import model.entities.Oficial;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		OficialDAO dao = DAOFactory.createOficialDao();
		
		System.out.println("=== TESTE [1]: Oficial findById ===");
		
		Oficial oficial = dao.findById(1);
		
		System.out.println(oficial);

		System.out.println("\n=== TESTE [2]: Oficial findByDepartamento ===");
		
		Departamento dep = new Departamento(1, null);
		
		List<Oficial> list = dao.findByDepartamento(dep);
		
		for (Oficial obj : list) {
			System.out.println(obj);
		}
		
	}

}
