package uy.turismo.servidorcentral.logic.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import uy.turismo.servidorcentral.logic.daos.CategoryDAO;
import uy.turismo.servidorcentral.logic.daos.CategoryDAOImpl;
import uy.turismo.servidorcentral.logic.datatypes.DtCategory;
import uy.turismo.servidorcentral.logic.datatypes.DtDepartment;
import uy.turismo.servidorcentral.logic.datatypes.DtInscription;
import uy.turismo.servidorcentral.logic.datatypes.DtProvider;
import uy.turismo.servidorcentral.logic.datatypes.DtTourist;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicBundle;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;
import uy.turismo.servidorcentral.logic.entities.Category;
import uy.turismo.servidorcentral.logic.entities.Department;
import uy.turismo.servidorcentral.logic.entities.Provider;
import uy.turismo.servidorcentral.logic.entities.TouristicActivity;
import uy.turismo.servidorcentral.logic.entities.TouristicDeparture;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;
import uy.turismos.servidorcentral.logic.enums.ActivityState;

public class ControllerTest {

	@Test
    public void initDataBase() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.close();
    }
	
	@Test
	public void registerActivityTest() {
		IController controller = ControllerFactory.getIController();
		
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		
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
		
		DtCategory catTest = new DtCategory(1L, "Recorridos", null);
		
		categories.add(catTest);
		
		DtTouristicActivity activityTest = new DtTouristicActivity(null, name, description, duration, costPerTourist, city,state, date, provider, department, null,
				null, categories);
		
		controller.registeTouristicActivity(activityTest);
	}
	
	
	@Test
	public void getListTouristicDepartureTest() {
		IController controller = ControllerFactory.getIController();
		
		List<DtTouristicDeparture> departuresTest = new ArrayList<DtTouristicDeparture>();
		
		//TODO : Cuando este implementada findAllProviders se puede continuar con este test
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
				"Degusta Octubre",
				4,
				LocalDate.now(),
				LocalDateTime.of(2023, 10, 17, 14, 0),
				"Sociedad Agropecuaria de Rocha",
				activity,
				null
				);
		
		controller.registerTouristicDeparture(departure);
		
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
		
		
		
		
	}
	
	
	@Test
	public void addActivityToBundleTest() {
		IController controller = ControllerFactory.getIController();
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
		
		controller.registerInscription(inscription);
		
		System.out.println(yellow + "Info: DONE" + yellow);
	}
	
	@Test
	public void listDepartureTest() {
		IController controller = ControllerFactory.getIController();
		
		List<DtTouristicDeparture> departures = controller.getListTouristicDeparture(1L);
		
		System.out.println();
	
	}
	
	@Test
	public void getDepartureTest() {
		IController controller = ControllerFactory.getIController();
		
		DtTouristicDeparture departure = controller.getTouristicDepartureData(1);
		
		System.out.println();
		
	}

	@Test
	public void registerCategoryTest() {
		
		IController controller = ControllerFactory.getIController();
		String yellow = "\u001B[33m";
		
		
		
		DtCategory categoryTest = new DtCategory(null, "Playas" , null);
		
		controller.registerCategory(categoryTest);
		
		System.out.println(yellow + "Info: DONE" + yellow);
		
	}
}
