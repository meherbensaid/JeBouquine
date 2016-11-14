<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="template/header.jsp" %>

    <h2>List des livres</h2>  
    <table>
        <tr>
            <td>TITRE</td>
            <td>Qunatité</td>
           
		  </tr>
        <c:forEach items="${panier.livres}" var="livre">
            <tr>
<%--             <td>  <img src="data:image/jpeg;base64,${livre.imageCree}" width="300" height="200"> </td> --%>
            <td>${livre.titre}</td>
            <td>${livre.quantite_panie}</td>
           
            
<%--             <td>${livre.description}</td> --%>
           
          
            
<%--              <td> <a href="<c:url value='/Supprimer/${livre.id}' />">Supprimer</a> --%>
            </tr>
        </c:forEach>
         <td>prix total</td>
         <td>${panier.prix_total}</td>
    </table>
    <br/>
   <td> <a href="<c:url value='/Commande/EffectuerCommande' />">EffectuerCommande</a>  


<%@include file="template/footer.jsp" %>