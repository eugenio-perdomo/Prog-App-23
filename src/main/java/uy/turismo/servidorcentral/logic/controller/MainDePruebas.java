package uy.turismo.servidorcentral.logic.controller;


import org.hibernate.Session;

import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class MainDePruebas {

	public static void main(String[] args) {
        String yellow = "\u001B[33m";
        
        System.out.println(yellow + "Info: DONE" + yellow);
        
	}
	
	public void initSession() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
		
	}

}