package com.trafoapp.trafoapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the battery database table.
 * 
 */
@Entity
@NamedQuery(name="Battery.findAll", query="SELECT b FROM Battery b")
public class Battery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id", insertable=true, updatable= true, unique=true)
	private int id;

	@Column(name="power")
	private Integer power;

	@Column(name="quantity")
	private Integer quantity;

	@Size(max=25)
	@Column(name="type")
	private String type;

	//bi-directional many-to-one association to Trafo
	@OneToMany(mappedBy="battery")
	private List<Trafo> trafos;

	public Battery() {
	}
	
	
	public Battery(Integer power, Integer quantity, String type) {
		this.power = power;
		this.quantity = quantity;
		this.type = type;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
    	

	public Integer getPower() {
		return power;
	}


	public void setPower(Integer power) {
		this.power = power;
	}


	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}






	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Trafo> getTrafos() {
		return this.trafos;
	}

	public void setTrafos(List<Trafo> trafos) {
		this.trafos = trafos;
	}

	public Trafo addTrafo(Trafo trafo) {
		getTrafos().add(trafo);
		trafo.setBattery(this);

		return trafo;
	}

	public Trafo removeTrafo(Trafo trafo) {
		getTrafos().remove(trafo);
		trafo.setBattery(null);

		return trafo;
	}


	 @Override
	    public String toString() {
		 if(power==null || quantity==null) {
	        return  " " + type;
	    } else return ""  + quantity + " " +  power + " " + type;


	 }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + power;
		result = prime * result + quantity;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Battery other = (Battery) obj;
		if (power != other.power)
			return false;
		if (quantity != other.quantity)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.trim().equalsIgnoreCase(other.type.trim()))
			return false;
		return true;
	}
	
	
	

}