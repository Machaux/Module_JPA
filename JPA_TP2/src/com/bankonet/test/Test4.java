package com.bankonet.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bankonet.model.Employe;
import com.bankonet.model.Projet;

public class Test4 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = null;
	    EntityManager em = null;
		EntityTransaction tx = null;
	    try {
	      emf = Persistence.createEntityManagerFactory("Employes");
	      em = emf.createEntityManager();
	      tx = em.getTransaction();
	      tx.begin();
	      
	      // Création des 3 employés
	      Employe emp1 = new Employe("Dupond");
	      Employe emp2 = new Employe("Durand");
	      Employe emp3 = new Employe("Legrand");
	      em.persist(emp1);
	      em.persist(emp2);
	      em.persist(emp3);
	      
	      // 2 Projets
	      Projet proj1 = new Projet("Projet1");
	      Projet proj2 = new Projet("Projet2");
	      em.persist(proj1);
	      em.persist(proj2);
	     
	      // répartition des employés dans les projets.
	      emp1.ajouterParticipation(proj1, "chef de projet");
	      emp1.ajouterParticipation(proj2, "secretaire");
	      emp2.ajouterParticipation(proj1, "chercheur de café");
	      emp3.ajouterParticipation(proj2, "casseur de code");
	      
	      
	      tx.commit();
	    }
	    catch(Exception e) {
	      e.printStackTrace();
	      if (tx != null) {
	        tx.rollback();
	      }
	    }
	    finally {
	      if (em != null) {
	        em.close();
	      }
	      if (emf != null) {
	        emf.close();
	      }
	    }
	}

}
