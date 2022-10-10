package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Instructor;

/**
 * @author Joe Shilkaitis - jshilkaitis
 * CIS175 - Fall 2022
 * Oct 8, 2022
 */
public class InstructorHelper {
		static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OnlineStudentDatabase");

		public void insertInstructor(Instructor i) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(i);
			em.getTransaction().commit();
			em.close();
		}

		public List<Instructor> showAllInstructors() {
		EntityManager em = emfactory.createEntityManager();
		List<Instructor> allInstructors = em.createQuery("SELECT i FROM Instructor i").getResultList();
		return allInstructors;
		}
	}

