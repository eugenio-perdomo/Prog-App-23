package uy.turismo.servidorcentral.logic.ws;

import java.awt.image.DataBufferByte;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.Icon;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Endpoint;
import uy.turismo.servidorcentral.logic.controller.ControllerFactory;
import uy.turismo.servidorcentral.logic.controller.IController;
import uy.turismo.servidorcentral.logic.ws.datatypes.*;
import uy.turismo.servidorcentral.logic.datatypes.*;
import uy.turismo.servidorcentral.logic.enums.ActivityState;
import uy.turismo.servidorcentral.logic.enums.EntityType;


@WebService(targetNamespace = "controller")
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
@XmlSeeAlso({
	DtBaseEntityWS.class,
	DtUserWS.class,
	DtProviderWS.class,
	DtTouristWS.class,
	DtCategoryWS.class,
	DtDepartmentWS.class,
	DtInscriptionWS.class,
	DtTouristicActivityWS.class,
	DtPurchaseWS.class,
	DtTouristicBundleWS.class,
	DtTouristicDepartureWS.class
	})
public class Publisher {
	
	private Endpoint endpoint;

	@WebMethod(exclude = true)
	public void publish() {
		endpoint = Endpoint.publish("http://localhost:8181/controller", this);
	}
	

	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
		return this.endpoint;
	}

	@WebMethod
	@WebResult(name = "userData")
	public DtUserWS checkCredentials(
			@WebParam(name = "userEmail") 
			String email,
			@WebParam(name = "userPassword")  
			String password) {

		IController controller = ControllerFactory.getIController();
		
		DtUser userData = controller.checkCredentials(email, password);
		
		DtUserWS userOutput = null;
		
		if(userData != null) {
			if(userData instanceof DtTourist) {
				userOutput = new DtTouristWS((DtTourist) userData, false);
			}else {
				userOutput = new DtProviderWS((DtProvider) userData, false);
			}
		}
		
		return userOutput;
	}
	
	@WebMethod
	@WebResult(name = "existsNick")
	public Boolean existsNick(
			@WebParam(name = "nickname")
			String userNickname) {

		IController controller = ControllerFactory.getIController();
		
		return controller.existsNick(userNickname);
	}

	@WebMethod
	@WebResult(name = "existsEmail")
	public Boolean existsEmail(
			@WebParam(name = "email")
			String userEmail) {
		

		IController controller = ControllerFactory.getIController();
		
		return controller.existsEmail(userEmail);
	}


	@WebMethod
	@WebResult(name = "existsName")
	public Boolean existsName(
			@WebParam(name = "name")
			String name,
			@WebParam(name = "entity") 
			EntityType entityType ) {

		IController controller = ControllerFactory.getIController();
		
		return controller.existsName(name, entityType);
	}
	
	@WebMethod
	@WebResult(name = "activityAndBundle")
	public DtBaseEntityWS[] filterByString(
			@WebParam(name = "strToFind")
			String str){

		IController controller = ControllerFactory.getIController();
		
		List<DtBaseEntity> baseEntityList = controller.filterByString(str);
		
		DtBaseEntityWS[] baseEntityArray = new DtBaseEntityWS[baseEntityList.size()];
		int i = 0;
		for(DtBaseEntity baseEntity : baseEntityList) {
			if(baseEntity instanceof DtTouristicActivity) {
				baseEntityArray[i] = new DtTouristicActivityWS(
						(DtTouristicActivity) baseEntity,
						true);
			}
			
			if(baseEntity instanceof DtTouristicBundle) {
				baseEntityArray[i] = new DtTouristicBundleWS(
						(DtTouristicBundle) baseEntity,
						true);
			}
			i++;
		}
		
		return baseEntityArray;
	}
	
	@WebMethod
	@WebResult(name = "userList")
	public DtUserWS[] getListUser() {
		IController controller = ControllerFactory.getIController();
		
		ArrayList<DtUser> userList = controller.getListUser();
		
		DtUserWS[] userArray = new DtUserWS[userList.size()];
		
		int i = 0;
		
		for(DtUser user : userList) {

	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        try {
	        	ImageIO.write(user.getImage(), "png", baos);
				
			} catch (Exception e) {
				System.err.println("Error al convertir imagen: " + e.getMessage());
			}
	        byte[] imageArray = baos.toByteArray();
			
	        if(user instanceof DtTourist) {
				userArray[i] = new DtTouristWS((DtTourist) user, true);
				
			}else {
				userArray[i] = new DtProviderWS((DtProvider) user, true);
				
			}
			
			i++;
		}
		
		return userArray;
	}
	
	@WebMethod
	@WebResult( name = "providerList")
	public DtProviderWS[] getProviderList() {
		IController controller = ControllerFactory.getIController();
		
		ArrayList<DtProvider> providerList = controller.getListProvider();
		
		DtProviderWS[] providerArray = new DtProviderWS[providerList.size()];
		
		int i = 0;
		
		for(DtProvider provider : providerList) {
			providerArray[i] = new DtProviderWS(provider, true);
			i++;
			
		}
		
		return providerArray;
	}

	@WebMethod
	@WebResult( name = "touristList")
	public DtTouristWS[] getTouristList() {
		IController controller = ControllerFactory.getIController();
		
		ArrayList<DtTourist> touristList = controller.getListTourist();
		
		DtTouristWS[] touristArray = new DtTouristWS[touristList.size()];
		
		int i = 0;
		
		for(DtTourist tourist : touristList) {
			touristArray[i] = new DtTouristWS(tourist, true);
			i++;
			
		}
		
		return touristArray;
	}
	
	@WebMethod
	@WebResult(name = "userData")
	public DtUserWS getUserData(
			@WebParam(name = "userId") 
			Long id) {
		
		IController controller = ControllerFactory.getIController();
		DtUser userData = controller.getUserData(id);
		
		DtUserWS userOutput = null;
		
		if(userData instanceof DtTourist) {
			userOutput = new DtTouristWS((DtTourist) userData, false);
		}else {
			userOutput = new DtProviderWS((DtProvider) userData, false);
		}
		
		return userOutput;
	}
	
	@WebMethod
	public void updateUser(
			@WebParam(name = "userData")
			DtUserWS userData) {
		
		IController controller = ControllerFactory.getIController();
		
		if(userData instanceof DtTouristWS) {
			controller.updateUser(new DtTourist((DtTouristWS) userData));
		}else {
			controller.updateUser(new DtProvider((DtProviderWS) userData));
		}
	}
	
	@WebMethod
	public void followUser(
			@WebParam(name = "userFollwer")
			Long userId, 
			@WebParam(name = "userToFollow")
			Long userToFollowId) {

		IController controller = ControllerFactory.getIController();
		controller.followUser(userId, userToFollowId);
	}

	@WebMethod
	public void unFollowUser(
			@WebParam(name = "userFollwer")
			Long userId, 
			@WebParam(name = "userToUnfollow")
			Long userToUnFollowId) {

		IController controller = ControllerFactory.getIController();
		controller.unFollowUser(userId, userToUnFollowId);
	}
	
	@WebMethod
	public void markFavoriteActivty(
			@WebParam(name = "userId")
			Long userId, 
			@WebParam(name = "activityToMark")
			Long activityId) {

		IController controller = ControllerFactory.getIController();
		controller.markFavoriteActivty(userId, activityId);
	}
	

	@WebMethod
	public void unMarkFavoriteActivity(
			@WebParam(name = "userId")
			Long userId, 
			@WebParam(name = "activityToUnmark")
			Long activityId) {

		IController controller = ControllerFactory.getIController();
		controller.unMarkFavoriteActivity(userId, activityId);
	}
	
	@WebMethod
	public void registerUser(
			@WebParam(name = "userData")
			DtUserWS userData) {
		
		IController controller = ControllerFactory.getIController();
		
		if(userData instanceof DtTouristWS) {
			controller.registerUser(new DtTourist((DtTouristWS) userData));
		}else {
			controller.registerUser(new DtProvider((DtProviderWS) userData));
		}
		
	}
	
	@WebMethod
	public void registeTouristicActivity( 
			@WebParam(name = "activityData")
			DtTouristicActivityWS touristicActivityData) {

		IController controller = ControllerFactory.getIController();
		
		controller.registeTouristicActivity(new DtTouristicActivity(touristicActivityData));
	}
	
	@WebMethod
	public void registerTouristicDeparture(
			@WebParam(name = "departureData")
			DtTouristicDepartureWS touristicDepartureData) {

		IController controller = ControllerFactory.getIController();
		
		controller.registerTouristicDeparture(new DtTouristicDeparture(touristicDepartureData));
	}
	
	@WebMethod
	public void registerTouristicBundle(
			@WebParam(name = "bundleData")
			DtTouristicBundleWS touristicBundleData){

		IController controller = ControllerFactory.getIController();
		
		controller.registerTouristicBundle(new DtTouristicBundle(touristicBundleData));
	}

	@WebMethod
	public void registerDepartment(
			@WebParam(name = "departmentData")
			DtDepartmentWS departmentData) {

		IController controller = ControllerFactory.getIController();
		
		controller.registerDepartment(new DtDepartment(departmentData));
	}

	@WebMethod
	public void registerInscription(
			@WebParam(name = "inscriptionData")
			DtInscriptionWS inscriptionData){

		IController controller = ControllerFactory.getIController();
		
		controller.registerInscription(new DtInscription(inscriptionData));
	}

	@WebMethod
	public void registerCategory(
			@WebParam(name = "categoryData")
			DtCategoryWS categoryData){

		IController controller = ControllerFactory.getIController();

		controller.registerCategory(new DtCategory(categoryData));
	}

	@WebMethod
	public void registerPurchase(
			@WebParam(name = "purchaseData")
			DtPurchaseWS purchase){

		IController controller = ControllerFactory.getIController();
		
		controller.registerPurchase(new DtPurchase(purchase));
	}
	
	
	@WebMethod
	@WebResult(name = "departmentsList")
	public DtDepartmentWS[] getListDepartment(
			@WebParam(name = "withActivities?") 
			Boolean alsoActivities){

		IController controller = ControllerFactory.getIController();
		
		ArrayList<DtDepartment> departmentList = controller.getListDepartment(alsoActivities);
		
		DtDepartmentWS[] departmentArray = null;
		
		if(departmentList != null && !departmentList.isEmpty()) {
			departmentArray = new DtDepartmentWS[departmentList.size()];
			int i = 0;
			for(DtDepartment department : departmentList) {
				departmentArray[i] = new DtDepartmentWS(department, true);
				i++;
			}
		}
		
		return departmentArray;
	}
	
	@WebMethod
	@WebResult(name = "activityData")
	public DtTouristicActivityWS getTouristicActivityData(
			@WebParam(name = "activityId") 
			Long touristicActivityId) {
		IController controller = ControllerFactory.getIController();
		
		DtTouristicActivity activityData = controller.getTouristicActivityData(touristicActivityId);
		DtTouristicActivityWS activityOutput = new DtTouristicActivityWS(activityData, false);
		
		return activityOutput;
	}

	@WebMethod
	@WebResult(name = "departuresByActivity")
	public DtTouristicDepartureWS[] getDeparturesByActivity(
			@WebParam(name = "activityId") 
			Long touristicActivityId) {
		IController controller = ControllerFactory.getIController();
		
		ArrayList<DtTouristicDeparture> departureList = controller
				.getDeparturesByActivity(touristicActivityId);
		
		DtTouristicDepartureWS[] departureArray = null;
		
		
		if(departureList != null && !departureList.isEmpty()) {
			departureArray = new DtTouristicDepartureWS[departureList.size()];
			int i = 0;
			for(DtTouristicDeparture departure : departureList) {
				departureArray[i] = new DtTouristicDepartureWS(departure, true);
				i++;
			}
		}
		
		return departureArray;
	}

	@WebMethod
	@WebResult(name = "departuresList")
	public DtTouristicDepartureWS[] getListTouristicDeparture(){
		IController controller = ControllerFactory.getIController();
		
		ArrayList<DtTouristicDeparture> departureList = controller.getListTouristicDeparture();
		
		DtTouristicDepartureWS[] departureArray = null;
		
		if(departureList != null && !departureList.isEmpty()) {
			departureArray = new DtTouristicDepartureWS[departureList.size()];
			int i = 0;
			for(DtTouristicDeparture departure : departureList) {
				departureArray[i] = new DtTouristicDepartureWS(departure, true);
				i++;
			}
			
		}
		
		return departureArray;
	}

	@WebMethod
	@WebResult(name = "bundleList")
	public DtTouristicBundleWS[] getListTouristicBundle() {
		IController controller = ControllerFactory.getIController();
		
		ArrayList<DtTouristicBundle> bundleList = controller.getListTouristicBundle();
		
		DtTouristicBundleWS[] bundleArray = null;

		if(bundleList != null && !bundleList.isEmpty()) {
			bundleArray = new DtTouristicBundleWS[bundleList.size()];
			int i = 0;
			for(DtTouristicBundle bundle : bundleList) {
				bundleArray[i] = new DtTouristicBundleWS(bundle, true);
				i++;
			}
			
		}
		return bundleArray;
	}

	@WebMethod
	@WebResult(name = "bundleList")
	public DtTouristicBundleWS getTouristicBundleData(
			@WebParam(name = "bundleId") 
			Long touristicBundleId) {
		
		IController controller = ControllerFactory.getIController();
		
		DtTouristicBundle bundle = controller.getTouristicBundleData(touristicBundleId);
		
		DtTouristicBundleWS bundleOutput = new DtTouristicBundleWS(bundle, false);
		
		return bundleOutput;
	}

	@WebMethod
	public void addTouristicActivityToBundle(
			@WebParam(name = "bundleId") 
			Long touristicBundleId, 
			@WebParam(name = "activityId") 
			Long touristicActivityId) {
		
		IController controller = ControllerFactory.getIController();
		
		controller.addTouristicActivityToBundle(touristicBundleId, touristicActivityId);
	}

	@WebMethod
	@WebResult(name = "departureData")
	public DtTouristicDepartureWS getTouristicDepartureData(
			@WebParam(name = "departureId")
			long touristicDepartureId) {
		
		IController controller = ControllerFactory.getIController();
		DtTouristicDeparture departure = controller.getTouristicDepartureData(touristicDepartureId);
		
		DtTouristicDepartureWS departureOutput = new DtTouristicDepartureWS(departure, false);
		
		return departureOutput;
	}

	@WebMethod
	@WebResult(name = "categoryList")
	public DtCategoryWS[] getListCategory(){

		IController controller = ControllerFactory.getIController();
		
		ArrayList<DtCategory> categoryList = controller.getListCategory();
		
		DtCategoryWS[] categoryArray = null;

		if(categoryList != null && !categoryList.isEmpty()) {
			categoryArray = new DtCategoryWS[categoryList.size()];
			int i = 0;
			for(DtCategory category : categoryList) {
				categoryArray[i] = new DtCategoryWS(category, true);
				i++;
			}
			
		}
		
		return categoryArray;
	}

	@WebMethod
	public void changeActivityState(
			@WebParam(name = "activityId")
			Long id, 
			@WebParam(name = "activityState")
			ActivityState state) {

		IController controller = ControllerFactory.getIController();
		
		controller.changeActivityState(id, state);
	}

	@WebMethod
	@WebResult(name = "activitiesByState")
	public DtTouristicActivityWS[] getListActivityStated(
			@WebParam(name = "activityState")
			ActivityState state){

		IController controller = ControllerFactory.getIController();
		
		ArrayList<DtTouristicActivity> activityList = controller.getListActivityStated(state);
		
		DtTouristicActivityWS[] activityArray = null;

		if(activityList != null && !activityList.isEmpty()) {
			activityArray = new DtTouristicActivityWS[activityList.size()];
			int i = 0;
			for(DtTouristicActivity activity : activityList) {
				activityArray[i] = new DtTouristicActivityWS(activity, true);
				i++;
			}
		}
		
		return activityArray;
	}

	@WebMethod
	@WebResult(name = "purchaseData")
	public DtPurchaseWS getPurchase(
			@WebParam(name = "purchaseId")
			Long purchaseId) {

		IController controller = ControllerFactory.getIController();
		
		DtPurchase purchase = controller.getPurchase(purchaseId);
		
		DtPurchaseWS purchaseOutput = new DtPurchaseWS(purchase);
		
		return purchaseOutput;
	}
	

	@WebMethod
	@WebResult(name = "purchaseList")
	public DtPurchaseWS[] getPurchaseList(){

		IController controller = ControllerFactory.getIController();
		
		ArrayList<DtPurchase> purchaseList = controller.getPurchaseList();
		
		DtPurchaseWS[] purchaseArray = null;

		if(purchaseList != null && !purchaseList.isEmpty()) {
			purchaseArray = new DtPurchaseWS[purchaseList.size()];
			int i = 0;
			for(DtPurchase purchase : purchaseList) {
				purchaseArray[i] = new DtPurchaseWS(purchase);
				i++;
			}
		}
		
		return purchaseArray;
	}
}