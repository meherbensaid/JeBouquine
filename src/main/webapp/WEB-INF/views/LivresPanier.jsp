<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="template/header.jsp" %>

<div class="content-bottom-right">
	<h3>Prix Total: ${prix}DT</h3>

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
					<span class="rupees">${livre.prix}DT (x${livre.quantite_panie})</span>
				</p>
			</div>
			
			
<!-- 			<div class="add-cart"> -->
<!-- 				<h4> -->
<%-- 					<a href="<c:url value='/Details/${livre.id}'/>">More Info</a> --%>
<!-- 				</h4> -->
<!-- 			</div> -->
<!-- 			<div class="clear"></div> -->
			
			
				<form method="GET" action="/springmvc/Panier/supprimer/${livre.id}">		
					<div class="share">
						<p>Quantité :</p><input name="qte" id="qte" type="number" class="text_box" type="text" value="1" min="1" />				
					</div>
						 <input type="submit" value="Retirer du Panier"  class="button"/> 		
					<div class="clear"></div>
				</form>
			
			
		</div>
	</div>
		</c:forEach>
</div>

<!--  Passer Commmmmmmmmmmmmmmmde -->
<div class="product-articles">
	<h3>
<a href="<c:url value='/Commande/EffectuerCommande'/>">Passer la commande</a></h3>
<div class="clear"></div>
