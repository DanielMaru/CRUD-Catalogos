package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.spring.model.Contact;
import net.codejava.spring.model.Usuario;

public class UsuarioDAOImp implements UsuarioDAO{

	private JdbcTemplate jdbcTemplate;
	
	public UsuarioDAOImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public boolean saveOrUpdate(Usuario usuario) {
		boolean retorno = false;
		try{
		if (usuario.getId()>0) {
			// update
			String sql = "UPDATE usuarios SET id=?, nombre=?, pass=?, "
						+ "estado=? WHERE id=?";
			jdbcTemplate.update(sql, usuario.getId(), usuario.getNombre(),
					usuario.getPass(), usuario.getEstado(),usuario.getId());
		} else {
			// insert
			String sql = "INSERT INTO usuarios (id, nombre, pass, estado)"
						+ " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, usuario.getId(), usuario.getNombre(),
					usuario.getPass(), usuario.getEstado());
			
			retorno = true;
		}
		}catch(Exception e){
			retornao = false;
		}
		
	}

	@Override
	public boolean delete(int id) {
		Usuario usuario = this.get(id);
		usuario.setEstado(1);
		this.saveOrUpdate(usuario);
		//String sql = "DELETE FROM usuarios WHERE id=?";
		//jdbcTemplate.update(sql, id);
		
	}

	@Override
	public Usuario get(int id) {
		String sql = "SELECT * FROM usuarios WHERE id=" + id;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Usuario>() {

			@Override
			public Usuario extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setPass(rs.getString("pass"));
					usuario.setEstado(rs.getInt("estado"));
					return usuario;
				}
				
				return null;
			}
			
		});
	}

	@Override
	public List<Usuario> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM usuarios where estado=0";
		List<Usuario> listUsuarios = jdbcTemplate.query(sql, new RowMapper<Usuario>() {

			@Override
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
				Usuario myUsuario = new Usuario();
				
				myUsuario.setId(rs.getInt("id"));
				myUsuario.setNombre(rs.getString("nombre"));
				myUsuario.setPass(rs.getString("pass"));
				myUsuario.setEstado(rs.getInt("estado"));
				
				return myUsuario;
			}
			
		});
		
		return listUsuarios;

	}


	

}
