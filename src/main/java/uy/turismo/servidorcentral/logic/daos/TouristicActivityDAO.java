package uy.turismo.servidorcentral.logic.daos;

import java.util.List;

import uy.turismo.servidorcentral.logic.entities.Department;
import uy.turismo.servidorcentral.logic.entities.Provider;
import uy.turismo.servidorcentral.logic.entities.TouristicActivity;

public interface TouristicActivityDAO {

	/**
	 * 
	 * @param touristicActivity -> Actividad turistica a crear
	 * @throws Exception -> En caso de no poder crear la actividad turistica
	 */
	public void create(TouristicActivity touristicActivity) throws Exception;
	
	/**
	 * 
	 * @param touristicActivityId -> identificador de actividad turistica a buscar.
	 * @return actividad turistica en particular
	 */
	
	public TouristicActivity findById(Long id);
	
	/**
	 * 
	 * @return Devuelve todas las actividades turisticas.
	 */
	
	public List<TouristicActivity> findAll();
	
	/**
	 * Devuelve una lista de las actividades de dicho proveedor
	 * @param provider
	 * @return
	 */
	
}
