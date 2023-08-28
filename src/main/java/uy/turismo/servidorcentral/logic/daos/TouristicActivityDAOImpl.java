package uy.turismo.servidorcentral.logic.daos;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.PersistenceException;
import uy.turismo.servidorcentral.logic.entities.Department;
import uy.turismo.servidorcentral.logic.entities.TouristicActivity;
import uy.turismo.servidorcentral.logic.entities.User;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class TouristicActivityDAOImpl implements TouristicActivityDAO{

	@Override
	public void createTouristicActivity(TouristicActivity touristicActivity) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
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
	public TouristicActivity getTouristicActivityData(Long touristicActivityId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		TouristicActivity touristicActivity = session.find(TouristicActivity.class, touristicActivityId);
		return touristicActivity;
	}

	@Override
	public List<TouristicActivity> getAllTouristicActivities() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<TouristicActivity> activities = session.createQuery("from Touristic_Activity", TouristicActivity.class).list();
		return activities;
	}

}
