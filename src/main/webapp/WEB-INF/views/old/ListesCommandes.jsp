

<%@page import="org.apache.taglibs.standard.tag.common.xml.ForEachTag"%>
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

<c:forEach items="${Commandes}" var="Commandes">
			 
				prix totale ${Commandes.prix_total} 
				
		
		<c:forEach items="${Commandes.livres}" var="livre">
				titre ${livre.titre}
		</c:forEach>
</c:forEach>

</body>
</html>







