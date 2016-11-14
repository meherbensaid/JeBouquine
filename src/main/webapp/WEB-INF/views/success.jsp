<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="template/header.jsp" %>

   <h2>List des livres</h2>  
    <table>
        <tr>
            <td>TITRE</td><td>AUTEUR</td><td>PRIX</td><td>DESCRIPTION</td><td></td>
        </tr>
        <c:forEach items="${liste}" var="livre">
            <tr>
            <td>${livre.titre}</td>
            <td>
           
            </td>
            
            <td>${livre.prix}</td>
         
         <!--     <td><a href="<c:url value='/edit-${employee.ssn}-employee' />">${employee.ssn}</a></td>
            <td><a href="<c:url value='/delete-${employee.ssn}-employee' />">delete</a></td>-->
            </tr>
        </c:forEach>
    </table>
    <br/>
<a href="<c:url value='/Authentification' />">authentification</a>

<%@include file="template/footer.jsp" %>html>