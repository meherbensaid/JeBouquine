<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="template/header_listeLivre.jsp"%>

<!-- <h2>List des livres</h2> -->
<!-- <table> -->

<!-- 	TITRE ISBN PRIX -->


<%-- 	<c:forEach items="${livres}" var="livre"> --%>
<%-- 		<%--                <img src="data:image/jpeg;base64,${livre.imageCree}" width="300" height="200">   --%>
<%-- 				 ${livre.titre}  --%>
<%-- 				 ${livre.ISBN}  --%>
<%-- 				 ${livre.prix}  --%>
<%-- 		<a href="<c:url value='/Details/${livre.id}' />">Details</a> --%>
<%-- 		<form method="GET"	action="/springmvc/Panier/AjouterPanier/${livre.id}"> --%>

<!-- 			<label for="qte">qte: </label> <input name="qte" id="qte" />  -->
<%-- 			<a	href="<c:url value='Commentaire/ListeCommentaire/${livre.id}' />">ListerCommentaire</a> --%>
<!-- 			<input type="submit" value="Ajouter au Panier" /> <a -->
<%-- 				href="<c:url value='/Supprimer/${livre.id}' />">Supprimer</a> --%>

<!-- 		</form> -->
<%-- 	</c:forEach> --%>
<!-- </table> -->
<%-- <a href="<c:url value='/Commande/ListerCommande' />">ListerCommande</a> --%>


<!-- <br /> -->


<div class="content-bottom-right">
	<h3>Nos Livres </h3>

	<div class="section group">
		<c:forEach items="${livres}" var="livre" varStatus="loop">
			<c:if test="${loop.index % 4 == 0}">
	</div>
	<div class="section group">
			</c:if>
	<div class="grid_1_of_4 images_1_of_4">
		<h4>
			<a href="<c:url value='/Details/${livre.id}' />">${livre.titre} </a>
		</h4>
		<a href="<c:url value='/Details/${livre.id}' />"><img
			src="<c:url value="/resources/web/images/${livre.photo_Couverture}"/>" alt="" /></a>
		<div class="price-details">
			<div class="price-number">
				<p>
					<span class="rupees">${livre.prix}DT</span>
				</p>
			</div>
			<div class="add-cart">
				<h4>
					<a href="<c:url value='/Details/${livre.id}'/>">More Info</a>
				</h4>
			</div>
			<div class="clear"></div>
		</div>
	</div>
		</c:forEach>
</div>


<div class="product-articles">
	<h3>A Venir...</h3>
	<ul>
		<li>
			<div class="article">
				<p>
					<span>Site de vente de musique</span>
				</p>
				<p>Eminem - lose yourself - berzerk - rap god - we made you -forget about dre</p>
				<p>
<!-- 					<a href="#" enabled="false">+ Read Full article</a> -->
				</p>
			</div>
		</li>
		<li>
			<div class="article">
				<p>
					<span>Site de vente de comptes-rendu 2015</span>
				</p>
				<p>Frameworks - ejb - STR - (GL4)</p>
				<p>
<!-- 					<a href="#" enabled="false">+ Read Full article</a> -->
				</p>
			</div>
		</li>
	</ul>
</div>
</div>
<div class="clear"></div>


<%@include file="template/footer.jsp"%>>
