package uy.turismo.servidorcentral.logic.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import uy.turismo.servidorcentral.logic.datatypes.DtUser;
import uy.turismo.servidorcentral.logic.entities.Provider;
import uy.turismo.servidorcentral.logic.entities.Tourist;
import uy.turismo.servidorcentral.logic.entities.TouristicActivity;
import uy.turismo.servidorcentral.logic.entities.User;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<User> findAll() {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		
		EntityManager em = session
				.getEntityManagerFactory()
				.createEntityManager();  
		
		CriteriaBuilder cb = em
				.getCriteriaBuilder();
		
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		
		Root<User> entityRoot = cq.from(User.class);
		entityRoot.alias("user");
		
//		cq.select(entityRoot);
		
	    cq.select(entityRoot);
		
		List<User> users = em
				.createQuery(cq)
				.getResultList();
	
		
		em.close();
		session.close();
		
		return users;
	}

	@Override
	public List<Tourist> findAllTourists() {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		
		EntityManager em = session
				.getEntityManagerFactory()
				.createEntityManager();  
		
		CriteriaBuilder cb = em
				.getCriteriaBuilder();
		
		CriteriaQuery<Tourist> cq = cb.createQuery(Tourist.class);
		
		Root<Tourist> entityRoot = cq.from(Tourist.class);
		entityRoot.alias("user");
		
		cq.select(entityRoot);
		
		List<Tourist> tourists = em
				.createQuery(cq)
				.getResultList();
		
		em.close();
		session.close();
		
		// TODO Auto-generated method stub
		return tourists;
	}

	@Override
	public List<Provider> findAllProviders() {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		
		EntityManager em = session
				.getEntityManagerFactory()
				.createEntityManager();  
		
		CriteriaBuilder cb = em
				.getCriteriaBuilder();
		
		CriteriaQuery<Provider> cq = cb.createQuery(Provider.class);
		
		Root<Provider> entityRoot = cq.from(Provider.class);
		entityRoot.alias("user");
		
		cq.select(entityRoot);
		
		List<Provider> providers = em
				.createQuery(cq)
				.getResultList();
		
		em.close();
		session.close();
		
		// TODO Auto-generated method stub
		return providers;
	}

	@Override
	public User findById(Long id) {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		User user = session
				.find(User.class, id);
		
		session.close();
		return user;
	}

	@Override
	public void create(User user) throws Exception {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		try {
			session.beginTransaction();
			session.persist(user);
			session.getTransaction().commit();
			
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo crear el Usuario : " + user.getNickname() +
					"\nError: " + e.getMessage());
		}
		session.close(); 
	
	}

	@Override
	public void update(User user) throws Exception {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		try {
			session.beginTransaction();
			session.merge(user);
			session.getTransaction().commit();
			
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo actualizar el Usuario : " + user.getNickname() +
					"\nError: " + e.getMessage());
		}
		
		
		session.close();

	}

	@Override
	public User checkCredentials(String email, String password) {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		
		EntityManager em = session
				.getEntityManagerFactory()
				.createEntityManager();  
		
		CriteriaBuilder cb = em
				.getCriteriaBuilder();
		
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		
		Root<User> entityRoot = cq.from(User.class);
		entityRoot.alias("user");
		
//		cq.select(entityRoot);
		
	    cq.select(entityRoot)
	    	.where( 
	    			cb.and(
	    					cb.equal(entityRoot.get("email"), email),
	    					cb.equal(entityRoot.get("password"), password)
	    			));
		
	    User user;
	    
	    try {
	    	user = em
	    			.createQuery(cq)
	    			.getSingleResult();
		} catch (Exception e) {
			em.close();
			session.close();
			return null;
		}
	
		
		em.close();
		session.close();
		
		return user;
	}

}
