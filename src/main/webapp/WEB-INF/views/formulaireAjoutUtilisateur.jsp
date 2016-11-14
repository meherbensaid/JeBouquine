<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="template/header.jsp" %>

 <h1>valeur de session ${thought.login}</h1>
    <h2>Inscription</h2>
  
    <form:form method="POST" modelAttribute="utilisateur">
      
        <table>
            <tr>
                <td><label for="nom">nom: </label> </td>
                <td><form:input path="Nom" id="Nom"/></td>
              
            </tr>
         <tr>
                <td><label for="Prenom">Prenom: </label> </td>
                <td><form:input path="prenom" id="prenom"/></td>
              
            </tr>
            <tr>
                <td><label for="Login">Login: </label> </td>
                <td><form:input path="login" id="login"/></td>
              
            </tr><tr>
                <td><label for="Mot_De_Passe">Mot_De_Passe: </label> </td>
                <td><form:input path="mot_De_Passe" id="mot_De_Passe"/></td>
              
            </tr><tr>
                <td><label for="Adresse">Adresse: </label> </td>
                <td><form:input path="adresse" id="adresse"/></td>
              
            </tr><tr>
                <td><label for="Email">Email: </label> </td>
                <td><form:input path="email" id="Email"/></td>
              
            </tr><tr>
                <td><label for="Sexe">Sexe: </label> </td>
                <td><form:input path="Sexe" id="Sexe"/></td>
              
            </tr>
            
            
            
            
         
            <tr>
                <td colspan="3">  
                            <input type="submit" value="S'inscrire" />
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
   

<%@include file="template/footer.jsp" %>