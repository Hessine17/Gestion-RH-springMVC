package com.essths.metier;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.transaction.annotation.Transactional;

import com.essths.DAO.IfonctionnaireDAO;
import com.essths.entities.Autorisation;
import com.essths.entities.Conge;
import com.essths.entities.Fonctionnaires;
import com.essths.entities.Heureabsfon;
import com.essths.entities.Heuresupp;

@Transactional
public class IfonctionnaireMetierImpl implements IfonctionnaireMetier {
private IfonctionnaireDAO daof;
	public IfonctionnaireMetierImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Long ajouterfonctionnaire(Fonctionnaires F) {
		// TODO Auto-generated method stub
		return daof.ajouterfonctionnaire(F);
	}
	@Override
	public List<Fonctionnaires> listefonctionnaire() {
		// TODO Auto-generated method stub
		return daof.listefonctionnaire();
	}
	@Override
	
	public void supp(Long id) {
		// TODO Auto-generated method stub
		daof.supp(id);
		
	}
	@Override
	public void modifierfonctionnaire(Fonctionnaires f) {
		// TODO Auto-generated method stub
daof.modifierfonctionnaire(f);		
	}
	public IfonctionnaireDAO getDaof() {
		return daof;
	}
	public void setDaof(IfonctionnaireDAO daof) {
		this.daof = daof;
	}
	@Override
	public Fonctionnaires getfonctionnaire(Long id) {
		// TODO Auto-generated method stub
		return daof.getfonctionnaire(id);
	}
	@Override
	public List<Fonctionnaires> ordrebynom() {
		// TODO Auto-generated method stub
		return daof.ordrebynom();
	}
	@Override
	public List<Fonctionnaires> ordrebygrade() {
		// TODO Auto-generated method stub
		return daof.ordrebygrade();
	}
	@Override
	public List<Fonctionnaires> ordrebyheureTravail() {
		// TODO Auto-generated method stub
		return daof.ordrebyheureTravail();
	}
	@Override
	public Long ajouterheure(Heuresupp h,Long idfon) {
		// TODO Auto-generated method stub
		return daof.ajouterheure(h,idfon);
	}
	@Override
	public List<Fonctionnaires> recherchrefonctionnaires(String nom) {
		// TODO Auto-generated method stub
		return daof.recherchrefonctionnaires(nom);
	}
	@Override
	public Long ajouterautorisation(Autorisation a,Long idfon) {
		// TODO Auto-generated method stub
		return daof.ajouterautorisation(a,idfon);
	}
	@Override
	public String sommeheuresuppfonctionnaire(Long idfon,String date1,String date2) {
		// TODO Auto-generated method stub
		return daof.sommeheuresuppfonctionnaire(idfon,date1,date2);
	}
	

	@Override
	public List<Conge> getListCongeAujourdhui() {
		// TODO Auto-generated method stub
		return daof.getListCongeAujourdhui();
	}
	@Override
	public Long ajouterConge(Conge c,Long idfon) {
		// TODO Auto-generated method stub
		return daof.ajouterConge(c,idfon);
	}
	@Override
	public Long ajouterheureabs(Heureabsfon h, Long idfon) {
		// TODO Auto-generated method stub
		return daof.ajouterheureabs(h, idfon);
	}
	@Override
	public List<Heureabsfon> listefonctionnaireretard() {
		// TODO Auto-generated method stub
		return daof.listefonctionnaireretard();
	}
	@Override
	public List<Heureabsfon> listefonctionnaireretarddate(String date1, String date2) {
		// TODO Auto-generated method stub
		return daof.listefonctionnaireretarddate(date1, date2);
	}
	@Override
	public void modifcongé(Conge c) {
		daof.modifcongé(c);
		
	}
	@Override
	public List<Fonctionnaires> titularasation() {
		// TODO Auto-generated method stub
		return daof.titularasation();
	}
	@Override
	public Long ajouterjoursabs(Conge j, Long idfon) {
		// TODO Auto-generated method stub
		return daof.ajouterjoursabs(j, idfon);
	}
	@Override
	public List<Autorisation> listeAutorisation() {
		// TODO Auto-generated method stub
		return daof.listeAutorisation();
	}
	@Override
	public String getfonctionnbrjabs(Long idfon) {
		// TODO Auto-generated method stub
	return daof.getfonctionnbrjabs(idfon);
	}
	@Override
	public void updatejoursabs(Conge c,Long idfon) {
daof.updatejoursabs(c,idfon);		
	}
	@Override
	public List<Heuresupp> detailheuresupfon(Long idfon) {
		// TODO Auto-generated method stub
		return daof.detailheuresupfon(idfon);
	}
	@Override
	public List<Conge> getabsdetail(Long idfon,String date1, String date2) {
		// TODO Auto-generated method stub
		return daof.getabsdetail(idfon,date1, date2);
	}
	@Override
	public List<Autorisation> getabsdetailauto(Long idfon, String date1, String date2) {
		// TODO Auto-generated method stub
		return daof.getabsdetailauto(idfon, date1, date2);
	}
	@Override
	public List<Heureabsfon> getretaddetailauto(Long idfon, String date1, String date2) {
		// TODO Auto-generated method stub
		return daof.getretaddetailauto(idfon, date1, date2);
	}
	@Override
	public List<Conge> getjourabsdetail(Long idfon, String date1, String date2) {
		// TODO Auto-generated method stub
		return daof.getjourabsdetail(idfon, date1, date2);
	}
	@Override
	public List<Fonctionnaires> recherchrefonctionnairesauto(String nom) {
		// TODO Auto-generated method stub
		return daof.recherchrefonctionnairesauto(nom);
	}




}
