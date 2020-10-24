package com.essths.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.essths.entities.Autorisation;
import com.essths.entities.Conge;
import com.essths.entities.Cooperation;
import com.essths.entities.Enseignants;
import com.essths.entities.Fonctionnaires;
import com.essths.entities.Heuresupp;




public class enseigantsDAOimpl implements IenseignantsDAO{

	public enseigantsDAOimpl() {
		// TODO Auto-generated constructor stub
	}
@PersistenceContext
private EntityManager em;
	@Override
	public int ajouterenseignants(Enseignants e) {
		em.persist(e);
		return e.getId();
	}
	@Override
	public List<Enseignants> listeenseignants() {
		Query req=em.createQuery("select e from Enseignants e");
		return req.getResultList();
	}
	@Override
	
	public void supp(int id) {
		
	
		 
//	Query req=em.createQuery("ALTER TABLE Enseignants  ADD CONSTRAINT FK_T1_T2_Cascade  FOREIGN KEY (iden) REFERENCES Cooperation(id) ON DELETE CASCADE where id='"+id+"'");
//		req.executeUpdate();
	Enseignants e=em.find(Enseignants.class, id);
////		  em.getTransaction().begin();
	em.remove(e);

//	//  em.getTransaction().commit();
////		
	}
	@Override
	public void modifierenseignant(Enseignants e) {
		em.merge(e);
		
	}
	@Override
	public Enseignants getEnseignant(int id) {
		 String reqt = "SELECT  e from Enseignants e WHERE id= '" + id + "'";
			

			Query req=em.createQuery(reqt);
		
			return (Enseignants) req.getResultList().get(0);
		//	return em.find(Enseignants.class, id);
	}
	@Override
	public List<Enseignants> recherchreenseignants(String nom) {
	
		Query req=em.createQuery("select e from Enseignants e where e.nom like'"+nom+"%'");
		return req.getResultList();
	}
	@Override
	public List<Enseignants> ordrebynom() {
		Query req=em.createQuery("select e from Enseignants e order by nom");
		return req.getResultList();
	}
	@Override
	public List<Enseignants> ordrebygrade() {
		Query req=em.createQuery("select e from Enseignants e order by grade");
		return req.getResultList();
	}
	@Override
	public List<Enseignants> ordrebyheureTravail() {
		Query req=em.createQuery("select e from Enseignants e order by heureTravail");
		return req.getResultList();
	}
	@Override
	public Long ajouterheure(Heuresupp h) {
	
		
		em.persist(h);
		return h.getId();
	}
	@Override
	public int ajoutercooperation(Cooperation c,int iden) {
		Enseignants e=getEnseignant(iden);
		c.setEnseignants(e);
		em.persist(c);
		return c.getId();
	}
	@Override
	public List<Cooperation> listeenseignantscooperation() {
		
		
		Query req=em.createQuery("select c from Cooperation c");
		return req.getResultList();
	}
	@Override
	public void suppcooperation(int id) {
		Cooperation c=em.find(Cooperation.class, id);
		em.remove(c);
		
	}
	@Override
	public String selectidenfi(String identificateur) {
		String reqt = "SELECT    identificateur from Enseignants e where e.identificateur='"+identificateur+"'  ";
		
		
		Query req=em.createQuery(reqt);
		//String identificateur=(String) req.getSingleResult();
	
		System.out.println("SUM result:"+identificateur);
		
		return identificateur;
	}
	@Override
	public List<Enseignants>  countnbrenseignant() {
	//	String reqt =;
		
		
	//	Query req=em.createQuery( "SELECT COUNT(id) FROM Enseignants");
//		int nbrenseignants=(int) req.getMaxResults();
//	 
//		
//		System.out.println("SUM result:"+nbrenseignants);
		Query req=em.createQuery("SELECT e FROM Enseignants e");
		System.out.println("SUM result:"+req);
		return req.getResultList();
		
	}
	@Override
	public Long ajouterautorisation(Autorisation a, int iden) {
		Enseignants e=getEnseignant(iden);
		a.setEnseignants(e);
		em.persist(a);
		return a.getId();
	}
	@Override
	public Long ajouterConge(Conge c, int iden) {
		Enseignants e=getEnseignant(iden);
		c.setEnseignants(e);
		em.persist(c);
		return c.getId();
	}
	@Override
	public List<Conge> getabsdetail(int iden, String date1, String date2) {
		Query req=em.createQuery(" SELECT c FROM Conge c  where iden='"+iden+"'and c.datededebut >='"+date1+"'and c.datedefin <='"+date2+"'");
		System.out.println(req);
		return req.getResultList();
	}
	@Override
	public List<Autorisation> getabsdetailauto(int iden, String date1, String date2) {
		Query req=em.createQuery(" SELECT a FROM Autorisation a  where iden='"+iden+"'and a.date >='"+date1+"'and a.date <='"+date2+"'");
		System.out.println(req);
		return req.getResultList();
	}

}
