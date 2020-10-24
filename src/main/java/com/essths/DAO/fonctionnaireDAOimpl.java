package com.essths.DAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;

import com.essths.entities.Autorisation;
import com.essths.entities.Conge;
import com.essths.entities.Cooperation;
import com.essths.entities.Enseignants;
import com.essths.entities.Fonctionnaires;
import com.essths.entities.Heureabsfon;
import com.essths.entities.Heuresupp;

import com.essths.entities.Ouvriers;

import javassist.bytecode.annotation.IntegerMemberValue;

public class fonctionnaireDAOimpl implements IfonctionnaireDAO {
@PersistenceContext
private EntityManager em;
	public fonctionnaireDAOimpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long ajouterfonctionnaire(Fonctionnaires F) {
		em.persist(F);
		return F.getId();
	}

	@Override
	public List<Fonctionnaires> listefonctionnaire() {
		Query req=em.createQuery("select f from Fonctionnaires f");
		return req.getResultList();
	}

	
	@Override

	public void supp(Long id) {
		
//		Query req=em.createQuery("DELETE   from Fonctionnaires f where f.id='"+id+"'");
//		req.executeUpdate();	
		Fonctionnaires f=em.find(Fonctionnaires.class, id);
	em.remove(f);
	
		
	}

	@Override
	public void modifierfonctionnaire(Fonctionnaires f) {
		f=em.merge(f);
		
	}

	@Override
	public Fonctionnaires getfonctionnaire(Long id) {
		 String reqt = "SELECT  f from Fonctionnaires f WHERE id= '" + id + "'";
		

		Query req=em.createQuery(reqt);
	
		return (Fonctionnaires) req.getResultList().get(0);
		/* return em.find(Fonctionnaires.class, id);*/
	}

	@Override
	public List<Fonctionnaires> ordrebynom() {
		Query req=em.createQuery("select o from Fonctionnaires o order by nom");
		return req.getResultList();
	}

	@Override
	public List<Fonctionnaires> ordrebygrade() {
		Query req=em.createQuery("select o from Fonctionnaires o order by grade");
		return req.getResultList();
	}

	@Override
	public List<Fonctionnaires> ordrebyheureTravail() {
		Query req=em.createQuery("select o from Fonctionnaires o order by heureTravaildebut");
		return req.getResultList();
	}

	@Override
	public Long ajouterheure(Heuresupp h,Long idfon ) {
	Fonctionnaires f=getfonctionnaire(idfon);
		h.setFonctionnaires(f);
	
		em.persist(h);
		return h.getId();
	}
	
	@Override
	public List<Fonctionnaires> recherchrefonctionnaires(String nom) {
	
		Query req=em.createQuery("select e from Fonctionnaires e where e.nom like'"+nom+"%'");
		return req.getResultList();
	}

	@Override
	public Long ajouterautorisation(Autorisation a ,Long idfon) {
		Fonctionnaires f=getfonctionnaire(idfon);
		a.setFonctionnaires(f);
		em.persist(a);
		return a.getId();
	}

	@Override
	public String sommeheuresuppfonctionnaire(Long idfon,String date1,String date2) {
	
		String reqt = "SELECT   SUM(nbrheure) as heuretotal from Heuresupp h where idfon='"+idfon+"' AND date>='"+date1+"'AND date<='"+date2+"'";
			
		
			Query req=em.createQuery(reqt);
			String heuretotal=(String) req.getSingleResult();
		
			System.out.println("SUM result:"+heuretotal);
			
			return heuretotal;
	
	}

	

	@Override
	public List<Conge> getListCongeAujourdhui() {
		Query req=em.createQuery(" SELECT c FROM Conge c  where datedefin =CURDATE()");
		System.out.println(req);
		return req.getResultList();
	}

	@Override
	public Long ajouterConge(Conge c ,Long idfon) {
		Fonctionnaires f=getfonctionnaire(idfon);
		c.setFonctionnaires(f);
		em.persist(c);
		return c.getId();
	}

	@Override
	public Long ajouterheureabs(Heureabsfon h, Long idfon) {
		Fonctionnaires f=getfonctionnaire(idfon);
		h.setFonctionnaires(f);
	
		em.persist(h);
		return h.getId();
	}

	@Override
	public List<Heureabsfon> listefonctionnaireretard() {
		Query req=em.createQuery("select h from Heureabsfon h where idouv=null ");
		return req.getResultList();
	}
	
	@Override
	public List<Heureabsfon> listefonctionnaireretarddate(String date1, String date2) {
		Query req=em.createQuery("select h from Heureabsfon h where  date>='"+date1+"'AND date<='"+date2+"' AND idouv=null"  );
		return req.getResultList();
	}

	@Override
	public void modifcongé(Conge c) {
		Query req=em.createQuery("UPDATE Fonctionnaires  f SET f.congéanull = f.congéanull-'"+c.getNbrj()+"' WHERE f.id ='"+ c.getFonctionnaires().getId()+"'");
		req.executeUpdate();
	}

	@Override
	public List<Fonctionnaires> titularasation() {
	

	DateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");

Calendar	dateA= Calendar.getInstance(); //issna3it clendier
dateA.setTime(new Date());// Calendar béch na5ou date ilyouma 
dateA.add(Calendar.YEAR, -4);//nass9ssit ni date ilyouma 4 ans 
Calendar	dateB= Calendar.getInstance();//issna3it clendier
dateB.setTime(new Date());// Calendar béch na5ou date ilyouma 


dateB.add(Calendar.DAY_OF_WEEK, 2); //bech inzid 2 jours 3alé date ilyouma
dateB.add(Calendar.YEAR, -4);//bech na9sit 4 ans 3alé date ilyouma

String dateAS=dateformat.format(dateA.getTime()); //béch na5ou ken date 
String dateBS=dateformat.format(dateB.getTime());
System.out.println(dateAS);
System.out.println("aaaaa"+dateBS);
String req1="SELECT f FROM Fonctionnaires f where f.datereq between '"+dateAS+"' and'"+ dateBS+"'";
		Query req=em.createQuery(req1);
		System.out.println(req);
		return req.getResultList();
	}

	@Override
	public Long ajouterjoursabs(Conge j, Long idfon) {
		Fonctionnaires f=getfonctionnaire(idfon);
		j.setFonctionnaires(f);
	
		em.persist(j);
		return j.getId();
	}

	@Override
	public List<Autorisation> listeAutorisation() {
		
		
		Query req=em.createQuery("select a from Autorisation a");
		return req.getResultList();
	}

	@Override
	public String getfonctionnbrjabs(Long idfon) {	
		
	String reqt = "SELECT f FROM Conge  f WHERE idfon='"+idfon+"'and datederetour='1900-01-01'";
	
		
		Query req=em.createQuery(reqt);	
		
	List<Conge> som=(ArrayList<Conge>) req.getResultList();
	
	if(som!=null){
		if(som.size()!=0)
		return som.get(0).getDatededebut();else return "jj/mm/aaaa";
			
		
	}else{
		return "jj/mm/aaaa";
	}
	

	}

	@Override
	public void updatejoursabs(Conge c ,Long idfon) {
		Query req=em.createQuery("UPDATE Conge  c  SET c.datederetour='"+c.getDatederetour()+"',c.nbrj = datediff (date('"+c.getDatederetour()+"'),datededebut) WHERE idfon ='"+ idfon+"' and c.datededebut='"+c.getDatededebut()+"'");
		req.executeUpdate();	
	}

	@Override
	public List<Heuresupp> detailheuresupfon(Long idfon) {
		Query req=em.createQuery("select h from Heuresupp h where idfon='"+idfon+"'");
		return req.getResultList();
	}

	@Override
	public List<Conge> getabsdetail(Long id,String date1, String date2) {

		Query req=em.createQuery(" SELECT c FROM Conge c  where idfon='"+id+"'and c.datededebut >='"+date1+"'and c.datedefin <='"+date2+"'");
		System.out.println(req);
		return req.getResultList();
	}

	@Override
	public List<Autorisation> getabsdetailauto(Long idfon, String date1, String date2) {
		Query req=em.createQuery(" SELECT a FROM Autorisation a  where idfon='"+idfon+"'and a.date >='"+date1+"'and a.date <='"+date2+"'");
		System.out.println(req);
		return req.getResultList();
	}

	@Override
	public List<Heureabsfon> getretaddetailauto(Long idfon, String date1, String date2) {
		Query req=em.createQuery(" SELECT a FROM Heureabsfon a  where idfon='"+idfon+"'and a.date >='"+date1+"'and a.date <='"+date2+"'");
		System.out.println(req);
		return req.getResultList();
	}

	@Override
	public List<Conge> getjourabsdetail(Long idfon, String date1, String date2) {
		Query req=em.createQuery(" SELECT c FROM Conge c  where idfon='"+idfon+"'and c.datededebut >='"+date1+"'and c.datederetour <='"+date2+"'");
		System.out.println(req);
		return req.getResultList();
	}

	@Override
	public List<Fonctionnaires> recherchrefonctionnairesauto(String nom) {
		Query req=em.createQuery("select a from Autorisation a where a.nom like'"+nom+"%'");
		return req.getResultList();
	}



}
