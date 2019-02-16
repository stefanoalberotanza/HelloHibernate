<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compratori</title>
</head>
<body>
<table style="border: 1px solid black;">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Data di nascita</th>
				<th>-</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listCompr}" var="current">
				<tr>
					<td><c:out value="${current.getNome()}" /></td>
					<td><c:out value="${current.getCognome()}" /></td>
					<td><c:out value="${current.getData().toString().substring(0, 10)}" /></td>
					<td><form action='doCompratore' method='post'>
							<input type='hidden' name='id' value="${current.getId()}"><input
								type="submit" value="Elimina compratore">
						</form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action='getVendite' method='get'>
	<input type="submit" value="Vendite">
	</form>
</body>
</html>