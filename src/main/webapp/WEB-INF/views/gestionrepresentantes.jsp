<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="miform"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestión Representantes</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="container">
	<h2 class="text-center">Operaciones Representantes</h2>
	<br>

    <c:url value="/operacionesrep" var="url"/>
 	
	<miform:form action="${url}" method="post" commandName="representante">
		<div class="form-row">
			<div class="form-group col-md-4">
				<label>Numero Representante:</label>
				<miform:input path="numero_rep" type="number" size="5" class="form-control" />
			</div>
			<div class="form-group col-md-4">
				<label>Nombre:</label>
				<miform:input path="nombre" type="text" size="20" class="form-control" />
			</div>
			<div class="form-group col-md-4">
				<label>Edad:</label>
				<miform:input path="edad" type="number" size="5" class="form-control" />
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<label>Oficina del Representante:</label>
					<miform:select path="oficina_rep" class="form-control">
							<miform:option value="0" label="Selecciona oficina" />
							  <miform:options items="${listaoficinas}" />
							</miform:select>
		
			</div>
			<div class="form-group col-md-6">
				<label>Director del Representante:</label>
					<miform:select path="director" class="form-control">
							<miform:option value="0" label="Selecciona el director" />
							  <miform:options items="${listarep}" />
							</miform:select>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
			<label>Numero de Ventas:</label>
				<miform:input path="num_ventas" type="number" size="10"  class="form-control"/>
			</div>
			<div class="form-group col-md-6">
			<label>Importe de Ventas:</label>
				<miform:input path="imp_ventas" type="number" size="10"  class="form-control"/>
			</div>
		</div>
		<div class="row">
			<input type="reset" value="Cancelar entrada." class="col-md-2 offset-md-3 mr-2 btn btn-outline-info"/>
			<miform:button name="insertar" class="col-md-2 btn btn-outline-info mr-2">Insertar</miform:button>
	        <miform:button name="modificar" class="col-md-2 btn btn-outline-info">Modificar</miform:button>
		</div>
		<div class="row mt-3">
			<miform:button name="borrar" class="col-md-2 btn offset-md-3 btn-outline-info mr-2">Borrar</miform:button>
			<miform:button name="listar" class="col-md-2 btn btn-outline-info mr-2">Listar representantes</miform:button>
			<miform:button name="volver" class="col-md-2 btn btn-outline-info">Volver al index</miform:button>
		</div>
	</miform:form>
	<h2 class="text-center">${mensaje}</h2>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>