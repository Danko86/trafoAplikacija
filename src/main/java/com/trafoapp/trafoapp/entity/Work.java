package com.trafoapp.trafoapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * The persistent class for the work database table.
 * 
 */
@Entity
@NamedQuery(name="Work.findAll", query="SELECT w FROM Work w")
public class Work implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="date")
	private Date date;

	@Size(max=29)
	@Column(name="name_of_the_work")
	private String nameOfTheWork;

	@Column(name="order_number")
	private int orderNumber;

	@Size(max=149)
	@Column(name="report")
	private String report;

	//bi-directional many-to-one association to Monter
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name = "monter_personal_number")
	private Monter monter;
	
	@Size(max=49)
	@Column(name="other_monters")
	private String otherMonters;

	//bi-directional many-to-one association to Trafo
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "trafo_number")
	private Trafo trafo;

	public Work() {
	}
	

	public Work(Date date, String nameOfTheWork, int orderNumber, String report, String otherMonters) {
		this.date = date;
		this.nameOfTheWork = nameOfTheWork;
		this.orderNumber = orderNumber;
		this.report = report;
		this.otherMonters = otherMonters;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNameOfTheWork() {
		return this.nameOfTheWork;
	}

	public void setNameOfTheWork(String nameOfTheWork) {
		this.nameOfTheWork = nameOfTheWork;
	}

	public int getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getReport() {
		return this.report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public Monter getMonter() {
		return this.monter;
	}

	public void setMonter(Monter monter) {
		this.monter = monter;
	}

	public Trafo getTrafo() {
		return this.trafo;
	}

	public void setTrafo(Trafo trafo) {
		this.trafo = trafo;
	}

	
	


	public String getOtherMonters() {
		return otherMonters;
	}





	public void setOtherMonters(String otherMonters) {
		this.otherMonters = otherMonters;
	}





	@Override
	public String toString() {
		return "Work [id=" + id + ", date=" + date + ", nameOfTheWork=" + nameOfTheWork + ", orderNumber=" + orderNumber
				+ ", report=" + report + ", monter=" + monter + ", otherMonters" + otherMonters + " trafo=" + trafo + "]";
	}
	
	

}