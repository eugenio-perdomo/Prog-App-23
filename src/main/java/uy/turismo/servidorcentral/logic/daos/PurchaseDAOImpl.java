package uy.turismo.servidorcentral.logic.daos;

import org.hibernate.Session;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import uy.turismo.servidorcentral.logic.entities.Purchase;
import uy.turismo.servidorcentral.logic.entities.User;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

import java.util.ArrayList;
import java.util.ArrayList;

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
	
	public ArrayList<Purchase> findAll()
	{
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		
		EntityManager em = session
				.getEntityManagerFactory()
				.createEntityManager();  
		
		CriteriaBuilder cb = em
				.getCriteriaBuilder();
		
		CriteriaQuery<Purchase> cq = cb.createQuery(Purchase.class);
		
		Root<Purchase> entityRoot = cq.from(Purchase.class);
		entityRoot.alias("purchase");
		
		cq.select(entityRoot);
		
		ArrayList<Purchase> purchase = (ArrayList<Purchase>) em
				.createQuery(cq)
				.getResultList();
	
		
		em.close();
		session.close();
		
		return purchase;
	}

}
