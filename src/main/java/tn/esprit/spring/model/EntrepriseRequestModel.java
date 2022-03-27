package tn.esprit.spring.model;

import java.util.ArrayList;
import java.util.List;
import tn.esprit.spring.entities.Departement;

public class EntrepriseRequestModel {
private int id;
	
	private String name;
	
	
	private String raisonSocial;
	

	private List<Departement> departements = new ArrayList<>();


	public int getIdModel() {
		return id;
	}


	public void setIdModel(int id) {
		this.id = id;
	}


	public String getNameModel() {
		return name;
	}


	public void setNameModel(String name) {
		this.name = name;
	}


	public String getRaisonSocialModel() {
		return raisonSocial;
	}


	public void setRaisonSocialModel(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}


	public List<Departement> getDepartementsModel() {
		return departements;
	}


	public void setDepartementsModel(List<Departement> departements) {
		this.departements = departements;
	}
	


}
