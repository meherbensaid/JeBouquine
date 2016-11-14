<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="template/header.jsp" %>

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

<%@include file="template/footer.jsp" %>