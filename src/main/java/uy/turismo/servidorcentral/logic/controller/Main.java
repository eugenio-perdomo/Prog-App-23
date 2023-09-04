package uy.turismo.servidorcentral.logic.controller;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		String yellow = "\u001B[33m";
//		initSesion();

		

		System.out.println(yellow + "INFO: Done" + yellow);
	}

	public static void initSesion() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
	}

}
