<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authentification</title>
</head>
<body>

Authentification : 
<form:form method="POST" modelAttribute="utilisateur">
      
        <table>
         
            <tr>
                <td><label for="Login">Login: </label> </td>
                <td><form:input path="login" id="Login"/></td>
              
            </tr>
            <tr>
                <td><label for="Mot_De_Passe">Mot_De_Passe: </label> </td>
                <td><form:input path="mot_De_Passe" id="mot_De_Passe"/></td>
              
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
</body>
</html>