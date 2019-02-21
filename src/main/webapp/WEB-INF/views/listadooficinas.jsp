<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Oficinas</title>
</head>
<body>
	<h2 align="center">Listado de Oficinas</h2>
	<br>
	<form:form action="volver">

		<table border=1>
			<tr>
				<th>OFICINA</th><th>CIUDAD</th><th>NOMBRE REGIÓN</th><th>NUM. REPRESENTANTES</th><th>NOMBRE DIRECTOR</th>
			</tr>
			<c:forEach items="${listaoficinas}" var="obj">
				<tr><td><c:out value="${obj.getOficina()}" /></td>
					<td><c:out value="${obj.getCiudad()}" /></td>
					<td><c:out value="${obj.getNombre_region()}" /></td>
					<td><c:out value="${obj.getNum_representantes()}" /></td>
					<td><c:out value="${obj.getNombre_director()}" /></td>
				</tr>
			</c:forEach>
		</table>

		<input type="submit" value="Volver" />
	</form:form>
</body>
</html>