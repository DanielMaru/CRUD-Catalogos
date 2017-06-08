<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
   		<script>
			function myFunction() {
			  var input, filter, table, tr, td, i;
			  input = document.getElementById("InputName");
			  filter = input.value.toUpperCase();
			  table = document.getElementById("myTable");
			  tr = table.getElementsByTagName("tr");
			  for (i = 0; i < tr.length; i++) {
			    td = tr[i].getElementsByTagName("td")[1];
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
    </head>
    <body>
    	<div align="center">
    		<input type="text" id="InputName" onkeyup="myFunction()" placeholder="Ingrese el nombre del usuario" title="Copie un nombres">
	        <h1>Lista de usuarios</h1>
	        <h3><a href="usuarioNuevo">Agregar usuario</a></h3>
	        <table border="1" id="myTable">
	        	<th>id</th>
	        	<th>Nombre</th>
	        	<th>Password</th>

	        	
	        	
				<c:forEach var="usuario" items="${listaUsuarios}" varStatus="status">
	        	<tr>
	        		
					<td>${usuario.id}</td>
					<td>${usuario.nombre}</td>
					<td>${usuario.pass}</td>
					
					<td>
						<a href="editUsuario?id=${usuario.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteUsuario?id=${usuario.id}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>
