package uy.turismo.servidorcentral.logic.daos;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.PersistenceException;
import uy.turismo.servidorcentral.logic.entities.TouristicBundle;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class BundleDAOImpl implements BundleDAO {

	@Override
	public List<TouristicBundle> findAllBundles() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<TouristicBundle> bundles = session.createQuery("from Touristic_Bundle", TouristicBundle.class).list();
		session.close();
		return bundles;
	}

	
	@Override
	public TouristicBundle findBundleById(Long id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		TouristicBundle bundle = session.find(TouristicBundle.class, id);
		session.close();
		return bundle;
	}

	@Override
	public void createBundle(TouristicBundle bundle) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.persist(bundle);
			session.getTransaction().commit();
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo dar de alta el Paquete turístico: " + bundle.getName() +
					"\nError: " + e.getMessage());
		}
		session.close();
	}

	@Override
	public void updateBundle(TouristicBundle bundle) throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.merge(bundle);
			session.getTransaction().commit();
			
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo modificar el paquete turístico: " + bundle.getName() +
					"\nError: " + e.getMessage());
			
		}
		session.close();	
	}

}
