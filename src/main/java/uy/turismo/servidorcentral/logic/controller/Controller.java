package uy.turismo.servidorcentral.logic.controller;

import java.util.ArrayList;
import java.util.List;

import uy.turismo.servidorcentral.logic.daos.DepartmentDAO;
import uy.turismo.servidorcentral.logic.daos.DepartmentDAOImpl;
import uy.turismo.servidorcentral.logic.daos.InscriptionDAO;
import uy.turismo.servidorcentral.logic.daos.InscriptionDAOImpl;
import uy.turismo.servidorcentral.logic.daos.PurchaseDAO;
import uy.turismo.servidorcentral.logic.daos.PurchaseDAOImpl;
import uy.turismo.servidorcentral.logic.daos.TouristicActivityDAO;
import uy.turismo.servidorcentral.logic.daos.TouristicActivityDAOImpl;
import uy.turismo.servidorcentral.logic.daos.TouristicBundleDAO;
import uy.turismo.servidorcentral.logic.daos.TouristicBundleDAOImpl;
import uy.turismo.servidorcentral.logic.daos.TouristicDepartureDAO;
import uy.turismo.servidorcentral.logic.daos.TouristicDepartureDAOImpl;
import uy.turismo.servidorcentral.logic.daos.CategoryDAO;
import uy.turismo.servidorcentral.logic.daos.CategoryDAOImpl;
import uy.turismo.servidorcentral.logic.daos.UserDAO;
import uy.turismo.servidorcentral.logic.daos.UserDAOImpl;
import uy.turismo.servidorcentral.logic.datatypes.DtBaseEntity;
import uy.turismo.servidorcentral.logic.datatypes.DtCategory;
import uy.turismo.servidorcentral.logic.datatypes.DtDepartment;
import uy.turismo.servidorcentral.logic.datatypes.DtInscription;
import uy.turismo.servidorcentral.logic.datatypes.DtProvider;
import uy.turismo.servidorcentral.logic.datatypes.DtPurchase;
import uy.turismo.servidorcentral.logic.datatypes.DtTourist;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicBundle;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;
import uy.turismo.servidorcentral.logic.datatypes.DtUser;
import uy.turismo.servidorcentral.logic.entities.Category;
import uy.turismo.servidorcentral.logic.entities.Department;
import uy.turismo.servidorcentral.logic.entities.Inscription;
import uy.turismo.servidorcentral.logic.entities.Provider;
import uy.turismo.servidorcentral.logic.entities.Purchase;
import uy.turismo.servidorcentral.logic.entities.Tourist;
import uy.turismo.servidorcentral.logic.entities.TouristicActivity;
import uy.turismo.servidorcentral.logic.entities.TouristicBundle;
import uy.turismo.servidorcentral.logic.entities.TouristicDeparture;
import uy.turismo.servidorcentral.logic.entities.User;
import uy.turismo.servidorcentral.logic.enums.ActivityState;
import uy.turismo.servidorcentral.logic.enums.EntityType;

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
	public ArrayList<DtUser> getListUser() {
		System.out.println("Se accedio a la operacion");
		UserDAO userDao = new UserDAOImpl();
		ArrayList<User> users = userDao.findAll();
		ArrayList<DtUser> usersOutput = new ArrayList<DtUser>();
		
		for(User usr : users) {
			usersOutput.add(usr.getShortDt());
		}	
		
		return usersOutput;
	}
	
	@Override
	public Boolean existsNick(String userNickname) {
		UserDAO userDao = new UserDAOImpl();
		
		return userDao.checkNick(userNickname);
	}

	@Override
	public Boolean existsEmail(String userEmail) {
		UserDAO userDao = new UserDAOImpl();
		
		return userDao.checkEmail(userEmail);
	}
	
	@Override
	public Boolean existsName(String name, EntityType entityType ) {
		Boolean existsname = null;
		switch(entityType) {
			case Activity:
				TouristicActivityDAO activityDao = new TouristicActivityDAOImpl();
				existsname = activityDao.checkName(name);
				break;
			case Departure:
				TouristicDepartureDAO departureDao = new TouristicDepartureDAOImpl();
				existsname = departureDao.checkName(name);
				break;
		}
		
		return existsname;
	}

	public List<DtBaseEntity> filterByString(String str){
		TouristicActivityDAO activityDao = new TouristicActivityDAOImpl();
		TouristicBundleDAO bundleDao = new TouristicBundleDAOImpl();
		
		List<TouristicActivity> activityList = activityDao.findByNameDescription(str);
		List<TouristicBundle> bundleList = bundleDao.findByNameDescription(str);
		
		List<DtBaseEntity> outputList = new ArrayList<DtBaseEntity>();
		
		for(TouristicActivity activity : activityList) {
			outputList.add(activity.getShortDt());
		}
		
		for(TouristicBundle bundle : bundleList) {
			outputList.add(bundle.getShortDt());
		}
		
		return outputList;
	}
	
	@Override
	public DtUser getUserData(
			Long id) {
	
		UserDAO userDao = new UserDAOImpl();
		User user = userDao.findById(id);
		DtUser userOutput;
		 
		ArrayList<User> userList = userDao.findAll();
		ArrayList<DtUser> followers = new ArrayList<DtUser>();
		
		for(User u : userList) {
			if(u.isFollowerOf(user)) {
				followers.add(u.getShortDt());
			}
		}
		
		if(user instanceof Provider) {
			Provider provider = (Provider) user;
			userOutput = provider.getDt(followers);
		}else {
			Tourist tourist = (Tourist) user;
			userOutput = tourist.getDt(followers);
			
		}
			
		return userOutput;
	}
	
	
	@Override
	
	public ArrayList<DtTourist>  getListTourist(){
		UserDAO userDAO = new UserDAOImpl();
		ArrayList<Tourist> users = userDAO.findAllTourists();
		ArrayList<DtTourist> userOutput = new ArrayList<DtTourist>();
		
		for(Tourist tur : users){
			userOutput.add((DtTourist)tur.getShortDt());
		}
		
		return userOutput;
	}
	
	@Override
	
	public ArrayList<DtProvider>  getListProvider(){
		UserDAO userDAO = new UserDAOImpl();
		ArrayList<Provider> users = userDAO.findAllProviders();
		ArrayList<DtProvider> userOutput = new ArrayList<DtProvider>();
		
		for(Provider prov : users){
			userOutput.add((DtProvider)prov.getShortDt());
		}
		
		return userOutput;
	}

	@Override
	
	public void updateUser( DtUser userData) {
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
						providerData.getUrl(),
						providerData.getPassword()
					);
			
			if(providerData.getImage() != null) {
				provider.setImage(providerData.getImage());
			}
			
			
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
						touristData.getNationality(),
						touristData.getPassword()
					);
			
			if(touristData.getImage() != null) {
				tourist.setImage(touristData.getImage());
			}
			
			try {
				userDao.update(tourist);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	

	
	public void registerUser( DtUser usrData) {
		UserDAO usrDAO = new UserDAOImpl();
		
		if(usrData instanceof DtProvider) {
			DtProvider provData = (DtProvider) usrData;
			
			
			Provider provUsr = new Provider(
					null, 
					provData.getName(), 
					provData.getNickname(), 
					provData.getEmail(),
					provData.getLastName(), 
					provData.getBirthDate(),
					provData.getDescription(), 
					provData.getUrl(), 
					provData.getPassword());
			
			if(provData.getImage() != null) {
				provUsr.setImage(provData.getImage());
			}
			
			try {
				usrDAO.create(provUsr);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
		}else {
			DtTourist touristData = (DtTourist) usrData;
			
			Tourist touristUsr = new Tourist(
					null, 
					touristData.getName(), 
					touristData.getNickname(), 
					touristData.getEmail(),
					touristData.getLastName(), 
					touristData.getBirthDate(),
					touristData.getNationality(),
					touristData.getPassword());
			
			
			try {
				usrDAO.create(touristUsr);
				if(touristData.getImage() != null) {
					touristUsr.setImage(touristData.getImage());
					usrDAO.update(touristUsr);
					
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	

	
	public ArrayList<DtDepartment> getListDepartment( Boolean alsoActivities) {
		DepartmentDAO departmentDAO = new DepartmentDAOImpl();
		ArrayList<Department> depas = departmentDAO.findAll();
		ArrayList<DtDepartment> departmentOutput = new ArrayList<DtDepartment>();
		
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

	@Override
	
	public DtTouristicActivity getTouristicActivityData(Long touristicActivityId) {
		
		TouristicActivityDAO touristicActivityDAO = new TouristicActivityDAOImpl();
		TouristicActivity touristicActivity = touristicActivityDAO.findById(touristicActivityId);
		touristicActivity.setVisits(touristicActivity.getVisits() + 1);
		
		try {
			touristicActivityDAO.update(touristicActivity);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		DtTouristicActivity dtTouristicActivity = touristicActivity.getDt();

		return dtTouristicActivity;
		
	}
	
	@Override
	
	public ArrayList<DtTouristicDeparture> getDeparturesByActivity( Long touristicActivityId) {
				
		TouristicActivityDAO touristicActivityDAO = new TouristicActivityDAOImpl();
		TouristicActivity activity = touristicActivityDAO.findById(touristicActivityId);
		//obtengo actividad.
		
		TouristicDepartureDAO touristicDepartureDAO = new TouristicDepartureDAOImpl();
		ArrayList<TouristicDeparture> touristicDepartureByAct = touristicDepartureDAO.findByActivity(activity);
		//lista de salidas turisticas con esa actividad.
		
		//agrego salidas al dt.
//		ArrayList<DtTouristicDeparture> dtTouristicDeparture = (ArrayList<DtTouristicDeparture>) new DtTouristicDeparture();
		ArrayList<DtTouristicDeparture> dtTouristicDeparture = new ArrayList<DtTouristicDeparture>();

//		for (int i = 0; i < touristicDepartureByAct.size(); i++) {
//			dtTouristicDeparture.add((DtTouristicDeparture) touristicDepartureByAct);
//		}
		
		touristicDepartureByAct.forEach(departure -> {
			dtTouristicDeparture.add(departure.getShortDt());
		});
		
		
		return dtTouristicDeparture;
	}
	
	
	@Override
	
	public void registeTouristicActivity( DtTouristicActivity touristicActivityData){
		DepartmentDAO departmentDao = new DepartmentDAOImpl();
		TouristicActivityDAO activityDao = new TouristicActivityDAOImpl();
		UserDAO userDao = new UserDAOImpl(); 
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		
		Department department = departmentDao.findById(touristicActivityData
				.getDepartment()
				.getId());
		
		Provider provider = (Provider) userDao.findById(touristicActivityData
				.getProvider()
				.getId());
		
		//categorias seleccionadas
		ArrayList<DtCategory> categoriesSelected = touristicActivityData.getCategories();
		
		ArrayList<Long> categories = new ArrayList<>();
		
		for (int i = 0; i < categoriesSelected.size(); i++) {
			categories.add(categoriesSelected.get(i).getId());
		}
		
		ArrayList<Category> categoriesSelectedList = categoryDAO.findManyById(categories);
		
		//pasar categorias
		TouristicActivity activity = new TouristicActivity(
				touristicActivityData.getId(),
				touristicActivityData.getName(),
				touristicActivityData.getDescription(),
				touristicActivityData.getDuration(),
				touristicActivityData.getCostPerTourist(),
				touristicActivityData.getCity(),
				touristicActivityData.getState(),
				touristicActivityData.getUploadDate(),
				provider,
				department,
				touristicActivityData.getVideoURL());
		

		activity.setCategory(categoriesSelectedList);
	
		try {
			activityDao.create(activity);
			if(touristicActivityData.getImage() != null) {
				activity.setImage(touristicActivityData.getImage());
				activityDao.update(activity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
//			e = new Exception("El nombre: " + touristicActivityData.getName() + " ya existe para la actividad.");
//			throw e;
			
		}
	}

	@Override
	
	public void registerTouristicDeparture( DtTouristicDeparture touristicDepartureData){
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
				activity);
		
		if(touristicDepartureData.getImage() != null) {
			departure.setImage(touristicDepartureData.getImage());
		}
		
		try {
			departureDao.create(departure);
			if(touristicDepartureData.getImage() != null) {
				departure.setImage(touristicDepartureData.getImage());
				departureDao.update(departure);
			}
		} catch (Exception e) {
			e.printStackTrace();
//			e = new Exception("La Salida: " + touristicDepartureData.getName() + " ya existe.");
//			throw e;
		}
		
	}

	@Override
	
	public ArrayList<DtTouristicDeparture> getListTouristicDeparture() {
		TouristicDepartureDAO departureDAO = new TouristicDepartureDAOImpl();
		ArrayList<TouristicDeparture> departures = departureDAO.findAll();
		ArrayList<DtTouristicDeparture> departureOutput = new ArrayList<DtTouristicDeparture>();
		
		for(TouristicDeparture der : departures ) {
			departureOutput.add(der.getShortDt());
		}
		return departureOutput;
	}

	public DtTouristicDeparture getTouristicDepartureData(long touristicDepartureId){
		
		TouristicDepartureDAO touristicDepartureDAO = new TouristicDepartureDAOImpl();
		TouristicDeparture tourDeparture = touristicDepartureDAO.findById(touristicDepartureId);
		tourDeparture.setVisits(tourDeparture.getVisits() + 1);
		
		try {
			touristicDepartureDAO.update(tourDeparture);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		DtTouristicDeparture dtTouristicActivity = tourDeparture.getDt();
		return dtTouristicActivity;
	}

	@Override
	
	public ArrayList<DtTouristicBundle> getListTouristicBundle() {
		TouristicBundleDAO bundleDAO = new TouristicBundleDAOImpl();
		ArrayList<TouristicBundle> bundles = bundleDAO.findAll();
		ArrayList<DtTouristicBundle> outputBundles = new ArrayList<DtTouristicBundle>();
		
		for(TouristicBundle bun : bundles) {
			outputBundles.add(bun.getShortDt());
		}
		//testeo pendiente
		return outputBundles;
	}
	
	@Override
	
	public void registerTouristicBundle( DtTouristicBundle touristicBundleData){
		
		TouristicBundleDAO touristicBundleDAO = new TouristicBundleDAOImpl();
		
		
		TouristicBundle bundle = new TouristicBundle(
				null, 
				touristicBundleData.getName(),
				touristicBundleData.getDescription(), 
				touristicBundleData.getValidityPeriod(), 
				touristicBundleData.getDiscount(), 
				touristicBundleData.getUploadDate());
		
		if(touristicBundleData.getImage() != null) {
			bundle.setImage(touristicBundleData.getImage());
		}
		
		try {
			touristicBundleDAO.create(bundle);
			if(touristicBundleData.getImage() != null) {
				bundle.setImage(touristicBundleData.getImage());
				touristicBundleDAO.update(bundle);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			e = new Exception("El Paquete: " + touristicBundleData.getName() + " ya existe.");
//			throw e;
		}
	}

	
	public void registerDepartment( DtDepartment departmentData){
		DepartmentDAO departmentDAO = new DepartmentDAOImpl();
		
		Department department = new Department(null, departmentData.getName(), departmentData.getDescription(), departmentData.getWebSite());
		
		try {
			departmentDAO.create(department);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	
	public DtTouristicBundle getTouristicBundleData(Long touristicBundleId) {
		TouristicBundleDAO bundleDAO = new TouristicBundleDAOImpl();
		TouristicBundle bundle = bundleDAO.findById(touristicBundleId);
		
		DtTouristicBundle outputBundle = bundle.getBundleDt();
		return outputBundle;
	}
	
	public void registerInscription(DtInscription inscriptionData){
		InscriptionDAO inscDAO = new InscriptionDAOImpl();
		TouristicDepartureDAO departureDao = new TouristicDepartureDAOImpl();
		UserDAO touristDao = new UserDAOImpl();
		
		User user = touristDao.findById(inscriptionData.getTourist().getId());	
		Tourist tourist = (Tourist) user;
		
		TouristicDeparture touristicDeparture = departureDao.findById(inscriptionData.getTouristicDeparture().getId());
		
		Double totalCost = 
				touristicDeparture.getTouristicActivity().getCostPerTourist() * 
				inscriptionData.getTouristAmount();
		
		Inscription inscCreation = new Inscription(
				inscriptionData.getId(),
				inscriptionData.getInscriptionDate(),
				totalCost,
				inscriptionData.getTouristAmount(),
				tourist,
				touristicDeparture);
		try {
			inscDAO.create(inscCreation);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
//			e = new Exception("La Inscripcion: " + inscriptionData.getName() + " ya existe.");
//			throw e;
		}
	}

	
	public void addTouristicActivityToBundle( Long touristicBundleId,
			 Long touristicActivityId) {
		TouristicBundleDAO bundleDao = new TouristicBundleDAOImpl();
		TouristicActivityDAO activityDao = new TouristicActivityDAOImpl();
		
		TouristicBundle bundle = bundleDao.findById(touristicBundleId);
		TouristicActivity activity = activityDao.findById(touristicActivityId);
		
		//mandar adentro de addact
//		bundle.addCategories(activity.getCategories());
		
		bundle.addActivity(activity);
				
		try {
			bundleDao.update(bundle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	@Override
	
	public void registerCategory( DtCategory categoryData){
		
		TouristicActivityDAO activityDAO = new TouristicActivityDAOImpl();
		//como pasar actividades.
		
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		
		Category category = new Category(null, categoryData.getName());
		
		try {
			categoryDAO.create(category);
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			e = new Exception("La Categoria: " + categoryData.getName() + " ya existe.");
//			throw e;
		}
	
	}

	@Override
	
	public ArrayList<DtCategory> getListCategory() {
		CategoryDAO  categoryDAO = new CategoryDAOImpl();
		
		ArrayList<Category> categories = categoryDAO.findAll();
		
		ArrayList<DtCategory> categoriesDt = new ArrayList<DtCategory>();
		
		for (Category cat : categories) {
			categoriesDt.add(cat.getCategoryDt());
		}
		
		return categoriesDt;
	}

	/*
	@Override
	public DtCategory getCategory(Long categoryId) {
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		Category category = categoryDAO.findById(categoryId);
		
		DtCategory categoryData = category.getCategoryDt();
		return categoryData;
	}
	*/
	
	@Override
	
	public void changeActivityState( Long id,  ActivityState state) {
		
		TouristicActivityDAO activityDao = new TouristicActivityDAOImpl();
		TouristicActivity touristicActivity = activityDao.findById(id);
		
		touristicActivity.setActivityState(state);
		
		try {
			activityDao.update(touristicActivity);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public DtUser checkCredentials( String email,  String password){
		UserDAO userDao = new UserDAOImpl();
		
		User user = userDao.checkCredentials(email, password);
		
		if(user == null) {
			return null;
		}else {
			return user.getDt(null);
		}
	}
	
	
		
	
	public ArrayList<DtTouristicActivity> getListActivityStated( ActivityState state){
		
		TouristicActivityDAO activityDao = new TouristicActivityDAOImpl();
		ArrayList<TouristicActivity> activities = activityDao.findAllbyState(state);
		ArrayList<DtTouristicActivity> activityOutput = new ArrayList<DtTouristicActivity>();
		
		if(activities != null || !activities.isEmpty()) {
			
			for(TouristicActivity acti : activities) {
				activityOutput.add(acti.getShortDt());
			}
		}

		return activityOutput;
	}

	@Override
	
	public void registerPurchase( DtPurchase purchase){
		PurchaseDAO purchaseDAO = new PurchaseDAOImpl();
		
		TouristicBundleDAO bundleDAO = new TouristicBundleDAOImpl();
		
		UserDAO userDAO = new UserDAOImpl();
		
		TouristicBundle bundle = bundleDAO.findById(purchase.getBundle().getId());
		
		Tourist tourist = (Tourist) userDAO.findById(purchase.getTourist().getId());
		
		Purchase newPurchase = new Purchase(null,
				purchase.getPurchaseDate(),
				purchase.getTouristAmount(),
				purchase.getTotalCost(),
				purchase.getExpireDate(),
				tourist,
				bundle);
		
		try {
			purchaseDAO.create(newPurchase);
		} catch (Exception e) {
			e.printStackTrace();
//			e = new Exception("Falló al realizar la compra, intente nuevamente.");
//			throw e;
		}	
	}

	@Override
	
	public DtPurchase getPurchase(Long purchaseId) {
		
		PurchaseDAO purchaseDAO = new PurchaseDAOImpl();
		
		Purchase purchase = purchaseDAO.findById(purchaseId);
		
		DtPurchase purchaseData = purchase.getPurchaseDt();

		return purchaseData;
	}
	
	public ArrayList<DtPurchase> getPurchaseList() {
		
		PurchaseDAO purchaseDAO = new PurchaseDAOImpl();
		ArrayList<Purchase> purchase = purchaseDAO.findAll();

		ArrayList<DtPurchase> purchaseOutput = new ArrayList<DtPurchase>();
		
		try {
			for(Purchase pur: purchase) {
				purchaseOutput.add(pur.getPurchaseDt());
			}
			
		} catch (Exception e) {
			throw e;
		}
		
		return purchaseOutput;
		
	}
	
	@Override
	public void followUser(Long userId, Long userToFollowId) {
		
		UserDAO userDAO = new UserDAOImpl();
		
		if(userId == userToFollowId) {
			System.out.println("No puedes seguirte a ti mismo.");
		}else {
			User userFollower = userDAO.findById(userId);
		
			User userFollowed = userDAO.findById(userToFollowId);
			
			if(userFollower.follow(userFollowed)) {	
				try {
					userDAO.update(userFollower);
				}catch (Exception e){
					
				}
			}
		}		
	}	
	
	//revisar como eliminar.
	@Override
	public void unFollowUser(Long userId, Long userToUnFollowId) {
		UserDAO userDAO = new UserDAOImpl();
		
		if(userId == userToUnFollowId) {
			System.out.println("No puedes seguirte/dejar de seguir a ti mismo.");
		}else {
			User userFollower = userDAO.findById(userId);
			User userFollowed = userDAO.findById(userToUnFollowId);
			
			if(userFollower.unFollow(userFollowed)) {	
				try {
					userDAO.update(userFollower);
				}catch (Exception e){
					
				}
			}
		}	
	}

	//revisar como hacer los updates.
	@Override
	public void markFavoriteActivty(Long userId, Long activityId) {

		UserDAO userDAO = new UserDAOImpl();
		TouristicActivityDAO activityDAO = new TouristicActivityDAOImpl();
		
		Tourist tourist = (Tourist) userDAO.findById(userId);
		TouristicActivity activity = activityDAO.findById(activityId);
		
		if(tourist.markFavoriteActivity(activity)) {
			activity.setFavouritesAmmout(activity.getFavouritesAmmout() + 1);
			try {
				activityDAO.update(activity);
				userDAO.update(tourist);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	public void unMarkFavoriteActivity(Long userId, Long activityId) {
		UserDAO userDAO = new UserDAOImpl();
		TouristicActivityDAO activityDAO = new TouristicActivityDAOImpl();
		
		Tourist tourist = (Tourist) userDAO.findById(userId);
		TouristicActivity activity = activityDAO.findById(activityId);

		if(tourist.unMarkFavoriteActivity(activity)) {
			activity.setFavouritesAmmout(activity.getFavouritesAmmout() - 1);
			try {
				activityDAO.update(activity);	
				userDAO.update(tourist);		
			}catch (Exception e){
				e.printStackTrace();
			}	
		}	
	}
	
}
