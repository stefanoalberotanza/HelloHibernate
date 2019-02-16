<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Auto</title>
</head>
<body>
<form action="newAuto" method="post">
		<p>
			<label>INSERIRE DATI AUTO<br /> <br /></label>
		</p>

		<label>TARGA<br></label><input type="text" name="targa" /><br />
		<label>MARCA<br></label><input type="text" name="marca" /><br />
		<label>DATA<br></label><input type="number" name="anno" /><br />
		<label>CHILOMETRI<br></label><input type="number" name="chilometri" /><br />
		<input type="submit" value="Aggiungi auto">
	</form>
</body>
</html>