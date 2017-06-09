<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Nuevo/Modificar Usuario</title>
</head>
<body>
	<div align="center">
		<h1>Nuevo/Modificar Usuario</h1>
		<form:form action="guardarUsuario" method="post" modelAttribute="usuario">

			
			<tr>
				<td>Nombre:</td>
				<td><form:input path="nombre" /></td>
			</tr>
			<tr>
				<td>Login:</td>
				<td><form:input path="login" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input path="pass" /></td>
			</tr>
			
			


			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save" class="btn btn-success"></td>
			</tr>
		</form:form>
	</div>
</body>
</html>