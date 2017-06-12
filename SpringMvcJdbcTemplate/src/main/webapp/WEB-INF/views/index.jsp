<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <div class="jumbotron text-center">
		  <h1>WELCOME</h1>
		  <p>Proyecto 1 - Spring !</p> 
		</div>
        
        <div class="row">
	    	<div class="col-md-6 col-md-offset-3">
			   <a href="perfil" class="btn btn-primary btn-lg btn-block" role="button">Perfiles </a>
			</div>
			<div class="col-md-6 col-md-offset-3">
			   <a href="categorias" class="btn btn-info btn-lg btn-block" role="button">Categorias </a>
			</div>
			<div class="col-md-6 col-md-offset-3">
			   <a href="usuarios" class="btn btn-primary btn-lg btn-block" role="button">Usuarios </a>
			</div>
			<div class="col-md-6 col-md-offset-3">
			   <a href="departamento" class="btn btn-info btn-lg btn-block" role="button">Departamentos </a>
			</div>
			<div class="col-md-6 col-md-offset-3">
			   <a href="perfil" class="btn btn-primary btn-lg btn-block" role="button">Ciudades </a>
			</div>
			<div class="col-md-6 col-md-offset-3">
			   <a href="perfil" class="btn btn-info btn-lg btn-block" role="button">Productos </a>
			</div>
        </div>

    </body>
</html>
