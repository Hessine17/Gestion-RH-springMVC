package com.essths.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Cooperation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	private String datededepart;
	private String nom;
	private String identificateur;
	private String prenom;
	private String tel;
	private String adresse;
	private String email;
	private String type;
	private String grade;
	private String datereq;
	@ManyToOne
	@JoinColumn(name="iden")
	private Enseignants enseignants;
	private String pays;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDatededepart() {
		return datededepart;
	}
	public void setDatededepart(String datededepart) {
		this.datededepart = datededepart;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getIdentificateur() {
		return identificateur;
	}
	public void setIdentificateur(String identificateur) {
		this.identificateur = identificateur;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDatereq() {
		return datereq;
	}
	public void setDatereq(String datereq) {
		this.datereq = datereq;
	}
	public Cooperation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cooperation(String datededepart, String nom, String identificateur, String prenom, String tel,
			String adresse, String email, String type, String grade, String datereq,String pays) {
		super();
		this.datededepart = datededepart;
		this.nom = nom;
		this.identificateur = identificateur;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
		this.email = email;
		this.type = type;
		this.grade = grade;
		this.datereq = datereq;
		this.pays=pays;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public Enseignants getEnseignants() {
		return enseignants;
	}
	public void setEnseignants(Enseignants enseignants) {
		this.enseignants = enseignants;
	}

	
	
}
