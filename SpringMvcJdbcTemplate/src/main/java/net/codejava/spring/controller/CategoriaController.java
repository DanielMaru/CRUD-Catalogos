package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.CategoriaDAO;
import net.codejava.spring.model.Categoria;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@RequestMapping(value="/categorias")
	public ModelAndView listCategoria(ModelAndView model) throws IOException{
		List<Categoria> listCategoria = categoriaDAO.list();
		model.addObject("listCategoria", listCategoria);
		model.setViewName("categoriaHome");
		
		return model;
	}
	
	@RequestMapping(value = "/nuevaCategoria", method = RequestMethod.GET)
	public ModelAndView nuevaCategoria(ModelAndView model) {
		Categoria nuevaCategoria = new Categoria();
		model.addObject("categoria", nuevaCategoria);
		model.setViewName("categoriaForm");
		return model;
	}
	
	@RequestMapping(value = "/guardarCategoria", method = RequestMethod.POST)
	public ModelAndView guardarCategoria(@ModelAttribute Categoria categoria) {
		if(categoria.getId() > 0){
			categoriaDAO.guardarOActualizar(categoria);		
			return new ModelAndView("redirect:/categorias");
		}
		else{
			if(!categoriaDAO.validar(categoria.getNombre())){
				ModelAndView model= new ModelAndView();
				Categoria nuevaCategoria = new Categoria();
				model.addObject("categoria", nuevaCategoria);
				model.addObject("error", "La categoria ya existe");
				model.setViewName("categoriaForm");
				return model;
			}
			else if(categoria.getNombre()=="" || categoria.getDescripcion()==""){
				ModelAndView model= new ModelAndView();
				Categoria nuevaCategoria = new Categoria();
				model.addObject("categoria", nuevaCategoria);
				model.addObject("error", "Los campos no pueden estar vacios");

				model.setViewName("categoriaForm");
				return model;
			}
			else{
				categoriaDAO.guardarOActualizar(categoria);		
				return new ModelAndView("redirect:/categorias");
			}
			
		}
		
	}
	
	@RequestMapping(value = "/eliminarCategoria", method = RequestMethod.GET)
	public ModelAndView eliminarCategoria(HttpServletRequest request) {
		int categoriaId = Integer.parseInt(request.getParameter("id"));
		categoriaDAO.eliminar(categoriaId);
		return new ModelAndView("redirect:/categorias");
	}
	
	@RequestMapping(value = "/editarCategoria", method = RequestMethod.GET)
	public ModelAndView editarCategoria(HttpServletRequest request) {
		int categoriaId = Integer.parseInt(request.getParameter("id"));
		Categoria categoria = categoriaDAO.get(categoriaId);
		ModelAndView model = new ModelAndView("categoriaForm");
		model.addObject("categoria", categoria);
		
		return model;
	}
}
