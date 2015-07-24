package com.bankonet.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TestEntity
 *
 */
@Entity

public class TestEntity implements Serializable {

	   
	@Id
	private long id;
	private String nom;
	private String prenom;
	private int salaire;
	private static final long serialVersionUID = 1L;

	public TestEntity() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public int getSalaire() {
		return this.salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
   
}
