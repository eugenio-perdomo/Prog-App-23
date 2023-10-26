package uy.turismo.servidorcentral.logic.daos;

import org.hibernate.Session;

import jakarta.persistence.PersistenceException;
import uy.turismo.servidorcentral.logic.entities.Purchase;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class PurchaseDAOImpl implements PurchaseDAO {

	@Override
	public void create(Purchase purchase) throws Exception {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		try {
			session.beginTransaction();
			session.persist(purchase);
			session.getTransaction().commit();
			
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo crear la compra del turista: " + purchase.getTourist().getName() +
					"\nError: " + e.getMessage());
		}
		session.close();
		
	}

	@Override
	public Purchase findById(Long purchaseId) {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		
		Purchase purchase = session.find(Purchase.class, purchaseId);
		session.close();
		
		return purchase;
	}

}
