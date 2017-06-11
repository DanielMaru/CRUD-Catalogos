<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Nuevo/Editar Categoria</title>

</head>
<body>
	<c:if test="${error!=null}"><script>$(function() {  $("#myModal").modal();  });</script></c:if>
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
		
			<center><h1 class="text-info">Nuevo/Editar Categoria</h1></center><br><br>
					
			<form:form action="guardarCategoria" method="post" modelAttribute="categoria" class="form-horizontal">
				<div class="form-group">
			      <label class="control-label col-sm-2" for="nombre">Nombre</label>
			      <div class="col-sm-10">
			      	<form:input  path="nombre" class="form-control"/>		        
			      </div>
			    </div>
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="descripcion">Descripcion</label>
			      <div class="col-sm-10">
			      	<form:input  path="descripcion" class="form-control"/>		        
			      </div>
			    </div>
			    <div class="form-group">        
			      <div class="col-sm-offset-2 col-sm-10">
			        <input class="btn btn-success" type="submit" value="Guardar">
			      </div>
			    </div>			
			</form:form>
			
			<div class="modal fade" id="myModal" role="dialog">
			    <div class="modal-dialog">
			    
			      <!-- Modal content-->
			      <div class="modal-content">
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h1 class="modal-title">Error</h1>
			        </div>
			        <div class="modal-body">
			          <p>${error}</p>
			        </div>
			        <div class="modal-footer">
			          <button type="button" class="btn btn-default" data-dismiss="modal">Aceptar</button>
			        </div>
			      </div>
			      
			    </div>
		  	</div>
		  	
		</div>
	</div>
</body>
</html>