package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.ContactDAO;
import net.codejava.spring.dao.PerfilUsuarioDAO;
import net.codejava.spring.model.Contact;
import net.codejava.spring.model.PerfilUsuario;

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
public class PerfilUsuarioControlador {

	@Autowired
	private PerfilUsuarioDAO perfilUsuarioDAO;
	
	@RequestMapping(value="/perfil")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		List<PerfilUsuario> listPerfilUsuario = perfilUsuarioDAO.list();
		model.addObject("listPerfilUsuario", listPerfilUsuario);
		model.setViewName("perfilView"); //NOMBRE DE LA VISTA PERFIL
		
		return model;
	}
	
	@RequestMapping(value = "/newPerfil", method = RequestMethod.GET)
	public ModelAndView newPerfil(ModelAndView model) {
		Contact newPerfil = new Contact();
		model.addObject("perfilUsuario", newPerfil);
		model.setViewName("PerfilForm"); //NOMBRE FORM
		return model;
	}
	
	@RequestMapping(value = "/savePerfil", method = RequestMethod.POST)
	public ModelAndView savePerfil(@ModelAttribute PerfilUsuario perfilUsuario) {
		perfilUsuarioDAO.saveOrUpdate(perfilUsuario);		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deletePerfil", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int perfilId = Integer.parseInt(request.getParameter("id"));
		perfilUsuarioDAO.delete(perfilId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editPerfil", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int perfilId = Integer.parseInt(request.getParameter("id"));
		PerfilUsuario perfilUsuario = perfilUsuarioDAO.get(perfilId);
		ModelAndView model = new ModelAndView("ContactForm");
		model.addObject("contact", perfilUsuario);
		
		return model;
	}
}
