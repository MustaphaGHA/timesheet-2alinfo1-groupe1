package tn.esprit.spring.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;

public class EntrepriseRequestModel {
	@Autowired
	Entreprise entreprise ;
	
	private int id;
	
	private String name;
	
	
	public EntrepriseRequestModel(Entreprise entreprise) {
		super();
		this.entreprise = entreprise;
	}


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
