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
	 * @return List<DtDepartment>
	 */
	public List<DtDepartment> getListDepartment(Boolean alsoActivities); 
	
	/**
	 * 
	 * @param touristicActivityId
	 * @return Devuelve los datos de la actividad Turistica con id = touristicActivityId
	 */
	
	public DtTouristicActivity getTouristicActivityData(Long touristicActivityId);
	
	/**
	 * 
	 * @param touristicActivityId
	 * @return Devuelve una lista de Salidas Turisticas de aquellas actividades turisticas con id = touristicActivityId
	 */
	
	public List<DtTouristicDeparture> getListTouristicDeparture(Long touristicActivityId); 
	
	
	
}
