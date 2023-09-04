package uy.turismo.servidorcentral.logic.daos;

import uy.turismo.servidorcentral.logic.entities.Inscription;

public interface InscriptionDAO {
	
	/**
	 * Persiste una nueva inscripcion en la BD
	 * @param inscription
	 */
	public void create (Inscription inscription) throws Exception;
}
