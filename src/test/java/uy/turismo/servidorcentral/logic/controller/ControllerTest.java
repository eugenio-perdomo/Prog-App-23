package uy.turismo.servidorcentral.logic.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import uy.turismo.servidorcentral.logic.datatypes.DtDepartment;
import uy.turismo.servidorcentral.logic.datatypes.DtProvider;

public class ControllerTest {

	@Test
	public void registerActivityTest() {
		IController controller = ControllerFactory.getIController();
		
		ArrayList<DtDepartment> departments = (ArrayList<DtDepartment>) controller.getListDepartment(false);
		DtDepartment department = departments.stream()
			.filter(d -> d.getName().equals("Maldonado"))
			.findFirst()
			.get();
		
	}
	
}
