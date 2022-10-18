package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ClassAttendance;

/**
 * @author Joe Shilkaitis - jshilkaitis
 * CIS175 - Fall 2022
 * Oct 7, 2022
 */
public class ClassAttendanceHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OnlineStudentDatabase");

	public void insertNewClassAttendance(ClassAttendance ca) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ca);
		em.getTransaction().commit();
		em.close();
	}

	public List<ClassAttendance> getAttendance() {
		EntityManager em = emfactory.createEntityManager();
		List<ClassAttendance> allAttendance = em.createQuery("SELECT d FROM ClassAttendance d").getResultList();
		return allAttendance;
	}
	
	public void deleteClass(ClassAttendance classToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ClassAttendance> typedQuery = em.createQuery("select c from ClassAttendance c where c.id = :id", ClassAttendance.class);
		typedQuery.setParameter("id", classToDelete.getId());
		typedQuery.setMaxResults(1);
		ClassAttendance result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public ClassAttendance searchForClassAttendanceById(Integer id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ClassAttendance found = em.find(ClassAttendance.class, id);
		em.close();
		return found;
	}
	
	public void updateClass(ClassAttendance classToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(classToEdit);
		em.getTransaction().commit();
		em.close();
	}
}
