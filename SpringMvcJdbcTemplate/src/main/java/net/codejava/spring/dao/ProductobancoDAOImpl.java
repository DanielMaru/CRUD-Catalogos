package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.model.Productobanco;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class ProductobancoDAOImpl implements ProductobancoDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ProductobancoDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Productobanco productobanco) {
		if (productobanco.getId() > 0) {
			// update
			String sql = "UPDATE producto SET nom_productos=?, tipo=?, "
						+ "estdo=? WHERE producto_id=?";
			jdbcTemplate.update(sql, productobanco.getNom_productos(), productobanco.getTipo(),
					productobanco.getEstdo(), productobanco.getId());
		} else {
			// insert
			String sql = "INSERT INTO producto (nom_productos, tipo, estdo)"
						+ " VALUES (?, ?, ?)";
			jdbcTemplate.update(sql, productobanco.getNom_productos(), productobanco.getTipo(),
					productobanco.getEstdo());
		}
		
	}

	@Override
	public void delete(int productobancoId) {
		String sql = "DELETE FROM producto WHERE producto_id=?";
		jdbcTemplate.update(sql, productobancoId);
	}

	@Override
	public List<Productobanco> list() {
		String sql = "SELECT * FROM producto";
		List<Productobanco> listProductobanco = jdbcTemplate.query(sql, new RowMapper<Productobanco>() {

			@Override
			public Productobanco mapRow(ResultSet rs, int rowNum) throws SQLException {
				Productobanco productobanco = new Productobanco();
	
				productobanco.setId(rs.getInt("producto_id"));
				productobanco.setNom_productos(rs.getString("nom_productos"));
				productobanco.setTipo(rs.getString("tipo"));
				productobanco.setEstdo(rs.getString("estdo"));
				
				
				return productobanco;
			}
			
		});
		
		return listProductobanco;
	}

	@Override
	public Productobanco get(int productoId) {
		String sql = "SELECT * from producto WHERE producto_id=" + productoId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Productobanco>() {

			@Override
			public Productobanco extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Productobanco productobanco = new Productobanco();
					
					productobanco.setId(rs.getInt("producto_id"));
					productobanco.setNom_productos(rs.getString("nom_productos"));
					productobanco.setTipo(rs.getString("tipo"));
					productobanco.setEstdo(rs.getString("estdo"));
					
					return productobanco;
				}
				
				return null;
			}
			
		});
	}

}
