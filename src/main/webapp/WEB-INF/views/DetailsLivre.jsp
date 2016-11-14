<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="template/header.jsp" %>

   	 	       <div class="section group">
				<div class="cont-desc span_1_of_2">
					<ul class="back-links">
						<li><a href="#">Détails</a></li>
						<div class="clear"> </div>
					</ul>
				  <div class="product-details">	
					<div class="grid images_3_of_2">
							<ul id="etalage">
							<li>
								<a href="optionallink.html">
									<img class="etalage_thumb_image" src="<c:url value="/resources/web/images/${livre.photo_Couverture}"/>" />
									<img class="etalage_source_image" src="<c:url value="/resources/web/images/${livre.photo_Couverture}"/>" title="" />
								</a>
							</li>
							<li>
								<img class="etalage_thumb_image" src="<c:url value="/resources/web/images/${livre.photo_Couverture}"/>" />
								<img class="etalage_source_image" src="<c:url value="/resources/web/images/${livre.photo_Couverture}"/>" title="" />
							</li>
							<li>
								<img class="etalage_thumb_image" src="http://localhost:8080/springmvc/resources/web/images/${livre.photo_Couverture}"/>
								<img class="etalage_source_image" src="http://localhost:8080/springmvc/resources/web/images/${livre.photo_Couverture}" />
							</li>
							<li>
						</ul>
				     </div>
				   <div class="desc span_3_of_2">
					<h2>${livre.titre} </h2>
					<p>${livre.description}</p>					
					<div class="price">
						<p>Price: <span>${livre.prix}DT</span></p>
					</div>
					<div class="available">
						<ul>
						  <li><span>Edition:</span> &nbsp; ${livre.edition_maison}</li>
						  <li><span>Langue:</span>&nbsp; ${livre.langue}</li>
						  <li><span>Stock:</span>&nbsp; ${livre.stock_Quantite}</li>
					    </ul>
					</div>
				<div class="share-desc">
				
				<form method="GET" action="/springmvc/Panier/AjouterPanier/${livre.id}">				
					<div class="share">
						<p>Quantité :</p><input name="qte" id="qte" type="number" class="text_box" type="text" value="1" min="1" />				
					</div>
						 <input type="submit" value="Ajouter au Panier"  class="button"/> 		
					<div class="clear"></div>
				</form>

				</div>
<!-- 				 <div class="wish-list"> -->
<!-- 				 	<ul> -->
<!-- 				 		<li class="wish"><a href="#">Add to Wishlist</a></li> -->
<!-- 				 	    <li class="compare"><a href="#">Add to Compare</a></li> -->
<!-- 				 	</ul> -->
<!-- 				 </div> -->
				 <div class="colors-share">
				 	<div class="color-types">
				 		<h4>Available Colors</h4>
				 		<form class="checkbox-buttons">
							<ul>
								<li><input id="r1" name="r1" type="radio"><label for="r1" class="grey"> </label></li>
								<li><input id="r2" name="r1" type="radio"><label for="r2" class="blue"> </label></li>
								<li><input id="r3" name="r1" type="radio"><label class="white" for="r3"> </label></li>
								<li><input id="r4" name="r1" type="radio"><label class="black" for="r4"> </label></li>
							</ul>
						 </form>
				 	</div>
				 	<div class="social-share">
				 		<h4>Share Product</h4>
				 			  <ul>
									<li><a class="share-face" href="#"> </a></li>
									<li><a class="share-twitter" href="#"> </a></li>
									<li><a class="share-google" href="#"> </a></li>
									<li><a class="share-rss" href="#"> </a></li>
									<div class="clear"> </div>
						    </ul>
				 	</div>
				 	<div class="clear"></div>
				 </div>
			</div>
			<div class="clear"></div>
		  </div>
		<div class="product_desc">	
			<div id="horizontalTab">
				<ul class="resp-tabs-list">
					<li>Specifications</li>
					<li>Commentaires</li>
					<li>..Votre Avis</li>
					<div class="clear"></div>
				</ul>
				
				<!-- 				SPECSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS  -->
				<div class="resp-tabs-container">
					<div class="product-specifications">
						<ul>
		                  <li><span class="specification-heading">ISBN</span> <span>${livre.ISBN}</span><div class="clear"></div></li>
		                  <li><span class="specification-heading">Auteurs</span> <span>${livre.auteurs_bloc}</span><div class="clear"></div></li>
		                  <li><span class="specification-heading">Categorie</span> <span>${livre.categories_bloc}</span><div class="clear"></div></li>
		                  <li><span class="specification-heading">Langue</span> <span>${livre.langue}</span><div class="clear"></div></li>
		                  <li><span class="specification-heading">Langue d'origine</span> <span>${livre.langue_Origine}</span><div class="clear"></div></li>
		                  <li><span class="specification-heading">Maison d'édition</span> <span>${livre.edition_maison}</span><div class="clear"></div></li>
		                  <li><span class="specification-heading">Date de publication</span> <span>${livre.date_Publication}</span><div class="clear"></div></li>
		                </ul>
				 	</div>
				<!-- 				 commmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmms -->
			   <div class="product-tags">
					<h4>Commentaires:</h4>
					
					
<!-- 					-------------------#########-------------------- -->

        <c:forEach items="${livre.commentaires}" var="c">
         <p>${ c.text}</p>
        
        <c:if test="${utilisateur.ID!=null && utilisateur.ID == c.utilisateur.ID}">        
			<div class="button"><span><a href="<c:url value="/Commentaire/Supprimer/${c.id}"/>">Supprimer votre commentaire </a></span></div>
        </c:if>
        <br/>
        
        </c:forEach>
       
        

<!-- ----------------************--------------- -->
					
					
<!-- 					<div class="input-box"> -->
<!-- 						<input type="text" value=""> -->
<!-- 					</div> -->
<!-- 					<div class="button"><span><a href="#">Add Tags</a></span></div> -->
		    	</div>	

     
				<!-- REVIEEEEEEEEEEEEEEEWwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwWWW -->
        <c:if test="${uexiste==1}">   
				<div class="review">
				  	 <h4>Qu'en pensez-vous ?</h4>
				  	  <form method="GET"  action="/springmvc/Commentaire/AjoutCommentaire/${livre.id}">
					    	<div>
						    	<span><label>Text<span class="red">*</span></label></span>
						    	<span><input name="text"  id="text" ></span>
						    </div>
						   <div>
						   		<span><input type="submit" value="AJOUTER"></span>
						  </div>
					    </form>
					    
				  	 </div>			
  		</c:if>		
        <c:if test="${utilisateur==null}">   
        			<div class="button"><span><a href="<c:url value="/Utilisateur/Authentification"/>">S'authentifier </a></span></div>        
  		</c:if>		
				  	  <script type="text/javascript">
										 /* place inside document ready function */
										 $(".rating").starRating({
										  minus: true // step minus button
										});
									</script>	
				</div>
			  </div>
		    </div>
	    </div>
      </div>
				   





<!-- 		Other non-template scripts -->
<script src="<c:url value="/resources/web/js/easyResponsiveTabs.js"/>" type="text/javascript"></script>
<link href="<c:url value="/resources/web/css/easy-responsive-tabs.css"/>" rel="stylesheet" type="text/css" media="all"/>
 <script type="text/javascript">
    $(document).ready(function () {
        $('#horizontalTab').easyResponsiveTabs({
            type: 'default', //Types: default, vertical, accordion           
            width: 'auto', //auto or any width like 600px
            fit: true   // 100% fit in a container
        });
    });
   </script>		
<link rel="stylesheet" href="<c:url value="/resources/web/css/etalage.css"/>">
<script src="<c:url value="/resources/web/js/jquery.etalage.min.js"/>"></script>
<script>
			jQuery(document).ready(function($){

				$('#etalage').etalage({
					thumb_image_width: 300,
					thumb_image_height: 400,
					source_image_width: 900,
					source_image_height: 1200,
					show_hint: true,
					click_callback: function(image_anchor, instance_id){
						alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
					}
				});

			});
		</script>
	  <script src="<c:url value="/resources/web/js/star-rating.js"/>" type="text/javascript"></script>
	  
<%@include file="template/footer.jsp" %>