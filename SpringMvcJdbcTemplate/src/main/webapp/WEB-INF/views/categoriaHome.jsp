<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
    	<div align="center">
	        <h1>Contact List</h1>
	        <h3><a href="newCategoria">Nuevo contacto</a></h3>
	        <table "table table-condensed" >
	        	<th>ID</th>
	        	<th>Nombre</th>
	        	<th>Descripcion</th>
	        	
	        	
				<c:forEach var="contact" items="${listCategoria}" varStatus="status">
	        	<tr>
	        		
					<td>${Categoria.id}</td>
					<td>${Categoria.nombre}</td>
					<td>${Categoria.descripcion}</td>
					
					<td>
						<a href="editCategoria?id=${Categoria.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteCategoria?id=${Categoria.id}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>
