package com.essths.DAO;

import java.util.Date;
import java.util.List;

import com.essths.entities.Autorisation;
import com.essths.entities.Conge;
import com.essths.entities.Enseignants;
import com.essths.entities.Fonctionnaires;
import com.essths.entities.Heureabsfon;
import com.essths.entities.Heuresupp;




public interface IfonctionnaireDAO {

	public Long ajouterfonctionnaire(Fonctionnaires F);
	public List<Fonctionnaires> listefonctionnaire();
	public void supp(Long id);
	public void modifierfonctionnaire(Fonctionnaires f);
	public Fonctionnaires getfonctionnaire(Long id);
	public List<Fonctionnaires> ordrebynom();
	public List<Fonctionnaires> ordrebygrade();
	public List<Fonctionnaires> ordrebyheureTravail();
	public Long ajouterheure(Heuresupp h ,Long idfon);
	public List<Fonctionnaires> recherchrefonctionnaires(String nom);
	public Long ajouterautorisation(Autorisation a,Long idfon);
	public String sommeheuresuppfonctionnaire(Long idfon ,String date1,String date2);
	public List<Heuresupp> detailheuresupfon(Long idfon);
	public Long ajouterConge(Conge c ,Long idfon);
	public List<Conge> getListCongeAujourdhui();
	public Long ajouterheureabs(Heureabsfon h ,Long idfon);
	public Long ajouterjoursabs(Conge j ,Long idfon);
	public List<Heureabsfon> listefonctionnaireretard();
	public List<Heureabsfon> listefonctionnaireretarddate(String date1, String date2);
	public void modifcongé(Conge c);
	public List<Fonctionnaires> titularasation();
	public List<Autorisation> listeAutorisation();
	public String getfonctionnbrjabs(Long idfon);
	public void updatejoursabs(Conge cx,Long idfon);

	public List<Conge> getabsdetail(Long idfon,String date1,String date2);
	public List<Autorisation> getabsdetailauto(Long idfon,String date1,String date2);
	public List<Heureabsfon> getretaddetailauto(Long idfon,String date1,String date2);
	public List<Conge> getjourabsdetail(Long idfon,String date1,String date2);

	public List<Fonctionnaires> recherchrefonctionnairesauto(String nom);

}



