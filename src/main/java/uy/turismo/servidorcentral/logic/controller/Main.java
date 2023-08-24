package uy.turismo.servidorcentral.logic.controller;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import uy.turismo.servidorcentral.logic.daos.UserDAO;
import uy.turismo.servidorcentral.logic.daos.UserDAOImpl;
import uy.turismo.servidorcentral.logic.entities.Department;
import uy.turismo.servidorcentral.logic.entities.Provider;
import uy.turismo.servidorcentral.logic.entities.Tourist;
import uy.turismo.servidorcentral.logic.entities.TouristicActivity;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		String yellow = "\u001B[33m";
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		IController controller = ControllerFactory.getIController();
//		Department department = new Department(1L, "Maldonado", "Tiene Punta del Este", "www.maldo.com");
//		TouristicActivity activity = new TouristicActivity();
//		department.getTouristicActivities().add(activity);
		
		UserDAO daoUser = new UserDAOImpl();
//		List<Tourist> tourists = daoUser.findAllTourists();
		Provider p = (Provider) daoUser.findById(11L);
		
//		for(Tourist t : tourists) {
		System.out.println(
				"Id: " + p.getId() +
				"\nNickname: " + p.getNickname() +
				"\nEmail: " + p.getEmail()
				);
		System.out.println();
//		}
		
		System.out.println(yellow + "INFO: Done" + yellow);

	}

}
