package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.spring.model.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO{

	private JdbcTemplate jdbcTemplate;
	
	public CategoriaDAOImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void guardarOActualizar(Categoria categoria) {
		if(categoria.getId() > 0){
			//Actualizar
			String sql = "UPDATE categoria SET nomCATEGORIAS=?, descipCATEGORIAS=?  WHERE idCATEGORIAS=?";
			jdbcTemplate.update(sql, categoria.getNombre(), categoria.getDescripcion(), categoria.getId());
		}
		else{
			//Insertar
			String sql = "INSERT INTO categoria (nomCATEGORIAS, descipCATEGORIAS, estadoCATEGORIA)"
					+ " VALUES (?, ?, ?)";
			jdbcTemplate.update(sql, categoria.getNombre(), categoria.getDescripcion(),
					categoria.getEstadoEliminado());
		}
		
	}

	@Override
	public void eliminar(int categoriaId) {
		String sql = "UPDATE categoria SET estadoCATEGORIA=1 WHERE idCATEGORIAS=?";
		jdbcTemplate.update(sql, categoriaId);
		
	}

	@Override
	public Categoria get(int categoriaId) {
		
		String sql = "SELECT * FROM categorias WHERE idCATEGORIAS=" + categoriaId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Categoria>() {

			@Override
			public Categoria extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Categoria categoria = new Categoria();
					categoria.setId(rs.getInt("idCATEGORIAS"));
					categoria.setNombre(rs.getString("nomCATEGORIAS"));
					categoria.setDescripcion(rs.getString("descripCATEGORIAS"));
					categoria.setEstadoEliminado(rs.getInt("estadoCATEGORIA"));
					return categoria;
				}
				
				return null;
			}
			
		});
	}

	@Override
	public List<Categoria> list() {
	
		String sql = "SELECT * FROM categorias";
		List<Categoria> listCategoria = jdbcTemplate.query(sql, new RowMapper<Categoria>() {

			@Override
			public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
				Categoria aCategoria = new Categoria();
	
				aCategoria.setId(rs.getInt("idCATEGORIAS"));
				aCategoria.setNombre(rs.getString("nomCATEGORIAS"));
				aCategoria.setDescripcion(rs.getString("descripCATEGORIAS"));
				aCategoria.setEstadoEliminado(rs.getInt("estadoCATEGORIA"));
				
				return aCategoria;
			}
			
		});
		
		return listCategoria;
	}

}
