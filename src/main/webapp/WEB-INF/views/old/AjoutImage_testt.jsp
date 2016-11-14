<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recherche Avancée</title>

<style>
.error {
	color: #ff0000;
}
</style>

</head>

<body>

	<h2>Recherche Avancée</h2>

	<form:form method="POST" modelAttribute="livre" enctype="multipart/form-data">>

		<table>

			<tr>
				<th><label for="image">Cover (JPEG format only):</label></th>
				<td><input name="image" type="file" />
			</tr>>
			
			<tr>
				<td colspan="3"><input type="submit" value="ajouter" /></td>
			</tr>
		</table>
	</form:form>
	<br />
	<br />

</body>
</html>