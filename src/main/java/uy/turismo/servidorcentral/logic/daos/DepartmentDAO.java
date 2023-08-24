package uy.turismo.servidorcentral.logic.daos;

import java.util.List;

import uy.turismo.servidorcentral.logic.entities.Department;

public interface DepartmentDAO {
	
	/**
	 * 
	 * @return lista con todos los Departamentos de la BD
	 */
	public List<Department> findAll();
	/**
	 * Persiste un nuevo departamento en la BD
	 * @param department
	 * @throws Exception si no se pudo persistir en la BD
	 */
	public void create(Department department) throws Exception;
	/**
	 * Modifica un departamento ya existente en la BD
	 * @param department
	 * @throws Exception si no se pudo mergear en la BD
	 */
	public void update(Department department) throws Exception;
}
