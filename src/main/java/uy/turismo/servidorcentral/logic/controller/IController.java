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
}
