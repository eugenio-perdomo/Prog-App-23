package uy.turismo.servidorcentral.logic.ws;

public class Main {

	public static void main(String[] args) {
		Publisher publisher = new Publisher();
		
		publisher.publish();
		
		System.out.println("Web Service Levantado");
	}

}
