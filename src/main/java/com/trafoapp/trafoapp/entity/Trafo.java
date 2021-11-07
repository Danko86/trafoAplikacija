package com.trafoapp.trafoapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import java.util.List;


/**
 * The persistent class for the trafo database table.
 * 
 */
@Entity
@NamedQuery(name="Trafo.findAll", query="SELECT t FROM Trafo t")
public class Trafo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Column(name="number")
	@Min(value=1, message="Broj trafostanice mora biti veci od 0")
	private int number;

	@Size(max=70, message="Ovo polje moze imati maksimalno 70 karaktera")
	@Column(name="address")
	private String address;

	@Size(max=5, message="Ovo polje moze imati maksimalno 2 karaktera")
	@Column(name="buholc_t1")
	private String buholcT1;
	
	@Column(name="power")
	private int power;

	@Size(max=5, message="Ovo polje moze imati maksimalno 2 karaktera")
	@Column(name="buholc_t2")
	private String buholcT2;

	@Size(max=5, message="Ovo polje moze imati maksimalno 2 karaktera")
	@Column(name="buholc_t3")
	private String buholcT3;

	@Size(max=5, message="Ovo polje moze imati maksimalno 2 karaktera")
	@Column(name="buholc_t4")
	private String buholcT4;
	
	@Size(max=20, message="Ovo polje moze imati maksimalno 20 karaktera")
	@Column(name="number_of_exits")
	private String numberOfExits;

	@Size(max=5, message="Ovo polje moze imati maksimalno 2 karaktera")
	@Column(name="thermocontact_t1")
	private String thermocontactT1;

	@Size(max=5, message="Ovo polje moze imati maksimalno 2 karaktera")
	@Column(name="thermocontact_t2")
	private String thermocontactT2;

	@Size(max=5, message="Ovo polje moze imati maksimalno 2 karaktera")
	@Column(name="thermocontact_t3")
	private String thermocontactT3;

	@Size(max=5, message="Ovo polje moze imati maksimalno 2 karaktera")
	@Column(name="thermocontact_t4")
	private String thermocontactT4;

	@Size(max=19, message="Ovo polje moze imati maksimalno 19 karaktera")
	@Column(name="type")
	private String type;

	//bi-directional many-to-one association to Work
	@OneToMany(mappedBy="trafo",
			cascade = CascadeType.REMOVE)
	private List<Work> works;

	@ManyToOne(cascade= {CascadeType.MERGE,
			CascadeType.PERSIST,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="battery_id")
	private Battery battery;

	@ManyToOne(cascade= {
			CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH
	})
	@JoinColumn(name="disconnector_id")
	private Disconnector disconnector;
	
	
	public Trafo() {
	}
	

	

	




	public Trafo(int number, String address, String buholcT1, int power, String buholcT2, String buholcT3,
			String buholcT4, String numberOfExits, String thermocontactT1, String thermocontactT2, String thermocontactT3,
			String thermocontactT4, String type) {
		this.number = number;
		this.address = address;
		this.buholcT1 = buholcT1;
		this.power = power;
		this.buholcT2 = buholcT2;
		this.buholcT3 = buholcT3;
		this.buholcT4 = buholcT4;
		this.numberOfExits = numberOfExits;
		this.thermocontactT1 = thermocontactT1;
		this.thermocontactT2 = thermocontactT2;
		this.thermocontactT3 = thermocontactT3;
		this.thermocontactT4 = thermocontactT4;
		this.type = type;
		
	}




	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBuholcT1() {
		return this.buholcT1;
	}

	public void setBuholcT1(String buholcT1) {
		this.buholcT1 = buholcT1;
	}

	public String getBuholcT2() {
		return this.buholcT2;
	}

	public void setBuholcT2(String buholcT2) {
		this.buholcT2 = buholcT2;
	}

	public String getBuholcT3() {
		return this.buholcT3;
	}

	public void setBuholcT3(String buholcT3) {
		this.buholcT3 = buholcT3;
	}

	public String getBuholcT4() {
		return this.buholcT4;
	}

	public void setBuholcT4(String buholcT4) {
		this.buholcT4 = buholcT4;
	}





	public String getNumberOfExits() {
		return this.numberOfExits;
	}

	public void setNumberOfExits(String numberOfExits) {
		this.numberOfExits = numberOfExits;
	}

	public String getThermocontactT1() {
		return this.thermocontactT1;
	}

	public void setThermocontactT1(String thermocontactT1) {
		this.thermocontactT1 = thermocontactT1;
	}

	public String getThermocontactT2() {
		return this.thermocontactT2;
	}

	public void setThermocontactT2(String thermocontactT2) {
		this.thermocontactT2 = thermocontactT2;
	}

	public String getThermocontactT3() {
		return this.thermocontactT3;
	}

	public void setThermocontactT3(String thermocontactT3) {
		this.thermocontactT3 = thermocontactT3;
	}

	public String getThermocontactT4() {
		return this.thermocontactT4;
	}
	
	

	public int getPower() {
		return power;
	}



	public void setPower(int power) {
		this.power = power;
	}



	public void setThermocontactT4(String thermocontactT4) {
		this.thermocontactT4 = thermocontactT4;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Work> getWorks() {
		return this.works;
	}

	public void setWorks(List<Work> works) {
		this.works = works;
	}

	public Work addWork(Work work) {
		getWorks().add(work);
		work.setTrafo(this);

		return work;
	}

	public Work removeWork(Work work) {
		getWorks().remove(work);
		work.setTrafo(null);

		return work;
	}
	
	

	public Disconnector getDisconnector() {
		return disconnector;
	}

	public void setDisconnector(Disconnector disconnector) {
		this.disconnector = disconnector;
	}

	public Battery getBattery() {
		return this.battery;
	}

	public void setBattery(Battery battery) {
		this.battery = battery;
	}

}