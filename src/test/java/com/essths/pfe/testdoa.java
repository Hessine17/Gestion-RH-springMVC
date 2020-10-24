package com.essths.pfe;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.essths.entities.Conge;
import com.essths.entities.Enseignants;
import com.essths.entities.Fonctionnaires;
import com.essths.entities.Ouvriers;
import com.essths.metier.IenseignantsMetier;
import com.essths.metier.IfonctionnaireMetier;
import com.essths.metier.IouvrierMetier;



public class testdoa {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	try {
	ClassPathXmlApplicationContext app= new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	assertTrue(true);
	} catch (Exception e) {
	assertTrue(e.getMessage(),false);
	} }
	
//	@Test
//public void test1() {
//	try {
//	ClassPathXmlApplicationContext context=
//	new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
//	
//	IouvrierMetier metier3=(IouvrierMetier) context.getBean("metier3");
//	metier3.ajouterautorisation(new AutorisationOuv(nom, date, de, a, cause, ouvriers));
//
//	} catch (Exception e) { assertTrue(e.getMessage(),false);}}
//	
}
