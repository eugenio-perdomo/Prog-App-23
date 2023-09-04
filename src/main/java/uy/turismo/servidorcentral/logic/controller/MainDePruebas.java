package uy.turismo.servidorcentral.logic.controller;


import org.hibernate.Session;


import uy.turismo.servidorcentral.logic.daos.DepartmentDAO;
import uy.turismo.servidorcentral.logic.daos.DepartmentDAOImpl;
import uy.turismo.servidorcentral.logic.daos.TouristicActivityDAO;
import uy.turismo.servidorcentral.logic.daos.TouristicActivityDAOImpl;
import uy.turismo.servidorcentral.logic.daos.TouristicDepartureDAO;
import uy.turismo.servidorcentral.logic.daos.TouristicDepartureDAOImpl;
import uy.turismo.servidorcentral.logic.daos.UserDAO;
import uy.turismo.servidorcentral.logic.daos.UserDAOImpl;
import uy.turismo.servidorcentral.logic.daos.UserDAOImpl;
import uy.turismo.servidorcentral.logic.entities.Department;
import uy.turismo.servidorcentral.logic.entities.Provider;
import uy.turismo.servidorcentral.logic.entities.Tourist;
import uy.turismo.servidorcentral.logic.entities.TouristicActivity;
import uy.turismo.servidorcentral.logic.entities.TouristicDeparture;
import uy.turismo.servidorcentral.logic.entities.User;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class MainDePruebas {

	public static void main(String[] args) {
		String yellow = "\u001B[33m";
		initSession();
		
        System.out.println(yellow + "Info: DONE" + yellow);
        
	}
	
	public static void initSession() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
		
	}

}
