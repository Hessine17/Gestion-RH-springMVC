package com.essths.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Heuresuppouvrier {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nbrheure;
	private String date;
	private String date1;
	private String date2;
	@ManyToOne
	@JoinColumn(name="idouv")
	private  Ouvriers ouvriers;
	

	
	public Heuresuppouvrier(String nbrheure, String date, String date1, String date2, Ouvriers ouvriers) {
		super();
		this.nbrheure = nbrheure;
		this.date = date;
		this.date1 = date1;
		this.date2 = date2;
		this.ouvriers = ouvriers;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNbrheure() {
		return nbrheure;
	}
	public void setNbrheure(String nbrheure) {
		this.nbrheure = nbrheure;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Ouvriers getOuvriers() {
		return ouvriers;
	}
	public void setOuvriers(Ouvriers ouvriers) {
		this.ouvriers = ouvriers;
	}
	public Heuresuppouvrier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Heuresuppouvrier(String nbrheure, String date, Ouvriers ouvriers) {
		super();
		this.nbrheure = nbrheure;
		this.date = date;
		this.ouvriers = ouvriers;
	}
	
}
