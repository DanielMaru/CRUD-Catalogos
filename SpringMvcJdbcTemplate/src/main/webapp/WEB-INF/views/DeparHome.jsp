<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Departamento</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        
	    <script type="text/javascript">
	    	function myFunction() {
	    	  // Declare variables
	    	  var input, filter, table, tr, td, i;
	    	  input = document.getElementById("inputDepart");
	    	  filter = input.value.toUpperCase();
	    	  table = document.getElementById("tableDepart");
	    	  tr = table.getElementsByTagName("tr");

	    	  // Loop through all table rows, and hide those who don't match the search query
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
    	<div align="center" class="row">
	        <h1>Lista Departamentos</h1>
	        <h3><a href="nuevoDepart">Nuevo Departamento</a></h3>
	        <input type="text" id="inputDepart" onkeyup="myFunction()" placeholder="Buscar ...">
	        <br></br>
	        
	        <div  class="col-md-6 col-md-offset-3" border="3">
	           <table class="table table-bordered table-striped " id="tableDepart">
	        	<th>No</th>
	        	<th>Departamento</th>
	        	<th>Descripcion</th>
	        	<th>Accion</th>
	        	
				<c:forEach var="depart" items="${listContact}" varStatus="status">
	        	<tr>
	        		<td>${depart.id_depart}</td>
					<td>${depart.nombre_depart}</td>
					<td>${depart.descrip_depart}</td>
					<td>
						<a href="editarDepart?id_depart=${depart.id_depart}">Editar</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="borrarDepart?id_depart=${depart.id_depart}">Borrar</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
	        </div>
	     
    	</div>
    	
    	
    	
    	
    </body>
</html>
