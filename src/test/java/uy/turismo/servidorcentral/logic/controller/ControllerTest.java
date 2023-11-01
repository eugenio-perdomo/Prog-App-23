package uy.turismo.servidorcentral.logic.controller;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

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
import uy.turismo.servidorcentral.logic.util.HibernateUtil;
import uy.turismos.servidorcentral.logic.enums.ActivityState;

public class ControllerTest {

	
	@Test
	public void initDataBase() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();	
	}
	
	
	@Test
	public void checkCredentialsTest() {
		IController controller = ControllerFactory.getIController();
		DtUser user = controller.checkCredentials("eldiez@socfomturriv.org.uy", "123");
		System.out.println(user.getEmail());
	}
	
	@Test
	public void updateUserTest() {
		IController controller = ControllerFactory.getIController();
		
		DtProvider provider = (DtProvider) controller.getUserData(13L);
		
		DtProvider updatedProvider = new DtProvider(
				provider.getId(), 
				provider.getName(), 
				provider.getNickname(), 
				provider.getEmail(), 
				"Bergoglio", 
				provider.getBirthDate(), 
				provider.getImage(), 
				provider.getUrl(), 
				provider.getDescription(), 
				null, 
				provider.getPassword());
		
		DtTourist tourist = (DtTourist) controller.getUserData(3L);
		
		DtTourist updatedTourist = new DtTourist(
				tourist.getId(),
				"Hannibal",
				tourist.getNickname(),
				tourist.getEmail(),
				tourist.getLastName(),
				tourist.getBirthDate(),
				tourist.getImage(),
				tourist.getNationality(),
				null,
				tourist.getPassword(),
				null,
				null,
				null
				);

		controller.updateUser(updatedProvider);
		controller.updateUser(updatedTourist);
				
	}
	
	@Test
	public void getProviderListTest() {
		IController controller = ControllerFactory.getIController();
		
		List<DtProvider> providers = controller.getListProvider();
		
		System.out.println();
	}
	
	@Test
	public void getTouristListTest() {
		IController controller = ControllerFactory.getIController();
		
		List<DtTourist> tourists = controller.getListTourist();
		
		System.out.println();
	}
	
	@Test
	public void getUserListTest() {
		IController controller = ControllerFactory.getIController();

		List<DtUser> users = controller.getListUser();
		
		Integer test = users.size();
		
		System.out.println(test);
	}
	
	@Test
	public void registerActivityTest() {
		IController controller = ControllerFactory.getIController();
		
		//CategoryDAO categoryDAO = new CategoryDAOImpl();
		
		ArrayList<DtDepartment> departments = (ArrayList<DtDepartment>) controller.getListDepartment(false);
		
		DtDepartment department = departments.stream()
			.filter(d -> d.getName().equals("Rocha"))
			.findFirst()
			.get();
		

		DtProvider provider = (DtProvider) controller.getUserData(11L);
		
		String name = "volar";
		String description = "algo ekisde";
		Double duration = 1d;
		Double costPerTourist = 120d;
		LocalDate date = LocalDate.now();
		String city = "Rocha";
		ActivityState state = ActivityState.ADDED;
		
		
		List<DtCategory> categories = new ArrayList<DtCategory>();
		
		DtCategory catTest = new DtCategory(1L, "Recorridos", null, null);
		
		categories.add(catTest);
		
		DtTouristicActivity activityTest = new DtTouristicActivity(
				null, 
				name, 
				description, 
				duration, 
				costPerTourist, 
				city,
				null,
				state, 
				date, 
				provider, 
				department, 
				null,
				null, 
				categories);
		
		try {
			controller.registeTouristicActivity(activityTest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getUserDataTest() {
		ControllerFactory.getIController().getUserData(1L);
	}
	
	
	@Test
	public void getListTouristicDepartureTest() {
		IController controller = ControllerFactory.getIController();
		
		List<DtTouristicDeparture> departuresTest = new ArrayList<DtTouristicDeparture>();
	
		departuresTest = controller.getListTouristicDeparture();
	}
	
	
	@Test
	public void getListCategoryTest() {
		IController controller = ControllerFactory.getIController();
		
		List<DtCategory> categories = new ArrayList<DtCategory>();
		
		categories = controller.getListCategory();
	}
	
	
	@Test
	public void registerDepartureTest() {
		IController controller = ControllerFactory.getIController();
        String yellow = "\u001B[33m";

		ArrayList<DtDepartment> departments = (ArrayList<DtDepartment>) controller.getListDepartment(true);
		
		List<DtTouristicActivity> activities = departments
				.stream()
				.filter(d -> d.getId() == 3L)
				.findFirst()
				.get()
				.getActivities();
		
		DtTouristicActivity activity = activities
				.stream()
				.filter(a -> a.getId() == 1L)
				.findFirst()
				.get();
		
		DtTouristicDeparture departure = new DtTouristicDeparture(
				null,
				"Degusta Diciembre",
				4,
				LocalDate.now(),
				LocalDateTime.of(2023, 10, 17, 14, 0),
				"Sociedad Agropecuaria de Rocha",
				null,
				activity,
				null
				);
		
		try {
			controller.registerTouristicDeparture(departure);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(yellow + "Info: DONE" + yellow);
	}
	
	@Test
	public void getListTouristicBundleTest() {
		IController controller = ControllerFactory.getIController();

		List<DtTouristicBundle> pruebaBundle = new ArrayList<DtTouristicBundle>();
		pruebaBundle = controller.getListTouristicBundle();
		
		System.out.println(pruebaBundle);
	}
	
	@Test
	public void getTouristicBundleDataTest() {
		IController controller = ControllerFactory.getIController();
		
		DtTouristicBundle pruebaBundle = controller.getTouristicBundleData(1);
		
		System.out.println(pruebaBundle.getName() + "/" +
						   pruebaBundle.getId() + "/" +
						   pruebaBundle.getDescription() + "/" +
						   pruebaBundle.getDiscount() + "%" + "/" +
						   pruebaBundle.getUploadDate());
	}
	
	@Test
	public void getActivityDataTest() {
		IController controller = ControllerFactory.getIController();
		
		DtTouristicActivity activity = controller.getTouristicActivityData(1L);
		
		System.out.println(activity.getName());
	}
	
	
	@Test
	public void addActivityToBundleTest() {
		IController controller = ControllerFactory.getIController();
		//controller.addTouristicActivityToBundle(1L, 3L);
		controller.addTouristicActivityToBundle(1L, 5L);
	}
	
	@Test
	public void registerInscriptionTest() {
		IController controller = ControllerFactory.getIController();
        String yellow = "\u001B[33m";
		
		DtTourist tourist = (DtTourist) controller.getUserData(4L);
		DtTouristicDeparture departure = controller.getTouristicDepartureData(5L);
		
		DtInscription inscription = new DtInscription(
				null,
				LocalDate.of(2023, 10, 8),
				null,
				3,
				tourist,
				departure
				);
		
		try {
			controller.registerInscription(inscription);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(yellow + "Info: DONE" + yellow);
	}
	
	@Test
	public void listDepartureTest() {
		IController controller = ControllerFactory.getIController();
		
		List<DtTouristicDeparture> departures = controller.getListTouristicDeparture(1L);
		
		System.out.println(departures.get(0).getName());
	
	}
	
	@Test
	public void getDepartureTest() {
		IController controller = ControllerFactory.getIController();
		
		DtTouristicDeparture departure = controller.getTouristicDepartureData(1);
		
		System.out.println(departure.getName());
		
	}

	@Test
	public void registerCategoryTest() {
		
		IController controller = ControllerFactory.getIController();
		String yellow = "\u001B[33m";
		
		
		
		DtCategory categoryTest = new DtCategory(null, "Playas" , null, null);
		
		try {
			controller.registerCategory(categoryTest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(yellow + "Info: DONE" + yellow);
		
	}
	
	@Test
	public void changeActivityStateTest() {
		IController controller = ControllerFactory.getIController();
		String yellow = "\u001B[33m";
		
		ActivityState stateAdded = ActivityState.ADDED;
		ActivityState stateRejected = ActivityState.REJECTED;
		ActivityState stateAccepted = ActivityState.ACCEPTED;
		try {
			controller.changeActivityState(1L,stateRejected);
			controller.changeActivityState(2L,stateRejected);
			controller.changeActivityState(3L,stateAccepted);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void getListActivityStatedTest() {
		//tested!
		//no puede ser nulo tho
		IController controller = ControllerFactory.getIController();
		String yellow = "\u001B[33m";
		
		ActivityState stateAdded = ActivityState.ADDED;
		ActivityState stateRejected = ActivityState.REJECTED;
		ActivityState stateAccepted = ActivityState.ACCEPTED;
		
		List<DtTouristicActivity> activities = controller.getListActivityStated(stateAccepted);
		
		System.out.println(activities);
		
	}

	@Test
	public void registerPurchase() throws Exception {
		IController controller = ControllerFactory.getIController();
		String yellow = "\u001B[33m";
		
		 LocalDate fechaHardcodeada = LocalDate.of(2023, 1, 1);
		 
		 LocalDate fechaHardcodeada2 = LocalDate.of(2023, 2, 2);
		 
		 DtTourist tourist = (DtTourist) controller.getUserData(1l);
		 
		 DtTouristicBundle bundle = controller.getTouristicBundleData(1l);
		 
		DtPurchase purchaseTest = new DtPurchase(null,fechaHardcodeada,11,2000d,fechaHardcodeada2, tourist, bundle);
		
		controller.registerPurchase(purchaseTest);
		
		System.out.println(yellow + "Info: DONE" + yellow);
	}
	
	@Test
	public void registerUserTest() throws Exception{
		IController controller = ControllerFactory.getIController();
		
		String name1 = "Pepe";
		String nickName1 = "El Pepe";
		String email1 = "elPepe@pepe.pepecom";
		String lastName1 = "pepito";
		LocalDate birthDate1 = LocalDate.now();
		BufferedImage image1 = null;
		String nationality1 = "PUTO";
		
		List<DtTouristicDeparture> listDeparture1 = new ArrayList<DtTouristicDeparture>();
		listDeparture1.add(controller.getTouristicDepartureData(1L));
		
		String password1 = "contrasenia";
		List<DtInscription> listInscriptions1 = null;
		List<DtTouristicBundle> listBundles1 = null;
		List<DtPurchase> listPurchases1 = null;
		//--------------------------------------------------------
		String name2 = "Pepeados";
		String nickName2 = "El Pepedor";
		String email2 = "elPepe@pepepepito.com";
		String lastName2 = "pepitopepeante";
		LocalDate birthDate2 = LocalDate.now();
		BufferedImage image2 = null;
		String url2 = "uwu";
		String desc2 = "pepeador barbaro";
		List<DtTouristicActivity> listActivities = null;
		String password2 = "contrasenia23";
		
		DtTourist touristTest = new DtTourist(null,
				name1,
				nickName1,
				email1,
				lastName1,
				birthDate1,
				image1,
				nationality1,
				listDeparture1,
				password1,
				listInscriptions1,
				listBundles1,
				listPurchases1);
		
		DtProvider providerTest = new DtProvider(null,
				name2,
				nickName2,
				email2,
				lastName2,
				birthDate2,
				image2,
				url2,
				desc2,
				listActivities,
				password2);
		
		//de alta bien
		controller.registerUser(touristTest);
		
		//de alta mal
		controller.registerUser(touristTest);
		
		//de alta proveedor
		controller.registerUser(providerTest);
	}
	
	@Test
	public void registerDepartment() {
		IController controller = ControllerFactory.getIController();
		
		String name = "Rocha2";
		String desc = "Efectivamente es rocha2";
		String url = "turismo.rocha.gub.com";
		
		DtDepartment departmentTest = new DtDepartment(null, name, desc, url, null);
		
		controller.registerDepartment(departmentTest);
		
		String yellow = "\u001B[33m";
		System.out.println(yellow + "Info: DONE" + yellow);
	}
	
	@Test
	public void registerDepartmentFail() {
		IController controller = ControllerFactory.getIController();
		
		String name = "Rocha2";
		String desc = "Efectivamente es rocha2";
		String url = "turismo.rocha.gub.com";
		
		DtDepartment departmentTest = new DtDepartment(null, name, desc, url, null);
		
		controller.registerDepartment(departmentTest);
		
		String yellow = "\u001B[33m";
		System.out.println(yellow + "Info: DONE" + yellow);
	}
	
	@Test
	public void getPurchaseTest() {
		IController controller = ControllerFactory.getIController();
		
		DtPurchase purchase = controller.getPurchase(1L);
		
		System.out.println(purchase.getId());
	}
	
	@Test
	public void getListPurchase() {
		IController controller = ControllerFactory.getIController();
		
		List<DtPurchase> purchaseList = controller.getPurchaseList();
		
		System.out.println(purchaseList.get(0).getId());
	}
	
	@Test 
	public void registerTouristcDeparture() throws Exception {
		IController controller = ControllerFactory.getIController();
		String yellow = "\u001B[33m";
		String name = "BundleTest";
		String desc = "Descripcion bundle Test";
		Integer validity = 20;
		Double discount = 20d;
		LocalDate upload = LocalDate.now();
		Double price = 200d;
		
		DtTouristicBundle bundle = new DtTouristicBundle(null, name, desc, validity, discount,upload, null, null, null, price);

		controller.registerTouristicBundle(bundle);
		System.out.println(yellow + "Info: DONE" + yellow);
	}
	
	public void registerTouristcDepartureFail() throws Exception {
		IController controller = ControllerFactory.getIController();
		String yellow = "\u001B[33m";
		String name = "BundleTest";
		String desc = "Descripcion bundle Test";
		Integer validity = 20;
		Double discount = 20d;
		LocalDate upload = LocalDate.now();
		Double price = 200d;
		
		DtTouristicBundle bundle = new DtTouristicBundle(null, name, desc, validity, discount,upload, null, null, null, price);

		controller.registerTouristicBundle(bundle);
		System.out.println(yellow + "Info: DONE" + yellow);
	}
	
}
