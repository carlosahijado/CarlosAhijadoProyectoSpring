package com.carlos.proyecto;

import java.sql.Connection;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.carlos.modelo.Oficinas;
import com.carlos.modelo.Operaciones;
import com.carlos.modelo.Regiones;
import com.carlos.modelo.Repventas;



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
	public String listaregiones(Model modelo){
		Operaciones op = new Operaciones();
		Connection cn = op.conexionmysql();
		ArrayList<Regiones> milista = op.listar(cn);
		modelo.addAttribute("listaregiones", milista);
		return "listadoregiones" ;
	}
	
	@RequestMapping(value="/listaroficinas", method = RequestMethod.GET)
	public String listaoficinas(Model modelo){
		Operaciones op = new Operaciones();
		Connection cn = op.conexionmysql();
		ArrayList<Oficinas> listaoficinas = op.listaroficinas(cn);
		modelo.addAttribute("listaoficinas", listaoficinas);
		return "listadooficinas" ;
	}
	
	@RequestMapping(value="/listarrepresentantes", method = RequestMethod.GET)
	public String listarepresentantes(Model modelo){
		Operaciones op = new Operaciones();
		Connection cn = op.conexionmysql();
		ArrayList<Repventas> listarep = op.listarrepresentantes(cn);
		modelo.addAttribute("listarep", listarep);
		return "listadorepresentantes" ;
	}
	
	//Aquí llega cuando pulsamos en el index gestion de representantes, y nos lleva al formulario de gestión
	@RequestMapping(value = "/gestionrep", method = RequestMethod.GET)
	public String gestionrep(@Validated @ModelAttribute("representante")Repventas rep, 
	  BindingResult result,  ModelMap model) {
	    if (result.hasErrors()) {
	        return "error";
	    }

	    return "gestionrepresentantes";
	}
	
	//Llegamos cuando rellenamos los datos del formulario y decidimos si insertar, borrar, modificar...
	@RequestMapping(value="/operacionesrep", method = RequestMethod.POST)
	public String operacioneslibros(Model modelo, @ModelAttribute("representante") Repventas rep, 
	       HttpServletRequest request) 
	{
		String mensaje="";
		boolean insertar = WebUtils.hasSubmitParameter(request, "insertar");
		boolean volver = WebUtils.hasSubmitParameter(request, "volver");
		boolean listar = WebUtils.hasSubmitParameter(request, "listar");
		boolean borrar = WebUtils.hasSubmitParameter(request, "borrar");
		boolean modificar = WebUtils.hasSubmitParameter(request, "modificar");
		if(volver)
		{
			return "home";
		}
		if(listar)
		{
			listarepresentantes(modelo);
			return "listadorepresentantes";
		}
		if(insertar)
		{
			Operaciones op = new Operaciones();
			Connection cn = op.conexionmysql();
			mensaje=op.insertar(rep,cn);
		}
		if(borrar)
		{
			Operaciones op = new Operaciones();
			Connection cn = op.conexionmysql();
			mensaje=op.borrar(rep.getNumero_rep(), cn);
		}
		if(modificar)
		{
			Operaciones op = new Operaciones();
			Connection cn = op.conexionmysql();
			mensaje=op.modificar(rep, cn);
		}
		modelo.addAttribute("mensaje", mensaje);
		return "gestionrepresentantes";
		
	}
	
	@ModelAttribute("listaoficinas")
	 public ArrayList<Integer> listaOficinas() {
		  Operaciones op = new Operaciones();
		  Connection cn = op.conexionmysql();
		  ArrayList<Integer> lista = op.listarnombreoficinas(cn);	  
		  return lista;
	 }
	
	@ModelAttribute("listarep")
	 public ArrayList<Integer> listaRepresentantes() {
		  Operaciones op = new Operaciones();
		  Connection cn = op.conexionmysql();
		  ArrayList<Integer> lista = op.listarnumerorep(cn);	  
		  return lista;
	 }
	
	@RequestMapping(value="/volver", method = RequestMethod.POST)
	public String volver(Model modelo){
		return "home" ;
	}
}
