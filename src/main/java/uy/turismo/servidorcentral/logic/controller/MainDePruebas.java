package uy.turismo.servidorcentral.logic.controller;

import org.hibernate.Session;

import uy.turismo.servidorcentral.logic.datatypes.DtTourist;
import uy.turismo.servidorcentral.logic.datatypes.DtUser;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class MainDePruebas {

	public static void main(String[] args) {

		String yellow = "\u001B[33m";
		
		IController sys = ControllerFactory.getIController();
		
		DtTourist userData = (DtTourist) sys.getUserData(5L);
		
		DtUser updatedData = new DtTourist(
				userData.getId(),
				userData.getName(),
				userData.getNickname(),
				userData.getEmail(),
				userData.getLastName(),
				userData.getBirthDate(),
				"canadiense",
				null
				);
		
		sys.updateUser(updatedData);
		
		
//		initSession();
		
		
        System.out.println(yellow + "Info: DONE" + yellow);
        
	}
	
	public static void initSession() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
	}

}
