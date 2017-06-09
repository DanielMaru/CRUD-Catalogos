<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Producto</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Producto</h1>
		<form:form action="saveProducto" method="post" modelAttribute="productobanco">
		<form:hidden path="id"/>
			
				Nombre_Producto:
				<form:input path="nom_productos" />
			
				Tipo_Producto:
				<form:input path="tipo" />
			
				Estado_Producto:
				<form:input path="estdo" />
			
				<td colspan="2" align="center"><input  class="btn btn-primary" type="submit" value="save"></td>
			
		</form:form>
	</div>
</body>
</html>