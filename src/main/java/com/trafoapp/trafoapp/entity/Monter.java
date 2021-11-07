package com.trafoapp.trafoapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the monter database table.
 * 
 */
@Entity
@NamedQuery(name="Monter.findAll", query="SELECT m FROM Monter m")
public class Monter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="personal_number")
	private int personalNumber;

	
	@Column(name="days_off")
	private int daysOff;

	@Size(max=25)
	@Column(name="first_name")
	private String firstName;

	@Size(max=25)
	@Column(name="last_name")
	private String lastName;

	//bi-directional many-to-one association to Work
	@OneToMany(mappedBy="monter")
	private List<Work> works;

	public Monter() {
	}

	
	
	public Monter(int personalNumber, int daysOff, String firstName, String lastName, List<Work> works) {
		this.personalNumber = personalNumber;
		this.daysOff = daysOff;
		this.firstName = firstName;
		this.lastName = lastName;
		this.works = works;
	}



	public int getPersonalNumber() {
		return this.personalNumber;
	}

	public void setPersonalNumber(int personalNumber) {
		this.personalNumber = personalNumber;
	}

	public int getDaysOff() {
		return this.daysOff;
	}

	public void setDaysOff(int daysOff) {
		this.daysOff = daysOff;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Work> getWorks() {
		return this.works;
	}

	public void setWorks(List<Work> works) {
		this.works = works;
	}

	public Work addWork(Work work) {
		getWorks().add(work);
		work.setMonter(this);

		return work;
	}

	public Work removeWork(Work work) {
		getWorks().remove(work);
		work.setMonter(null);

		return work;
	}



	@Override
	public String toString() {
		return "Monter [personalNumber=" + personalNumber + ", daysOff=" + daysOff + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", works=" + works + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monter other = (Monter) obj;
		if (personalNumber != other.personalNumber)
			return false;
		
		return true;
	}
	
	

}