package uy.turismo.servidorcentral.logic.controller;


import java.util.List;

import org.hibernate.Session;

import uy.turismo.servidorcentral.logic.datatypes.DtUser;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class MainDePruebas {

	public static void main(String[] args) {
        String yellow = "\u001B[33m";
        
        IController sys = ControllerFactory.getIController();
//      List<DtUser> users = sys.getListUser();
        DtUser user = sys.getUserData(1L);
        
        System.out.println(yellow + "Info: DONE" + yellow);
        
	}
	
	public static void initSession() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
	}

}
