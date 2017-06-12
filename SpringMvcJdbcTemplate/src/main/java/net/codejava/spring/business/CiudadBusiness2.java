package net.codejava.spring.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.spring.dao.ciudadDAO;
import net.codejava.spring.model.ciudad;

@Service
public class CiudadBusiness2 {
	
	private ciudadDAO ciudadDAO;
	
	@Autowired
	public CiudadBusiness2(ciudadDAO ciudadDAO) {
		this.ciudadDAO = ciudadDAO;
	}

	public List<ciudad> listar() {
		return ciudadDAO.list();
	}

	public String saveOrUpdate(ciudad ciudad) {
		String mensaje = "";
		if(ciudad.getIdCiudad() > 0){ //si es editar
			ciudadDAO.saveOrUpdate(ciudad);
		}else{ //si es guardar
			if(ciudadDAO.buscarPorNombreCiudad(ciudad.getNombreCiudad()) == null){
				ciudadDAO.saveOrUpdate(ciudad);
			}else{
				mensaje = "El nombre de la ciudad ya existe";
			}
		}
		return mensaje;
	}

	public ciudad buscarPorNombreCiudad(String NombreCiudad) {
		return ciudadDAO.buscarPorNombreCiudad(NombreCiudad);
	}

	public void delete(int CiudadId) {
		ciudadDAO.delete(CiudadId);
		
	}

	public ciudad Obtener(int CiudadId) {
		return ciudadDAO.Obtener(CiudadId);
	}
	
	
}
