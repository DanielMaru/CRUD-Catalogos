package net.codejava.spring.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.spring.dao.PerfilUsuarioDAO;
import net.codejava.spring.model.PerfilUsuario;

@Service
public class PerfilUsuarioBusiness {
	
	private PerfilUsuarioDAO perfilUsuarioDAO;
	
	@Autowired
	public PerfilUsuarioBusiness(PerfilUsuarioDAO perfilUsuarioDAO) {
		this.perfilUsuarioDAO = perfilUsuarioDAO;
	}

	public List<PerfilUsuario> listar() {
		return perfilUsuarioDAO.listar();
	}

	public String guardarOActualizar(PerfilUsuario perfilUsuario) {
		String mensaje = "";
		if(perfilUsuario.getId() > 0){ //si es editar
			perfilUsuarioDAO.guardarOActualizar(perfilUsuario);
		}else{ //si es guardar
			if(perfilUsuarioDAO.buscarPorNombre(perfilUsuario.getNombre()) == null){
				perfilUsuarioDAO.guardarOActualizar(perfilUsuario);
			}else{
				mensaje = "El nombre del perfil ya existe";
			}
		}
		return mensaje;
	}

	public PerfilUsuario buscarPorNombre(String nombre) {
		return perfilUsuarioDAO.buscarPorNombre(nombre);
	}

	public void borrar(int perfilId) {
		perfilUsuarioDAO.borrar(perfilId);
		
	}

	public PerfilUsuario obtener(int perfilId) {
		return perfilUsuarioDAO.obtener(perfilId);
	}
	
	
}
