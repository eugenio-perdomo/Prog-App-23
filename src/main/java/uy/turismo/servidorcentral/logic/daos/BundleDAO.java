package uy.turismo.servidorcentral.logic.daos;

import uy.turismo.servidorcentral.logic.entities.TouristicBundle;
import java.util.List;



public interface BundleDAO {


	/**
	 * @return Devuelve una lista con los paquetes turisticos registrados en la bd. 
	 * */
	public List<TouristicBundle> findAllBundles();
	
	
	/**
	 * 
	 * @param id -> id del paquete turistico.
	 * @return Devuelve un paquete turistico especifico.
	 */
	public TouristicBundle findBundleById(Long id);
	
	/**
	 * 
	 * @param Bundle -> Paquete
	 * @throws Exception -> en caso de no poder crear un paquete.
	 */
	public void createBundle(TouristicBundle Bundle) throws Exception;
	
	/**
	 * 
	 * @param Bundle -> Paquete
	 * @throws Exception -> En caso de no poder agregar un paquete.
	 */
	public void updateBundle(TouristicBundle  Bundle) throws Exception;
	
}
