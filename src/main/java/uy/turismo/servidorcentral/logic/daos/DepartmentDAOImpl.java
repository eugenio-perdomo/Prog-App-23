package uy.turismo.servidorcentral.logic.daos;

import java.util.ArrayList;

import org.hibernate.Session;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import uy.turismo.servidorcentral.logic.entities.Category;
import uy.turismo.servidorcentral.logic.entities.Department;
import uy.turismo.servidorcentral.logic.entities.Provider;
import uy.turismo.servidorcentral.logic.entities.User;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class DepartmentDAOImpl implements DepartmentDAO {
	
	/**
	 * Devuelve todos los departamentos de la BD.
	 * @return List<Department>
	 */
	@Override
	public ArrayList<Department> findAll() {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		
		EntityManager em = session
				.getEntityManagerFactory()
				.createEntityManager();  
		
		CriteriaBuilder cb = em
				.getCriteriaBuilder();
		
		CriteriaQuery<Department> cq = cb.createQuery(Department.class);
		
		Root<Department> entityRoot = cq.from(Department.class);
		entityRoot.alias("department");
		
		cq.select(entityRoot);
		
		ArrayList<Department> departments = (ArrayList<Department>) em
				.createQuery(cq)
				.getResultList();
		
		em.close();
		session.close();
		
		return departments;
	}

	@Override
	public void create(Department department) throws Exception {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		try {
			session.beginTransaction();
			session.persist(department);
			session.getTransaction().commit();
			
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo crear el Departamento : " + department.getName() +
					"\nError: " + e.getMessage());
		}
		session.close();

	}

	@Override
	public Department findById(Long id) {
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		
		Department department = session
				.find(Department.class, id);
		
		session.close();
		return department;
	}

}
