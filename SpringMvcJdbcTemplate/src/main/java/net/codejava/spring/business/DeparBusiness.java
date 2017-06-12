package net.codejava.spring.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.spring.dao.DeparDAO;
import net.codejava.spring.model.Depar;

@Service
public class DeparBusiness {
	
	private DeparDAO DeparDAO;
	
	@Autowired
	public DeparBusiness(DeparDAO DeparDAO) {
		this.DeparDAO = DeparDAO;
	}

	public List<Depar> list() {
		return DeparDAO.list();
	}
	
	public boolean validar(String nombre) {
		return DeparDAO.validar(nombre);
	}

	public String saveOrUpdate(Depar depar) {
		String mensaje = "";
		if(depar.getId_depart() > 0){ //si es editar
			DeparDAO.saveOrUpdate(depar);
		}else{ //si es guardar
			if(DeparDAO.validar(depar.getNombre_depart()) == true){
				DeparDAO.saveOrUpdate(depar);
			}else{
				mensaje = "El nombre del perfil ya existe";
			}
		}
		return mensaje;
	}
	

	public void delete(int id_depart) {
		DeparDAO.delete(id_depart);
		
	}

	public Depar get(int id_depart) {
		return DeparDAO.get(id_depart);
	}
	
	
	
	
}
