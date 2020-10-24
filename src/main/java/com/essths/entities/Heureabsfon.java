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

public class Heureabsfon  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String heure;
	private String date;
	private String nom;
	private String prenom;
	private String identificateur;
	
	@ManyToOne
	@JoinColumn(name="idfon")
	private  Fonctionnaires fonctionnaires;
	@ManyToOne
	@JoinColumn(name="idouv")
	private  Ouvriers ouvriers;

	
	
	public Heureabsfon(String heure, String date, String nom, String prenom, String identificateur,
			Fonctionnaires fonctionnaires, Ouvriers ouvriers) {
		super();
		this.heure = heure;
		this.date = date;
		this.nom = nom;
		this.prenom = prenom;
		this.identificateur = identificateur;
		this.fonctionnaires = fonctionnaires;
		this.ouvriers = ouvriers;
	}
	public Ouvriers getOuvriers() {
		return ouvriers;
	}
	public void setOuvriers(Ouvriers ouvriers) {
		this.ouvriers = ouvriers;
	}
	public Heureabsfon(String heure, String date, String nom, String prenom, String identificateur,
			Fonctionnaires fonctionnaires) {
		super();
		this.heure = heure;
		this.date = date;
		this.nom = nom;
		this.prenom = prenom;
		this.identificateur = identificateur;
		this.fonctionnaires = fonctionnaires;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getIdentificateur() {
		return identificateur;
	}
	public void setIdentificateur(String identificateur) {
		this.identificateur = identificateur;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
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
	public Heureabsfon(String heure, String date, Fonctionnaires fonctionnaires) {
		super();
		this.heure = heure;
		this.date = date;
		this.fonctionnaires = fonctionnaires;
	}
	public Heureabsfon() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
