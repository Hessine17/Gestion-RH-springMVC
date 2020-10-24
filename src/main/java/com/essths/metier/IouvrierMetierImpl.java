package com.essths.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.essths.DAO.IouvrierDAO;
import com.essths.entities.Autorisation;

import com.essths.entities.Conge;

import com.essths.entities.Heureabsfon;

import com.essths.entities.Heuresuppouvrier;

import com.essths.entities.Ouvriers;
@Transactional
public class IouvrierMetierImpl implements IouvrierMetier {
private IouvrierDAO daoO;
	public IouvrierMetierImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long ajouterouvriers(Ouvriers o) {
		// TODO Auto-generated method stub
		return daoO.ajouterouvriers(o);
	}

	@Override
	public List<Ouvriers> listeouvriers() {
		// TODO Auto-generated method stub
		return daoO.listeouvriers();
	}

	@Override
	public void suppouvriers(Long id) {
		// TODO Auto-generated method stub
		daoO.suppouvriers(id);
	}

	@Override
	public void modifierouvriers(Ouvriers o) {
		// TODO Auto-generated method stub
		daoO.modifierouvriers(o);
	}

	@Override
	public Ouvriers getouvriers(Long id) {
		// TODO Auto-generated method stub
		return daoO.getouvriers(id);
	}

	public IouvrierDAO getDaoO() {
		return daoO;
	}

	public void setDaoO(IouvrierDAO daoO) {
		this.daoO = daoO;
	}

	@Override
	public List<Ouvriers> ordrebynom() {
		// TODO Auto-generated method stub
		return daoO.ordrebynom();
	}

	@Override
	public List<Ouvriers> ordrebygrade() {
		// TODO Auto-generated method stub
		return daoO.ordrebygrade();
	}

	@Override
	public List<Ouvriers> ordrebyheureTravail() {
		// TODO Auto-generated method stub
		return daoO.ordrebyheureTravail();
	}

	@Override
	public Long ajouterheure(Heuresuppouvrier h, Long idouv) {
		// TODO Auto-generated method stub
		return daoO.ajouterheure(h, idouv);
	}

	@Override
	public List<Ouvriers> recherchreOuvriers(String nom) {
		// TODO Auto-generated method stub
		return daoO.recherchreOuvriers(nom);
	}

	@Override
	public String sommeheuresuppfonctionnaire(Long idouv,String date1,String date2) {
		// TODO Auto-generated method stub
		return daoO.sommeheuresuppfonctionnaire(idouv,date1,date2);
	}

	@Override
	public Long ajouterheureabs(Heureabsfon h, Long idouv) {
		// TODO Auto-generated method stub
		return daoO.ajouterheureabs(h, idouv);
	}

	@Override
	public List<Heureabsfon> listeouvrierretard() {
		// TODO Auto-generated method stub
		return daoO.listeouvrierretard();
	}

	@Override
	public Long ajouterautorisation(Autorisation a, Long idouv) {
		// TODO Auto-generated method stub
		return daoO.ajouterautorisation(a, idouv);
	}

	@Override
	public Long ajouterConge(Conge c, Long idouv) {
		// TODO Auto-generated method stub
		return daoO.ajouterConge(c, idouv);
	}

	@Override
	public List<Conge> getListCongeAujourdhui() {
		// TODO Auto-generated method stub
		return daoO.getListCongeAujourdhui();
	}

	@Override
	public Long ajouterjoursabs(Conge j, Long idouv) {
		// TODO Auto-generated method stub
		return daoO.ajouterjoursabs(j, idouv);
	}

	@Override
	public List<Conge> listeouvrierabs() {
		// TODO Auto-generated method stub
		return daoO.listeouvrierabs();
	}

	@Override
	public void modifcongé(Conge c) {
		// TODO Auto-generated method stub
		daoO.modifcongé(c);
	}

	@Override
	public List<Heureabsfon> listeouvrierretarddate(String date1, String date2) {
		// TODO Auto-generated method stub
		return daoO.listeouvrierretarddate(date1, date2);
	}

	@Override
	public List<Ouvriers> titularasation() {
		// TODO Auto-generated method stub
		return daoO.titularasation();
	}

	@Override
	public List<Conge> listeouvrierabsdate(String date,String date2) {
		// TODO Auto-generated method stub
		return daoO.listeouvrierabsdate(date,date2);
	}

	@Override
	public String getouvriernbrjabs(Long idouv) {
		// TODO Auto-generated method stub
		return daoO.getouvriernbrjabs(idouv);
	}

	@Override
	public void updatejoursabs(Conge c, Long idouv) {
		// TODO Auto-generated method stub
		daoO.updatejoursabs(c, idouv);
	}

	@Override
	public List<Heuresuppouvrier> detailheuresupouv(Long idouv) {
		// TODO Auto-generated method stub
		return daoO.detailheuresupouv(idouv);
	}

	@Override
	public List<Conge> getabsdetail(Long idouv, String date1, String date2) {
		// TODO Auto-generated method stub
		return daoO.getabsdetail(idouv, date1, date2);
	}

	@Override
	public List<Autorisation> getabsdetailauto(Long idouv, String date1, String date2) {
		// TODO Auto-generated method stub
		return daoO.getabsdetailauto(idouv, date1, date2);
	}

	@Override
	public List<Heureabsfon> getretaddetailauto(Long idouv, String date1, String date2) {
		// TODO Auto-generated method stub
		return daoO.getretaddetailauto(idouv, date1, date2);
	}

	@Override
	public List<Conge> getjourabsdetail(Long idouv, String date1, String date2) {
		// TODO Auto-generated method stub
		return daoO.getjourabsdetail(idouv, date1, date2);
	}

}
