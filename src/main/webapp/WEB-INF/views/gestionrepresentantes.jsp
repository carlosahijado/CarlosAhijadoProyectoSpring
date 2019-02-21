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
</head>
<body>
	<h2 align="center">Operaciones Representantes</h2>
	<br>

    <c:url value="/operacionesrep" var="url"/>
 	
	<miform:form action="${url}" method="post" commandName="representante">
		<p>
			Numero_Rep:
			<miform:input path="numero_rep" type="number" size="5" />
			<miform:button name="consultar">Consultar</miform:button>
		</p>
		<p>
			Nombre:
			<miform:input path="nombre" type="text" size="20" />
		</p>
		<p>
			Edad:
			<miform:input path="edad" type="number" size="5" />
		</p>
		
		<p>
			Oficina_rep:
			<miform:select path="oficina_rep">
					<miform:option value="0" label="Selecciona oficina" />
					  <miform:options items="${listaoficinas}" />
					</miform:select>
		</p>
		
		<p>
			Director:
			<miform:select path="director">
					<miform:option value="0" label="Selecciona el director" />
					  <miform:options items="${listarep}" />
					</miform:select>
		</p>
		<p>
			Num_Ventas:
			<miform:input path="num_ventas" type="number" size="10" />
		</p>
		<p>
			Importe_Ventas:
			<miform:input path="imp_ventas" type="number" size="10" />
		</p>
		
		<input type="reset" value="Cancelar entrada." />
		<miform:button name="insertar">Insertar</miform:button>
        <miform:button name="modificar">Modificar</miform:button>
		<miform:button name="borrar">Borrar</miform:button>
		<miform:button name="listar">Listar representantes</miform:button>
		<miform:button name="volver">Volver al index</miform:button>
	</miform:form>
	<h2>${mensaje}</h2>
</body>
</html>