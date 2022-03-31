package tn.esprit.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;

@Controller
public class ControllerEntrepriseImpl{

	@Autowired
	IEmployeService iemployeservice;
	@Autowired
	IEntrepriseService ientrepriseservice;
	@Autowired
	ITimesheetService itimesheetservice;
	static final Logger l = Logger.getLogger(ControllerEmployeImpl.class);
	
	public int ajouterEntreprise(Entreprise ssiiConsulting) {
		ientrepriseservice.ajouterEntreprise(ssiiConsulting);
		l.info("Entreprise added Successfully");
		return ssiiConsulting.getId();
	}
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		ientrepriseservice.affecterDepartementAEntreprise(depId, entrepriseId);
		l.info("DepartementService ajouté avec succes");
	}
	public void deleteEntrepriseById(int entrepriseId)
	{
		ientrepriseservice.deleteEntrepriseById(entrepriseId);
		l.info("Entreprise supprimé avec succes");
	}
	public Entreprise getEntrepriseById() {

		return ientrepriseservice.getEntrepriseById(1);
	}
	
	public int ajouterDepartement(Departement dep) {
		return ientrepriseservice.ajouterDepartement(dep);
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		return ientrepriseservice.getAllDepartementsNamesByEntreprise(entrepriseId);
	}

	public void deleteDepartementById(int depId) {
		ientrepriseservice.deleteDepartementById(depId);

	}
}
