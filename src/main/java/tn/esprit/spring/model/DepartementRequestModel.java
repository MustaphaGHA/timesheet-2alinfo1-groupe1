package tn.esprit.spring.model;

import java.util.List;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;

public class DepartementRequestModel {
	
	private int id;
	
	private String name;
	
	
	private List<Employe> employes;
	

	private List<Mission> missions;
	
	private Entreprise entreprise;

	

	public DepartementRequestModel(int id, String name, List<Employe> employes, List<Mission> missions,
			Entreprise entreprise) {
		super();
		this.id = id;
		this.name = name;
		this.employes = employes;
		this.missions = missions;
		this.entreprise = entreprise;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	

}
