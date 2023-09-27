package uy.turismo.servidorcentral.logic.daos;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import uy.turismo.servidorcentral.logic.entities.Category;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class CategoryDAOImpl implements CategoryDAO{

	@Override
	public List<Category> findAll() {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		
		EntityManager em = session
				.getEntityManagerFactory()
				.createEntityManager();  
		
		CriteriaBuilder cb = em
				.getCriteriaBuilder();
		
		CriteriaQuery<Category> cq = cb.createQuery(Category.class);
		
		Root<Category> entityRoot = cq.from(Category.class);
		entityRoot.alias("touristic_bundle");
		
		cq.select(entityRoot);
		
		List<Category> categories = em
				.createQuery(cq)
				.getResultList();
		
		em.close();
		session.close();
	
		return categories;
	}

	@Override
	public void create(Category category) throws Exception {
		
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		try {
			session.beginTransaction();
			session.persist(category);
			session.getTransaction().commit();
			
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo crear la categoría : " + category.getName() +
					"\nError: " + e.getMessage());
		}
		session.close();
	}

}
