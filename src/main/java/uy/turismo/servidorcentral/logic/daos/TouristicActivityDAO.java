package uy.turismo.servidorcentral.logic.daos;

import java.util.ArrayList;
import java.util.List;

import uy.turismo.servidorcentral.logic.entities.Department;
import uy.turismo.servidorcentral.logic.entities.Provider;
import uy.turismo.servidorcentral.logic.entities.TouristicActivity;
import uy.turismo.servidorcentral.logic.enums.ActivityState;

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
	
	public ArrayList<TouristicActivity> findAll();
	
	public ArrayList<TouristicActivity> findAllbyState(ActivityState state);
	
	public void update(TouristicActivity activity) throws Exception;
	
	public Boolean checkName(String name);

	/**
	 * Devuelve todas las Actividades cuyo nombre o descripcion contenga una cadena de caracteres especifica
	 * @param str
	 * @return
	 */
	public List<TouristicActivity> findByNameDescription(String str);
	
}
