package uy.turismo.servidorcentral.logic.controller;

import java.util.List;
import uy.turismo.servidorcentral.logic.datatypes.DtUser;
import uy.turismo.servidorcentral.logic.datatypes.DtTourist;

public interface IController {
	
	/**
	 * Devuelve una Lista de DtUser con id, nickname y email
	 * @return
	 */
	public List<DtUser> getListUser();
	
	/**
	 * Busca y devuelve los datos de un usuario
	 * @param id del usuario a encontrar
	 * @return DtUser
	 */
	public DtUser getUserData(Long id);
	
	/**
	 * Devuelve una lista de todos los Turistas con el nickname, el email y su id.
	 * @return
	 */
	public List<DtTourist>  getListTourist();
	
	/**
	 * Modifica un usuario ya existente con nuevos datos
	 * @param userData
	 */
	public void updateUser(DtUser userData);
	
	/**
	 * Da de alta un usuario con los datos pasados por parametros (puede ser tanto turista como proveedor)
	 * @param userData
	 */
	
	public void registerUser(DtUser userData);
}
