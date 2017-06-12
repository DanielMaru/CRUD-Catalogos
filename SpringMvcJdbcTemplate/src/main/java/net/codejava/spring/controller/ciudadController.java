package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.business.CiudadBusiness2;
import net.codejava.spring.dao.ciudadDAO;
import net.codejava.spring.model.ciudad;

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
	private CiudadBusiness2 ciudadBusiness2;
	
	@RequestMapping(value="/ciudad")
	public ModelAndView listciudad(ModelAndView model) throws IOException{
		List<ciudad> listciudad = ciudadBusiness2.listar();
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
	public ModelAndView saveOrUpdate(@ModelAttribute ciudad ciudad) {
		if(!ciudadBusiness2.validar(ciudad.getNombreCiudad())){
			ModelAndView model= new ModelAndView();
//			ciudad nuevaciudad = new ciudad();
			model.addObject("ciudad", ciudad);
			model.addObject("error", "la ciudad ya existe.");
			model.setViewName("ciudadForm");
			return model;
		}
		else if(ciudad.getNombreCiudad().equals("") ||ciudad.getNombreDepartamento()==""){
			ModelAndView model= new ModelAndView();
			ciudad nuevociudad = new ciudad();
			model.addObject("ciudad", nuevociudad);
			model.addObject("error", "Los campos no pueden estar vacios");
			model.setViewName("ciudadForm");
            return model;
		}
		else{
			ciudadBusiness2.saveOrUpdate(ciudad);		
			return new ModelAndView("redirect:/ciudad");
		}
		
		
	}
	
	@RequestMapping(value = "/Eliminarciudad", method = RequestMethod.GET)
	public ModelAndView Eliminarciudad(HttpServletRequest request) {
		
		int ciudadId = Integer.parseInt(request.getParameter("IdCiudad"));
		ciudadBusiness2.delete(ciudadId);
		return new ModelAndView("redirect:/ciudad");
	}
	
	@RequestMapping(value = "/Editarciudad", method = RequestMethod.GET)
	public ModelAndView Editarciudad(HttpServletRequest request) {
		int CiudadId = Integer.parseInt(request.getParameter("IdCiudad"));
		ciudad ciudad = ciudadBusiness2.Obtener(CiudadId);
		ModelAndView model = new ModelAndView("ciudadForm");
		model.addObject("ciudad", ciudad);
		
		return model;
	}
}
