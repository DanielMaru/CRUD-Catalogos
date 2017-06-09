<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ciudad</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
    <script>
			function myFunction() {
			  // Declare variables 
			  var input, filter, table, tr, td, i;
			  input = document.getElementById("IdCiudad");
			  filter = input.value.toUpperCase();
			  table = document.getElementById("ciudad");
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
         <div class="row" align="center">
    	<h3>Buscar Ciudad</h3>
		<input type="text" id="IdCiudad" onkeyup="myFunction()" placeholder="Buscando...">
    	</div>
    	<div align="center">
	        <h1>Lista de Ciudad</h1>
	        <h3><a href="nuevaciudad" class="btn btn-primary ">Nuevo Ciudad</a></h3>
	        <div class="col-md-6 col-md-offset-3" border="3">
	            <table  class="table table-bordered table-striped " id="ciudad">
	        	<th>Nombre Ciudad</th>
	        	<th>Nombre Departamento</th>
	        	<th>Acción</th>
	        	
				<c:forEach var="ciudad" items="${listciudad}" varStatus="status">
	        	<tr>
					<td>${ciudad.nombreCiudad}</td>
					<td>${ciudad.nombreDepartamento}</td>
					<td>
						<a href="Editarciudad?IdCiudad=${ciudad.idCiudad}">Editar</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="Eliminarciudad?IdCiudad=${ciudad.idCiudad}">Borrar</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
	        </div>
	      
    	</div>
    	
         
         
    	
    </body>
</html>