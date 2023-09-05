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
	 * Busca un Departamento por id
	 * @param id
	 * @return
	 */
	public Department findById(Long id);
	
	/**
	 * Persiste un nuevo departamento en la BD
	 * @param department
	 * @throws Exception si no se pudo persistir en la BD
	 */
	public void create(Department department) throws Exception;

}
