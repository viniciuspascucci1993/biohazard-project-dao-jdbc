package application;

import java.text.ParseException;
import java.util.Date;
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
		
		System.out.println("\n=== TESTE [3]: Oficial finAll ===");
		
		list = dao.findAll();
		
		for (Oficial obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE [4]: Oficial insert ===");
		
		Departamento newDep = new Departamento(4, null);
		
		Oficial newOficial = new Oficial( null, "Carlos Oliveira", "carlos.oliveira@umbrella.com", new Date(), "U.B.C.S", newDep);
		
		dao.insert(newOficial);
		
		System.out.println("[INCLUÍDO! Novo Identificador = ] " + newOficial.getId());
		
		
		System.out.println("\n=== TESTE [5]: Oficial update ===");
		
		oficial = dao.findById(12);
		oficial.setNome("Carlos Oliveira New");
		dao.updtae(oficial);
		
		System.out.println("[UPDATED COMPLETED]");
		
	}

}
