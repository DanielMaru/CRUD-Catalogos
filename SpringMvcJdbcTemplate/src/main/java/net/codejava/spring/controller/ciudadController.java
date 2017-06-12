package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.ciudadDAO;
import net.codejava.spring.model.ciudad;
//import net.codejava.spring.model.ciudad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * This controller routes accesses to the application to the appropriate
 * hanlder methods. 
 * @author www.codejava.net
 *
 */
@Controller
public class ciudadController {

	@Autowired
	private ciudadDAO ciudadDAO;
	
	@RequestMapping(value="/ciudad")
	public ModelAndView listciudad(ModelAndView model) throws IOException{
		List<ciudad> listciudad = ciudadDAO.list();
		model.addObject("listciudad", listciudad);
		model.setViewName("ciudadView");
		
		return model;
	}
	
	@RequestMapping(value = "/nuevaciudad", method = RequestMethod.GET)
	public ModelAndView nuevaciudad(ModelAndView model) {
		ciudad nuevaciudad = new ciudad();
		model.addObject("ciudad", nuevaciudad);
		model.setViewName("ciudadForm");
		return model;
	}
	
	@RequestMapping(value = "/guardarciudad", method = RequestMethod.POST)
	public ModelAndView guardarciudad(@ModelAttribute ciudad ciudad) {
		if(!ciudadDAO.validar(ciudad.getNombreCiudad())){
			ModelAndView model= new ModelAndView();
			ciudad nuevaciudad = new ciudad();
			model.addObject("ciudad", nuevaciudad);
			model.addObject("error", "error");
			model.setViewName("ciudadForm");
			return model;
		}
		else{
			ciudadDAO.saveOrUpdate(ciudad);		
			return new ModelAndView("redirect:/ciudad");
		}
	}
	
	@RequestMapping(value = "/Eliminarciudad", method = RequestMethod.GET)
	public ModelAndView Eliminarciudad(HttpServletRequest request) {
		
		int ciudadId = Integer.parseInt(request.getParameter("IdCiudad"));
		ciudadDAO.delete(ciudadId);
		return new ModelAndView("redirect:/ciudad");
	}
	
	@RequestMapping(value = "/Editarciudad", method = RequestMethod.GET)
	public ModelAndView Editarciudad(HttpServletRequest request) {
		
		int IdCiudad = Integer.parseInt(request.getParameter("IdCiudad"));
		ciudad ciudad = ciudadDAO.get(IdCiudad);
		ModelAndView model = new ModelAndView("ciudadForm");
		model.addObject("ciudad", ciudad);
		
		return model;
	}
}
