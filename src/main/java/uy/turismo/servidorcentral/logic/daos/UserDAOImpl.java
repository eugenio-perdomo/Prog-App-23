package uy.turismo.servidorcentral.logic.daos;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.JpaCriteriaDelete;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
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
	public ArrayList<User> findAll() {
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
		
		ArrayList<User> users = (ArrayList<User>) em
				.createQuery(cq)
				.getResultList();
	
		
		em.close();
		session.close();
		
		return users;
	}

	@Override
	public ArrayList<Tourist> findAllTourists() {
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
		
		ArrayList<Tourist> tourists = (ArrayList<Tourist>) em
				.createQuery(cq)
				.getResultList();
		
		em.close();
		session.close();
		
		// TODO Auto-generated method stub
		return tourists;
	}

	@Override
	public ArrayList<Provider> findAllProviders() {
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
		
		ArrayList<Provider> providers = (ArrayList<Provider>) em
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
	

	@Override
	public Boolean checkNick(String nickname) {
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

	    cq.select(entityRoot)
	    	.where(cb.equal(entityRoot.get("nickname"), nickname));
	    
	    try {
	    	User user = em
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

	@Override
	public Boolean checkEmail(String email) {
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

	    cq.select(entityRoot)
	    	.where(cb.equal(entityRoot.get("email"), email));

	    try {
	    	User user = em
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
}
