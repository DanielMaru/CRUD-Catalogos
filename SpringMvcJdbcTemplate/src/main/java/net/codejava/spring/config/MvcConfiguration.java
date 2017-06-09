package net.codejava.spring.config;

//dnfufiisdfkf

//HOLA
//111111
//HOLA 2


//version  mateo

import javax.sql.DataSource;

import net.codejava.spring.dao.CategoriaDAO;
import net.codejava.spring.dao.CategoriaDAOImpl;
import net.codejava.spring.dao.ContactDAO;
import net.codejava.spring.dao.ContactDAOImpl;
import net.codejava.spring.dao.DeparDAO;
import net.codejava.spring.dao.DeparDAOImpl;
import net.codejava.spring.dao.PerfilUsuarioDAO;
import net.codejava.spring.dao.PerfilUsuarioDAOImpl;
import net.codejava.spring.dao.UsuarioDAO;
import net.codejava.spring.dao.UsuarioDAOImp;
import net.codejava.spring.dao.ciudadDAO;
import net.codejava.spring.dao.ciudadDAOImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="net.codejava.spring")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		return dataSource;
	}
	
	@Bean
	public ContactDAO getContactDAO() {
		return new ContactDAOImpl(getDataSource());
	}
	
	@Bean
	public PerfilUsuarioDAO getPerfilUsuarioDAO() {
		return new PerfilUsuarioDAOImpl(getDataSource());
	}
	
	@Bean 
	public UsuarioDAO getUsuarioDAO(){
		return new UsuarioDAOImp(getDataSource());
	}
	
	@Bean
	public CategoriaDAO getCategoriaDAO() {
		return new CategoriaDAOImpl(getDataSource());
	}

	@Bean
	public DeparDAO getDeparDAO() {
		return new DeparDAOImpl(getDataSource());
	}
	
	@Bean
	public ciudadDAO getciudadDAO() {
		return new ciudadDAOImpl(getDataSource());
	}
}
	