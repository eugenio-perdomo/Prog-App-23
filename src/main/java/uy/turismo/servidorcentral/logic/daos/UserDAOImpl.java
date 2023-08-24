package uy.turismo.servidorcentral.logic.daos;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.PersistenceException;
import uy.turismo.servidorcentral.logic.entities.Provider;
import uy.turismo.servidorcentral.logic.entities.Tourist;
import uy.turismo.servidorcentral.logic.entities.User;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	public UserDAOImpl() {
		
	}
	
	@Override
	public List<User> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<User> users = session.createQuery("from User", User.class).list();
		session.close();
		return users;
	}

	@Override
	public List<Tourist> findAllTourists() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Tourist> tourists = session.createQuery("from Tourist", Tourist.class).list();
		session.close();
		return tourists;
	}

	@Override
	public List<Provider> findAllProviders() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Provider> providers = session.createQuery("from Provider", Provider.class).list();
		session.close();
		return providers;
	}

	@Override
	public User findById(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		User user = session.find(User.class, id);
		
		session.close();
		
		return user;
	}

	@Override
	public void create(User user) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.persist(user);
			session.getTransaction().commit();
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo persistir el Usuario: " + user.getNickname() +
					"\nError: " + e.getMessage());
		}
		
		session.close();
	}

	@Override
	public void update(User user) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.merge(user);
			session.getTransaction().commit();
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo actualizar el Usuario: " + user.getNickname() +
					"\nError: " + e.getMessage());
		}
		
		session.close();
		
	}
	

}
