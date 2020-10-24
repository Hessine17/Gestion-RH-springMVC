package com.essths.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Conge  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	private String type;
	private String type2;
	private String type3;
	private String identificateur;
	private String nom;

	private String prenom;
	private String tel;

	private String adresse;
	private String grade;
	private String codepostal;
	private String papier;
	private String datededebut;
	private String datedefin;
	private String datederetour;
	private int nbrj;
	
	
	@ManyToOne
	@JoinColumn(name="idfon")
	private Fonctionnaires fonctionnaires;
	@ManyToOne
	@JoinColumn(name="idouv")
	private Ouvriers ouvriers;
	@ManyToOne
	@JoinColumn(name="iden")
	private Enseignants enseignants;
	
	
	
	
	public Conge(Long id, String type, String type2, String type3, String identificateur, String nom, String prenom,
			String tel, String adresse, String grade, String codepostal, String papier, String datededebut,
			String datedefin, String datederetour, int nbrj) {
		super();
		this.id = id;
		this.type = type;
		this.type2 = type2;
		this.type3 = type3;
		this.identificateur = identificateur;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
		this.grade = grade;
		this.codepostal = codepostal;
		this.papier = papier;
		this.datededebut = datededebut;
		this.datedefin = datedefin;
		this.datederetour = datederetour;
		this.nbrj = nbrj;
	}
	public Enseignants getEnseignants() {
		return enseignants;
	}
	public void setEnseignants(Enseignants enseignants) {
		this.enseignants = enseignants;
	}
	public Conge(String type, String type2, String type3, String identificateur, String nom, String prenom, String tel,
			String adresse, String grade, String codepostal, String papier, String datededebut, String datedefin,
			String datederetour, int nbrj, Fonctionnaires fonctionnaires, Ouvriers ouvriers) {
		super();
		this.type = type;
		this.type2 = type2;
		this.type3 = type3;
		this.identificateur = identificateur;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
		this.grade = grade;
		this.codepostal = codepostal;
		this.papier = papier;
		this.datededebut = datededebut;
		this.datedefin = datedefin;
		this.datederetour = datederetour;
		this.nbrj = nbrj;
		this.fonctionnaires = fonctionnaires;
		this.ouvriers = ouvriers;
	}
	public String getDatederetour() {
		return datederetour;
	}
	public void setDatederetour(String datederetour) {
		this.datederetour = datederetour;
	}
	public Conge(String type, String type2, String type3, String identificateur, String nom, String prenom, String tel,
			String adresse, String grade, String codepostal, String papier, String datededebut, String datedefin,
			int nbrj, Fonctionnaires fonctionnaires, Ouvriers ouvriers) {
		super();
		this.type = type;
		this.type2 = type2;
		this.type3 = type3;
		this.identificateur = identificateur;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
		this.grade = grade;
		this.codepostal = codepostal;
		this.papier = papier;
		this.datededebut = datededebut;
		this.datedefin = datedefin;
		this.nbrj = nbrj;
		this.fonctionnaires = fonctionnaires;
		this.ouvriers = ouvriers;
	}
	public Ouvriers getOuvriers() {
		return ouvriers;
	}
	public void setOuvriers(Ouvriers ouvriers) {
		this.ouvriers = ouvriers;
	}
	public Fonctionnaires getFonctionnaires() {
		return fonctionnaires;
	}
	public void setFonctionnaires(Fonctionnaires fonctionnaires) {
		this.fonctionnaires = fonctionnaires;
	}
	public Conge(String type, String type2, String type3, String identificateur, String nom, String prenom, String tel,
			String adresse, String grade, String codepostal, String papier, String datededebut, String datedefin,
			int nbrj ,Fonctionnaires fonctionnaires) {
		super();
		this.type = type;
		this.type2 = type2;
		this.type3 = type3;
		this.identificateur = identificateur;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
		this.grade = grade;
		this.codepostal = codepostal;
		this.papier = papier;
		this.datededebut = datededebut;
		this.datedefin = datedefin;
		this.nbrj = nbrj;
		this.fonctionnaires=fonctionnaires;
		
		
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public String getType3() {
		return type3;
	}
	public void setType3(String type3) {
		this.type3 = type3;
	}
	public String getIdentificateur() {
		return identificateur;
	}
	public void setIdentificateur(String identificateur) {
		this.identificateur = identificateur;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCodepostal() {
		return codepostal;
	}
	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}
	public String getPapier() {
		return papier;
	}
	public void setPapier(String papier) {
		this.papier = papier;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDatededebut() {
		return datededebut;
	}
	public void setDatededebut(String datededebut) {
		this.datededebut = datededebut;
	}
	public String getDatedefin() {
		return datedefin;
	}
	public void setDatedefin(String datedefin) {
		this.datedefin = datedefin;
	}
	public int getNbrj() {
		return nbrj;
	}
	public void setNbrj(int nbrj) {
		this.nbrj = nbrj;
	}
	public Conge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Conge(String type, String datededebut, String datedefin, int nbrj) {
		super();
		this.type = type;
		this.datededebut = datededebut;
		this.datedefin = datedefin;
		this.nbrj = nbrj;
	}
	public Conge(String type, int nbrj) {
		super();
		this.type = type;
		this.nbrj = nbrj;
	}
	
	
}
