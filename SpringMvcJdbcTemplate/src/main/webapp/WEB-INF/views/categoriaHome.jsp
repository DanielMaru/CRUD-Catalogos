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
    <script>
		function myFunction() {
  		// Declare variables 
  			var input, filter, table, tr, td, i;
  			input = document.getElementById("id");
  			filter = input.value.toUpperCase();
  			table = document.getElementById("tablaCategorias");
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
    	<h3>Buscar Categoria</h3>
		<input type="text" id="id" onkeyup="myFunction()" placeholder="Buscando...">
    	</div>
    	<div align="center">
	        <h1>Lista de Categorias</h1>
	        <h3><a href="nuevaCategoria" class="btn btn-primary ">Nuevo Categoria</a></h3>
	        <div class="col-md-6 col-md-offset-3" border="3">
	            <table  class="table table-bordered table-striped " id="tablaCategorias">
	        	<th>Nombre</th>
	        	<th>Descripcion</th>
	        	<th>Acción</th>
	        	
				<c:forEach var="categoria" items="${listCategoria}" varStatus="status">
	        	<tr>
					<td>${categoria.nombre}</td>
					<td>${categoria.descripcion}</td>
					<td>
						<a href="editarCategoria?id=${categoria.id}" class="btn btn-info">Editar</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="eliminarCategoria?id=${categoria.id}" class="btn btn-danger">Borrar</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
	        </div>	      
    	</div>   	
    </body>
</html>
