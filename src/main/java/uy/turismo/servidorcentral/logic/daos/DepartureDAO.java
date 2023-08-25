package uy.turismo.servidorcentral.logic.daos;

import uy.turismo.servidorcentral.logic.entities.TouristicDeparture;

import uy.turismo.servidorcentral.logic.entities.TouristicActivity;

import java.util.List;

public interface DepartureDAO {

	
	/**
	 * 
	 * @return Devuelve una lista con todas las salidas turisticas.
	 */
	public List<TouristicDeparture> findAllDepartures();
	
	/**
	 * 
	 * @param id -> de la salida turistica
	 * @return
	 */
	public TouristicDeparture findDepartureById(Long id);
	
	/**
	 * 
	 * @param activityId -> identificador de la actividad turistica
	 * @return -> Devuelve una lista de las salidas turisticas de aquellas actividades turistcas cuyo id = activityId
	 */
	public List<TouristicDeparture> findDepartureByActivity(TouristicActivity activity);
	
	/**
	 * 
	 * @param departure -> salida turistica
	 * @throws Exception -> En caso de no poder crear una salida turistica.
	 */
	public void createDeparture(TouristicDeparture departure) throws Exception;
	
	
}
