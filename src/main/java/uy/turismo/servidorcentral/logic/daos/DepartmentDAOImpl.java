package uy.turismo.servidorcentral.logic.daos;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.PersistenceException;
import uy.turismo.servidorcentral.logic.entities.Department;
import uy.turismo.servidorcentral.logic.util.HibernateUtil;

public class DepartmentDAOImpl implements DepartmentDAO {

	@Override
	public List<Department> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Department> departments = session.createQuery("from Department", Department.class).list();
		session.close();
		return departments;
	}

	@Override
	public void create(Department department) throws Exception{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.persist(department);
			session.getTransaction().commit();
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo persistir el Departamento: " + department.getName() +
					"\nError: " + e.getMessage());
		}
		session.close();
	}

	@Override
	public void update(Department department) throws Exception{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.merge(department);
			session.getTransaction().commit();
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			session.close();
			throw new Exception("No se pudo actualizar el Departamento: " + department.getName() +
					"\nError: " + e.getMessage());
		}
		session.close();
		
	}

}
