package uy.turismo.servidorcentral.logic.controller;

import java.util.List;
import uy.turismo.servidorcentral.logic.datatypes.DtUser;
import uy.turismo.servidorcentral.logic.datatypes.DtDepartment;
import uy.turismo.servidorcentral.logic.datatypes.DtInscription;
import uy.turismo.servidorcentral.logic.datatypes.DtProvider;
import uy.turismo.servidorcentral.logic.datatypes.DtTourist;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicBundle;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;

public interface IController {
	
	/**
	 * Devuelve una Lista de DtUser con id, nickname y email
	 * @return List<DtUser>
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
	 * Devuelve una lista de todos los Turistas con el nickname, el email y su id.
	 * @return List<DtProvider>
	 */
	public List<DtProvider>  getListProvider();
	
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
	
	/**
	 * Devuelve una lista con el id y el nombre de todos los Paquetes Turisticos
	 * @return List<DtTouristBundle>
	 */
	public List<DtTouristicBundle> getListTouristicBundle();

	 /** 
	 * @param touristicBundleData
	 * Da de alta un paquete Turistico con los datos pasados por parametros.
	 */
	public void registerTouristicBundle(DtTouristicBundle touristicBundleData);
	
	/**
	 * 
	 * @param departmentData
	 * Da de alta un departamento con los datos pasados por parametro.
	 */
	public void registerDepartment(DtDepartment departmentData);

	
	/**
	 * Devuelve los datos del Paquete Turistico con id = touristicBundleId
	 * @param touristicBundleId
	 * @return DtTouristicBundle
	 */
	public DtTouristicBundle getTouristicBundleData(long touristicBundleId);

	/**
	 * Agrega una actividad turistica a un paquete turistico
	 * @param touristicBundleId
	 * @param touristicActivityId
	 */
	public void addTouristicActivityToBundle(Long touristicBundleId, Long touristicActivityId);
	
	public DtTouristicDeparture getTouristicDepartureData(long touristicDepartureId);

	void registerInscription(DtInscription inscriptionData);
}
