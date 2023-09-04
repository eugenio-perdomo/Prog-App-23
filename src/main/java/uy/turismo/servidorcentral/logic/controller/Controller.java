package uy.turismo.servidorcentral.logic.controller;

import java.util.ArrayList;
import java.util.List;

import uy.turismo.servidorcentral.logic.daos.UserDAO;
import uy.turismo.servidorcentral.logic.daos.UserDAOImpl;
import uy.turismo.servidorcentral.logic.datatypes.DtUser;
import uy.turismo.servidorcentral.logic.datatypes.DtTourist;
import uy.turismo.servidorcentral.logic.entities.Tourist;
import uy.turismo.servidorcentral.logic.entities.User;

public class Controller implements IController {
	
	//Definicion como Singleton
	private static Controller _instance;
	
	private Controller() {
		
	}
	
	public static Controller getInstance() {
		if(_instance == null) {
			_instance = new Controller();
		}
		
		return _instance;
	}

	//Metodos

	@Override
	public List<DtUser> getListUser() {
		UserDAO userDao = new UserDAOImpl();
		List<User> users = userDao.findAll();
		List<DtUser> usersOutput = new ArrayList<DtUser>();
		
		for(User usr : users) {
			usersOutput.add(usr.getShortDt());
		}
		
		return usersOutput;
	}
	
	
	@Override
	public List<DtTourist>  getListTourist(){
		UserDAO user = new UserDAOImpl();
		List<Tourist> users = user.findAllTourists();
		List<DtTourist> userOutput = new ArrayList<DtTourist>();
		
		for(Tourist tur : users){
			userOutput.add((DtTourist)tur.getShortDt());
		}
		
		return userOutput;
	}
}
