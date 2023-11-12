package uy.turismo.servidorcentral.logic.daos;

import java.util.ArrayList;

import uy.turismo.servidorcentral.logic.entities.Purchase;

public interface PurchaseDAO {

	/**
	 * Crea una nueva compra de paquete de un usuario.
	 * 
	 * @param purchase -> datos de la compra
	 * @throws Exception -> Excepcion en caso de fallar
	 */
	public void create(Purchase purchase) throws Exception;
	
	/**
	 * Busca y devuelve una compra por id
	 * @param purchaseId -> id de la compra
	 * @return -> compra que devuelve
	 */
	public Purchase findById(Long purchaseId);
	
	/**
	 * Devuelve todas las compras
	 * @return -> List<Purchase>
	 */
	public ArrayList<Purchase> findAll();
	
	
}
