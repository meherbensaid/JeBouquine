<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
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
  
    <form:form method="POST" modelAttribute="livre">
      
        <table>
            <tr>
                <td><label for="titre">Titre: </label> </td>
                <td><form:input path="titre" id="titre"/></td>
              
            </tr>
         
            <tr>
                <td><label for="auteurs">Auteurs: </label> </td>
                
					<td>	<select>
						<c:forEach items="${Auteurs}" var="Auteurs">
							<option>${Auteurs.nom}</option>
							</c:forEach>
						</select>
					</td>
            </tr>
     
           
     
            <tr>
                <td><label for="categorie">ISBN: </label> </td>
                <td><form:input path="ISBN" id="ISBN"/></td>
            
            </tr>
            
            <tr>
                <td><label for="Catergories">Categories: </label> </td>
                
                <td>
						<select>
						<c:forEach items="${Categories}" var="Categories">
							<option>${Categories.nom}</option>
							</c:forEach>
						</select>
					</td>
            </tr>
            
            
            
            
         
            <tr>
                <td colspan="3">  
                            <input type="submit" value="Rechercher" />
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/list' />">List of All Employees</a>
</body>
</html>