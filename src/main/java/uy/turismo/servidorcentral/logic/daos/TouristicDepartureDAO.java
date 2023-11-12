package uy.turismo.servidorcentral.logic.daos;

import uy.turismo.servidorcentral.logic.entities.TouristicDeparture;

import uy.turismo.servidorcentral.logic.entities.TouristicActivity;

import java.util.ArrayList;

public interface TouristicDepartureDAO {

	
	/**
	 * 
	 * @return Devuelve una lista con todas las salidas turisticas.
	 */
	public ArrayList<TouristicDeparture> findAll();
	
	/**
	 * 
	 * @param id -> de la salida turistica
	 * @return
	 */
	public TouristicDeparture findById(Long id);
	
	/**
	 * 
	 * @param activityId -> identificador de la actividad turistica
	 * @return -> Devuelve una lista de las salidas turisticas de aquellas actividades turisticas cuyo id = activityId
	 */
	public ArrayList<TouristicDeparture> findByActivity(TouristicActivity activity);
	
	/**
	 * 
	 * @param departure -> salida turistica
	 * @throws Exception -> En caso de no poder crear una salida turistica.
	 */
	public void create(TouristicDeparture departure) throws Exception;

	public void update(TouristicDeparture departure) throws Exception;

	public Boolean checkName(String name);
	
	
}
