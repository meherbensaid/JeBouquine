<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>University Enrollments</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>

    <h2>List des livres</h2>  
    <table>
        <tr>
            <td>TITRE</td>
            <td>ISBN</td>
            <td>PRIX</td>
            <td>Qunatité</td>
           
		  </tr>
        <c:forEach items="${livres}" var="livre">
            <tr>
<%--             <td>  <img src="data:image/jpeg;base64,${livre.imageCree}" width="300" height="200"> </td> --%>
            <td>${livre.titre}</td>
            <td>${livre.ISBN}</td>
            <td>${livre.prix}</td>
           <td>${livre.quantite_panie}</td>
           
            
<%--             <td>${livre.description}</td> --%>
           
<%--             <td> <a href="<c:url value='/Panier/supprimer/${livre.id}' />">Supprimer</a> --%>
            <td><form method="GET" action="/springmvc/Panier/supprimer/${livre.id}">
           					 <label for="qte">qte: </label> 
							 <input name="qte" id="qte" /> 
            				 <input type="submit" value="Enlever du Panier" /> 
            </form>
            </td>
<%--              <td> <a href="<c:url value='/Supprimer/${livre.id}' />">Supprimer</a> --%>
            </tr>
        </c:forEach>
         <td>prix total</td>
         <td>${prix}</td>
          <td> <a href="<c:url value='/Commande/PasserCommande' />">PasserCommnde</a>
    </table>
    
    

    <br/>

</body>
</html>