package com.essths.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Ouvriers  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	private String identificateur;
	@NotEmpty

	private String nom;
	private String prenom;
	private String tel;
	private String adresse;
	private String email;

	private String heureTravaildebut;
	private String heureTravailfin;
	private String nomPhoto;
	@Lob
	private byte[] photo1;
	private int congéanull=45;
	@OneToMany(mappedBy="ouvriers")
	
	public int getCongéanull() {
		return congéanull;
	}


	public void setCongéanull(int congéanull) {
		this.congéanull = congéanull;
	}

	private String type;
	private String grade;
	private String datereq;

	@OneToMany(mappedBy="ouvriers",cascade=CascadeType.REMOVE,orphanRemoval=true)
	private Collection<Conge> conge=new ArrayList<Conge>();
	@OneToMany(mappedBy="ouvriers",cascade=CascadeType.REMOVE,orphanRemoval=true)
	private Collection<Autorisation> autorisations=new ArrayList<Autorisation>();
	@OneToMany(mappedBy="ouvriers",cascade=CascadeType.REMOVE,orphanRemoval=true)
	private Collection<Heureabsfon> heureabsfons=new ArrayList<Heureabsfon>();
	@OneToMany(mappedBy="ouvriers",cascade=CascadeType.REMOVE,orphanRemoval=true)
	private Collection<Heuresuppouvrier> heuresuppouvriers=new ArrayList<Heuresuppouvrier>();


	public String getDatereq() {
		return datereq;
	}


	public Ouvriers(String identificateur, String nom, String prenom, String tel, String adresse, String email,
			String heureTravail, String nomPhoto, byte[] photo1, int congéanull, String type, String grade,
			String datereq) {
		super();
		this.identificateur = identificateur;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
		this.email = email;
		
		this.nomPhoto = nomPhoto;
		this.photo1 = photo1;
		this.congéanull = congéanull;
		this.type = type;
		this.grade = grade;
		this.datereq = datereq;
	}


	public String getNomPhoto() {
		return nomPhoto;
	}


	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}


	public byte[] getPhoto1() {
		return photo1;
	}


	public void setPhoto1(byte[] photo1) {
		this.photo1 = photo1;
	}


	public Ouvriers(String identificateur, String nom, String prenom, String tel, String adresse, String email,
			String heureTravail, String nomPhoto, byte[] photo1, String type, String grade, String datereq) {
		super();
		this.identificateur = identificateur;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
		this.email = email;

		this.nomPhoto = nomPhoto;
		this.photo1 = photo1;
		this.type = type;
		this.grade = grade;
		this.datereq = datereq;
	}


	public void setDatereq(String datereq) {
		this.datereq = datereq;
	}


	public Ouvriers() {
		// TODO Auto-generated constructor stub
	}
	

	public String getIdentificateur() {
		return identificateur;
	}


	public void setIdentificateur(String identificateur) {
		this.identificateur = identificateur;
	}


	public Ouvriers(String identificateur,String nom, String prenom, String tel, String adresse, String email, byte[] photo,
			String nomphoto, String heureTravail, String type, String grade,String datereq) {
		super();
		this.identificateur=identificateur;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
		this.email = email;
	

		this.type = type;
		this.grade = grade;
		this.datereq= datereq;
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




	public Ouvriers(String identificateur, String nom, String prenom, String tel, String adresse, String email,
			String heureTravaildebut, String heureTravailfin, String nomPhoto, byte[] photo1, int congéanull,
			String type, String grade, String datereq) {
		super();
		this.identificateur = identificateur;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
		this.email = email;
		this.heureTravaildebut = heureTravaildebut;
		this.heureTravailfin = heureTravailfin;
		this.nomPhoto = nomPhoto;
		this.photo1 = photo1;
		this.congéanull = congéanull;
		this.type = type;
		this.grade = grade;
		this.datereq = datereq;
	}


	public String getHeureTravaildebut() {
		return heureTravaildebut;
	}


	public void setHeureTravaildebut(String heureTravaildebut) {
		this.heureTravaildebut = heureTravaildebut;
	}


	public String getHeureTravailfin() {
		return heureTravailfin;
	}


	public void setHeureTravailfin(String heureTravailfin) {
		this.heureTravailfin = heureTravailfin;
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

}
