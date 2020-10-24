package com.essths.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Autorisation implements Serializable {
@Id
@GeneratedValue
private Long id ;
private String nom;
private String date ;
private String de;
private String a;
private String cause;
public String getCause() {
	return cause;
}

public void setCause(String cause) {
	this.cause = cause;
}

public Fonctionnaires getFonctionnaires() {
	return fonctionnaires;
}

public void setFonctionnaires(Fonctionnaires fonctionnaires) {
	this.fonctionnaires = fonctionnaires;
}

@ManyToOne
@JoinColumn(name="idfon")
private  Fonctionnaires fonctionnaires;
@ManyToOne
@JoinColumn(name="idouv")
private  Ouvriers ouvriers;
@ManyToOne
@JoinColumn(name="iden")
private  Enseignants enseignants;
	public Autorisation(String nom, String date, String de, String a, String cause, Fonctionnaires fonctionnaires,
		Ouvriers ouvriers, Enseignants enseignants) {
	super();
	this.nom = nom;
	this.date = date;
	this.de = de;
	this.a = a;
	this.cause = cause;
	this.fonctionnaires = fonctionnaires;
	this.ouvriers = ouvriers;
	this.enseignants = enseignants;
}

	public Enseignants getEnseignants() {
	return enseignants;
}

public void setEnseignants(Enseignants enseignants) {
	this.enseignants = enseignants;
}

	public Autorisation(String nom, String date, String de, String a, String cause, Fonctionnaires fonctionnaires,
		Ouvriers ouvriers) {
	super();
	this.nom = nom;
	this.date = date;
	this.de = de;
	this.a = a;
	this.cause = cause;
	this.fonctionnaires = fonctionnaires;
	this.ouvriers = ouvriers;
}

	public Ouvriers getOuvriers() {
	return ouvriers;
}

public void setOuvriers(Ouvriers ouvriers) {
	this.ouvriers = ouvriers;
}

	public Autorisation() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public Autorisation(String nom, String date, String de, String a,String cause) {
		super();
		this.nom = nom;
		this.date = date;
		this.de = de;
		this.a = a;
		this.cause=cause;
	}

}
