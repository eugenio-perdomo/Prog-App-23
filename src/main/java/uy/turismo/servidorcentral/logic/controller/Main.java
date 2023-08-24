package uy.turismo.servidorcentral.logic.controller;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import uy.turismo.servidorcentral.logic.entities.Department;
import uy.turismo.servidorcentral.logic.entities.TouristicActivity;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		String yellow = "\u001B[33m";
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
//		IController controller = ControllerFactory.getIController();
//		Department department = new Department(1L, "Maldonado", "Tiene Punta del Este", "www.maldo.com");
//		TouristicActivity activity = new TouristicActivity();
//		department.getTouristicActivities().add(activity);
		System.out.println(yellow + "INFO: Done" + yellow);

	}

}
