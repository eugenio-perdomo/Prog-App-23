package uy.turismo.servidorcentral.logic.daos;

import java.util.ArrayList;

import uy.turismo.servidorcentral.logic.entities.Category;

public interface CategoryDAO {

	/**
	 * 
	 * @return devuelve una lista de categorias.
	 */
	
	public ArrayList<Category> findAll();
	
	
	/**
	 *  Crea una categoria nueva.
	 * @param category -> datos de la categoria a crear
	 * @throws Exception -> Excepcion en caso de error. 
	 */
	public void create(Category category) throws Exception;
	
	/**
	 * Encuentro una o muchas categorias 
	 * @param id -> lista de id de las categorias 
	 * @return devuelvo lista de categorias, que busque por id
	 */
	public ArrayList<Category> findManyById(ArrayList<Long> id);

	
	/**
	 * 
	 * @param id -> Identificador de la catetoria.
	 * @return devuelve los datos de una categoria
	 */
	public Category findById(Long id);
	
}
