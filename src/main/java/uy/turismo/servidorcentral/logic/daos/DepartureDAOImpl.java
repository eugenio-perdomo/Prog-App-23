package uy.turismo.servidorcentral.logic.daos;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.PersistenceException;
import uy.turismo.servidorcentral.logic.entities.TouristicActivity;
import uy.turismo.servidorcentral.logic.entities.TouristicDeparture;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class DepartureDAOImpl implements DepartureDAO {

	@Override
	public List<TouristicDeparture> findAllDepartures() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<TouristicDeparture> departures = session.createQuery("from Touristic_Departure", TouristicDeparture.class).list();
		session.close();
		return departures;
	}

	@Override
	public TouristicDeparture findDepartureById(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		TouristicDeparture departure = session.find(TouristicDeparture.class, id);
		session.close();
		return departure;
	}

	@Override
	//revisar aca.
	public List<TouristicDeparture> findDepartureByActivity(TouristicActivity activity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<TouristicDeparture> departuresByActivities = (List<TouristicDeparture>) session.find(TouristicDeparture.class,activity.getTouristicDepartures());
		session.close();		
		return departuresByActivities;
	}

	@Override
	public void createDeparture(TouristicDeparture departure) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.persist(departure);
			session.getTransaction().commit();
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo dar de alta la salida turistica: " + departure.getName() +
					"\nError: " + e.getMessage());
		}
		session.close();		
	}

}
