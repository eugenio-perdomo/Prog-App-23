package uy.turismo.servidorcentral.logic.daos;

import org.hibernate.Session;

import jakarta.persistence.PersistenceException;
import uy.turismo.servidorcentral.logic.entities.Inscription;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class InscriptionDAOImpl implements InscriptionDAO {

	@Override
	public void create(Inscription inscription) throws Exception {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		try {
			session.beginTransaction();
			session.persist(inscription);
			session.getTransaction().commit();
			
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo crear la Inscripcion.\nError: " + e.getMessage());
		}
		session.close();
	}

}
