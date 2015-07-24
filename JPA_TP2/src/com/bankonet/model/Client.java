package com.bankonet.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("C")
public class Client extends Personne {

	@Embedded
	private Adresse adresse;

	public Client (){
		
	}
	
  public Client(String nom, Adresse adresse) {
		super();
		this.setNom(nom);
		this.adresse = adresse;
	}

public Adresse getAdresse() {
    return adresse;
  }

  public void setAdresse(Adresse adresse) {
    this.adresse = adresse;
  }

  

}
