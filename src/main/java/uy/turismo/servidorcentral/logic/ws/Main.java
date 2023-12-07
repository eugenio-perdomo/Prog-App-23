package uy.turismo.servidorcentral.logic.ws;

import java.util.Scanner;

import org.hibernate.Session;

import uy.turismo.servidorcentral.logic.util.HibernateUtil;


public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("¿Desea iniciar la base de datos? y/Y");
		String bdOption = scanner.nextLine();
		if(bdOption.equalsIgnoreCase("y") || bdOption.equalsIgnoreCase("Y")) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.close();
			String yellow = "\u001B[33m";
			System.out.println( yellow + "Info: Done" + yellow);
		}
		
		
		Publisher publisher = new Publisher();
		System.out.println(publisher.publish());
		String option = "";
		while(!option.equalsIgnoreCase("0")) {
			System.out.println("Ingrese una opcion:\n"
					+ "1. Iniciar WS\n"
					+ "2. Reiniciar WS\n"
					+ "3. Detener WS\n"
					+ "0. Salir");
			option = scanner.nextLine();
			
			switch(option) {
			case "1":
				if(publisher.getEndpoint().isPublished()) {
					System.out.println("El proceso ya esta corriendo");
				}
				else {
					System.out.println(publisher.publish());
				}
				break;
			case "2":
				if(publisher.getEndpoint().isPublished()) {
					System.out.println(publisher.stop()); 
				}
				System.out.println(publisher.publish());
				break;
			case "3":
				if(publisher.getEndpoint().isPublished()) {
					System.out.println(publisher.stop()); 
				}
				break;
			case "0":
				if(publisher.getEndpoint().isPublished()) {
					System.out.println(publisher.stop()); 
				}
				break;
			default: 
				System.out.println("Opcion incorrecta, intente de nuevo");
			}
		}
		
		scanner.close();
		
		System.out.println("Saliendo del programa...");
		
	}

}
