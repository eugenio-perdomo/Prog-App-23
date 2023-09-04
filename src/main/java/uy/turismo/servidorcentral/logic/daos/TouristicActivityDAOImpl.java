package uy.turismo.servidorcentral.logic.daos;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import uy.turismo.servidorcentral.logic.entities.Department;
import uy.turismo.servidorcentral.logic.entities.Provider;
import uy.turismo.servidorcentral.logic.entities.TouristicActivity;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class TouristicActivityDAOImpl implements TouristicActivityDAO {

	@Override
	public void create(TouristicActivity touristicActivity) throws Exception {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		try {
			session.beginTransaction();
			session.persist(touristicActivity);
			session.getTransaction().commit();
			
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo crear la actividad turística : " + touristicActivity.getName() +
					"\nError: " + e.getMessage());
		}
		session.close();

	}

	@Override
	public TouristicActivity findById(Long id) {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		
		TouristicActivity activity = session
				.find(TouristicActivity.class, id);
		session.close();
		return activity;
	}

	@Override
	public List<TouristicActivity> findAll() {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		
		EntityManager em = session
				.getEntityManagerFactory()
				.createEntityManager();  
		
		CriteriaBuilder cb = em
				.getCriteriaBuilder();
		
		CriteriaQuery<TouristicActivity> cq = cb.createQuery(TouristicActivity.class);
		
		Root<TouristicActivity> entityRoot = cq.from(TouristicActivity.class);
		entityRoot.alias("touristic_activity");
		
		cq.select(entityRoot);
		
		List<TouristicActivity> activities = em
				.createQuery(cq)
				.getResultList();
		
		em.close();
		session.close();
		return activities;
	}

}
