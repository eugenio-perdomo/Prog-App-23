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
import uy.turismo.servidorcentral.logic.entities.TouristicBundle;
import uy.turismo.servidorcentral.logic.entities.TouristicBundle;
import uy.turismo.servidorcentral.logic.entities.User;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class TouristicBundleDAOImpl implements TouristicBundleDAO {

	@Override
	public ArrayList<TouristicBundle> findAll() {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		
		EntityManager em = session
				.getEntityManagerFactory()
				.createEntityManager();  
		
		CriteriaBuilder cb = em
				.getCriteriaBuilder();
		
		CriteriaQuery<TouristicBundle> cq = cb.createQuery(TouristicBundle.class);
		
		Root<TouristicBundle> entityRoot = cq.from(TouristicBundle.class);
		entityRoot.alias("touristic_bundle");
		
//		criteriaQuery.where(criteriaBuilder.equal(entidadRoot.get("id"), idBuscado));
		
		cq.select(entityRoot);
		
		ArrayList<TouristicBundle> bundles = (ArrayList<TouristicBundle>) em
				.createQuery(cq)
				.getResultList();
		
		em.close();
		session.close();
		
		// TODO Auto-generated method stub
		return bundles;
	}

	@Override
	public TouristicBundle findById(Long id) {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		TouristicBundle bundle = session
				.find(TouristicBundle.class, id);
		
		session.close();
		return bundle;
	}

	@Override
	public void create(TouristicBundle bundle) throws Exception {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		try {
			session.beginTransaction();
			session.persist(bundle);
			session.getTransaction().commit();
			
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo crear el Paquete : " + bundle.getName() +
					"\nError: " + e.getMessage());
		}
		session.close();

	}

	@Override
	public void update(TouristicBundle bundle) throws Exception {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		try {
			session.beginTransaction();
			session.merge(bundle);
			session.getTransaction().commit();
			
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo actualizar el Paquete : " + bundle.getName() +
					"\nError: " + e.getMessage());
		}
		session.close();
	}
	
	//preguntar si esto está, con tilde, bien
	@Override
	public ArrayList<TouristicBundle> findPurchaseless() {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		
		EntityManager em = session
				.getEntityManagerFactory()
				.createEntityManager();  
		
		CriteriaBuilder cb = em
				.getCriteriaBuilder();
		
		CriteriaQuery<TouristicBundle> cq = cb.createQuery(TouristicBundle.class);
		
		Root<TouristicBundle> entityRoot = cq.from(TouristicBundle.class);
		entityRoot.alias("touristic_bundle");
		
		cq.select(entityRoot).where(cb.isNull(entityRoot.get("purchases")));
		
		ArrayList<TouristicBundle> bundles = (ArrayList<TouristicBundle>) em
				.createQuery(cq)
				.getResultList();
		
		em.close();
		session.close();
		
		return bundles;
	}
	
	public List<TouristicBundle> findByNameDescription(String str){
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		
		EntityManager em = session
				.getEntityManagerFactory()
				.createEntityManager();  
		
		CriteriaBuilder cb = em
				.getCriteriaBuilder();
		
		CriteriaQuery<TouristicBundle> cq = cb.createQuery(TouristicBundle.class);

		Root<TouristicBundle> entityRoot = cq.from(TouristicBundle.class);
		

        // Construir la expresión para la condición de búsqueda en el nombre
        Predicate nameCondition = cb.like(entityRoot.get("name"), "%" + str + "%");

        // Construir la expresión para la condición de búsqueda en la descripción
        Predicate descriptionCondition = cb.like(entityRoot.get("description"), "%" + str + "%");
        
        Predicate condition = cb.or(nameCondition, descriptionCondition);
        
        cq.select(entityRoot).where(condition);
        
        List<TouristicBundle> bundles = em
        		.createQuery(cq)
        		.getResultList();
        
        return bundles;
	}

}
