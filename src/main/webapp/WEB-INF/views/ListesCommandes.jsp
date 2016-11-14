<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="template/header.jsp"%>


<c:forEach items="${Commandes}" var="Commande">
	<div class="content-bottom-right">
		<h3>Prix Total: ${Commande.prix_total}DT</h3>

		<div class="section group">
	<c:forEach items="${Commande.livres}" var="livre" varStatus="loop">
			<c:if test="${loop.index % 4 == 0}">
		</div>
		<div class="section group">
			</c:if>
			<div class="grid_1_of_4 images_1_of_4">
				<h4>
					<a href="<c:url value='/Details/${livre.id}' />">${livre.titre}
					</a>
				</h4>
				<a href="<c:url value='/Details/${livre.id}' />"><img
					src="<c:url value="/resources/web/images/${livre.photo_Couverture}"/>"
					alt="" /></a>
				<div class="price-details">
					<div class="price-number">
						<p>
							<span class="rupees">${livre.prix}DT
								(x${livre.quantite_panie})</span>
						</p>
					</div>

				</div>
			</div>
	</c:forEach>
		</div>
	</div>

</c:forEach>