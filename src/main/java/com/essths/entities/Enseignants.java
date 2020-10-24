package com.essths.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;


	@Entity
	public class Enseignants   implements Serializable{
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id; 
		
	
		private String nom;
		
		private String identificateur;
		public Enseignants(String nom, String identificateur, String prenom, String tel, String adresse, String email,
				 String photo, String heureTravail, String type, String grade ,String datereq) {
			super();
			this.nom = nom;
			this.identificateur = identificateur;
			this.prenom = prenom;
			this.tel = tel;
			this.adresse = adresse;
			this.email = email;
			
			this.photo = photo;
			this.heureTravail = heureTravail;
			this.type = type;
			this.grade = grade;
			this.datereq=datereq;
		}

		public String getIdentificateur() {
			return identificateur;
		}

		public void setIdentificateur(String identificateur) {
			this.identificateur = identificateur;
		}

		private String prenom;
		private String tel;
		private String adresse;
		private String email;
		private String nomPhoto;
		@Lob
		private byte[] photo1;
		
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

		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}

		public Enseignants(String nom, String identificateur, String prenom, String tel, String adresse, String email,
				String nomPhoto, byte[] photo1, String photo, String heureTravail, String type, String grade,
				String datereq) {
			super();
			this.nom = nom;
			this.identificateur = identificateur;
			this.prenom = prenom;
			this.tel = tel;
			this.adresse = adresse;
			this.email = email;
			this.nomPhoto = nomPhoto;
			this.photo1 = photo1;
			this.photo = photo;
			this.heureTravail = heureTravail;
			this.type = type;
			this.grade = grade;
			this.datereq = datereq;
		}

		private String photo;
		private String heureTravail;
		
		private String type;
		private String grade;
		private String datereq;
		@OneToMany(mappedBy = "enseignants" ,cascade=CascadeType.REMOVE,orphanRemoval=true)
		private Collection<Cooperation> cooperations=new ArrayList<Cooperation>();
		@OneToMany(mappedBy = "enseignants" ,cascade=CascadeType.REMOVE,orphanRemoval=true)
		private Collection<Conge> conges=new ArrayList<Conge>();
		@OneToMany(mappedBy = "enseignants" ,cascade=CascadeType.REMOVE,orphanRemoval=true)
		private Collection<Autorisation> autorisations=new ArrayList<Autorisation>();
		public String getDatereq() {
			return datereq;
		}

		public void setDatereq(String datereq) {
			this.datereq = datereq;
		}

		

	

		public String getphoto() {
			return photo;
		}

		public void setphoto(String photo) {
			this.photo = photo;
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

		public Enseignants(String type, String grade) {
			super();
			this.type = type;
			this.grade = grade;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}



		public Enseignants() {
			super();
			// TODO Auto-generated constructor stub
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



		public Enseignants(String nom, String prenom, String tel, String adresse, String email, 
				String nomphoto, String heureTravail, String type, String grade) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.tel = tel;
			this.adresse = adresse;
			this.email = email;
			
			this.photo = photo;
			this.heureTravail = heureTravail;
			this.type = type;
			this.grade = grade;
		}

		public String getHeureTravail() {
			return heureTravail;
		}

		public void setHeureTravail(String heureTravail) {
			this.heureTravail = heureTravail;
		}




		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}



}
