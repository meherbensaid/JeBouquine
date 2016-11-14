<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>University Enrollments</title>

<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>

</head>


<body>

	<h2>Details Livres</h2>
	<table>
		 <td>
			<tr> TITRE</tr> 
			 <tr>ISBN</tr> 
			<tr> PRIX </tr>
		</td>
		 
		
			 
				<%--                <img src="data:image/jpeg;base64,${livre.imageCree}" width="300" height="200">   --%>
				<td>
				<tr> ${livre.titre}</tr> 
				<tr> ${livre.ISBN} </tr>
				<tr> ${livre.prix} </tr>
			</td>

				<%--              ${livre.description}  --%>

				 


					</form>
		
	</table>
	<br />

</body>
</html>