<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center mt-4 mb-4">
	Proyecto Spring Carlos Ahijado  
</h1>
<p class="text-center">Proyecto de Spring de 2º de DAW para gestionar representantes con sus oficinas</p>
<div class="row justify-content-center">
	<div class="col-md-3">
		<a href="listarregiones"><button class="btn btn-outline-info">Listar las regiones</button></a>
	</div>
	<div class="col-md-3">
		<a href="listaroficinas"><button class="btn btn-outline-info">Listar las oficinas</button></a>
	</div>
	<div class="col-md-3">
		<a href="gestionrep"><button class="btn btn-outline-info">Gestionar Representantes</button></a>
	</div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
