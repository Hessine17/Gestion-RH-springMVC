package com.essths.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity

public class Heuresupp  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nbrheure;
	private int heuretotal;
	private String date;
	private String date1;
	private String date2;
	@ManyToOne
	@JoinColumn(name="idfon")
	private  Fonctionnaires fonctionnaires;
	





	public Heuresupp(String nbrheure, int heuretotal, String date, String date1, String date2,
			Fonctionnaires fonctionnaires) {
		super();
		this.nbrheure = nbrheure;
		this.heuretotal = heuretotal;
		this.date = date;
		this.date1 = date1;
		this.date2 = date2;
		this.fonctionnaires = fonctionnaires;
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

	public int getHeuretotal() {
		return heuretotal;
	}

	public void setHeuretotal(int heuretotal) {
		this.heuretotal = heuretotal;
	}

	public Heuresupp() {
		// TODO Auto-generated constructor stub
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

	public Fonctionnaires getFonctionnaires() {
		return fonctionnaires;
	}

	public void setFonctionnaires(Fonctionnaires fonctionnaires) {
		this.fonctionnaires = fonctionnaires;
	}

	public Heuresupp(String nbrheure, String date,Fonctionnaires fonctionnaires ,int heuretotal) {
		super();
		this.nbrheure = nbrheure;
		this.date = date;
		this.heuretotal=heuretotal;
		this.fonctionnaires=fonctionnaires;
	}


	
	

}
