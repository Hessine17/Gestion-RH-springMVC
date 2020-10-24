package com.essths.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.essths.DAO.IenseignantsDAO;
import com.essths.entities.Autorisation;
import com.essths.entities.Conge;
import com.essths.entities.Cooperation;
import com.essths.entities.Enseignants;
import com.essths.entities.Heuresupp;
@Transactional
public class IenseignantsMetierImpl  implements IenseignantsMetier{
private IenseignantsDAO dao;
	public IenseignantsMetierImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int ajouterenseignants(Enseignants e) {
		
		return dao.ajouterenseignants(e);
	}

	public IenseignantsDAO getDao() {
		return dao;
	}

	public void setDao(IenseignantsDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Enseignants> listeenseignants() {
		
		return dao.listeenseignants();
	}

	@Override
	public void supp(int id) {
		dao.supp(id);
		
		
	}

	@Override
	public void modifierenseignant(Enseignants E) {
		dao.modifierenseignant(E);
		
	}

	@Override
	public Enseignants getEnseignant(int id) {
		// TODO Auto-generated method stub
		return dao.getEnseignant(id);
	}

	@Override
	public List<Enseignants> recherchreenseignants(String nom) {

		return dao.recherchreenseignants(nom);
	}

	@Override
	public List<Enseignants> ordrebynom() {
		
		return dao.ordrebynom();
	}

	@Override
	public List<Enseignants> ordrebygrade() {
		// TODO Auto-generated method stub
		return dao.ordrebygrade();
	}

	@Override
	public List<Enseignants> ordrebyheureTravail() {
		// TODO Auto-generated method stub
		return dao.ordrebyheureTravail();
	}

	@Override
	public Long ajouterheure(Heuresupp h) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int ajoutercooperation(Cooperation c,int iden) {
		// TODO Auto-generated method stub
		return dao.ajoutercooperation(c,iden);
	}

	@Override
	public List<Cooperation> listeenseignantscooperation() {
		// TODO Auto-generated method stub
		return dao.listeenseignantscooperation();
	}

	@Override
	public void suppcooperation(int id) {
		dao.suppcooperation(id);
		
	}

	@Override
	public String selectidenfi(String identificateur) {
		// TODO Auto-generated method stub
		return dao.selectidenfi(identificateur);
	}

	@Override
	public List<Enseignants> countnbrenseignant() {
		// TODO Auto-generated method stub
		return dao.countnbrenseignant();
	}

	@Override
	public Long ajouterautorisation(Autorisation a, int iden) {
		// TODO Auto-generated method stub
		return dao.ajouterautorisation(a, iden);
	}

	@Override
	public Long ajouterConge(Conge c, int iden) {
		// TODO Auto-generated method stub
		return dao.ajouterConge(c, iden);
	}

	@Override
	public List<Conge> getabsdetail(int iden, String date1, String date2) {
		// TODO Auto-generated method stub
		return dao.getabsdetail(iden, date1, date2);
	}

	@Override
	public List<Autorisation> getabsdetailauto(int iden, String date1, String date2) {
		// TODO Auto-generated method stub
		return dao.getabsdetailauto(iden, date1, date2);
	}





}
