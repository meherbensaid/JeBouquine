<%@page import="org.apache.taglibs.standard.tag.common.xml.ForEachTag"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.websystique.springmvc.model.*"%> 
<%@ page import="java.util.*"%> 

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
            
		  </tr>
       
            <tr>
<%--             <td>  <img src="data:image/jpeg;base64,${livre.imageCree}" width="300" height="200"> </td> --%>
            <td>${livre.titre}</td>
            <td>${livre.ISBN}</td>
            <td>${livre.prix}</td>
           
            
<%--             <td>${livre.description}</td> --%>
           
           
            </tr>
       
        <c:forEach items="${livre.commentaires}" var="c">
         ${ c.text}
<%--         utilisateur <c:out value="${utilisateur.nom}"/> --%>
<%--         ${c.utilisateur.ID } --%>
        
        <c:if test="${utilisateur.ID == c.utilisateur.ID}">
        <a href="<c:url value="/Commentaire/Supprimer/${c.id}"/>">Supprimer_commentaire</a>
        </c:if>
<%--           <% --%>
<!--       	Utilisateur U=(Utilisateur)session.getAttribute("utilisateur"); -->
<!--          	List<Commentaire> C=(List<Commentaire>)session.getAttribute("Commentaire"); -->
<%--         	%><%=C.size()%> --%>
<%--         	<% %> --%>
        
        </c:forEach>
       
        
       <form method="GET"  action="/springmvc/Commentaire/AjoutCommentaire/${livre.id}">
			<tr>
				<td><label for="Text">Text: </label></td>
				<td><input name="text" id="text" /></td>

			</tr>
			
			
			
			
			
			<input type="submit" value="Ajouter commentaire" /> 
            </form>
        
        
    </table>
    <br/>

</body>
</html>