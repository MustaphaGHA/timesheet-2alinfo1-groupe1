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
	private static final long serialVersionUID = -5369734855993305723L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String Label;

	private int Quantity;

	@ManyToOne
	private Employe employe;
	
	@OneToMany(mappedBy="logistique")
	private  List<Timesheet> timesheets;

	public Logistique() {
		super();
	}

	public Logistique(String Label, int Quantity){
		this.Label = Label;
		this.Quantity = Quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String Label) {
		this.Label = Label;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
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
