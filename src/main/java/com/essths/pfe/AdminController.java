package com.essths.pfe;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.Principal;
import java.sql.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.essths.entities.Autorisation;
import com.essths.entities.Conge;
import com.essths.entities.Cooperation;
import com.essths.entities.Enseignants;
import com.essths.entities.Fonctionnaires;
import com.essths.entities.Heureabsfon;
import com.essths.entities.Heuresupp;
import com.essths.entities.Heuresuppouvrier;

import com.essths.entities.Ouvriers;
import com.essths.metier.IenseignantsMetier;
import com.essths.metier.IfonctionnaireMetier;
import com.essths.metier.IouvrierMetier;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private IenseignantsMetier metier;
	@Autowired
	private IfonctionnaireMetier metier2;
	@Autowired
	private IouvrierMetier metier3;
	 private byte[] files;
	
	/**********************************home******************************************************/
	
		@RequestMapping(value = "/home")
		public String homr( Model model, Principal principal) {
			
			String name = principal.getName();
			model.addAttribute("username", name);
			
			model.addAttribute("notification",metier2.getListCongeAujourdhui().size());
			model.addAttribute("notifications",metier2.getListCongeAujourdhui());
		   int a=metier2.titularasation().size();
		   int b=metier3.titularasation().size();
		   int c=a+b;
		
			model.addAttribute("titu",c);
			model.addAttribute("titulis",metier2.titularasation());
		model.addAttribute("tituliso",metier3.titularasation());	
			model.addAttribute("enseignants", metier.countnbrenseignant().size());
			model.addAttribute("fonctionnaires", metier2.listefonctionnaire().size());
			model.addAttribute("heureretardfon", 0);
			model.addAttribute("presentfon", 0);
			model.addAttribute("heureretardouv", 0);
			model.addAttribute("presentouv", 0);
			model.addAttribute("ouvriers", metier3.listeouvriers().size());
			
			return "home";
		}
	@RequestMapping(value="/stat")
	public String stat(Model model, Principal principal,@RequestParam String date1,@RequestParam String date2){
		
		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("notification",metier2.getListCongeAujourdhui().size());
		model.addAttribute("notifications",metier2.getListCongeAujourdhui());
	   int a=metier2.titularasation().size();
	   int b=metier3.titularasation().size();
	   int c=a+b;
	
		model.addAttribute("titu",c);
		model.addAttribute("titulis",metier2.titularasation());
	model.addAttribute("tituliso",metier3.titularasation());	
		model.addAttribute("enseignants", metier.countnbrenseignant().size());
		model.addAttribute("fonctionnaires", metier2.listefonctionnaire().size());
		int totalouv=metier3.listeouvriers().size();
		int	retardouv=metier3.listeouvrierretarddate(date1, date2).size();
		int presentouv=totalouv-retardouv;
		
		int totalfon=metier2.listefonctionnaire().size();
		int	retardfon=metier2.listefonctionnaireretarddate(date1,date2).size();
		int presentfon=totalfon-retardfon;
		model.addAttribute("heureretardouv", metier3.listeouvrierretarddate(date1, date2).size());
		model.addAttribute("presentfon", presentfon);
		model.addAttribute("heureretardfon", metier2.listefonctionnaireretarddate(date1, date2).size());
		model.addAttribute("presentouv", presentouv);
		model.addAttribute("ouvriers", metier3.listeouvriers().size());
		
		return"home";
	}
	
		@RequestMapping(value = "/listeautorisation")
		public String listeautorisation( Model model) {
			
			model.addAttribute("listeautorisation", metier2.listeAutorisation());
			
			return "listeautorisation";
		}


	
	/*****************************************************************************************/
		@RequestMapping(value = "/rechrechFonauto")
		public String test(String nom, Model model) {
			
			model.addAttribute("fonctionnaires", metier2.listefonctionnaire());
			
			return "rechrechFonauto";
		}
		@RequestMapping(value = "/rechrechFonautoper")
	public String rechrechFonautoper(String nom, Model model) {
		
		model.addAttribute("fonctionnaires", metier2.recherchrefonctionnaires(nom));
		
		return "rechrechFonauto";
	}
	@RequestMapping(value = "/autorisationFon")
	public String autorisationFon(Long id,Model model) {
		
		Fonctionnaires a=metier2.getfonctionnaire(id);
		model.addAttribute("fonctionnaire",a );
		
		return "autorisationFon";
	}
	@RequestMapping(value = "/addauto")
	public String addauto(@Valid Autorisation a, Long idfon,Model model,HttpServletRequest request) {
		
try{		Fonctionnaires f=metier2.getfonctionnaire(idfon);
		model.addAttribute("fonctionnaire",f );
		request.setAttribute("ajouter_avec_succes",  " avec succés");
		metier2.ajouterautorisation(a,idfon);
		return "autorisationFon";
}catch (Exception message){ 
	request.setAttribute("Erreur",  "Erreur");
	
	
	return "autorisationFon";}	

		
		
	}
/***************************************autorisation en***/
	
	@RequestMapping(value = "/rechrechEnauto")
	public String rechrechFonauto(String nom, Model model) {
		
		model.addAttribute("enseignants", metier.listeenseignants());
		
		return "rechrechEnauto";
	}
	@RequestMapping(value = "/rechrechEnautoper")
public String rechrechEnautoper(String nom, Model model) {
	
	model.addAttribute("enseignants", metier.recherchreenseignants(nom));
	
	return "rechrechEnauto";
}
@RequestMapping(value = "/autorisationEn")
public String autorisationen(int id,Model model) {
	
Enseignants e=metier.getEnseignant(id);
	model.addAttribute("enseignants",e );
	
	return "autorisationEn";
}
@RequestMapping(value = "/addautoen")
public String addautoen(@Valid Autorisation a, int iden,Model model,HttpServletRequest request) {
	
try{	
	Enseignants e=metier.getEnseignant(iden);
	model.addAttribute("enseignants",e );

	
	metier.ajouterautorisation(a, iden);
	request.setAttribute("ajouter_avec_succes",  " avec succés");
	return "autorisationEn";
}
catch (Exception message){ 
	request.setAttribute("Erreur",  "Erreur");
	

return "autorisationEn";}
	
	
	
	
}


/**********************détail abs et auto enseignants **/
@RequestMapping(value = "/detailen")
public String detailen(int id, Model model) {

	Enseignants e=metier.getEnseignant(id);
	model.addAttribute("enseignants",e );
	
	
return "détailscongeen";

}
//
@RequestMapping(value = "/détailen")
public String détailen(int iden, Model model ,@RequestParam String date1,String date2) {
//	
	Enseignants o=metier.getEnseignant(iden);
	model.addAttribute("enseignants",o );
model.addAttribute("détail", metier.getabsdetail(iden ,date1, date2));


	return "détailscongeen";
//
}


@RequestMapping(value = "/detailenauto")
public String detailenauto(int id, Model model) {

	Enseignants e=metier.getEnseignant(id);
	model.addAttribute("enseignants",e );
	
	
return "détailsautoen";

}
//
@RequestMapping(value = "/détailautoen")
public String détailautoen(int iden, Model model ,@RequestParam String date1,String date2) {
//	
	Enseignants e=metier.getEnseignant(iden);
	model.addAttribute("enseignants",e );
	
model.addAttribute("détail", metier.getabsdetailauto(iden, date1, date2));


	return "détailsautoen";
//
}
	/*********************************** Congé enseignants****/

@RequestMapping(value = "/rechrechEnConge")
public String rechrechEnConge(String nom, Model model) {
	
	model.addAttribute("enseignants", metier.listeenseignants());
	
	return "rechrechEnConge";
}


@RequestMapping(value = "/rechrechEnCongeper")
public String rechrechEnCongeper(String nom, Model model) {
	
	model.addAttribute("enseignants", metier.recherchreenseignants(nom));
	
	return "rechrechEnConge";
}




@RequestMapping(value = "/autorisationEnConge")
public String autorisationEnConge(int id, Model model) {
	
	Enseignants f=metier.getEnseignant(id);
	model.addAttribute("enseignants",f );

	
	model.addAttribute("notification",metier2.getListCongeAujourdhui().size());
	model.addAttribute("notifications",metier2.getListCongeAujourdhui());

	return "autorisationEnConge";

}
@RequestMapping(value = "/addcongeEn")

public String addcongeEn(@Valid Conge c,@RequestParam int iden , Model model , @RequestParam String nom ,@RequestParam String type  , @RequestParam String datededebut, @RequestParam String datedefin, @RequestParam int  nbrj,	HttpServletRequest request ) throws IOException{


try{
	Enseignants f=metier.getEnseignant(iden);
	model.addAttribute("enseignants",f );

		
metier.ajouterConge(c, iden);


request.setAttribute("ajouter_avec_succes",  " avec succés");
return "autorisationEnConge";
}
catch (Exception message){ 
	request.setAttribute("Erreur",  "Erreur");
	

return "autorisationEnConge";}
						}
/***********************************enseignants***********************************************************************************************************/
	
	@RequestMapping(value = "/gererenseignants")
	public String gererenseignants( Model model) {
		
		model.addAttribute("notification",metier2.getListCongeAujourdhui().size());
		model.addAttribute("notifications",metier2.getListCongeAujourdhui());
	
	model.addAttribute("titu",metier2.titularasation().size());
		model.addAttribute("titulis",metier2.titularasation());
//		
		model.addAttribute("enseignant", new Enseignants());
		model.addAttribute("enseignants", metier.listeenseignants());

		
		return "gererenseignants";
	}



	/***********supprimer enseignant*******/
	@RequestMapping(value = "/suppenseignant")
	public String suppenseignant(int id, Model model,HttpServletRequest request) {
	//	metier.suppcooperation(id);

try{		metier.supp(id);
		
			model.addAttribute("enseignant", new Enseignants());
			model.addAttribute("enseignants", metier.listeenseignants());
			request.setAttribute("Supprimer_avec_succes",  " Supprimer avec succés ");
		return "gererenseignants";}
catch (Exception message){ 
	request.setAttribute("Erreur",  "Erreur");
	

return "gererenseignants";}
	}




	/***********ajouter enseignant*******/
	@RequestMapping(value = "/adden")
	public String adden(@Valid Enseignants e , Model model ,@RequestParam String nom ,@RequestParam String identificateur ,@RequestParam String prenom  ,@RequestParam String tel ,@RequestParam String adresse ,@RequestParam String email ,
			MultipartFile file,	HttpServletRequest request, @RequestParam String type ,@RequestParam String grade ,@RequestParam String datereq,BindingResult bindingResult) throws IOException{

		
	
				
		
		if (!file.isEmpty()){
			BufferedImage bi=ImageIO.read(file.getInputStream());
			e.setPhoto1(file.getBytes());
			e.setphoto(file.getOriginalFilename());
		}
		

	try{
	metier.ajouterenseignants(e);
	model.addAttribute("enseignant", new Enseignants());
	model.addAttribute("enseignants", metier.listeenseignants());
	request.setAttribute("ajouter_avec_succes",  " avec succés");
	return "gererenseignants";


	}
	catch (Exception message){ 
		request.setAttribute("employe_deja_existe",  "l'identificateur : "+e.getIdentificateur()+" : de ce employé existe deja");
		model.addAttribute("enseignants", metier.listeenseignants());
	
	return "gererenseignants";
	}
							}
	@RequestMapping(value="/photoen",produces=MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] photoen(int id ) throws IOException  {
		Enseignants c=metier.getEnseignant(id);
		
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto1()));
	}

	
	
	

	
	
	/*******************************************cooperation **************************************/



	
	
	
	@RequestMapping(value = "/cooperation")
	public String cooperation( int id,Model model) throws IOException{

		Enseignants e=metier.getEnseignant(id);
	
		model.addAttribute("enseignant",e );
		model.addAttribute("cooperations", metier.listeenseignantscooperation());
				
				return "cooperation";
			}
	
	
	@RequestMapping(value = "/addcoop")
	public String addcoop(@Valid Cooperation c ,@RequestParam int iden,@RequestParam String datededepart,@RequestParam String pays, Model model ,HttpServletRequest request ) throws IOException{
	
		try{
		System.out.println("hhhhhhh");
		metier.ajoutercooperation(c,iden);

			model.addAttribute("cooperation", new Cooperation());
			model.addAttribute("cooperations", metier.listeenseignantscooperation());
			request.setAttribute("ajouter_avec_succes",  " avec succés");
		}
	
	catch (Exception message){ 
	request.setAttribute("employe_deja_existe",  "cette enseignant en coopération");
		model.addAttribute("enseignants", metier.listeenseignantscooperation());
	
	
	}
				
				return "cooperation";
			}
	
	
	/***********supprimer cooperation*******/
	@RequestMapping(value = "/suppcooperation")
	public String suppcooperation(int id, Model model) {
		metier.suppcooperation(id);
		
			model.addAttribute("cooperation", new Enseignants());
			model.addAttribute("cooperations", metier.listeenseignantscooperation());
		return "cooperation";
	}
	
	
	@RequestMapping(value = "/listecooperation")
	public String listecooperation(Model model) {
		
		
			
			model.addAttribute("cooperations", metier.listeenseignantscooperation());

		return "listecooperation";
	}
	
	/**********************************************************************************************/
	
	
	/********************rechrechen*****************************************************/
	@RequestMapping(value="/rechrechen")
	public String rechrechen(String nom ,Model model)	{
		
		
		model.addAttribute("enseignants", metier.recherchreenseignants(nom));
	return "rechrechen";
	}
	
	@RequestMapping(value="/ajouterheureen")
	public String ajouterheureens(@Valid Heuresupp h,Model model)	{
		
	
	return "ajouterheureen";
	

	
	}

	

	/******************----Consultatio et ordre---------**********************************************************************************/

	@RequestMapping(value="/consultationEnsiegnants")
	public String consultation  (Model model)	{
		
		model.addAttribute("enseignants", metier.listeenseignants());
		
	return "consultationEnsiegnants";
	}



	@RequestMapping(value="/ordrebynom")
	public String ordrebynom  (Model model)	{
		
		model.addAttribute("enseignants", metier.ordrebynom());
		
	return "consultationEnsiegnants";
	}



	@RequestMapping(value="/ordrebygrade")
	public String ordrebygrade (Model model)	{
		
		model.addAttribute("enseignants", metier.ordrebygrade());
		
	return "consultationEnsiegnants";
	}


	@RequestMapping(value="/ordrebyheureTravail")
	public String ordrebyheureTravail (Model model)	{
		
		model.addAttribute("enseignants", metier.ordrebyheureTravail());
		
	return "consultationEnsiegnants";
	}


	/***************-----fin-----Consultatio et orde------***********************************************************************************************/

/*	*//***********modifer enseignant*******//*
	@RequestMapping(value="/modifenseignant")
	public String modifenseignant(int id,Model model){
	Enseignants e=metier.getEnseignant(id);



	model.addAttribute("enseignant",e );
	model.addAttribute("enseignants", metier.listeenseignants());
	return "gererenseignants";} */


	/**
	*********************FIN*********************************************************************************************
	*/
	
	
	@RequestMapping(value="/modifenseignant")
	public String modifenseignant(int id,Model model){
		
		
		Enseignants e=metier.getEnseignant(id);

	model.addAttribute("enseignant",e );
	files=e.getPhoto1();
	model.addAttribute("enseignants", metier.listeenseignants());
	return "modifierenseignant";}
	


	@RequestMapping(value = "/moden")
	public String moden(@Valid Enseignants e,@RequestParam int id, Model model ,@RequestParam String identificateur, @RequestParam String nom ,@RequestParam String prenom  ,@RequestParam String tel ,@RequestParam String adresse ,@RequestParam String email ,
		 @RequestParam String type ,@RequestParam String grade, @RequestParam String datereq, MultipartFile file,HttpServletRequest request) throws IOException{

 try{
if(file.isEmpty())
{
	e.setPhoto1(files);
}else {
	e.setPhoto1(file.getBytes());
	
}


		
		System.out.println("hhhhhhh");


	metier.modifierenseignant(e);
	System.out.println("ffffffff");
	model.addAttribute("enseignant",e );
	model.addAttribute("enseignants", metier.listeenseignants());

	request.setAttribute("modifier_avec_succes",  " avec succés");
		return "gererenseignants";}
 catch (Exception message){ 
	 
		request.setAttribute("Erreur",  "Erreur");
		
	
	return "gererenseignants";}
	
	}

	

	
	/**************************************************************************************************************************/

	@RequestMapping(value="/rechrech")
	public String rechrech(String nom ,Model model)	{
//		
		model.addAttribute("listeautorisation", metier2.recherchrefonctionnairesauto(nom));
//		
//
	
	return "listeautorisation";
	}
	
	
	
	@RequestMapping(value="/rechrechFon")
	public String rechrechfon(Long idfon,String nom ,Model model)	{
		
		model.addAttribute("fonctionnaires", metier2.listefonctionnaire());
		


	
		return "rechrechFon";
		}
	

	
	@RequestMapping(value="/rechrechFonper")
	public String rechrechfonper(Long idfon,String nom ,Model model)	{
		
		
		model.addAttribute("fonctionnaires", metier2.recherchrefonctionnaires(nom));


	
		return "rechrechFon";
		}
	
	@RequestMapping(value="/ajouterheurefon")
	public String ajouterheurefon(Long id,Model model)	{
		
		Fonctionnaires f=metier2.getfonctionnaire(id);
		model.addAttribute("fonctionnaire",f );
		
	return "ajouterheurefon";
	}
	
	
	
	@RequestMapping(value="/addheure")
	public String addheurefon(@Valid Heuresupp h,@RequestParam Long idfon,Long id,Model model,HttpServletRequest request)	{
	
	
try{		Fonctionnaires f=metier2.getfonctionnaire(idfon);
		model.addAttribute("fonctionnaire",f );
		metier2.ajouterheure(h,idfon);

		request.setAttribute("ajouter_avec_succes",  " avec succés");

	return "ajouterheurefon";}
	catch (Exception message){ 
		request.setAttribute("Erreur",  "Erreur");
		
	
	return "ajouterheurefon";
	}
	}
	
	
	@RequestMapping(value="/voirtotalfon")
	public String voirtotalfon(Long id,Model model,@RequestParam String date1,@RequestParam String date2,Long idfon)	{
		

		
	
	model.addAttribute("heuresupps", metier2.sommeheuresuppfonctionnaire(idfon,date1,date2));
	
		System.out.println("dddd");
		
		
		
	return "calculesommefon";
	}
	
	@RequestMapping(value="/voirsommefon")
	public String test(Long id,Model model,Long idfon)	{
		

		Fonctionnaires f=metier2.getfonctionnaire(id);
		model.addAttribute("fonctionnaire",f );
		model.addAttribute("detailheuresup",metier2.detailheuresupfon(id));
		
		
		
	
//		model.addAttribute("heuresupps", metier2.sommeheuresuppfonctionnaire(idfon));
//
//		System.out.println("dddd");
//		
		
		
	return "voirsommefon";
	}
	
	
	
	/***********consulter fonctionnaire*******/
	@RequestMapping(value = "/gererfonctionnaires")
	public String gererfonctionnaires( Model model) {
		model.addAttribute("fonctionnaire", new Fonctionnaires());
		model.addAttribute("fonctionnaires", metier2.listefonctionnaire());

		
		return "gererfonctionnaires";
	}

	/***********ajouter fonctionnaire*******/

	@RequestMapping(value = "/addfon")
	public String addfon(@Valid Fonctionnaires F , Model model ,@RequestParam String identificateur, @RequestParam String nom ,@RequestParam String prenom  ,@RequestParam String tel ,@RequestParam String adresse ,@RequestParam String email ,
		@RequestParam String type ,@RequestParam String grade, @RequestParam Date datereq,@RequestParam String heureTravaildebut,@RequestParam String heureTravailfin ,HttpServletRequest request ,MultipartFile file) throws IOException{

		
	

		if (!file.isEmpty()){
			BufferedImage bi=ImageIO.read(file.getInputStream());
			F.setPhoto1(file.getBytes());
			F.setNomPhoto(file.getOriginalFilename());
		}	
		

try{


	metier2.ajouterfonctionnaire(F);
	model.addAttribute("fonctionnaire", new Fonctionnaires());
	model.addAttribute("fonctionnaires", metier2.listefonctionnaire());
	request.setAttribute("ajouter_avec_succes",  " avec succés");

		return "gererfonctionnaires";
}
catch (Exception message){
//	model.addAttribute("fonctionnaires", metier2.listefonctionnaire());


//	return "gererfonctionnaires";
	request.setAttribute("employe_deja_existe",  "l'identificateur : "+F.getIdentificateur()+" : de ce employé existe deja");
	model.addAttribute("fonctionnaires", metier2.listefonctionnaire());
	return "gererfonctionnaires";
	
}
}
	
	@RequestMapping(value="/photofon",produces=MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] photofon(Long id ) throws IOException{
		Fonctionnaires c=metier2.getfonctionnaire(id);
		
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto1()));
	}


	/***********modifer fonctionnaires*******/
	@RequestMapping(value="/modiferfont")
	public String modifer(Long id,Model model){
	Fonctionnaires f=metier2.getfonctionnaire(id);



	model.addAttribute("fonctionnaire",f );
	model.addAttribute("fonctionnaires", metier2.listefonctionnaire());
	return "modifierfonctionnaire";} 



	@RequestMapping(value = "/modfon")
	public String modfon(@Valid Fonctionnaires f,Long id, Model model ,@RequestParam String identificateur, @RequestParam String nom ,@RequestParam String prenom  ,@RequestParam String tel ,@RequestParam String adresse ,@RequestParam String email ,
		 @RequestParam String type ,@RequestParam String grade, @RequestParam Date datereq,@RequestParam String heureTravaildebut,@RequestParam String heureTravailfin,MultipartFile file,HttpServletRequest request) throws IOException{

try{		
		if(file.isEmpty())
		{
			f.setPhoto1(files);
			f.setNomPhoto(file.getOriginalFilename());
		}else {
			f.setPhoto1(file.getBytes());
			
		}

		System.out.println("hhhhhhh");
	metier2.modifierfonctionnaire(f);
	System.out.println("ffffffff");
	model.addAttribute("fonctionnaire",f);
	model.addAttribute("fonctionnaires", metier2.listefonctionnaire());

	request.setAttribute("modifier_avec_succes",  " avec succés");
		return "gererfonctionnaires";
	}catch (Exception message){ 
		request.setAttribute("Erreur",  "Erreur");
		

		return "gererfonctionnaires";}
	}





	/***********supprimer fonctionnaire*******/

	@RequestMapping(value = "/suppfon")
	public String suppfon(Long id, Model model,HttpServletRequest request) {
	
		try{ metier2.supp(id);
		
		model.addAttribute("fonctionnaire", new Fonctionnaires());
		model.addAttribute("fonctionnaires", metier2.listefonctionnaire());
		request.setAttribute("Supprimer_avec_succes",  " Supprimer avec succés ");
		return "gererfonctionnaires";}
		catch (Exception message){ 
			request.setAttribute("Erreur",  "Erreur");
			

		return "gererfonctionnaires";}
	}
	/**
	 *********************FIN*********************************************************************************************
	 */
	
	/******************----Consultatio et ordre---------**********************************************************************************/

	@RequestMapping(value="/consultationFonctionnaires")
	public String consultationf  (Model model)	{
		
		model.addAttribute("fonctionnaires", metier2.listefonctionnaire());
		
	return "consultationFonctionnaires";
	}



	@RequestMapping(value="/ordrebynomf")
	public String ordrebynomf  (Model model)	{
		
		model.addAttribute("fonctionnaires", metier2.ordrebynom());
		
	return "consultationFonctionnaires";
	}



	@RequestMapping(value="/ordrebygradef")
	public String ordrebygradef (Model model)	{
		
		model.addAttribute("fonctionnaires", metier2.ordrebygrade());
		
	return "consultationFonctionnaires";
	}


	@RequestMapping(value="/ordrebyheureTravailf")
	public String ordrebyheureTravailf (Model model)	{
		
		model.addAttribute("fonctionnaires", metier2.ordrebyheureTravail());
		
	return "consultationFonctionnaires";
	}
	
/*****congé fonctionnaire********/
	
	
	@RequestMapping(value = "/rechrechFonConge")
	public String rechrechFonConge(String nom, Model model) {
		
		model.addAttribute("fonctionnaires", metier2.listefonctionnaire());
		
		return "rechrechFonConge";
	}
	
	
	@RequestMapping(value = "/rechrechFonCongeper")
	public String rechrechFonCongeper(String nom, Model model) {
		
		model.addAttribute("fonctionnaires", metier2.recherchrefonctionnaires(nom));
		
		return "rechrechFonConge";
	}
	
	
	
	
	@RequestMapping(value = "/autorisationFonConge")
	public String autorisationFonConge(Long id, Model model) {
		
		Fonctionnaires f=metier2.getfonctionnaire(id);
		model.addAttribute("fonctionnaire",f );
	
		
		model.addAttribute("notification",metier2.getListCongeAujourdhui().size());
		model.addAttribute("notifications",metier2.getListCongeAujourdhui());
	
		return "autorisationFonConge";
	
	}
//	
	@RequestMapping(value = "/detailfon")
	public String detailfon(Long id, Model model) {
	
		Fonctionnaires f=metier2.getfonctionnaire(id);
		model.addAttribute("fonctionnaire",f );
		
		
	return "détailscongefon";

	}
//	
	@RequestMapping(value = "/détail")
	public String détail(Long idfon, Model model ,@RequestParam String date1,String date2) {
//		
		Fonctionnaires f=metier2.getfonctionnaire(idfon);
		model.addAttribute("fonctionnaire",f );
		
	model.addAttribute("détail", metier2.getabsdetail(idfon ,date1, date2));
	
	
		return "détailscongefon";
//	
}
	
	
	@RequestMapping(value = "/detailfonauto")
	public String detailfonauto(Long id, Model model) {
	
		Fonctionnaires f=metier2.getfonctionnaire(id);
		model.addAttribute("fonctionnaire",f );
		
		
	return "détailsautofon";

	}
//	
	@RequestMapping(value = "/détailauto")
	public String détailauto(Long idfon, Model model ,@RequestParam String date1,String date2) {
//		
		Fonctionnaires f=metier2.getfonctionnaire(idfon);
		model.addAttribute("fonctionnaire",f );
		
	model.addAttribute("détail", metier2.getabsdetailauto(idfon, date1, date2));
	
	
		return "détailsautofon";
//	
}
	
	
	@RequestMapping(value = "/detailretafon")
	public String detailretafon(Long id, Model model) {
	
		Fonctionnaires f=metier2.getfonctionnaire(id);
		model.addAttribute("fonctionnaire",f );
		
		
	return "détailsretafon";

	}
//	
	@RequestMapping(value = "/détailreta")
	public String détailreta(Long idfon, Model model ,@RequestParam String date1,String date2) {
//		
		Fonctionnaires f=metier2.getfonctionnaire(idfon);
		model.addAttribute("fonctionnaire",f );
		
	model.addAttribute("détail", metier2.getretaddetailauto(idfon, date1, date2));
	
	
		return "détailsretafon";
//	
}
	
	
	@RequestMapping(value = "/detailJourabsfon")
	public String detailJourabsfon(Long id, Model model) {
	
		Fonctionnaires f=metier2.getfonctionnaire(id);
		model.addAttribute("fonctionnaire",f );
		
		
	return "detailJourabsfon";

	}
//	
	@RequestMapping(value = "/détailjoursabs")
	public String détailjoursabs(Long idfon, Model model ,@RequestParam String date1,String date2) {
//		
		Fonctionnaires f=metier2.getfonctionnaire(idfon);
		model.addAttribute("fonctionnaire",f );
		
	model.addAttribute("détail", metier2.getjourabsdetail(idfon, date1, date2));
	
	
		return "detailJourabsfon";
//	
}
	
	@RequestMapping(value = "/addconge")
	
	public String addconge(@Valid Conge c,@RequestParam Long idfon , Model model , @RequestParam String nom ,@RequestParam String type  , @RequestParam String datededebut, @RequestParam String datedefin, @RequestParam int  nbrj ,HttpServletRequest request) throws IOException{
	

	
	try{	Fonctionnaires f=metier2.getfonctionnaire(idfon);
		model.addAttribute("fonctionnaire",f );
		
			
	metier2.ajouterConge(c,idfon);
	if(c.getType().equals("Congé annuel")){
	metier2.modifcongé(c);
	}
	
	
	request.setAttribute("ajouter_avec_succes",  " avec succés");
	return "autorisationFonConge";}
	catch (Exception message){ 
		request.setAttribute("Erreur",  "Erreur");
		
	
	return "autorisationFonConge";}

							}
	
	
/********************************retard***************************************/	

	@RequestMapping(value = "/rechrechFonHeureAbs")
	public String rechrechFonHeureAbs(String nom, Model model) {
		
		model.addAttribute("fonctionnaires", metier2.listefonctionnaire());
		
		return "rechrechFonHeureAbs";
	}
	
	@RequestMapping(value = "/rechrechFonHeureAbsper")
	public String rechrechFonHeureAbsper(String nom, Model model) {
		
		model.addAttribute("fonctionnaires", metier2.recherchrefonctionnaires(nom));
		
		return "rechrechFonHeureAbs";
	}
	
	

	@RequestMapping(value = "/ajouterHeureAbs")
	public String ajouterHeureAbs(Long id, Model model) {
		
		Fonctionnaires f=metier2.getfonctionnaire(id);
		model.addAttribute("fonctionnaire",f );
	
		
		
	
		return "ajouterHeureAbs";
	
	}
	
	
	@RequestMapping(value = "/addheureabs")
	
	public String addheureabs(@Valid Heureabsfon h,@RequestParam Long idfon ,@RequestParam String identificateur,@RequestParam String nom,@RequestParam String prenom , Model model ,@RequestParam String date, @RequestParam String  heure ,HttpServletRequest request ) throws IOException{
	
	try{	
		
		Fonctionnaires f=metier2.getfonctionnaire(idfon);
		model.addAttribute("fonctionnaire",f );
	
	
metier2.ajouterheureabs(h, idfon);
model.addAttribute("heureretardfon", metier2.listefonctionnaireretard());
request.setAttribute("ajouter_avec_succes",  " avec succés");
	return "ajouterHeureAbs";}
	catch (Exception message){ 
		request.setAttribute("Erreur",  "Erreur");
		
	
	return "ajouterHeureAbs";}


							}
	

@RequestMapping(value = "/listederetardatairefon")
	
	public String listederetardatairefon(@Valid Heureabsfon h, Model model ) throws IOException{
	
	

model.addAttribute("heureretardfon", metier2.listefonctionnaireretard());

	return "listederetardatairefon";

							}


@RequestMapping(value = "/fildate")

public String fildate(@Valid Heureabsfon h,@RequestParam String date1,@RequestParam String date2, Model model ) throws IOException{



model.addAttribute("heureretardfon", metier2.listefonctionnaireretarddate(date1, date2));

return "listederetardatairefon";

						}
		

/*****jours abs ouv ****/

@RequestMapping(value = "/rechrechFonJoursAbs")
public String rechrechFonJoursAbs(String nom, Model model) {
	
	model.addAttribute("fonctionnaire", metier2.listefonctionnaire());
	
	return "rechrechFonJoursAbs";
}

@RequestMapping(value = "/rechrechFonJoursAbsper")
public String rechrechFonJoursAbsper(String nom, Model model) {
	
	model.addAttribute("fonctionnaire", metier2.recherchrefonctionnaires(nom));
	
	return "rechrechFonJoursAbs";
}


//
@RequestMapping(value = "/ajouterJoursAbsFon")
public String ajouterJoursAbsFon(Long id, Model model) {
//	
	Fonctionnaires o=metier2.getfonctionnaire(id);
	model.addAttribute("fonctionnaire",o );

	String date=metier2.getfonctionnbrjabs(id);
	model.addAttribute("datedebut", date);
////
////	
////
return "ajouterJoursAbsFon";
////
}
////
@RequestMapping(value = "/addjoursabsfon")
////
public String addjoursabsfon(@Valid Conge j,@RequestParam String type ,@RequestParam Long idfon ,@RequestParam String identificateur,@RequestParam String nom,@RequestParam String prenom ,@RequestParam String datededebut, @RequestParam String datederetour,Model model ,HttpServletRequest request ) throws IOException{
//

	
	Fonctionnaires o=metier2.getfonctionnaire(idfon);
	model.addAttribute("fonctionnaire",o );
try{	
	if(datederetour.equals("")){
		
	j.setDatederetour("1900/01/01");
		
	}
if(!metier2.getfonctionnbrjabs(idfon).equals("jj/mm/aaaa")){
	
	metier2.updatejoursabs(j,idfon);
	
}else{
metier2.ajouterjoursabs(j, idfon);
metier2.updatejoursabs(j,idfon);}
//metier2.getnbrjabs(idfon, datededebut, datededebut);
//model.addAttribute("nbrj", metier2.getnbrjabs(idfon));
//	model.addAttribute("joursabsouv", metier3.listeouvrierabs());
////
request.setAttribute("ajouter_avec_succes",  " avec succés");
return "ajouterJoursAbsFon";}
catch (Exception message){ 
	request.setAttribute("Erreur",  "Erreur");
	

return "ajouterJoursAbsFon";}
////
					}
////
//@RequestMapping(value = "/listedeAbsouv")
//////
//public String listederetardataireouv(@Valid JoursAbs h, Model model ) throws IOException{
////
//model.addAttribute("joursabsouv", metier3.listeouvrierabs());
////
//return "listedeAbsouv";
//////	
//////
//}	

	
	
	
/************************fin fonctionnaire*****************************************************************************************************/
	
	
	/******************************************ouvrier********************************************************************************-/
	
	/***********consulter ouvriers*******/

	@RequestMapping(value = "/gererouvriers")
	public String gererouvriers( Model model) {
		model.addAttribute("ouvrier", new Ouvriers());
		model.addAttribute("ouvriers", metier3.listeouvriers());

		
		return "gererouvriers";
	}




	/***********ajouter ouvrier*******/

	@RequestMapping(value = "/addouv")
	public String addouv(@Valid Ouvriers o , Model model ,@RequestParam String nom ,@RequestParam String identificateur,@RequestParam String prenom  ,@RequestParam String tel ,@RequestParam String adresse ,@RequestParam String email ,
	HttpServletRequest request,@RequestParam String heureTravaildebut,@RequestParam String heureTravailfin, @RequestParam String type ,@RequestParam String grade , @RequestParam String datereq ,MultipartFile file) throws IOException{


		if (!file.isEmpty()){
			BufferedImage bi=ImageIO.read(file.getInputStream());
			o.setPhoto1(file.getBytes());
			o.setNomPhoto(file.getOriginalFilename());
		}	


try{
	metier3.ajouterouvriers(o);

	model.addAttribute("ouvrier", new Ouvriers());
	model.addAttribute("ouvriers", metier3.listeouvriers());
	request.setAttribute("ajouter_avec_succes",  " avec succés");
	return "gererouvriers";
}

catch (Exception message){
	request.setAttribute("employe_deja_existe",  "l'identificateur : "+o.getIdentificateur()+" : de ce employé existe deja");
	model.addAttribute("ouvriers", metier3.listeouvriers());
	return "gererouvriers";
}

	
	}
	
	@RequestMapping(value="/photoouv",produces=MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] photoouv(Long id ) throws IOException{
		Ouvriers c=metier3.getouvriers(id);
		
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto1()));
	}

	
/*************************************************************/	


	@RequestMapping(value = "/suppouv")
	public String suppouv(Long id, Model model,HttpServletRequest request) {
	
	try{	
		metier3.suppouvriers(id);
		

	model.addAttribute("ouvrier", new Ouvriers());
	model.addAttribute("ouvriers", metier3.listeouvriers());

	request.setAttribute("Supprimer_avec_succes",  " Supprimer avec succés ");
	return "gererouvriers";}
	catch (Exception message){ 
		request.setAttribute("Erreur",  "Erreur");
		

	return "gererouvriers";}
	}



	/**
	*********************FIN*********************************************************************************************
	*/

	/******************----Consultatio et ordre---------**********************************************************************************/

	@RequestMapping(value="/consultationOuvriers")
	public String consultationo  (Model model)	{
		
		model.addAttribute("ouvriers", metier3.listeouvriers());
		
	return "consultationOuvriers";
	}



	@RequestMapping(value="/ordrebynomo")
	public String ordrebynomo  (Model model)	{
		
		model.addAttribute("ouvriers", metier3.ordrebynom());
		
	return "consultationOuvriers";
	}



	@RequestMapping(value="/ordrebygradeo")
	public String ordrebygradeo (Model model)	{
		
		model.addAttribute("ouvriers", metier3.ordrebygrade());
		
	return "consultationOuvriers";
	}


	@RequestMapping(value="/ordrebyheureTravailo")
	public String ordrebyheureTravailo (Model model)	{
		
		model.addAttribute("ouvriers", metier3.ordrebyheureTravail());
		
	return "consultationOuvriers";
	}

	
	
	/**********************************modifierouvriers******/
	
	
	@RequestMapping(value="/modiferouv")
	public String modiferouv(Long id,Model model){
		Ouvriers o=metier3.getouvriers(id);



	model.addAttribute("ouvrier",o );
	model.addAttribute("ouvriers", metier2.listefonctionnaire());
	return "modifierouvriers";} 



	@RequestMapping(value = "/modouv")
	public String modouv(@Valid Ouvriers o,Long id, Model model ,@RequestParam String identificateur, @RequestParam String nom ,@RequestParam String prenom  ,@RequestParam String tel ,@RequestParam String adresse ,@RequestParam String email ,
		@RequestParam String heureTravaildebut,@RequestParam String heureTravailfin, @RequestParam String type ,@RequestParam String grade, @RequestParam String datereq,MultipartFile file,HttpServletRequest request) throws IOException{

try{		
		if(file.isEmpty())
		{
			o.setPhoto1(files);
			o.setNomPhoto(file.getOriginalFilename());
		}else {
			o.setPhoto1(file.getBytes());
			
		}

		
		System.out.println("hhhhhhh");
	metier3.modifierouvriers(o);
	System.out.println("ffffffff");
	model.addAttribute("ouvrier",o);
	model.addAttribute("ouvriers", metier3.listeouvriers());

	request.setAttribute("modifier_avec_succes",  " avec succés");
		return "gererouvriers";}
catch (Exception message){ 
	request.setAttribute("Erreur",  "Erreur");
	

return "gererouvriers";}
	}

	
	
	/*************************************rechercher et ajouter des heures **************************************************************************************/
	@RequestMapping(value="/rechrechOuv")
	public String rechrechOuv(String nom ,Model model)	{
		
		
		model.addAttribute("ouvriers", metier3.listeouvriers());
	return "rechrechOuv";
	}
	@RequestMapping(value="/rechrechOuvper")
	public String rechrechOuvper(String nom ,Model model)	{
		
		
		model.addAttribute("ouvriers", metier3.recherchreOuvriers(nom));
	return "rechrechOuv";
	}
	
	@RequestMapping(value="/ajouterheureouv")
	public String ajouterheureouv(Long id,Model model)	{
		Ouvriers o=metier3.getouvriers(id);
		model.addAttribute("ouvrier",o );
		
	
		
	return "ajouterheureouv";
	}
	
	
	
	@RequestMapping(value="/addheureouv")
	public String addheureouv(@Valid Heuresuppouvrier h,@RequestParam Long idouv, Model model,HttpServletRequest request)	{
	
	try{	Ouvriers o=metier3.getouvriers(idouv);
		model.addAttribute("ouvrier",o );
		
		metier3.ajouterheure(h, idouv);
		request.setAttribute("ajouter_avec_succes",  " avec succés");
		
	return "ajouterheureouv";}
	catch (Exception message){ 
		request.setAttribute("Erreur",  "Erreur");
		
	
	return "ajouterheureouv";}
	}
	
	
	
@RequestMapping(value="/voirtotalouv")
	public String voirtotal(Long id,Model model,@RequestParam String date1,@RequestParam String date2,Long idouv)	{
		

		
	
	model.addAttribute("heuresupps", metier3.sommeheuresuppfonctionnaire(idouv,date1,date2));

		System.out.println("dddd");
		
		
		
	return "calculesommeouv";
	}
	
	@RequestMapping(value="/voirsommeouv")
	public String voirsommeouv(Long id,Model model,Long idouv)	{
		

		Ouvriers o=metier3.getouvriers(id);
		model.addAttribute("Ouvriers",o );
		model.addAttribute("detailheuresup",metier3.detailheuresupouv(id));


	//	System.out.println("dddd");
		
		
		
	return "voirsommeouv";
	}
	
	
	
	/*********************************retaredouv*****************************/
	
	
	
	@RequestMapping(value = "/rechrechOuvHeureAbs")
	public String rechrechOuvHeureAbs(String nom, Model model) {
		
		model.addAttribute("Ouvriers", metier3.listeouvriers());
		
		return "rechrechOuvHeureAbs";
	}
	

	@RequestMapping(value = "/rechrechOuvHeureAbsper")
	public String rechrechOuvHeureAbsper(String nom, Model model) {
		
		model.addAttribute("Ouvriers", metier3.recherchreOuvriers(nom));
		
		return "rechrechOuvHeureAbs";
	}

	@RequestMapping(value = "/ajouterHeureAbsOuv")
	public String ajouterHeureAbsOuv(Long id, Model model) {
		
		Ouvriers o=metier3.getouvriers(id);
		model.addAttribute("ouvrier",o );
	
		

		return "ajouterHeureAbsOuv";
	
	}
	
@RequestMapping(value = "/addheureabsouv")
	
	public String addheureabsouv(@Valid Heureabsfon h,@RequestParam Long idouv ,@RequestParam String identificateur,@RequestParam String nom,@RequestParam String prenom , Model model ,@RequestParam String date, @RequestParam String  heure ,HttpServletRequest request ) throws IOException{
try{
	
metier3.ajouterheureabs(h, idouv);
	model.addAttribute("heureretardouv", metier3.listeouvrierretard());
	request.setAttribute("ajouter_avec_succes",  " avec succés");}catch (Exception message){}
return "ajouterHeureAbsOuv";

							}

@RequestMapping(value = "/listederetardataireouv")
	
public String listederetardataireouv(@Valid Heureabsfon h, Model model ) throws IOException{
	
model.addAttribute("heureretardouv", metier3.listeouvrierretard());

	return "listederetardataireouv";
		
	
	
}	



@RequestMapping(value = "/rechrechOuvConge")
public String rechrechOuvConge(String nom, Model model) {
	
	model.addAttribute("ouvriers", metier3.listeouvriers());
	
	return "rechrechOuvConge";
}


@RequestMapping(value = "/rechrechOuvCongeper")
public String rechrechOuvCongeper(String nom, Model model) {
	
	model.addAttribute("ouvriers", metier3.recherchreOuvriers(nom));
	
	return "rechrechOuvConge";
}



@RequestMapping(value = "/autorisationOuvConge")
public String autorisationOuvConge(Long id, Model model) {

	Ouvriers f=metier3.getouvriers(id);
model.addAttribute("ouvrier",f );

	model.addAttribute("notification",metier3.getListCongeAujourdhui().size());
	model.addAttribute("notifications",metier3.getListCongeAujourdhui());

	return "autorisationOuvConge";

}
@RequestMapping(value = "/addcongeouv")

public String addcongeouv(@Valid Conge c,@RequestParam Long idouv , Model model , @RequestParam String nom ,@RequestParam String type  , @RequestParam String datededebut, @RequestParam String datedefin, @RequestParam int  nbrj,HttpServletRequest request) throws IOException{

try{	
	Ouvriers o=metier3.getouvriers(idouv);
	model.addAttribute("ouvrier",o );

	
		metier3.ajouterConge(c, idouv);
		if(c.getType().equals("Congé annule")) {
		
			metier3.modifcongé(c);
			
			}
		request.setAttribute("ajouter_avec_succes",  " avec succés");
return "autorisationOuvConge";
}
catch (Exception message){ 
	request.setAttribute("Erreur",  "Erreur");
	

return "autorisationOuvConge";}
						}




@RequestMapping(value = "/rechrechOuvauto")
public String rechrechOuvauto(String nom, Model model) {
	
	model.addAttribute("ouvrier", metier3.listeouvriers());
	
	return "rechrechOuvauto";
}

@RequestMapping(value = "/rechrechOuvautoper")
public String rechrechOuvautoper(String nom, Model model) {
	
	model.addAttribute("ouvrier", metier3.recherchreOuvriers(nom));
	
	return "rechrechOuvauto";
}
@RequestMapping(value = "/autorisationOuv")
public String autorisationOuv(Long id,Model model) {
	
	Ouvriers a=metier3.getouvriers(id);
	model.addAttribute("Ouvrier",a );
	
	return "autorisationOuv";
}
@RequestMapping(value = "/addautoOuv")
public String addautoOuv(@Valid Autorisation a, Long idouv,Model model,HttpServletRequest request) {
	
try{	Ouvriers o=metier3.getouvriers(idouv);
	model.addAttribute("Ouvrier",o );
	metier3.ajouterautorisation(a, idouv);
	request.setAttribute("ajouter_avec_succes",  " avec succés");
	return "autorisationOuv";}
catch (Exception message){ 
	request.setAttribute("Erreur",  "Erreur");
	

return "autorisationOuv";}
}


/*****jours abs ouv ****/

@RequestMapping(value = "/rechrechOuvJoursAbs")
public String rechrechOuvJoursAbs(String nom, Model model) {
	
	model.addAttribute("ouvriers", metier3.listeouvriers());
	
	return "rechrechOuvJoursAbs";
}

@RequestMapping(value = "/rechrechOuvJoursAbsper")
public String rechrechOuvJoursAbsper(String nom, Model model) {
	
	model.addAttribute("ouvriers", metier3.recherchreOuvriers(nom));
	
	return "rechrechOuvJoursAbs";
}


@RequestMapping(value = "/ajouterJoursAbsOuv")
public String ajouterJoursAbsOuv(Long id, Model model) {
	
	Ouvriers o=metier3.getouvriers(id);
	model.addAttribute("ouvrier",o );
	String date=metier3.getouvriernbrjabs(id);
	model.addAttribute("datedebut", date);	

	return "ajouterJoursAbsOuv";
//
}
//
@RequestMapping(value = "/addjoursabsouv")
//
public String addjoursabsouv(@Valid Conge j,@RequestParam String datederetour ,@RequestParam String type ,@RequestParam Long idouv ,@RequestParam String identificateur,@RequestParam String nom,@RequestParam String prenom , Model model ,@RequestParam String datededebut,HttpServletRequest request ) throws IOException{
	Ouvriers o=metier3.getouvriers(idouv);
	model.addAttribute("ouvrier",o );
try{	
	if(datederetour.equals("")){
		
		j.setDatederetour("1900/01/01");
			
		}
	if(!metier3.getouvriernbrjabs(idouv).equals("jj/mm/aaaa")){
		
		metier3.updatejoursabs(j,idouv);
		
	}else
	
	
metier3.ajouterjoursabs(j, idouv);
//model.addAttribute("joursabsouv", metier3.listeouvrierabs());
	request.setAttribute("ajouter_avec_succes",  " avec succés");
return "ajouterJoursAbsOuv";}
catch (Exception message){ 
	request.setAttribute("Erreur",  "Erreur");
	

return "ajouterJoursAbsOuv";
							}
						}
//
@RequestMapping(value = "/listedeAbs")
////
public String listederetardataireouv( Model model ) throws IOException{
//
model.addAttribute("joursabs", metier3.listeouvrierabs());
//
return "listedeAbs";
////	
////
}	
@RequestMapping(value = "/listeabsdate")
////
public String listeabsdate(@RequestParam String date,@RequestParam String date2, Model model ) throws IOException{
//
model.addAttribute("joursabs", metier3.listeouvrierabsdate(date,date2));
//
return "listedeAbs";
////	
////
}
@RequestMapping(value = "/fildateouv")

public String fildateouv(@Valid Heureabsfon h,@RequestParam String date1,@RequestParam String date2, Model model ) throws IOException{



model.addAttribute("heureretardouv", metier3.listeouvrierretarddate(date1, date2));

return "listederetardataireouv";

						}



@RequestMapping(value = "/detailouv")
public String detailouv(Long id, Model model) {

	Ouvriers o=metier3.getouvriers(id);
	model.addAttribute("ouvriers",o );
	
	
return "détailscongeouv";

}
//
@RequestMapping(value = "/détailouv")
public String détailouv(Long idouv, Model model ,@RequestParam String date1,String date2) {
//	
	Ouvriers o=metier3.getouvriers(idouv);
	model.addAttribute("ouvriers",o );
model.addAttribute("détail", metier3.getabsdetail(idouv ,date1, date2));


	return "détailscongeouv";
//
}


@RequestMapping(value = "/detailouvauto")
public String detailouvauto(Long id, Model model) {

	Ouvriers o=metier3.getouvriers(id);
	model.addAttribute("ouvriers",o );
	
	
return "détailsautoouv";

}
//
@RequestMapping(value = "/détailautoouv")
public String détailautoouv(Long idouv, Model model ,@RequestParam String date1,String date2) {
//	
	Ouvriers o=metier3.getouvriers(idouv);
	model.addAttribute("ouvriers",o );
	
model.addAttribute("détail", metier3.getabsdetailauto(idouv, date1, date2));


	return "détailsautoouv";
//
}


@RequestMapping(value = "/detailretaouv")
public String detailretaouv(Long id, Model model) {

	Ouvriers o=metier3.getouvriers(id);
	model.addAttribute("ouvriers",o );
	
	
return "détailsretaouv";

}
//
@RequestMapping(value = "/détailretaouv")
public String détailretaouv(Long idouv, Model model ,@RequestParam String date1,String date2) {
//	
	Ouvriers o=metier3.getouvriers(idouv);
	model.addAttribute("ouvriers",o );
	
model.addAttribute("détail", metier3.getretaddetailauto(idouv, date1, date2));


	return "détailsretaouv";
//
}


@RequestMapping(value = "/detailJourabsouv")
public String detailJourabsouv(Long id, Model model) {

	Ouvriers o=metier3.getouvriers(id);
	model.addAttribute("ouvriers",o );
	
	
return "detailJourabsouv";

}
//
@RequestMapping(value = "/détailjoursabsouv")
public String détailjoursabsouv(Long idouv, Model model ,@RequestParam String date1,String date2) {
//	
	Ouvriers o=metier3.getouvriers(idouv);
	model.addAttribute("ouvriers",o );
	
model.addAttribute("détail", metier3.getjourabsdetail(idouv, date1, date2));


	return "detailJourabsouv";
//
}

	

}
