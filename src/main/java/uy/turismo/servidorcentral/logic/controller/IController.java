package uy.turismo.servidorcentral.logic.controller;


import java.util.ArrayList;
import java.util.List;

import uy.turismo.servidorcentral.logic.datatypes.DtUser;
import uy.turismo.servidorcentral.logic.enums.ActivityState;
import uy.turismo.servidorcentral.logic.enums.EntityType;
import uy.turismo.servidorcentral.logic.datatypes.DtBaseEntity;
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
	public DtUser checkCredentials(String email, String password);
	
	/**
	 * Checkea si existe un usuario con el nickname en cuestion
	 * @param userNickname 
	 * @return
	 */
	public Boolean existsNick(String userNickname);
	
	/**
	 * Checkea si existe un usuario con el email en cuestion
	 * @param userEmail
	 * @return
	 */
	public Boolean existsEmail(String userEmail);
	
	/**
	 * Devuelve una lista con Actividades y Paquetes cuyos nombres o descipciones
	 * contieneten una cadena de caracteres especifica
	 * @param str Cadena de caracteres a buscar que debe coincidir 
	 * @return Lista de Actividades y Paquetes 
	 */
	public List<DtBaseEntity> filterByString(String str);
	
	/**
	 * Devuelve una Lista de DtUser con id, nickname y email
	 * @return ArrayList<DtUser>
	 * @throws Exception 
	 */
	public ArrayList<DtUser> getListUser();
	
	/**
	 * Checkea si ya existe un determinada entidad con ese nombre
	 * @param name Nombre de la entidad
	 * @param entityType Tipo de entidad: Activity, Departure
	 * @return true si ya existe una entidad con ese nombre y false si no
	 */
	public Boolean existsName(String name, EntityType entityType );
	
	/**
	 * Busca y devuelve los datos de un usuario
	 * @param id del usuario a encontrar
	 * @return DtUser
	 * @throws Exception 
	 */
	public DtUser getUserData(Long id) ;
	
	
	/**
	 * Devuelve una lista de todos los Turistas con el nickname, el email y su id.
	 * @return ArrayList<DtTourist>
	 * @throws Exception 
	 */
	public ArrayList<DtTourist>  getListTourist();
	
	/**
	 * Devuelve una lista de todos los Turistas con el nickname, el email y su id.
	 * @return ArrayList<DtProvider>
	 * @throws Exception 
	 */
	public ArrayList<DtProvider>  getListProvider();
	
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
	public void registerUser(DtUser userData); //TODO: WS
	
	
	/**
	 * Devuelve una lista con el id, el nombre de todos los Departamentos. Si el parametro alsoActivities es true, tambien devuelve las Actividades que se hacen en el Departamento
	 * @param alsoActivities
	 * @return ArrayList<DtDepartment>
	 */
	public ArrayList<DtDepartment> getListDepartment(Boolean alsoActivities); 

	
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
	public ArrayList<DtTouristicDeparture> getDeparturesByActivity(Long touristicActivityId); 
	

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
	 * @return ArrayList<DtTouristicDeparture>
	 */
	public ArrayList<DtTouristicDeparture> getListTouristicDeparture(); 
	
	/**
	 * Devuelve una lista con el id y el nombre de todas las Salidas Turisticas
	 * @return ArrayList<DtTouristicActivity>
	 */
	public ArrayList<DtTouristicActivity> getListTouristicActivityWithVisits();
	
	/**
	 * Devuelve una lista con el id y el nombre de todos los Paquetes Turisticos
	 * @return ArrayList<DtTouristBundle>
	 */
	public ArrayList<DtTouristicBundle> getListTouristicBundle();

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
	public DtTouristicBundle getTouristicBundleData(Long touristicBundleId);

	/**
	 * Agrega una actividad turistica a un paquete turistico
	 * @param touristicBundleId
	 * @param touristicActivityId
	 */
	public void addTouristicActivityToBundle(Long touristicBundleId, Long touristicActivityId);
	
	public DtTouristicDeparture getTouristicDepartureData(long touristicDepartureId);

	void registerInscription(DtInscription inscriptionData);
	
	/**
	 * Registra una nueva categoria.
	 * @param category -> Datos de la categoria a registrar
	 */
	public void registerCategory(DtCategory category);
	
	/**
	 * 
	 * @return devuelve una  lista  de categorias con nombre e id.
	 */
	public ArrayList<DtCategory>  getListCategory();

	//public DtCategory getCategory(Long categoryId);
	
	
	/**
	 * Cambia el estado de una Actividad turistica
	 * @param touristicActivityData
	 */
	public void changeActivityState(Long id, ActivityState state) throws Exception;
	
	/**
	 * Devuelve todas las actividades con el estado especificado
	 * @return
	 */
	public ArrayList<DtTouristicActivity> getListActivityStated(ActivityState state);
	
	/**
	 * Crea una nueva compra
	 * @param purchase -> datos de la compra.
	 */
	public void registerPurchase(DtPurchase purchase);
	
	/**
	 * Devuelve los datos de una compra
	 * @param purchaseId -> identificador de la compra
	 * @return
	 */
	public DtPurchase getPurchase(Long purchaseId);
	
	/**
	 * Devuelve una lista de compras.
	 * @return
	 */
	public ArrayList<DtPurchase> getPurchaseList();
	
	/**
	 * Operacion para que un usuario pueda seguir a otro.
	 * @param userId -> Id del usuario seguidor. SEGUIDOR
	 * @param userToFollowId -> Id del usuario a seguir. SEGUIDO
	 */
	public void followUser(Long userId, Long userToFollowId);
	
	/**
	 * Operacion para que un usuario pueda dejar de seguir a otro.
	 * @param userId -> Id del usuario que quiere dejar de seguir.
	 * @param userToUnFollowId -> Id del usuario a dejar  de seguir.
	 */
	public void unFollowUser(Long userId, Long userToUnFollowId);
	
	/**
	 * Operacion para marcar una activdad turistica como favorita.
	 * @param userId -> id del usuario(en sesion) que quiere marcar la actividad como favorita.
	 * @param activityId -> actividad a la que se quiere marcar como favorita.
	 */
	public void markFavoriteActivty(Long userId, Long activityId);
	
	/**
	 * Operacion para desmarcar una activdad turistica como favorita.
	 * @param userId id del usuario(en sesion) que quiere desmarcar la actividad como favorita.
	 * @param acitivtyId actividad a la que se quiere desmarcar como favorita.
	 */
	public void unMarkFavoriteActivity(Long userId, Long acitivtyId);

}
