package com.bankonet.test;

import javax.persistence.*;

import com.bankonet.model.Departement;

/**
 * Teste la persistance de la classe Departement.
 */
public class Test1 {

  public static void main(String[] args) {
    
	EntityManagerFactory emf = null;
    EntityManager em = null;
    
    emf = Persistence.createEntityManagerFactory("Employes");
    em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    
    
    try {
    	tx.begin();
	      Departement dept = new Departement("Direction", "Nice");
	      Departement dept2 = new Departement("Comptabilité", "Nice");
	      @SuppressWarnings("unused")
		Departement dept3 = new Departement("Gestion personnel", "Nantes");
	      em.persist(dept);
	      em.persist(dept2);
	      dept.setLieu("Paris");
	      tx.commit();
    }
    catch(Exception e) {
      // En "vrai" il faudrait affiner un peu plus...
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
