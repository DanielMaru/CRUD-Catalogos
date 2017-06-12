package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.business.PerfilUsuarioBusiness;
import net.codejava.spring.dao.PerfilUsuarioDAO;
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
	private PerfilUsuarioBusiness perfilUsuarioBusiness;
	
	@RequestMapping(value="/perfil")
	public ModelAndView listPerfilUsuario(ModelAndView model) throws IOException{
		List<PerfilUsuario> listPerfilUsuario = perfilUsuarioBusiness.listar();
		model.addObject("listPerfilUsuario", listPerfilUsuario);
		model.setViewName("PerfilView"); //NOMBRE DE LA VISTA PERFIL
		
		return model;
	}
	
	@RequestMapping(value = "/nuevoPerfil", method = RequestMethod.GET)
	public ModelAndView nuevoPerfil(ModelAndView model) {
		PerfilUsuario nuevoPerfil = new PerfilUsuario();
		model.addObject("perfilUsuario", nuevoPerfil);
		model.setViewName("PerfilForm"); //NOMBRE FORM
		return model;
	}
	
	@RequestMapping(value = "/guardarPerfil", method = RequestMethod.POST)
	public ModelAndView guardarPerfil(@ModelAttribute PerfilUsuario perfilUsuario) {
		String mensaje = "";
		if(perfilUsuario.equals("") || perfilUsuario.equals("")){
			mensaje = "Debe ingresar todos los campos";
		}else{
			mensaje = perfilUsuarioBusiness.guardarOActualizar(perfilUsuario);
		}
		
		if(!mensaje.equals("")){
			ModelAndView model= new ModelAndView();
			model.addObject("mensaje", mensaje);
			model.addObject("perfilUsuario", perfilUsuario);
			model.addObject("error", "error");
			model.setViewName("PerfilForm"); 			
			
			return model;
		}
		return new ModelAndView("redirect:/perfil");
		
	}
	
	@RequestMapping(value = "/borrarPerfil", method = RequestMethod.GET)
	public ModelAndView borrarPerfilUsuario(HttpServletRequest request) {
		int perfilId = Integer.parseInt(request.getParameter("id"));
		perfilUsuarioBusiness.borrar(perfilId);
		return new ModelAndView("redirect:/perfil");
	}
	
	@RequestMapping(value = "/editarPerfil", method = RequestMethod.GET)
	public ModelAndView editarCategoria(HttpServletRequest request) {
		int perfilId = Integer.parseInt(request.getParameter("id"));
		PerfilUsuario perfilUsuario = perfilUsuarioBusiness.obtener(perfilId);
		ModelAndView model = new ModelAndView("PerfilForm");
		model.addObject("perfilUsuario", perfilUsuario);
		
		return model;
	}
}
