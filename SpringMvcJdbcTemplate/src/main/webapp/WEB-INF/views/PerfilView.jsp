<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Manager Home</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
    	<div align="center">
	        <h1>Contact List</h1>
	        <h3><a href="nuevoPerfil">New Contact</a></h3>
	        <table border="1">
	        	<th>No</th>
	        	<th>Nombre</th>
	        	<th>Descripcion</th>
	        	<th>Estado</th>
	        	<th>Action</th>
	        	
				<c:forEach var="perfilUsuario" items="${listPerfilUsuario}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${perfilUsuario.nombre}</td>
					<td>${perfilUsuario.descripcion}</td>
					<td>${perfilUsuario.estado}</td>
					<td>
						<a href="editarPerfil?id=${perfilUsuario.id}">Editar</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="borrarPerfil?id=${perfilUsuario.id}">Borrar</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>
