package com.carlos.proyecto;

import java.sql.Connection;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carlos.modelo.Operaciones;
import com.carlos.modelo.Regiones;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/listarregiones", method = RequestMethod.GET)
	public String listalibros(Model modelo){
		Operaciones op = new Operaciones();
		Connection cn = op.conexionmysql();
		ArrayList<Regiones> milista = op.listar(cn);
		modelo.addAttribute("listaregiones", milista);
		return "listadoregiones" ;
	}
	@RequestMapping(value="/volver", method = RequestMethod.POST)
	public String volver(Model modelo){
		return "home" ;
	}
}
