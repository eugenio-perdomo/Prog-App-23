package uy.turismo.servidorcentral.logic.daos;

import uy.turismo.servidorcentral.logic.entities.TouristicBundle;
import java.util.List;



public interface TouristicBundleDAO {
	/**
	 * @return Devuelve una lista con los paquetes turisticos registrados en la bd. 
	 * */
	public List<TouristicBundle> findAll();
	
	
	/**
	 * 
	 * @param id -> id del paquete turistico.
	 * @return Devuelve un paquete turistico especifico.
	 */
	public TouristicBundle findById(Long id);
	
	/**
	 * 
	 * @param Bundle -> Paquete
	 * @throws Exception -> en caso de no poder crear un paquete.
	 */
	public void create(TouristicBundle bundle) throws Exception;
	
	/**
	 * 
	 * @param Bundle -> Paquete
	 * @throws Exception -> En caso de no poder agregar un paquete.
	 */
	public void update(TouristicBundle  bundle) throws Exception;
	
}
