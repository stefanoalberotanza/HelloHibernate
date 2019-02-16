<%@page import="it.main.model.Auto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendite</title>
</head>
<body>
	<table style="border: 1px solid black;">
		<thead>
			<tr>
				<th>Targa</th>
				<th>Data</th>
				<th>Prezzo</th>
				<th>Compratore</th>
				<th>-</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listVendite}" var="current">
				<tr>
					<td><c:out value="${current.getAuto().getTarga()}" /></td>
					<td><c:out
							value="${current.getData().toString().substring(0, 10)}" /></td>
					<td><c:out value="${current.getPrezzo()}" /></td>
					<td><c:out value="${current.getCompratore().getCognome()}" /></td>
					<td><form action='deleteVend' method='post'>
							<input type='hidden' name='id' value="${current.getId()}"><input
								type="submit" value="Elimina vendita">
						</form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>