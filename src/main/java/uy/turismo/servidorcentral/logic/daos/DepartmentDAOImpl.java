package uy.turismo.servidorcentral.logic.daos;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.PersistenceException;
import uy.turismo.servidorcentral.logic.entities.Department;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class DepartmentDAOImpl implements DepartmentDAO {

	@Override
	public List<Department> findAllDepartments(boolean alsoActivities) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Department> departments = session.createQuery("from Department", Department.class).list();
		return departments;
	}

	@Override
	public void createDepartment(Department department) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.persist(department);
			session.getTransaction().commit();
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo crear el departamento: " + department.getName() +
					"\nError: " + e.getMessage());
		}
		
		session.close();
	}

}
