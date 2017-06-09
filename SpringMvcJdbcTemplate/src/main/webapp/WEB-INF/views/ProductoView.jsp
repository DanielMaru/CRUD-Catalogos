<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto Manager Home</title>
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
    	<div class="row" align="center">
	        <h1>Producto List</h1>
	        <h3><a href="newProducto">New Producto</a></h3>
	        <div class="col-md-6 col-md-offset-3">
	        <table class="table table-striped" border="1">
	        	<th>No</th>
	        	<th>Nombre_Producto</th>
	        	<th>Tipo_Producto</th>
	        	<th>Estado_Producto</th>
	        	<th>Action</th>
	        	
				<c:forEach var="productobanco" items="${listProductobanco}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${productobanco.nom_productos}</td>
					<td>${productobanco.tipo}</td>
					<td>${productobanco.estdo}</td>
					<td>
						<a href="editProducto?id=${productobanco.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteProducto?id=${productobanco.id}">delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
	        </div>
    	</div>
    </body>
</html>
