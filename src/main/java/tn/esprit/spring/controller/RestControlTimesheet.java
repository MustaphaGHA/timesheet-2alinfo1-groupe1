package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.MissionRequestModel;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;
import org.apache.log4j.Logger;


@RestController
public class RestControlTimesheet {

	@Autowired
	IEmployeService iemployeservice;
	@Autowired
	IEntrepriseService ientrepriseservice;
	@Autowired
	ITimesheetService itimesheetservice;
	
	static final Logger l = Logger.getLogger(RestControlTimesheet.class);
	
	//http://localhost:8081/SpringMVC/servlet/ajouterMission
	@PostMapping("/ajouterMission")
	@ResponseBody
	public int ajouterMission(@RequestBody MissionRequestModel missionRequestModel) {
	    Mission mission = new Mission(missionRequestModel);
	    try {
	    	itimesheetservice.ajouterMission(mission);
			l.info("Mission added Successfully");

	    }
	    catch (Exception e) {
	    	l.error("Failed to add a Mission");
			l.debug(e.getStackTrace());
	    }
	    return mission.getId();
	}

	// http://localhost:8081/SpringMVC/servlet/affecterMissionADepartement/4/4
	@PutMapping(value = "/affecterMissionADepartement/{idmission}/{iddept}") 
	public void affecterMissionADepartement(@PathVariable("idmission") int missionId, @PathVariable("iddept") int depId) {
		 try {
		itimesheetservice.affecterMissionADepartement(missionId, depId);
		l.info("Departement affectation is added Successfully");

		    }
		    catch (Exception e) {
		    	l.error("Failed to add Departement to the mission");
				l.debug(e.getStackTrace());
		    }
	}
	
	
	@PostMapping("/ajouterTimesheet/idmission/idemp/dated/datef")
	@ResponseBody
	public void ajouterTimesheet(@PathVariable("idmission") int missionId, @PathVariable("idemp") int employeId, @PathVariable("dated") Date dateDebut,@PathVariable("datef") Date dateFin) {
		 try {
		itimesheetservice.ajouterTimesheet(missionId, employeId, dateDebut, dateFin);
		l.info("Timesheet added Successfully");

		 }
		    catch (Exception e) {
		    	l.error("Failed to add Timesheet");
				l.debug(e.getStackTrace());
		    }
		}

	// http://localhost:8081/SpringMVC/servlet/validerTimesheet/1/1/03-10-2020/03-20-2020/1
	@PutMapping(value = "/validerTimesheet/{idmission}/{idemp}/{dated}/{datef}/{idval}") 
	public void validerTimesheet(@PathVariable("idmission") int missionId, @PathVariable("idemp") int employeId, @PathVariable("dated") Date dateDebut,@PathVariable("datef") Date dateFin, @PathVariable("idval") int validateurId) {
		 try {
		itimesheetservice.validerTimesheet(missionId, employeId, dateDebut, dateFin, validateurId);
		l.info("Timesheet is valide ");

		 }
		    catch (Exception e) {
		    	l.error("Failed to validate Timesheet");
				l.debug(e.getStackTrace());
		  }
	}
	
	// URL : http://localhost:8081/SpringMVC/servlet/findAllMissionByEmployeJPQL/1
    @GetMapping(value = "findAllMissionByEmployeJPQL/{idemp}")
    @ResponseBody
	public List<Mission> findAllMissionByEmployeJPQL(@PathVariable("idemp") int employeId) {
    	List<Mission> MissionList= null;
    	try {
    		MissionList=itimesheetservice.findAllMissionByEmployeJPQL(employeId);
			l.info("Missions : "+MissionList); }
			catch (Exception e) {
				l.error("No mission found");
				l.debug(e.getStackTrace());
			}
	 return MissionList;
	}

    // URL : http://localhost:8081/SpringMVC/servlet/getAllEmployeByMission/1
    @GetMapping(value = "getAllEmployeByMission/{idmission}")
    @ResponseBody
	public List<Employe> getAllEmployeByMission(@PathVariable("idmission") int missionId) {
    	List<Employe>Employe_List= null;
    	try {
    		Employe_List=itimesheetservice.getAllEmployeByMission(missionId);
			l.info("Missions : "+Employe_List); }
			catch (Exception e) {
				l.error("No mission found");
				l.debug(e.getStackTrace());
			}
	 return Employe_List;
	}
}
