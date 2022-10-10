package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
