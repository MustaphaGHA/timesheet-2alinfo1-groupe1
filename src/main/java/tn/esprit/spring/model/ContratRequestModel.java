package tn.esprit.spring.model;

import java.util.Date;

public class ContratRequestModel {

	private Date dateDebut;
	
	private String typeContrat;
	

	private float salaire;

	public Date getDateDebutModel() {
		return dateDebut;
	}

	public void setDateDebutModel(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getTypeContratModel() {
		return typeContrat;
	}

	public void setTypeContratModel(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public float getSalaireModel() {
		return salaire;
	}

	public void setSalaireModel(float salaire) {
		this.salaire = salaire;
	}
	
	

}
