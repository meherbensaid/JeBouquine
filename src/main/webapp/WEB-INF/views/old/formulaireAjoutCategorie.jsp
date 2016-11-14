<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Inscription</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Ajout Categorie</h2>
  
    <form:form method="POST" modelAttribute="categorie">
      
        <table>
            <tr>
                <td><label for="nom">nom: </label> </td>
                <td><form:input path="nom" id="Nom"/></td>
              
            </tr>
<!--          <tr> -->
<!--                 <td><label for="Prenom">Prenom: </label> </td> -->
<%--                 <td><form:input path="prenom" id="prenom"/></td> --%>
              
<!--             </tr> -->
<!--             <tr> -->
<!--                 <td><label for="Login">Login: </label> </td> -->
<%--                 <td><form:input path="login" id="login"/></td> --%>
              
<!--             </tr><tr> -->
<!--                 <td><label for="Mot_De_Passe">Mot_De_Passe: </label> </td> -->
<%--                 <td><form:input path="mot_De_Passe" id="mot_De_Passe"/></td> --%>
              
<!--             </tr><tr> -->
<!--                 <td><label for="Adresse">Adresse: </label> </td> -->
<%--                 <td><form:input path="adresse" id="adresse"/></td> --%>
              
<!--             </tr><tr> -->
<!--                 <td><label for="Email">Email: </label> </td> -->
<%--                 <td><form:input path="email" id="Email"/></td> --%>
              
<!--             </tr><tr> -->
<!--                 <td><label for="Sexe">Sexe: </label> </td> -->
<%--                 <td><form:input path="Sexe" id="Sexe"/></td> --%>
              
<!--             </tr> -->
            
            
            
            
         
            <tr>
                <td colspan="3">  
                            <input type="submit" value="Ajouter Categorie" />
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
   
</body>
</html>