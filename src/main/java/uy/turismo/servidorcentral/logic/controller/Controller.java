package uy.turismo.servidorcentral.logic.controller;

import java.util.ArrayList;
import java.util.List;

import uy.turismo.servidorcentral.logic.daos.UserDAO;
import uy.turismo.servidorcentral.logic.daos.UserDAOImpl;
import uy.turismo.servidorcentral.logic.datatypes.DtUser;
import uy.turismo.servidorcentral.logic.entities.Provider;
import uy.turismo.servidorcentral.logic.datatypes.DtProvider;
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
	public DtUser getUserData(Long id) {
		UserDAO userDao = new UserDAOImpl();
		User user = userDao.findById(id);
		DtUser userOutput;
		if(user instanceof Provider) {
			Provider provider = (Provider) user;
			userOutput = provider.getDt();
		}else {
			Tourist tourist = (Tourist) user;
			userOutput = tourist.getDt();
			
		}
		
		return userOutput;
	}
	
	
	@Override
	public List<DtTourist>  getListTourist(){
		UserDAO userDAO = new UserDAOImpl();
		List<Tourist> users = userDAO.findAllTourists();
		List<DtTourist> userOutput = new ArrayList<DtTourist>();
		
		for(Tourist tur : users){
			userOutput.add((DtTourist)tur.getShortDt());
		}
		
		return userOutput;
	}

	@Override
	public void updateUser(DtUser userData) {
		UserDAO userDao = new UserDAOImpl();
		if(userData instanceof DtProvider) {
			DtProvider providerData = (DtProvider) userData;
			
			Provider provider = new Provider(
						providerData.getId(),
						providerData.getName(),
						providerData.getNickname(),
						providerData.getEmail(),
						providerData.getLastName(),
						providerData.getBirthDate(),
						providerData.getDescription(),
						providerData.getUrl()
					);
			try {
				userDao.update(provider);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}else {
			DtTourist touristData = (DtTourist) userData;
			
			Tourist tourist = new Tourist(
						touristData.getId(),
						touristData.getName(),
						touristData.getNickname(),
						touristData.getEmail(),
						touristData.getLastName(),
						touristData.getBirthDate(),
						touristData.getNationality()
					);
			try {
				userDao.update(tourist);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
