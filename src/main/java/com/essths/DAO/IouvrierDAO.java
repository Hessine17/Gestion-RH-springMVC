package com.essths.DAO;

import java.util.List;

import com.essths.entities.Autorisation;

import com.essths.entities.Conge;

import com.essths.entities.Enseignants;
import com.essths.entities.Fonctionnaires;
import com.essths.entities.Heureabsfon;

import com.essths.entities.Heuresupp;
import com.essths.entities.Heuresuppouvrier;

import com.essths.entities.Ouvriers;


public interface IouvrierDAO {
	public Long ajouterouvriers(Ouvriers o);
	public List<Ouvriers> listeouvriers();
	public void suppouvriers(Long id);
	public void modifierouvriers(Ouvriers o);
	public List<Ouvriers> recherchreOuvriers(String nom);
	public Ouvriers getouvriers(Long id);
	public List<Ouvriers> ordrebynom();
	public List<Ouvriers> ordrebygrade();
	public List<Ouvriers> ordrebyheureTravail();
	public Long ajouterheure(Heuresuppouvrier h ,Long idouv);
	public String sommeheuresuppfonctionnaire(Long idouv,String date1,String date2);
	public Long ajouterheureabs(Heureabsfon h ,Long idouv);
	public List<Heuresuppouvrier> detailheuresupouv(Long idouv);
	public List<Heureabsfon> listeouvrierretard();
	public List<Heureabsfon> listeouvrierretarddate(String date1, String date2);
	public Long ajouterautorisation(Autorisation a,Long idouv);
	
	public Long ajouterConge(Conge c ,Long idouv);
	public List<Conge> getListCongeAujourdhui();
	public Long ajouterjoursabs(Conge j ,Long idouv);
	public List<Conge > listeouvrierabs();
	public List<Conge> listeouvrierabsdate(String date,String date2);
	public void modifcongé(Conge c);
	public List<Ouvriers> titularasation(); 
	public String getouvriernbrjabs(Long idouv);
	public void updatejoursabs(Conge c,Long idouv);
	
	public List<Conge> getabsdetail(Long idouv,String date1,String date2);
	public List<Autorisation> getabsdetailauto(Long idouv,String date1,String date2);
	public List<Heureabsfon> getretaddetailauto(Long idouv,String date1,String date2);
	public List<Conge> getjourabsdetail(Long idouv,String date1,String date2);


	
}
