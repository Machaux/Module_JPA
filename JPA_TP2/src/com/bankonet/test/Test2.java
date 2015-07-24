package com.bankonet.test;

import javax.persistence.*;
import com.bankonet.model.*;

/**
 * Teste la persistance de plusieurs classes, dont une "embedded".
 */
public class Test2 {

  public static void main(String[] args) {
    EntityManagerFactory emf = null;
    EntityManager em = null;
	EntityTransaction tx = null;
    try {
      emf = Persistence.createEntityManagerFactory("Employes");
      em = emf.createEntityManager();
      tx = em.getTransaction();
      tx.begin();
      // Création des 3 départements
      Departement dept1 = new Departement("Direction", "Nice");
      Departement dept2 = new Departement("Comptabilité", "Nice");
      Departement dept3 = new Departement("Gestion personnel", "Nantes");
      em.persist(dept1);
      em.persist(dept2);
      em.persist(dept3);
      dept1.setLieu("Paris");
      // 2 clients avec leur adresse
      Adresse ad1 = new Adresse(36, "avenue Cyrnos", "Paris");
      Client client1 = new Client("Bibi", ad1);
      em.persist(client1);
      Adresse ad2 = new Adresse(50, "rue Victor Hugo", "Paris");
      Client client2 = new Client("Toto", ad2);
      em.persist(client2);
      // Création des 3 employés
      Employe emp1 = new Employe("Dupond");
      Employe emp2 = new Employe("Durand", dept2, emp1);
      Employe emp3 = new Employe("Legrand", dept1, null);
      em.persist(emp1);
      em.persist(emp2);
      em.persist(emp3);
      dept1.addEmploye(emp1);
      dept1.addEmploye(emp3);
      dept2.addEmploye(emp3);
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

