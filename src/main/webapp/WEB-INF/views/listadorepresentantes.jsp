<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Representantes</title>
</head>
<body>
	<h2 align="center">Listado de Representantes</h2>
	<br>
	<form:form action="volver">

		<table border=1>
			<tr>
				<th>NUMERO_REP</th><th>NOMBRE</th><th>EDAD</th><th>OFICINA_REP</th><th>DIRECTOR</th><th>NUM_VENTAS</th><th>IMP_VENTAS</th>
			</tr>
			<c:forEach items="${listarep}" var="obj">
				<tr><td><c:out value="${obj.getNumero_rep()}" /></td>
					<td><c:out value="${obj.getNombre()}" /></td>
					<td><c:out value="${obj.getEdad()}" /></td>
					<td><c:out value="${obj.getOficina_rep()}" /></td>
				</tr>
			</c:forEach>
		</table>

		<input type="submit" value="Volver" />
	</form:form>
</body>
</html>