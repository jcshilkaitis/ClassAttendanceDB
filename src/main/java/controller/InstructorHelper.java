package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
		
		public Instructor findInstructor(String nameToLookUp) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Instructor> typedQuery = em.createQuery("select i from Instructor i where i.name = :selectedName", Instructor.class);
			typedQuery.setParameter("selectedName", nameToLookUp);
			typedQuery.setMaxResults(1);
			Instructor foundInstructor;
			try {
				foundInstructor = typedQuery.getSingleResult();
			} catch (NoResultException ex) {
				foundInstructor = new Instructor(nameToLookUp);
			}
			em.close();
			return foundInstructor;
		}
	}

