<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<title>Nuevo/Editar Categoria</title>

</head>
<body>
	<div align="center">
		<h1>Nuevo/Editar Categoria</h1>
		<form:form action="guardarCategoria" method="post" modelAttribute="categoria">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Nombre:</td>
				<td><form:input path="nombre" /></td>
			</tr>
			<tr>
				<td>Descripcion:</td>
				<td><form:input path="descripcion" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input  type="submit" value="Guardar"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>