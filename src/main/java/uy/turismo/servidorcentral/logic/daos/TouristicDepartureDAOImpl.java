package uy.turismo.servidorcentral.logic.daos;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import uy.turismo.servidorcentral.logic.entities.TouristicActivity;
import uy.turismo.servidorcentral.logic.entities.TouristicDeparture;
import uy.turismo.servidorcentral.logic.entities.User;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class TouristicDepartureDAOImpl implements TouristicDepartureDAO {

	@Override
	public List<TouristicDeparture> findAll() {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		
		EntityManager em = session
				.getEntityManagerFactory()
				.createEntityManager();  
		
		CriteriaBuilder cb = em
				.getCriteriaBuilder();
		
		CriteriaQuery<TouristicDeparture> cq = cb.createQuery(TouristicDeparture.class);
		
		Root<TouristicDeparture> entityRoot = cq.from(TouristicDeparture.class);
		entityRoot.alias("user");
		
		cq.select(entityRoot);
		
		List<TouristicDeparture> departures = em
				.createQuery(cq)
				.getResultList();
		
		em.close();
		session.close();
		
		// TODO Auto-generated method stub
		return departures;
	}

	@Override
	public TouristicDeparture findById(Long id) {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		TouristicDeparture departure = session
				.find(TouristicDeparture.class, id);
		
		session.close();
		return departure;
	}

	@Override
	public List<TouristicDeparture> findByActivity(TouristicActivity activity) {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		
		EntityManager em = session
				.getEntityManagerFactory()
				.createEntityManager(); 
		
		CriteriaBuilder cb = em
				.getCriteriaBuilder();
		
		CriteriaQuery<TouristicDeparture> cq = cb.createQuery(TouristicDeparture.class);
		
		Root<TouristicDeparture> entityRoot = cq.from(TouristicDeparture.class);
		entityRoot.alias("touristic_departure");
		
		cq.where(cb.equal(entityRoot.get("touristicActivity"), activity)).select(entityRoot);
		
		List<TouristicDeparture> departures = em
				.createQuery(cq)
				.getResultList();
		
		em.close();
		session.close();
		
		return departures;
	}

	@Override
	public void create(TouristicDeparture departure) throws Exception {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		try {
			session.beginTransaction();
			session.persist(departure);
			session.getTransaction().commit();
			
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo crear la Salida : " + departure.getName() +
					"\nError: " + e.getMessage());
		}
		session.close();
	}

}
