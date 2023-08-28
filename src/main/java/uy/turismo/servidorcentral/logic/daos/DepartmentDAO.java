package uy.turismo.servidorcentral.logic.daos;

import java.util.List;

import uy.turismo.servidorcentral.logic.entities.Department;

public interface DepartmentDAO {

	/**
	 * 
	 * @param alsoActivities -> Si es true devuelve tambien las actividades que se hacen en el departamento
	 * @return-> devuelva una lista con el id de los departamentos.
	 */
	
	public List<Department> findAllDepartments(boolean alsoActivities);
	
	/**
	 * 
	 * @param department -> Departamento a crear.
	 * @throws Exception -> En caso de no crear el departamento.
	 */
	
	public void createDepartment(Department department) throws Exception;
	
}
