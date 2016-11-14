<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>

<head>
<title>jeBouquine | a la folie</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.googleapis.com/css?family=Ubuntu+Condensed'
	rel='stylesheet' type='text/css'>
<link href="<c:url value="/resources/web/css/style.css"/>"
	rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript"
	src="<c:url value="/resources/web/js/jquery-1.9.0.min.js"/>"></script>
<script src="<c:url value="/resources/web/js/jquery.openCarousel.js"/>"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<c:url value="/resources/web/js/move-top.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/web/js/easing.js"/>"></script>
</head>
<body>
	<div class="header">
		<div class="wrap">
			<div class="header_top">
				<div class="logo">
					<a href="index.html"><img src="<c:url value="/resources/web/images/ddd.png"/>" alt="" style=" width: 250;"/></a>
				</div>
				<div class="header_top_right">
					<div class="search_box">
						<span>Search</span>
						<form>
							<input type="text" value=""><input type="submit" value="">
						</form>
						<div class="clear"></div>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="navigation">
				<a class="toggleMenu" href="#">Menu</a>
				<ul class="nav">
				<li><a href="<c:url value="/"/>">Home</a></li>				
        <c:if test="${uexiste==1}">   		
				<li><a href="<c:url value="/Panier/AfficherPanier"/>">Mon Panier</a></li>
				<li><a href="<c:url value="/Commande/ListerCommande"/>">Mes Commandes</a></li>
<%-- 				<li><a href="<c:url value="/Utilisateur/Deconnexion"/>">Se	déconnecter</a></li> --%>
        </c:if>		
        <c:if test="${uexiste==0}">   	
				<li><a href="<c:url value="/Utilisateur/AjouterUtilisateur"/>">S'inscrire</a></li>
				<li><a href="<c:url value="/Utilisateur/Authentification"/>">Se	connecter</a></li>
        </c:if>		
				<li><a href="<c:url value="/AjoutLivre"/>">Ajouter un Livre</a></li>
				</ul>
				<span class="left-ribbon"> </span> <span class="right-ribbon">
				</span>
			</div>
		</div>
	</div>