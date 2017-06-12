package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.business.DeparBusiness;
import net.codejava.spring.dao.DeparDAO;
import net.codejava.spring.model.Categoria;
import net.codejava.spring.model.Depar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

/**
 * This controller routes accesses to the application to the appropriate
 * hanlder methods. 
 * @author www.codejava.net
 *
 */
@Controller
public class DeparController {

	@Autowired
	private DeparBusiness deparBusiness ;

	
	@RequestMapping(value="/departamento")
	public ModelAndView listDepart(ModelAndView model) throws IOException{
		List<Depar> listDepart = deparBusiness.list();
		model.addObject("listContact", listDepart);
		model.setViewName("DeparHome");
		return model;
	}
	
	@RequestMapping(value = "/nuevoDepart", method = RequestMethod.GET)
	public ModelAndView nuevoDepart(ModelAndView model) {
		Depar nuevoDepart = new Depar();
		model.addObject("depar", nuevoDepart);
		model.setViewName("DeparForm");
		return model;
	}
	
	
	
	
	@RequestMapping(value = "/guardarDepart", method = RequestMethod.POST)
	public ModelAndView guardarDepart(@ModelAttribute Depar depar) {
		if(!deparBusiness.validar(depar.getNombre_depart())){
			ModelAndView model= new ModelAndView();
			Depar nuevoDepart = new Depar();
			model.addObject("depar", nuevoDepart);
			model.addObject("error", "El departamento ya existe.");
			model.setViewName("DeparForm");
			return model;
		}
		else if(depar.getNombre_depart()=="" ||depar.getDescrip_depart()==""){
			ModelAndView model= new ModelAndView();
			Depar nuevoDepart = new Depar();
			model.addObject("depar", nuevoDepart);
			model.addObject("error", "Los campos no pueden estar vacios");
			model.setViewName("DeparForm");
            return model;
		}
		else{
			deparBusiness.saveOrUpdate(depar);		
			return new ModelAndView("redirect:/departamento");
		}
		
		
	}
	
	@RequestMapping(value = "/borrarDepart", method = RequestMethod.GET)
	public ModelAndView borrarDepart(HttpServletRequest request) {
		int id_depart = Integer.parseInt(request.getParameter("id_depart"));
		deparBusiness.delete(id_depart);
		return new ModelAndView("redirect:/departamento");
	}
	
	@RequestMapping(value = "/editarDepart", method = RequestMethod.GET)
	public ModelAndView editarDepart(HttpServletRequest request) {
		int id_depart = Integer.parseInt(request.getParameter("id_depart"));
		Depar depart = deparBusiness.get(id_depart);
		ModelAndView model = new ModelAndView("DeparForm");
		model.addObject("depar", depart);
		
		return model;
	}
}
