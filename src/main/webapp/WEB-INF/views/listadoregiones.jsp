<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Regiones</title>
</head>
<body>
	<h2 align="center">Listado de Regiones</h2>
	<br>
	<form:form action="volver">

		<table border=1>
			<tr>
				<th>CODIGO</th><th>NOMBRE</th><th>NUMERO OFICINAS</th><th>TOTAL VENTAS</th>
			</tr>
			<c:forEach items="${listaregiones}" var="obj">
				<tr><td><c:out value="${obj.getCod_region()}" /></td>
					<td><c:out value="${obj.getNombre()}" /></td>
					<td><c:out value="${obj.getNumero_oficinas()}" /></td>
					<td><c:out value="${obj.getTotal_ventas()}" /></td>
				</tr>
			</c:forEach>
		</table>

		<input type="submit" value="Volver" />
	</form:form>
</body>
</html>