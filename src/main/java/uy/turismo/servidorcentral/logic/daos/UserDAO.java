package uy.turismo.servidorcentral.logic.daos;

import java.util.List;

import uy.turismo.servidorcentral.logic.entities.Provider;
import uy.turismo.servidorcentral.logic.entities.Tourist;
import uy.turismo.servidorcentral.logic.entities.User;

public interface UserDAO {

	/**
	 *
	 * @return Devuelve una lista con todos los usuarios de la BD
	 */
	public List<User> findAll();	
	/**
	 *
	 * @return Devuelve una lista con todos los Turistas de la BD
	 */
	public List<Tourist> findAllTourists();
	/**
	 *
	 * @return Devuelve una lista con todos los Proveedores de la BD
	 */
	public List<Provider> findAllProviders();
	/**
	 * Busca un usuario por id 
	 * @param id
	 * @return Devuelve un Proveedor o Turista
	 */
	public User findById(Long id);
	/**
	 * Persiste un nuevo usuario en la BD
	 * @param user
	 * @throws Exception si no se pudo persistir el usuario
	 */
	public void create(User user) throws Exception;
	/**
	 * Modifica un usuario ya existente en la BD
	 * @param user
	 * @throws Exception si no se pudo hacer el merge
	 */
	public void update(User user) throws Exception;
}
