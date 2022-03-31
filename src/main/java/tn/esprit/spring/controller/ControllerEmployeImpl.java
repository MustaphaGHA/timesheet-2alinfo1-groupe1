package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.services.IEmployeService;

@Scope(value = "session")
@Controller(value = "employeController")
@ELBeanName(value = "employeController")
@Join(path = "/", to = "/login.jsf")
public class ControllerEmployeImpl {

	static final Logger l = Logger.getLogger(ControllerEmployeImpl.class);
	private static final String LOGIN_REDIRECT_TRUE = "/login.xhtml?faces-redirect=true";

	@Autowired
	IEmployeService employeService;

	private String login;
	private String password;
	private Boolean loggedIn;

	private Employe authenticatedUser = null;
	private String prenom;
	private String nom;
	private String email;
	private boolean actif;
	private Role role;

	public Role[] getRoles() {
		return Role.values();
	}

	private List<Employe> employes;

	private Integer employeIdToBeUpdated; // getter et setter

	public String doLogin() {
		String navigateTo = "null";
		authenticatedUser = employeService.authenticate(login, password);
		if (authenticatedUser != null && authenticatedUser.getRole() == Role.ADMINISTRATEUR) {
			navigateTo = "/pages/admin/welcome.xhtml?faces-redirect=true";
			loggedIn = true;
			l.info("User " + login + " is Logged in");
		}

		else {

			FacesMessage facesMessage = new FacesMessage(
					"Login Failed: Please check your username/password and try again.");
			FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
			l.error("Login Failed: Please check your username/password and try again.");
		}
		return navigateTo;
	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		l.info("Logged out sucessfully");

		return LOGIN_REDIRECT_TRUE;
	}

	public String addEmploye() {
		if (authenticatedUser == null || !loggedIn)
			return LOGIN_REDIRECT_TRUE;
		try {
			employeService.addOrUpdateEmploye(new Employe(nom, prenom, email, password, actif, role));
			l.info("Employe added Successfully");
		} catch (Exception e) {
			l.error("Failed to add an employe");
			l.debug(e.getStackTrace());
		}
		return "null";

	}

	public String removeEmploye(int employeId) {
		String navigateTo = "null";
		if (authenticatedUser == null || !loggedIn)
			return LOGIN_REDIRECT_TRUE;
		try {
			employeService.deleteEmployeById(employeId);
			l.info("Employe removed Successfully");
		} catch (Exception e) {
			l.error("Failed to remove an employe");
			l.debug(e.getStackTrace());
		}
		return navigateTo;
	}

	public String displayEmploye(Employe empl) {
		String navigateTo = "null";
		if (authenticatedUser == null || !loggedIn)
			return LOGIN_REDIRECT_TRUE;

		empl.setPrenom(empl.getPrenom());
		empl.setNom(empl.getNom());
		empl.setActif(empl.isActif());
		empl.setEmail(empl.getEmail());
		empl.setRole(empl.getRole());
		this.setPassword(empl.getPassword());
		this.setEmployeIdToBeUpdated(empl.getId());
		l.info("Employee : " + empl.toString());

		return navigateTo;

	}

	public String updateEmploye() {
		String navigateTo = "null";

		if (authenticatedUser == null || !loggedIn)
			return LOGIN_REDIRECT_TRUE;
		try {
			employeService
					.addOrUpdateEmploye(new Employe(employeIdToBeUpdated, nom, prenom, email, password, actif, role));
			l.info("Employe updated successfully!");
		} catch (Exception e) {
			l.error("Failed to update an employe");
			l.debug(e.getStackTrace());
		}
		return navigateTo;

	}

	// getters and setters

	public IEmployeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(IEmployeService employeService) {
		this.employeService = employeService;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Employe> getAllEmployes() {
		return employeService.getAllEmployes();
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public int ajouterEmploye(Employe employe) {
		try {
			employeService.addOrUpdateEmploye(employe);
			l.info("Employe added successfully!");
		} catch (Exception e) {
			l.error("Failed to add an employe");
			l.debug(e.getStackTrace());
		}
		return employe.getId();
	}

	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		try {
			employeService.mettreAjourEmailByEmployeId(email, employeId);
			l.info("Employe updated successfully!");
		} catch (Exception e) {
			l.error("Failed to update an employe");
			l.debug(e.getStackTrace());
		}

	}

	public void affecterEmployeADepartement(int employeId, int depId) {
		try {
			employeService.affecterEmployeADepartement(employeId, depId);
			l.info("Department affected successfully!");
		} catch (Exception e) {
			l.error("Failed to affect a department to an employe");
			l.debug(e.getStackTrace());
		}

	}

	public void desaffecterEmployeDuDepartement(int employeId, int depId) {
		try {
			employeService.desaffecterEmployeDuDepartement(employeId, depId);
			l.info("Department unaffected successfully!");
		} catch (Exception e) {
			l.error("Failed to unaffect a department to an employe");
			l.debug(e.getStackTrace());
		}
	}

	public int ajouterContrat(Contrat contrat) {
		try {
			employeService.ajouterContrat(contrat);
			l.info("Contract added successfully!");
		} catch (Exception e) {
			l.error("Failed to add a contract");
			l.debug(e.getStackTrace());
		}
		return contrat.getReference();
	}

	public void affecterContratAEmploye(int contratId, int employeId) {
		try {
			employeService.affecterContratAEmploye(contratId, employeId);
			l.info("Contract affected successfully!");
		} catch (Exception e) {
			l.error("Failed to affect a contract");
			l.debug(e.getStackTrace());
		}
	}

	public String getEmployePrenomById(int employeId) {
		return employeService.getEmployePrenomById(employeId);
	}

	public void deleteEmployeById(int employeId) {
		try {
			employeService.deleteEmployeById(employeId);
			l.info("Employe deleted successfully , employe's id : "+employeId);
		} catch (Exception e) {
			l.error("Failed to delete an employe by id :"+employeId);
			l.debug(e.getStackTrace());
		}

	}

	public void deleteContratById(int contratId) {
		try {
			employeService.deleteContratById(contratId);
			l.info("Contract deleted successfully , contract's id : "+contratId);
		} catch (Exception e) {
			l.error("Failed to delete a contract by id :"+contratId);
			l.debug(e.getStackTrace());
		}
	}

	public int getNombreEmployeJPQL() {

		return employeService.getNombreEmployeJPQL();
	}

	public List<String> getAllEmployeNamesJPQL() {

		return employeService.getAllEmployeNamesJPQL();
	}

	public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise) {
		return employeService.getAllEmployeByEntreprise(entreprise);
	}

	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId) {
		try {
			employeService.mettreAjourEmailByEmployeIdJPQL(email, employeId);
			l.info("Email updated successfully!");
		} catch (Exception e) {
			l.error("Failed to update email adress");
			l.debug(e.getStackTrace());
		}

	}

	public void deleteAllContratJPQL() {
		try {
			employeService.deleteAllContratJPQL();
			l.info("Contracts deleted!");
		} catch (Exception e) {
			l.error("Failed to delete all the contracts");
			l.debug(e.getStackTrace());
		}

	}

	public float getSalaireByEmployeIdJPQL(int employeId) {
		return employeService.getSalaireByEmployeIdJPQL(employeId);
	}

	public Double getSalaireMoyenByDepartementId(int departementId) {
		return employeService.getSalaireMoyenByDepartementId(departementId);
	}

	public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut,
			Date dateFin) {
		return employeService.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
	}

	public List<Employe> getEmployes() {
		try {
			l.info("Retrieving employees !");
			employes = employeService.getAllEmployes();
			l.info("Employees Retrieved !");
			l.debug(employes.toString());
		} catch (Exception e) {
			l.error("Failed to retrieve all the employees");
			l.debug(e.getStackTrace());
		}
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public Integer getEmployeIdToBeUpdated() {
		return employeIdToBeUpdated;
	}

	public void setEmployeIdToBeUpdated(Integer employeIdToBeUpdated) {
		this.employeIdToBeUpdated = employeIdToBeUpdated;
	}

	public Employe getAuthenticatedUser() {
		return authenticatedUser;
	}

	public void setAuthenticatedUser(Employe authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}

}
