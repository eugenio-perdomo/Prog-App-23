package uy.turismo.servidorcentral.logic.controller;

import java.time.LocalDate;
import java.util.List;

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

public class Main {

	public static void main(String[] args) {
		String yellow = "\u001B[33m";
		initSesion();

//		TouristicDeparture departure = findDeparturesById(1L);

//		TouristicActivity activity = findActivitiesById(2L);
		
//		Tourist tourist = (Tourist) findUserById(2L);
//		
//		tourist.setNationality("irlandés");
//		
//		updateUser(tourist);
		
//		Provider provider = (Provider) findUserById(11L);
//		
//		Department department = findDepartmentById(2L);
//		
//		TouristicActivity activity = new TouristicActivity(
//				null,
//				"Paseo por la playa",
//				"Paseo por la costa de la parada 25 a la 36",
//				1D,
//				120D,
//				LocalDate.of(2023, 11, 10),
//				"Punta del Este",
//				provider,
//				department
//				);
//		
//		persistActivity(activity);
		
//		User tourist = new Tourist(
//				null,
//				"Rosa María",
//				"lachiqui",
//				"mirtha.legrand.ok@hotmail.com.ar",
//				"Martínez",
//				LocalDate.of(1927, 02, 23),
//				"argentina"
//				);
//		
//		persistUser(tourist);
		
//		List<TouristicActivity> activities = findAllActivities();
		
//		List<Provider> providers = findAllProvdiers();
		
//		List<Department> departments = findAllDepartments();
		

		System.out.println(yellow + "INFO: Done" + yellow);
	}

	public static void initSesion() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
	}

}
