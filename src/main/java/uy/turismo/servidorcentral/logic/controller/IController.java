package uy.turismo.servidorcentral.logic.controller;

import java.util.List;
import uy.turismo.servidorcentral.logic.datatypes.DtUser;
import uy.turismo.servidorcentral.logic.datatypes.DtDepartment;
import uy.turismo.servidorcentral.logic.datatypes.DtTourist;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;

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
	 * @return List<DtTourist>
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
	
	
	/**
	 * Devuelve una lista con el id, el nombre de todos los Departamentos. Si el parametro alsoActivities es true, tambien devuelve las Actividades que se hacen en el Departamento
	 * @param alsoActivities
	 * @return List<DtDepartment>
	 */
	public List<DtDepartment> getListDepartment(Boolean alsoActivities); 
	/**
	 * Da de alta una Actividad Turistica con los datos pasados por parametro
	 * @param touristicActivityData
	 */
	public void registeTouristicActivity(DtTouristicActivity touristicActivityData);

	/**
	 * Da de alta una Salida Turistica con los datos pasados por parametros
	 * @param touristicDepartureData
	 */
	public void registerTouristicDeparture(DtTouristicDeparture touristicDepartureData);
	
	/**
	 * Devuelve una lista con el id y el nombre de todas las Salidas Turisticas
	 * @return List<DtTouristicDeparture>
	 */
	public List<DtTouristicDeparture> getListTouristicDeparture();
}
