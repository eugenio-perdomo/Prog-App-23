package uy.turismo.servidorcentral.logic.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import uy.turismo.servidorcentral.logic.daos.UserDAO;
import uy.turismo.servidorcentral.logic.daos.UserDAOImpl;
import uy.turismo.servidorcentral.logic.datatypes.DtDepartment;
import uy.turismo.servidorcentral.logic.datatypes.DtTourist;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class MainDePruebas {

	public static void main(String[] args) {

		String yellow = "\u001B[33m";      
        Controller controlador = Controller.getInstance();
        
//        UserDAO user = new UserDAOImpl();
//    	
//    	List<DtTourist> pruebaTourist;
//    	
//    	pruebaTourist =  controlador.getListTourist();
        
        List<DtDepartment> pruebaDepartment = controlador.getListDepartment(true);
    	
    	System.out.println(yellow + "Info: DONE" + yellow);
        
	}
	
	public static void initSession() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
	}

	
}
