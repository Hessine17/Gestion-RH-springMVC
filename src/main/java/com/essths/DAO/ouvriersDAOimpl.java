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

import com.essths.entities.Autorisation;

import com.essths.entities.Conge;

import com.essths.entities.Fonctionnaires;
import com.essths.entities.Heureabsfon;

import com.essths.entities.Heuresuppouvrier;

import com.essths.entities.Ouvriers;

public class ouvriersDAOimpl implements IouvrierDAO {
	@PersistenceContext
	private EntityManager em;
	public ouvriersDAOimpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long ajouterouvriers(Ouvriers o) {
		em.persist(o);
		return o.getId();
	}

	@Override
	public List<Ouvriers> listeouvriers() {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select o from Ouvriers o");
		return req.getResultList();
	}

	@Override
	public void suppouvriers(Long id) {
		Ouvriers o=em.find(Ouvriers.class, id);
		em.remove(o);
		
	}

	@Override
	public void modifierouvriers(Ouvriers o) {
		// TODO Auto-generated method stub
		o=em.merge(o);
		
	}

	@Override
	public Ouvriers getouvriers(Long id) {
		 String reqt = "SELECT  o from Ouvriers o WHERE id= '" + id + "'";
			

			Query req=em.createQuery(reqt);
		
			return (Ouvriers) req.getResultList().get(0);
	}

	@Override
	public List<Ouvriers> ordrebynom() {
		Query req=em.createQuery("select o from Ouvriers o order by nom");
		return req.getResultList();
	}

	@Override
	public List<Ouvriers> ordrebygrade() {
			Query req=em.createQuery("select o from Ouvriers o order by grade");
		return req.getResultList();
	}

	@Override
	public List<Ouvriers> ordrebyheureTravail() {
		Query req=em.createQuery("select o from Ouvriers o order by heureTravaildebut");
		return req.getResultList();
	}

	@Override
	public List<Ouvriers> recherchreOuvriers(String nom) {
		Query req=em.createQuery("select o from Ouvriers o where o.nom like'"+nom+"%'");
		return req.getResultList();
	}

	@Override
	public Long ajouterheure(Heuresuppouvrier h, Long idouv) {
		Ouvriers o=getouvriers(idouv);
		h.setOuvriers(o);
	
		em.persist(h);
		return h.getId();
	}

	@Override
	public String sommeheuresuppfonctionnaire(Long idouv,String date1,String date2) {
		String reqt = "SELECT   SUM(nbrheure)  from Heuresuppouvrier h where idouv='"+idouv+"' AND date>='"+date1+"'AND date<='"+date2+"'";
		
		
		Query req=em.createQuery(reqt);
		String heuretotal=(String) req.getSingleResult();
	
		System.out.println("SUM result:"+heuretotal);
		
	//	return req.getResultList();
		return heuretotal;
	}

	@Override
	public Long ajouterheureabs(Heureabsfon h, Long idouv) {
		Ouvriers o=getouvriers(idouv);
		h.setOuvriers(o);
	
		em.persist(h);
		return h.getId();
	}

	@Override
	public List<Heureabsfon> listeouvrierretard() {
		Query req=em.createQuery("select h from Heureabsfon h where idfon=null");
		return req.getResultList();
	}

	@Override
	public List<Heureabsfon> listeouvrierretarddate(String date1, String date2) {
		Query req=em.createQuery("select h from Heureabsfon h where  date>='"+date1+"'AND date<='"+date2+"' and idfon=null" );
		return req.getResultList();
	}
	
	@Override
	public Long ajouterautorisation(Autorisation a, Long idouv) {
		Ouvriers o=getouvriers(idouv);
		a.setOuvriers(o);
		em.persist(a);
		return a.getId();
	}

	@Override
	public Long ajouterConge(Conge c, Long idouv) {
		Ouvriers f=getouvriers(idouv);
		c.setOuvriers(f);;
		em.persist(c);
		return c.getId();
	}

	@Override
	public List<Conge> getListCongeAujourdhui() {
		Query req=em.createQuery(" SELECT c FROM Conge c  where datedefin =CURDATE()");
		System.out.println(req);
		return req.getResultList();
	}

	@Override
	public Long ajouterjoursabs(Conge j, Long idouv) {
		Ouvriers o=getouvriers(idouv);
		j.setOuvriers(o);
	
		em.persist(j);
		return j.getId();
	}

	@Override
	public List<Conge> listeouvrierabs() {
		Query req=em.createQuery(" SELECT c FROM Conge c  order by type");
		System.out.println(req);
		return req.getResultList();
	}
	
	
	@Override
	public List<Conge> listeouvrierabsdate(String date,String date2) {
		Query req=em.createQuery(" SELECT c FROM Conge c  where datededebut>='"+date+"'and datededebut<='"+date2+"' order by type");
	
		System.out.println(req);
		return req.getResultList();
	}


	@Override
	public void modifcongé(Conge c) {
		Query req=em.createQuery("UPDATE Ouvriers  o SET o.congéanull = o.congéanull-'"+c.getNbrj()+"' WHERE o.id ='"+ c.getOuvriers().getId()+"'");
		req.executeUpdate();
		
	}

	@Override
	public List<Ouvriers> titularasation() {
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
		String req1="SELECT o FROM Ouvriers o where o.datereq between '"+dateAS+"' and'"+ dateBS+"'";
				Query req=em.createQuery(req1);
				System.out.println(req);
				return req.getResultList();
	}

	@Override
	public String getouvriernbrjabs(Long idouv) {
		
	String reqt = "SELECT f FROM Conge  f WHERE idouv='"+idouv+"'and datederetour='1900-01-01'";
	
		
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
	public void updatejoursabs(Conge c, Long idouv) {
		Query req=em.createQuery("UPDATE Conge  c  SET c.datederetour='"+c.getDatederetour()+"',c.nbrj = datediff (date('"+c.getDatederetour()+"'),datededebut)  WHERE idouv ='"+ idouv+"' and c.datededebut='"+c.getDatededebut()+"'");
		req.executeUpdate();	
		
	}

	@Override
	public List<Heuresuppouvrier> detailheuresupouv(Long idouv) {
		Query req=em.createQuery("select h from Heuresuppouvrier h where idouv='"+idouv+"'");
		return req.getResultList();
	}

	@Override
	public List<Conge> getabsdetail(Long idouv, String date1, String date2) {
		Query req=em.createQuery(" SELECT c FROM Conge c  where idouv='"+idouv+"'and c.datededebut >='"+date1+"'and c.datedefin <='"+date2+"'");
		System.out.println(req);
		return req.getResultList();
	}

	@Override
	public List<Autorisation> getabsdetailauto(Long idouv, String date1, String date2) {
		Query req=em.createQuery(" SELECT a FROM Autorisation a  where idouv='"+idouv+"'and a.date >='"+date1+"'and a.date <='"+date2+"'");
		System.out.println(req);
		return req.getResultList();
	}

	@Override
	public List<Heureabsfon> getretaddetailauto(Long idouv, String date1, String date2) {
		Query req=em.createQuery(" SELECT a FROM Heureabsfon a  where idouv='"+idouv+"'and a.date >='"+date1+"'and a.date <='"+date2+"'");
		System.out.println(req);
		return req.getResultList();
	}

	@Override
	public List<Conge> getjourabsdetail(Long idouv, String date1, String date2) {
		Query req=em.createQuery(" SELECT c FROM Conge c  where idouv='"+idouv+"'and c.datededebut >='"+date1+"'and c.datederetour <='"+date2+"'");
		System.out.println(req);
		return req.getResultList();
	}
	

}
