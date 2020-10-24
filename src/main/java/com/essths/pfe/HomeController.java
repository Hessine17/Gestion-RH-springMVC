package com.essths.pfe;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Locale;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

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
import com.google.gson.Gson;




/**
 * Handles requests for the application home page.
 */
/**
 * @author Hamdi
 *
 */

@Controller
@RequestMapping(value="/home")
public class HomeController  {
	
	

	 
	 @RequestMapping("")
	    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
        	System.out.println("ROLE_ADMIN");
        	return "redirect:/admin/home";
        }
      if (request.isUserInRole("ROLE_USER")) {
        	System.out.println("ROLE_USER2");
    	  return "redirect:/user/userhome";
        }
      if (request.isUserInRole("ROLE_USER")) {
      	System.out.println("ROLE_USER1");
  	  return "redirect:/user/userhome";
      }
	        
	     
      return "redirect:/login";
	
	 }
	 

}




