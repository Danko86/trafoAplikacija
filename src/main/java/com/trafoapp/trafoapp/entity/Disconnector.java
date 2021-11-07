package com.trafoapp.trafoapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;


/**
 * The persistent class for the disconnector database table.
 * 
 */
@Entity
@NamedQuery(name="Disconnector.findAll", query="SELECT d FROM Disconnector d")
public class Disconnector implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id", insertable=true, updatable= true, unique=true)
	private int id;

	@Size(max=29)
	@Column(name="others_quantity_type")
	private String othersQuantityType;

	@Size(max=29)
	@Column(name="trafo_quantity_type")
	private String trafoQuantityType;

	public Disconnector() {
	}
	
	

	public Disconnector(String othersQuantityType, String trafoQuantityType) {
		this.othersQuantityType = othersQuantityType;
		this.trafoQuantityType = trafoQuantityType;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOthersQuantityType() {
		return this.othersQuantityType;
	}

	public void setOthersQuantityType(String othersQuantityType) {
		this.othersQuantityType = othersQuantityType;
	}

	public String getTrafoQuantityType() {
		return this.trafoQuantityType;
	}

	public void setTrafoQuantityType(String trafoQuantityType) {
		this.trafoQuantityType = trafoQuantityType;
	}

	
	@Override
	public String toString() {
		return " " + trafoQuantityType + " " + othersQuantityType;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((othersQuantityType == null) ? 0 : othersQuantityType.hashCode());
		result = prime * result + ((trafoQuantityType == null) ? 0 : trafoQuantityType.hashCode());
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
		Disconnector other = (Disconnector) obj;
		if (othersQuantityType == null) {
			if (other.othersQuantityType != null)
				return false;
		} else if (!othersQuantityType.trim().replaceAll("\\s", "").equalsIgnoreCase(other.othersQuantityType.trim().replaceAll("\\s", "")))
			return false;
		if (trafoQuantityType == null) {
			if (other.trafoQuantityType != null)
				return false;
		} else if (!trafoQuantityType.trim().replaceAll("\\s", "").equalsIgnoreCase(other.trafoQuantityType.trim().replaceAll("\\s", "")))
			return false;
		return true;
	}
	
	

}