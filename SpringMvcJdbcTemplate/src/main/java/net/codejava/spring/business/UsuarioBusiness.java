package net.codejava.spring.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.spring.dao.UsuarioDAO;
import net.codejava.spring.model.Usuario;

@Service
public class UsuarioBusiness {
	@Autowired
	private UsuarioDAO usuarioDAO;
	public List<Usuario> list() {
		return usuarioDAO.list();
	}


	public boolean saveOrUpdate(Usuario usuario) throws Exception {
		boolean retorno = false;
		try{
			usuarioDAO.saveOrUpdate(usuario);
			retorno = true;
		}catch(Exception e){
			throw new Exception();
		}
		return true;
	}

	public boolean delete(int id) {
		return usuarioDAO.delete(id);
		
	}

	public Usuario get(int id) {
		return usuarioDAO.get(id);
	}


	public Usuario findByLogin(String login) {
		return usuarioDAO.findByLogin(login);
	}
	
}
