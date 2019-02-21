<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Representantes</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body class="container bg-light">
	<h2 align="center">Listado de Representantes</h2>
	<br>
	<form:form action="volver">

		<table class="table table-striped table-info">
			<tr>
				<th>NUMERO_REP</th><th>NOMBRE</th><th>EDAD</th><th>OFICINA_REP</th><th>DIRECTOR</th><th>NUM_VENTAS</th><th>IMP_VENTAS</th>
			</tr>
			<c:forEach items="${listarep}" var="obj">
				<tr><td><c:out value="${obj.getNumero_rep()}" /></td>
					<td><c:out value="${obj.getNombre()}" /></td>
					<td><c:out value="${obj.getEdad()}" /></td>
					<td><c:out value="${obj.getOficina_rep()}" /></td>
					<td><c:out value="${obj.getDirector()}" /></td>
					<td><c:out value="${obj.getNum_ventas()}" /></td>
					<td><c:out value="${obj.getImp_ventas()}" /></td>
				</tr>
			</c:forEach>
		</table>

		<input type="submit" value="Volver" class="btn btn-outline-info"/>
	</form:form>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>