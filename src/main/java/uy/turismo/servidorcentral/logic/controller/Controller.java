package uy.turismo.servidorcentral.logic.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import uy.turismo.servidorcentral.logic.daos.DepartmentDAO;
import uy.turismo.servidorcentral.logic.daos.DepartmentDAOImpl;
import uy.turismo.servidorcentral.logic.daos.TouristicActivityDAO;
import uy.turismo.servidorcentral.logic.daos.TouristicActivityDAOImpl;
import uy.turismo.servidorcentral.logic.daos.TouristicBundleDAO;
import uy.turismo.servidorcentral.logic.daos.TouristicBundleDAOImpl;
import uy.turismo.servidorcentral.logic.daos.TouristicDepartureDAO;
import uy.turismo.servidorcentral.logic.daos.TouristicDepartureDAOImpl;
import uy.turismo.servidorcentral.logic.daos.UserDAO;
import uy.turismo.servidorcentral.logic.daos.UserDAOImpl;
import uy.turismo.servidorcentral.logic.datatypes.DtUser;
import uy.turismo.servidorcentral.logic.entities.Department;
import uy.turismo.servidorcentral.logic.entities.Provider;
import uy.turismo.servidorcentral.logic.datatypes.DtProvider;
import uy.turismo.servidorcentral.logic.datatypes.DtDepartment;
import uy.turismo.servidorcentral.logic.datatypes.DtTourist;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;

import uy.turismo.servidorcentral.logic.datatypes.DtTouristicBundle;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;
import uy.turismo.servidorcentral.logic.entities.Tourist;
import uy.turismo.servidorcentral.logic.entities.TouristicActivity;
import uy.turismo.servidorcentral.logic.entities.TouristicBundle;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;
import uy.turismo.servidorcentral.logic.entities.Tourist;
import uy.turismo.servidorcentral.logic.entities.TouristicActivity;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;
import uy.turismo.servidorcentral.logic.entities.Tourist;

import uy.turismo.servidorcentral.logic.entities.TouristicDeparture;
import uy.turismo.servidorcentral.logic.entities.User;

public class Controller implements IController {
	
	//Unica instancia del constructor en todo el sistema
	private static Controller _instance;
	
	//Constructor
	private Controller() {
		
	}
	
	//Devuelve una nueva instancia del controlador si no existe una
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
	
	//testeo pendiente
	public void registerUser(DtUser usrData) {
		UserDAO usrDAO = new UserDAOImpl();
		
		if(usrData instanceof DtProvider) {
			DtProvider provData = (DtProvider) usrData;
			
			
			Provider provUsr = new Provider(null, provData.getName(), provData.getNickname(), provData.getEmail(),
					provData.getLastName(), provData.getBirthDate(), provData.getDescription(), provData.getUrl());
			
			try {
				usrDAO.create(provUsr);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}else {
			DtTourist touristData = (DtTourist) usrData;
			
			Tourist touristUsr = new Tourist(null, touristData.getName(), touristData.getNickname(), touristData.getEmail(),
				touristData.getLastName(), touristData.getBirthDate(), touristData.getNationality());

			try {
				usrDAO.create(touristUsr);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	

	public List<DtDepartment> getListDepartment(Boolean alsoActivities) {
		DepartmentDAO departmentDAO = new DepartmentDAOImpl();
		List<Department> depas = departmentDAO.findAll();
		List<DtDepartment> departmentOutput = new ArrayList<DtDepartment>();
		
		if(alsoActivities) {
			for(Department der : depas) {
				departmentOutput.add(der.getDtWithActivities());
			}
			return departmentOutput;
			
		}else {
			for(Department der : depas) {
				departmentOutput.add(der.getShortDt());
			}
			return departmentOutput;
		}
	}

	//testeo pendiente
	@Override
	public DtTouristicActivity getTouristicActivityData(Long touristicActivityId) {
		
		TouristicActivityDAO touristicActivityDAO = new TouristicActivityDAOImpl();
		TouristicActivity touristicActivity = touristicActivityDAO.findById(touristicActivityId);
		
		DtTouristicActivity dtTouristicActivity = touristicActivity.getDt();

		return dtTouristicActivity;
		
	}
	//testeo pendiente
	@Override
	public List<DtTouristicDeparture> getListTouristicDeparture(Long touristicActivityId) {
				
		TouristicActivityDAO touristicActivityDAO = new TouristicActivityDAOImpl();
		TouristicActivity activity = touristicActivityDAO.findById(touristicActivityId);
		//obtengo actividad.
		
		TouristicDepartureDAO touristicDepartureDAO = new TouristicDepartureDAOImpl();
		List<TouristicDeparture> touristicDepartureByAct = touristicDepartureDAO.findByActivity(activity);
		//lista de salidas turisticas con esa actividad.
		
		//agrego salidas al dt.
		List<DtTouristicDeparture> dtTouristicDeparture = (List<DtTouristicDeparture>) new DtTouristicDeparture();
		
		for (int i = 0; i < touristicDepartureByAct.size(); i++) {
			dtTouristicDeparture.add((DtTouristicDeparture) touristicDepartureByAct);
		}
		
		
		return dtTouristicDeparture;
	}
	
	
	@Override
	public void registeTouristicActivity(DtTouristicActivity touristicActivityData) {
		DepartmentDAO departmentDao = new DepartmentDAOImpl();
		TouristicActivityDAO activityDao = new TouristicActivityDAOImpl();
		UserDAO userDao = new UserDAOImpl(); 
		
		Department department = departmentDao.findById(touristicActivityData
				.getDepartment()
				.getId());
		
		Provider provider = (Provider) userDao.findById(touristicActivityData
				.getProvider()
				.getId());
		
		TouristicActivity activity = new TouristicActivity(
				touristicActivityData.getId(),
				touristicActivityData.getName(),
				touristicActivityData.getDescription(),
				touristicActivityData.getDuration(),
				touristicActivityData.getCostPerTourist(),
				touristicActivityData.getUploadDate(),
				touristicActivityData.getCity(),
				provider,
				department
				);
		try {
			activityDao.create(activity);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void registerTouristicDeparture(DtTouristicDeparture touristicDepartureData) {
		TouristicActivityDAO activityDao = new TouristicActivityDAOImpl();
		TouristicDepartureDAO departureDao = new TouristicDepartureDAOImpl();
		
		TouristicActivity activity = activityDao.findById(touristicDepartureData
				.getTouristicActivity().getId());
		
		TouristicDeparture departure = new TouristicDeparture(
				touristicDepartureData.getId(),
				touristicDepartureData.getName(),
				touristicDepartureData.getMaxTourist(),
				touristicDepartureData.getUploadDate(),
				touristicDepartureData.getDepartureDateTime(),
				touristicDepartureData.getPlace(),
				activity
				);
		
		try {
			departureDao.create(departure);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public List<DtTouristicDeparture> getListTouristicDeparture() {
		TouristicDepartureDAO departureDAO = new TouristicDepartureDAOImpl();
		List<TouristicDeparture> departures = departureDAO.findAll();
		List<DtTouristicDeparture> departureOutput = new ArrayList<DtTouristicDeparture>();
		
		for(TouristicDeparture der : departures ) {
			departureOutput.add(der.getShortDt());
		}
		return departureOutput;
	}

	//testeo pendiente
	@Override
	public void registerTouristicBundle(DtTouristicBundle touristicBundleData) {
		
		TouristicBundleDAO touristicBundleDAO = new TouristicBundleDAOImpl();
		
		
		TouristicBundle bundle = new TouristicBundle(null, touristicBundleData.getName(),
				touristicBundleData.getDescription(), touristicBundleData.getValidityPeriod(), 
				touristicBundleData.getDiscount(), touristicBundleData.getUploadDate());
		
		try {
			touristicBundleDAO.create(bundle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void registerDepartment(DtDepartment departmentData) {
		DepartmentDAO departmentDAO = new DepartmentDAOImpl();
		
		Department department = new Department(null, departmentData.getName(), departmentData.getDescription(), departmentData.getWebSite());
		
		/**this.id = id;
		this.name = name;
		this.description = description;
		this.webSite = webSite;*/
		
		try {
			departmentDAO.create(department);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
