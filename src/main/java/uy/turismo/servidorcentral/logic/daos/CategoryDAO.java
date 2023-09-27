package uy.turismo.servidorcentral.logic.daos;

import java.util.List;

import uy.turismo.servidorcentral.logic.entities.Category;

public interface CategoryDAO {

	/**
	 * 
	 * @return devuelve una lista de categorias.
	 */
	
	public List<Category> findAll();
	
	
	/**
	 *  Crea una categoria nueva.
	 * @param category -> datos de la categoria a crear
	 * @throws Exception -> Excepcion en caso de error. 
	 */
	public void create(Category category) throws Exception;
	
	
}
