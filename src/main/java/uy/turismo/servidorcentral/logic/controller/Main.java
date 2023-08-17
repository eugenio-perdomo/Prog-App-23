package uy.turismo.servidorcentral.logic.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

	}

}
