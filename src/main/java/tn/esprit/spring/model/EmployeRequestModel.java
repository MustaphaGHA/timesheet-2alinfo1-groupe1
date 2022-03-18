package tn.esprit.spring.model;


import tn.esprit.spring.entities.Role;


public class EmployeRequestModel {
	
	private String prenom;
	
	private String nom;
	
	private String email;

	private String password;
	
	private boolean actif;
	
	private Role role;

	public String getPrenomModel() {
		return prenom;
	}

	public void setPrenomModel(String prenom) {
		this.prenom = prenom;
	}

	public String getNomModel() {
		return nom;
	}

	public void setNomModel(String nom) {
		this.nom = nom;
	}

	public String getEmailModel() {
		return email;
	}

	public void setEmailModel(String email) {
		this.email = email;
	}

	public String getPasswordModel() {
		return password;
	}

	public void setPasswordModel(String password) {
		this.password = password;
	}

	public boolean isActifModel() {
		return actif;
	}

	public void setActifModel(boolean actif) {
		this.actif = actif;
	}

	public Role getRoleModel() {
		return role;
	}

	public void setRoleModel(Role role) {
		this.role = role;
	}
	
	
	
}
