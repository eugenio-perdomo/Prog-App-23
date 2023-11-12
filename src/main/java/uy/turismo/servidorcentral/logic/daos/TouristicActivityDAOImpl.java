package uy.turismo.servidorcentral.logic.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import uy.turismo.servidorcentral.logic.entities.Department;
import uy.turismo.servidorcentral.logic.entities.Provider;
import uy.turismo.servidorcentral.logic.entities.TouristicActivity;
import uy.turismo.servidorcentral.logic.entities.User;
import uy.turismo.servidorcentral.logic.enums.ActivityState;
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
	public ArrayList<TouristicActivity> findAll() {
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
		
		ArrayList<TouristicActivity> activities = (ArrayList<TouristicActivity>) em
				.createQuery(cq)
				.getResultList();
		
		em.close();
		session.close();
		return activities;
	}
	
	@Override
	public void update(TouristicActivity activity) throws Exception {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		try {
			session.beginTransaction();
			session.merge(activity);
			session.getTransaction().commit();
			
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo actualizar la Actividad : " + activity.getName() +
					"\nError: " + e.getMessage());
		}
		session.close();
	}

	public ArrayList<TouristicActivity> findAllbyState(ActivityState state) {
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
		
		cq.select(entityRoot).where(cb.equal(entityRoot.get("state"), state));
		
		ArrayList<TouristicActivity> activities = (ArrayList<TouristicActivity>) em
				.createQuery(cq)
				.getResultList();
		
		em.close();
		session.close();
		return activities;
	}

	@Override
	public Boolean checkName(String name) {
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

	    cq.select(entityRoot)
	    	.where(cb.equal(entityRoot.get("name"), name));

	    try {
	    	TouristicActivity activity = em
	    			.createQuery(cq)
	    			.getSingleResult();
		} catch (Exception e) {
			em.close();
			session.close();
			return false;
		}
	
		
		em.close();
		session.close();
		
		return true;

	}
	
	public List<TouristicActivity> findByNameDescription(String str){
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
		

        // Construir la expresión para la condición de búsqueda en el nombre
        Predicate nameCondition = cb.like(entityRoot.get("name"), "%" + str + "%");

        // Construir la expresión para la condición de búsqueda en la descripción
        Predicate descriptionCondition = cb.like(entityRoot.get("description"), "%" + str + "%");
        
        Predicate condition = cb.or(nameCondition, descriptionCondition);
        
        cq.select(entityRoot).where(condition);
        
        List<TouristicActivity> activities = em
        		.createQuery(cq)
        		.getResultList();
        
        return activities;
	}
	

}
