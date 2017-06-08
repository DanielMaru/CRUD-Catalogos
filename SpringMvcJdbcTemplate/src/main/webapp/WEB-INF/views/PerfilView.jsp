<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administración de Perfiles</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
    <script>
		function myFunction() {
  		// Declare variables 
  			var input, filter, table, tr, td, i;
  			input = document.getElementById("id");
  			filter = input.value.toUpperCase();
  			table = document.getElementById("tablaPerfiles");
  			tr = table.getElementsByTagName("tr");

  			// Loop through all table rows, and hide those who don't match the search query
  			for (i = 0; i < tr.length; i++) {
    			td = tr[i].getElementsByTagName("td")[0];
    			if (td) {
    	  			if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        				tr[i].style.display = "";
      				} else {
        				tr[i].style.display = "none";
      				}
   				} 
  			}
		}
	</script>
    	<div align="center">
    	<h1>Buscar Perfil</h1>
		<input type="text" id="id" onkeyup="myFunction()" placeholder="Buscando...">
    	</div>
    	<div align="center">
	        <h1>Lista de Perfiles</h1>
	        <h3><a href="nuevoPerfil">Nuevo Perfil</a></h3>
	        <table border="1" id="tablaPerfiles">
	        	<th>Nombre</th>
	        	<th>Descripcion</th>
	        	<th>Acción</th>
	        	
				<c:forEach var="perfilUsuario" items="${listPerfilUsuario}" varStatus="status">
	        	<tr>
					<td>${perfilUsuario.nombre}</td>
					<td>${perfilUsuario.descripcion}</td>
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
