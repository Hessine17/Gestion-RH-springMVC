package com.essths.pfe;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.Principal;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essths.entities.Enseignants;
import com.essths.entities.Fonctionnaires;
import com.essths.entities.Heureabsfon;
import com.essths.entities.Ouvriers;
import com.essths.metier.IenseignantsMetier;
import com.essths.metier.IfonctionnaireMetier;
import com.essths.metier.IouvrierMetier;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	
	@Autowired
	private IenseignantsMetier metier;
	@Autowired
	private IfonctionnaireMetier metier2;
	@Autowired
	private IouvrierMetier metier3;
	 private byte[] files;
	
	
	 
	 
	 
	@RequestMapping("/userhome")
	public String userhome(ModelMap model, Principal principal){
//		
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
//		
	return "userhome";
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
		
		return"userhome";
	}
/***************************************liste de cooperation ************/
	@RequestMapping(value = "/userlistecooperation")
	public String listecooperation(Model model) {
		
		
			
			model.addAttribute("cooperations", metier.listeenseignantscooperation());
		return "userlistecooperation";
	}
	
	
	/************************liste des autorisation**********************/
	@RequestMapping(value = "/userlisteautorisation")
	public String listeautorisation( Model model) {
		
		model.addAttribute("listeautorisation", metier2.listeAutorisation());
		
		return "userlisteautorisation";
	}


	/*******************************consulter par order enseignants******/
	
	@RequestMapping(value="/photoen",produces=MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] photoen(int id ) throws IOException{
		Enseignants c=metier.getEnseignant(id);
		
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto1()));
	}

	
	@RequestMapping(value="/userconsultationEnsiegnants")
	public String consultation  (Model model)	{
		
		model.addAttribute("enseignants", metier.listeenseignants());
		
	return "userconsultationEnsiegnants";
	}



	@RequestMapping(value="/ordrebynom")
	public String ordrebynom  (Model model)	{
		
		model.addAttribute("enseignants", metier.ordrebynom());
		
	return "userconsultationEnsiegnants";
	}



	@RequestMapping(value="/ordrebygrade")
	public String ordrebygrade (Model model)	{
		
		model.addAttribute("enseignants", metier.ordrebygrade());
		
	return "userconsultationEnsiegnants";
	}


	@RequestMapping(value="/ordrebyheureTravail")
	public String ordrebyheureTravail (Model model)	{
		
		model.addAttribute("enseignants", metier.ordrebyheureTravail());
		
	return "userconsultationEnsiegnants";
	}
	/********************************consulter par ordrer fonctionnaire ***/
	
	
	@RequestMapping(value="/photofon",produces=MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] photofon(Long id ) throws IOException{
		Fonctionnaires c=metier2.getfonctionnaire(id);
		
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto1()));
	}

	
	
	@RequestMapping(value="/userconsultationFonctionnaires")
	public String consultationf  (Model model)	{
		
		model.addAttribute("fonctionnaires", metier2.listefonctionnaire());
		
	return "userconsultationFonctionnaires";
	}



	@RequestMapping(value="/ordrebynomf")
	public String ordrebynomf  (Model model)	{
		
		model.addAttribute("fonctionnaires", metier2.ordrebynom());
		
	return "userconsultationFonctionnaires";
	}



	@RequestMapping(value="/ordrebygradef")
	public String ordrebygradef (Model model)	{
		
		model.addAttribute("fonctionnaires", metier2.ordrebygrade());
		
	return "userconsultationFonctionnaires";
	}


	@RequestMapping(value="/ordrebyheureTravailf")
	public String ordrebyheureTravailf (Model model)	{
		
		model.addAttribute("fonctionnaires", metier2.ordrebyheureTravail());
		
	return "userconsultationFonctionnaires";
	}
	
/***********************consulter par ordre ouvrier ****/
	
	
	@RequestMapping(value="/photoouv",produces=MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] photoouv(Long id ) throws IOException{
		Ouvriers c=metier3.getouvriers(id);
		
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto1()));
	}

	@RequestMapping(value="/userconsultationOuvriers")
	public String consultationo  (Model model)	{
		
		model.addAttribute("ouvriers", metier3.listeouvriers());
		
	return "userconsultationOuvriers";
	}



	@RequestMapping(value="/ordrebynomo")
	public String ordrebynomo  (Model model)	{
		
		model.addAttribute("ouvriers", metier3.ordrebynom());
		
	return "userconsultationOuvriers";
	}



	@RequestMapping(value="/ordrebygradeo")
	public String ordrebygradeo (Model model)	{
		
		model.addAttribute("ouvriers", metier3.ordrebygrade());
		
	return "userconsultationOuvriers";
	}


	@RequestMapping(value="/ordrebyheureTravailo")
	public String ordrebyheureTravailo (Model model)	{
		
		model.addAttribute("ouvriers", metier3.ordrebyheureTravail());
		
	return "userconsultationOuvriers";
	}
	/******************************liste des abs*********/
	@RequestMapping(value = "/userlistedeAbs")
	////
	public String listederetardataireouv( Model model ) throws IOException{
	//
	model.addAttribute("joursabs", metier3.listeouvrierabs());
	//
	return "userlistedeAbs";
	////	
	////
	}	
	@RequestMapping(value = "/listeabsdate")
	////
	public String listeabsdate(@RequestParam String date,@RequestParam String date2, Model model ) throws IOException{
	//
	model.addAttribute("joursabs", metier3.listeouvrierabsdate(date,date2));
	//
	return "userlistedeAbs";
	////	
	////
	}
	@RequestMapping(value = "/fildateouv")

	public String fildateouv(@Valid Heureabsfon h,@RequestParam String date1,@RequestParam String date2, Model model ) throws IOException{



	model.addAttribute("heureretardouv", metier3.listeouvrierretarddate(date1, date2));

	return "listederetardataireouv";

							}

/****************************liste des retardataire***////
@RequestMapping(value = "/userlistederetardatairefon")
	
	public String listederetardatairefon(@Valid Heureabsfon h, Model model ) throws IOException{
	
	

model.addAttribute("heureretardfon", metier2.listefonctionnaireretard());

	return "userlistederetardatairefon";

							}

@RequestMapping(value = "/userlistederetardataireouv")

public String listederetardataireouv(@Valid Heureabsfon h, Model model ) throws IOException{
	
model.addAttribute("heureretardouv", metier3.listeouvrierretard());

	return "userlistederetardataireouv";
		
	
	
}	


}
