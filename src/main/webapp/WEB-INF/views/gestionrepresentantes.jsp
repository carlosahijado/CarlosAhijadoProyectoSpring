<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="miform"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="container">
	<h2 align="center">Operaciones Representantes</h2>
	<br>

    <c:url value="/operacionesrep" var="url"/>
 	
	<miform:form action="${url}" method="post" commandName="representante">
		<div class="form-row">
			<div class="form-group col-md-4">
				<label>Numero_Rep:</label>
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
		<label>Oficina_rep:</label>
			<miform:select path="oficina_rep">
					<miform:option value="0" label="Selecciona oficina" />
					  <miform:options items="${listaoficinas}" />
					</miform:select>
		
		
		<label>Director:</label>
			<miform:select path="director">
					<miform:option value="0" label="Selecciona el director" />
					  <miform:options items="${listarep}" />
					</miform:select>
		
		<label>Num_Ventas:</label>
			<miform:input path="num_ventas" type="number" size="10" />
		
		<label>Importe_Ventas:</label>
			<miform:input path="imp_ventas" type="number" size="10" />
		
		
		<input type="reset" value="Cancelar entrada." />
		<miform:button name="insertar">Insertar</miform:button>
        <miform:button name="modificar">Modificar</miform:button>
		<miform:button name="borrar">Borrar</miform:button>
		<miform:button name="listar">Listar representantes</miform:button>
		<miform:button name="volver">Volver al index</miform:button>
	</miform:form>
	<h2>${mensaje}</h2>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>