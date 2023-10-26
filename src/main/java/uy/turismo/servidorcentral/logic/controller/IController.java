package uy.turismo.servidorcentral.logic.controller;

import java.util.List;
import uy.turismo.servidorcentral.logic.datatypes.DtUser;
import uy.turismos.servidorcentral.logic.enums.ActivityState;
import uy.turismo.servidorcentral.logic.datatypes.DtCategory;
import uy.turismo.servidorcentral.logic.datatypes.DtDepartment;
import uy.turismo.servidorcentral.logic.datatypes.DtInscription;
import uy.turismo.servidorcentral.logic.datatypes.DtProvider;
import uy.turismo.servidorcentral.logic.datatypes.DtPurchase;
import uy.turismo.servidorcentral.logic.datatypes.DtTourist;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicBundle;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;

public interface IController {
	
	/**
	 * Revisa si existe un usuario con email y password pasados
	 * @param email
	 * @param password
	 * @return Devulve true si existe y false si no
	 * @throws Exception 
	 */
	public DtUser checkCredentials(String email, String password) throws Exception;
	
	/**
	 * Devuelve una Lista de DtUser con id, nickname y email
	 * @return List<DtUser>
	 * @throws Exception 
	 */
	public List<DtUser> getListUser() throws Exception;
	
	
	/**
	 * Busca y devuelve los datos de un usuario
	 * @param id del usuario a encontrar
	 * @return DtUser
	 * @throws Exception 
	 */
	public DtUser getUserData(Long id) throws Exception;
	
	
	/**
	 * Devuelve una lista de todos los Turistas con el nickname, el email y su id.
	 * @return List<DtTourist>
	 * @throws Exception 
	 */
	public List<DtTourist>  getListTourist() throws Exception;
	
	/**
	 * Devuelve una lista de todos los Turistas con el nickname, el email y su id.
	 * @return List<DtProvider>
	 * @throws Exception 
	 */
	public List<DtProvider>  getListProvider() throws Exception;
	
	/**
	 * Modifica un usuario ya existente con nuevos datos
	 * @param userData
	 */
	public void updateUser(DtUser userData);
	
	
	/**
	 * Da de alta un usuario con los datos pasados por parametros (puede ser tanto turista como proveedor)
	 * @param userData
	 * @throws Exception 
	 */
	public void registerUser(DtUser userData) throws Exception;
	
	
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
	public void registeTouristicActivity(DtTouristicActivity touristicActivityData) throws Exception;

	
	/**
	 * Da de alta una Salida Turistica con los datos pasados por parametros
	 * @param touristicDepartureData
	 */
	public void registerTouristicDeparture(DtTouristicDeparture touristicDepartureData) throws Exception;
	
	
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
	public void registerTouristicBundle(DtTouristicBundle touristicBundleData) throws Exception;
	
	/**
	 * 
	 * @param departmentData
	 * Da de alta un departamento con los datos pasados por parametro.
	 */
	public void registerDepartment(DtDepartment departmentData) throws Exception;

	
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

	void registerInscription(DtInscription inscriptionData) throws Exception;
	
	/**
	 * Registra una nueva categoria.
	 * @param category -> Datos de la categoria a registrar
	 */
	public void registerCategory(DtCategory category) throws Exception;
	
	/**
	 * 
	 * @return devuelve una  lista  de categorias con nombre e id.
	 */
	public List<DtCategory>  getListCategory();
	
	public DtCategory getCategory(Long categoryId);
	
	
	/**
	 * Cambia el estado de una Actividad turistica
	 * @param touristicActivityData
	 */
	public void changeActivityState(Long id, ActivityState state) throws Exception;
	
	/**
	 * Devuelve todas las actividades con el estado especificado
	 * @return
	 */
	public List<DtTouristicActivity> getListActivityStated(ActivityState state);
	
	/**
	 * Crea una nueva compra
	 * @param purchase -> datos de la compra.
	 */
	public void registerPurchase(DtPurchase purchase) throws Exception;
	
	public DtPurchase getPurchase(Long purchaseId);
	
	public List<DtPurchase> getPurchaseList();
}
