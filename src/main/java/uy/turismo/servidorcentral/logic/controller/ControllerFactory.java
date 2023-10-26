package uy.turismo.servidorcentral.logic.controller;

public class ControllerFactory {
	
	public ControllerFactory() {
		
	}
	
	public static IController getIController() {
		return Controller.getInstance();
	}

}
