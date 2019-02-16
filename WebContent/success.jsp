<%@page import="it.main.model.Auto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Successo</title>
</head>
<body>
<table style="border: 1px solid black;">
    <thead>
        <tr>
        	<th>Targa</th>
        	<th>Marca</th>
        	<th>Anno</th>
        	<th>Chilometri</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listaAuto}" var="current">
        <tr>
          <td> <c:out value="${current.targa}" /></td>
          <td><c:out value="${current.marca}" /></td>
          <td><c:out value="${current.anno}" /></td>
          <td><c:out value="${current.chilometri}" /></td>
        </tr>
      </c:forEach>
    </tbody>
</table>
</body>
</html>