<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Ajouter  livre</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Ajouter Livre</h2>
  
    <form:form method="POST" modelAttribute="livre">
      
        <table>
              <tr>
                <td><label for="titre">Titre: </label> </td>
                <td><form:input path="Titre" id="titre"/></td>
              
            </tr>
            
              
            <td><label for="Description">Description: </label> </td>
                <td><input name="Description" id="Description"/></td>
            <tr>            
            
            
            <td><label for="Auteur">Auteur: </label> </td>
                <td><input name="Auteur" id="Auteur"/></td>
            <tr>
            
              
            <td><label for="Categorie">Categorie: </label> </td>
                <td><input name="Categorie" id="Categorie"/></td>
            <tr>            
            
            
              <tr>
                <td><label for="Stock_Quantite">Stock_Quantite: </label> </td>
                <td><form:input path="Stock_Quantite" id="Stock_Quantite"/></td>
              
            </tr>
            
              <tr>
                <td><label for="Langue">Langue: </label> </td>
                <td><form:input path="Langue" id="Langue"/></td>
              
            </tr>
            
              <tr>
                <td><label for="Langue_Origine">Langue_Origine: </label> </td>
                <td><form:input path="Langue_Origine" id="Langue_Origine"/></td>
              
            </tr>
            
              <tr>
                <td><label for="Edition_maison">Edition_maison: </label> </td>
                <td><form:input path="Edition_maison" id="Edition_maison"/></td>
              
            </tr>
             
            
            
            
             <td><label for="Date_Publication">Date_Publication: </label> </td>
                <td><form:input path="Date_Publication" id="Date_Publication"/></td>
            <tr>
            
            
              <tr>
                <td><label for="titre">ISBN: </label> </td>
                <td><form:input path="ISBN" id="ISBN"/></td>
              
            </tr>
            
            <tr>
                <td><label for="Prix">Prix: </label> </td>
                <td><form:input path="Prix" id="Prix"/></td>
              
            </tr>
            
            
            azdazd
         
            <tr>
                <td colspan="3">  
                            <input type="submit" value="ajouter" />
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
   
</body>
</html>