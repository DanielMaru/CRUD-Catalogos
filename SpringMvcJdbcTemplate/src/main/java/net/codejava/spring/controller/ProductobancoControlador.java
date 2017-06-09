package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import net.codejava.spring.dao.ContactDAO;
import net.codejava.spring.dao.ProductobancoDAO;
import net.codejava.spring.model.Contact;
import net.codejava.spring.model.Productobanco;

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
public class ProductobancoControlador {

	@Autowired
	private ProductobancoDAO productobancoDAO;
	
	@RequestMapping(value="/producto")
	public ModelAndView listProductobanco(ModelAndView model) throws IOException{
		List<Productobanco> listProductobanco = productobancoDAO.list();
		model.addObject("listProductobanco", listProductobanco);
		model.setViewName("ProductoView");
		System.out.println(listProductobanco.get(0).getNom_productos());
		
		return model;
	}
	
	@RequestMapping(value = "/newProducto", method = RequestMethod.GET)
	public ModelAndView newProductobanco(ModelAndView model) {
		Productobanco newProducto = new Productobanco();
		model.addObject("productobanco", newProducto);
		model.setViewName("ProductoForm");
		return model;
	}
	
	@RequestMapping(value = "/saveProducto", method = RequestMethod.POST)
	public ModelAndView saveProductobanco(@ModelAttribute Productobanco productobanco) {
		productobancoDAO.saveOrUpdate(productobanco);		
		return new ModelAndView("redirect:/producto");
	}
	
	@RequestMapping(value = "/deleteProducto", method = RequestMethod.GET)
	public ModelAndView deleteProductobanco(HttpServletRequest request) {
		int productoId = Integer.parseInt(request.getParameter("id"));
		productobancoDAO.delete(productoId);
		return new ModelAndView("redirect:/producto");
	}
	
	@RequestMapping(value = "/editProducto", method = RequestMethod.GET)
	public ModelAndView editProductobanco(HttpServletRequest request) {
		int productoId = Integer.parseInt(request.getParameter("id"));
		Productobanco productobanco = productobancoDAO.get(productoId);
		ModelAndView model = new ModelAndView("ProductoForm");
		model.addObject("productobanco", productobanco);
		
		return model;
	}
}
