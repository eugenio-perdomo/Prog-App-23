package uy.turismo.servidorcentral.logic.daos;

import java.util.ArrayList;

import uy.turismo.servidorcentral.logic.entities.Provider;
import uy.turismo.servidorcentral.logic.entities.Tourist;
import uy.turismo.servidorcentral.logic.entities.User;

public interface UserDAO {

	/**
	 *
	 * @return Devuelve una lista con todos los usuarios de la BD
	 */
	public ArrayList<User> findAll();	
	/**
	 *
	 * @return Devuelve una lista con todos los Turistas de la BD
	 */
	public ArrayList<Tourist> findAllTourists();
	/**
	 *
	 * @return Devuelve una lista con todos los Proveedores de la BD
	 */
	public ArrayList<Provider> findAllProviders();
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

	
	/**
	 * Busca un usuario con email y contraseña pasados
	 * @param email
	 * @param password
	 * @return Devuelve el usuario si lo encontro, sino devuelve null
	 */
	public User checkCredentials(String email, String password);
	
	/**
	 * Busca si hay un usuario con el nickname en cuestion
	 * @param nickname
	 * @return
	 */
	public Boolean checkNick(String nickname);
	
	/**
	 * Busca si hay un usuario con el email en cuestion
	 * @param email
	 * @return
	 */
	public Boolean checkEmail(String email);
}
