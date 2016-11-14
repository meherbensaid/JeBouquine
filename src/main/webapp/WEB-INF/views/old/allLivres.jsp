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

	<h2>List des livres</h2>
	<table>
		 
			 TITRE 
			 ISBN 
			 PRIX 

		 
		<c:forEach items="${livres}" var="livre">
			 
				<%--                <img src="data:image/jpeg;base64,${livre.imageCree}" width="300" height="200">   --%>
				 ${livre.titre} 
				 ${livre.ISBN} 
				 ${livre.prix} 


				<%--              ${livre.description}  --%>

				<a href="<c:url value='/Details/${livre.id}' />">Details</a>
					<form method="GET" action="/springmvc/Panier/AjouterPanier/${livre.id}">
						
							 <label for="qte">qte: </label> 
							 <input name="qte" id="qte" /> 

						 

<%-- 						  <a href="<c:url value='Panier/AjouterPanier/${livre.id}' />">Ajouter au panier</a>   --%>
							<a	href="<c:url value='Commentaire/ListeCommentaire/${livre.id}' />">ListerCommentaire</a>
						 <a	href="<c:url value='Commentaire/ListeCommentaire/${livre.id}' />">ListerCommentaire</a> 
						 <input type="submit" value="Ajouter au Panier" /> 
						 <a href="<c:url value='/Supprimer/${livre.id}' />">Supprimer</a> 


					</form>
		</c:forEach>
	</table>
		<a href="<c:url value='/Commande/ListerCommande' />">ListerCommande</a> 

	 
	<br />

</body>
</html>