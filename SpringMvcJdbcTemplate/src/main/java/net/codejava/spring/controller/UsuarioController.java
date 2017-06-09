package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.PerfilUsuarioDAO;
import net.codejava.spring.dao.UsuarioDAO;
import net.codejava.spring.model.Contact;
import net.codejava.spring.model.PerfilUsuario;
import net.codejava.spring.model.Usuario;

@Controller
public class UsuarioController {
	
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private PerfilUsuarioDAO perfilUsuarioDAO;
	@RequestMapping(value="/usuarios")
	public ModelAndView listaUsuario(ModelAndView model) throws IOException{
		/*
		List<PerfilUsuario> listPerfilUsuario = perfilUsuarioDAO.list();
		model.addObject("listPerfilUsuario", listPerfilUsuario);
		model.setViewName("perfilView"); //NOMBRE DE LA VISTA PERFIL
		*/
		
		List<Usuario> listaUsuarios = usuarioDAO.list();
		model.addObject("listaUsuarios",listaUsuarios);
		model.setViewName("usuarios");
		
		return model;
	}
	
	@RequestMapping(value = "/usuarioNuevo", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Usuario usuarioNuevo = new Usuario();
		model.addObject("usuario", usuarioNuevo);
		model.addObject("error","123");
		model.addObject("mensaje","Recuerda llenar todos los campos");
		model.setViewName("UsuarioForm");
		return model;
	}
	
	@RequestMapping(value = "/guardarUsuario", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Usuario usuario) {
		boolean error  = false;
		String mensaje = "";
		if(usuario.getNombre().equals("")){
			error = true;
			mensaje = "El nombre no puede ser nulo/n";
		}
		
		if(usuario.getLogin().equals("")){
			error = true;
			mensaje = "El login no puede ser nulo\n";
		}
		if(usuario.getPass().equals("")){
			error = true;
			mensaje = "La password no puede ser nula\n";
		}
		//Usuario usuario2 = usuarioDAO.findByLogin(usuario.getLogin());
//		if(usuario2!=null){
//			error = true;
//			mensaje = "Login no disponible";
//		}
//		
		if(!error){	
			try{
				usuarioDAO.saveOrUpdate(usuario);
			}catch(Exception e){
				error = true;
				mensaje += "Información no valida";
					
			}
		}else{
			ModelAndView model = new ModelAndView("UsuarioForm");
			model.addObject("mensaje", mensaje);
			model.addObject("usuario",usuario);
			model.addObject("error","error");
			
			return model;
		}
			
			
		return new ModelAndView("redirect:/usuarios");
	}
	
	@RequestMapping(value = "/deleteUsuario", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		if(id>0){
			usuarioDAO.delete(id);
		}
		return new ModelAndView("redirect:/usuarios");
	}
	
	@RequestMapping(value = "/editUsuario", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Usuario usuario = usuarioDAO.get(id);
		ModelAndView model = new ModelAndView("EditUsuario");
		model.addObject("usuario", usuario);
		
		return model;
	}
	
	
	
}
