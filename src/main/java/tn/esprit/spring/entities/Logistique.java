package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Logistique implements Serializable {

	private static final long serialVersionUID = -1369702518850240341L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String label;

	private int quantity;

	@ManyToOne
	private Employe employe;
	
	@OneToMany(mappedBy="logistique")
	private  List<Timesheet> timesheets;

	public Logistique() {
		super();
	}

	public Logistique(String label, int quantity){
		this.label = label;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Employe getemploye() {
		return employe;
	}

	public void setDepartement(Employe employe) {
		this.employe = employe;
	}

	public List<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}
}
