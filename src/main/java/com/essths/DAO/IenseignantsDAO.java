package com.essths.DAO;

import java.util.List;

import com.essths.entities.Autorisation;
import com.essths.entities.Conge;
import com.essths.entities.Cooperation;
import com.essths.entities.Enseignants;
import com.essths.entities.Heuresupp;

public interface IenseignantsDAO {
	public int ajouterenseignants(Enseignants e);
	public List<Enseignants> listeenseignants();
	public void supp(int id);
	public void suppcooperation(int id);
	public void modifierenseignant(Enseignants e);
	public Enseignants getEnseignant(int id);
	public List<Enseignants> recherchreenseignants(String nom);
	public List<Enseignants> ordrebynom();
	public List<Enseignants> ordrebygrade();
	public List<Enseignants> ordrebyheureTravail();
	public Long ajouterheure(Heuresupp h );
	public int ajoutercooperation(Cooperation c,int iden);
	public List<Cooperation> listeenseignantscooperation();
	public String selectidenfi(String identificateur);
	public List<Enseignants> countnbrenseignant();
	public Long ajouterautorisation(Autorisation a,int iden);
	public Long ajouterConge(Conge c ,int iden);
	public List<Conge> getabsdetail(int iden,String date1,String date2);
	public List<Autorisation> getabsdetailauto(int iden,String date1,String date2);
	
	

}
