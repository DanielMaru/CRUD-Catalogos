package net.codejava.spring.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.spring.dao.UsuarioDAO;
import net.codejava.spring.model.Usuario;

@Service
public class UsuarioBusiness {
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	public UsuarioBusiness(UsuarioDAO usuarioDao){
		this.usuarioDAO = usuarioDao;
	}
	public List<Usuario> list() {
		return usuarioDAO.list();
	}


	public boolean saveOrUpdate(Usuario usuario) throws Exception {
		boolean retorno = false;
		try{
			Usuario usuarioTemp = usuarioDAO.findByLogin(usuario.getLogin());
			if(usuarioTemp==null){
				usuarioDAO.saveOrUpdate(usuario);
				retorno = true;
			}else if(usuarioTemp.getId()==usuario.getId()){
				usuarioDAO.saveOrUpdate(usuario);
				retorno = true;
			}else{
				retorno=false;
			}
			
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
