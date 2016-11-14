<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>$

<%@include file="header_top.jsp" %>

   <!------------End Header ------------>
  <div class="main">
      <div class="content">
      
<!--       #########    to be AJAXed   ############## -->
<!--     	        <div class="content_top"> -->
<!--     	        	<div class="wrap"> -->
<!-- 		          	   <h3>Latest Products</h3> -->
<!-- 		          	</div> -->
<!-- 		          	<div class="line"> </div> -->
<!-- 		          	<div class="wrap"> -->
<!-- 		          	 <div class="ocarousel_slider">   -->
<!-- 	      				<div class="ocarousel example_photos" data-ocarousel-perscroll="3"> -->
<!-- 			                <div class="ocarousel_window"> -->
<!-- 			                   <a href="#" title="img1"> <img src="web/images/latest-product-img1.jpg" alt="" /><p>Nuncvitae</p></a> -->
<!-- 			                   <a href="#" title="img2"> <img src="web/images/latest-product-img2.jpg" alt="" /><p>Suspendiss</p></a> -->
<!-- 			                   <a href="#" title="img3"> <img src="web/images/latest-product-img3.jpg" alt="" /><p>Phasellus ferm</p></a> -->
<!-- 			                   <a href="#" title="img4"> <img src="web/images/latest-product-img4.jpg" alt="" /><p>Veldignissim</p></a> -->
<!-- 			                   <a href="#" title="img5"> <img src="web/images/latest-product-img5.jpg" alt="" /><p>Aliquam interd</p></a> -->
<!-- 			                   <a href="#" title="img6"> <img src="web/images/latest-product-img6.jpg" alt="" /><p>Sapien lectus</p></a> -->
<!-- 			                   <a href="#" title="img1"> <img src="web/images/latest-product-img1.jpg" alt="" /><p>Nuncvitae</p></a> -->
<!-- 			                   <a href="#" title="img2"> <img src="web/images/latest-product-img2.jpg" alt="" /><p>Suspendiss</p></a> -->
<!-- 			                   <a href="#" title="img3"> <img src="web/images/latest-product-img3.jpg" alt="" /><p>Phasellus ferm</p></a> -->
<!-- 			                   <a href="#" title="img4"> <img src="web/images/latest-product-img4.jpg" alt="" /><p>Veldignissim</p></a> -->
<!-- 			                   <a href="#" title="img5"> <img src="web/images/latest-product-img5.jpg" alt="" /><p>Aliquam interd</p></a> -->
<!-- 			                   <a href="#" title="img6"> <img src="web/images/latest-product-img6.jpg" alt="" /><p>Sapien lectus</p></a> -->
<!-- 			                </div> -->
<!-- 			               <span>            -->
<!-- 			                <a href="#" data-ocarousel-link="left" style="float: left;" class="prev"> </a> -->
<!-- 			                <a href="#" data-ocarousel-link="right" style="float: right;" class="next"> </a> -->
<!-- 			               </span> -->
<!-- 					   </div> -->
<!-- 				     </div>   -->
<!-- 				   </div>    		 -->
<!--     	       </div> -->
    	       
<!--       #########   / to be AJAXed   ############## -->
    	       
    	  <div class="content_bottom">
    	    <div class="wrap">
    	    	<div class="content-bottom-left">
    	    		<div class="categories">
						   <ul>
						  	   <h3>Categories</h3>
						  	   <c:forEach items="${cats}" var="cat">
							      <li><a href="<c:url value="/RLPC/${cat.nom}"/>">${cat.nom}</a></li>
						  	   </c:forEach>
					  	 	</ul>
						   <ul>
						  	   <h3>Auteurs</h3>
						  	   <c:forEach items="${auths}" var="cat">
							      <li><a href="<c:url value="/RLPA/${cat.nom}"/>">${cat.nom}</a></li>
						  	   </c:forEach>
					  	 	</ul>
						</div>		
						<div class="buters-guide">
						<h3>
						<a href="<c:url value='/RechercheAvancee'/>">Rechercher Par</a>
						</h3>
						<p><span>Critères:</span></p>	
						<p>ISBN
						<br/>Auteurs
						<br/>Titre
						<br/>Categories </p>
						
						
					  </div>	
<!-- 					  <br/>					  <br/>					  <br/>					  <br/> -->
<!-- 					  <div class="add-banner"> -->
<!-- 					  	<img src="web/images/camera.png" alt="" /> -->
<!-- 					  	<div class="banner-desc"> -->
<!-- 					  		<h4>Electronics</h4> -->
<!-- 					  	    <a href="#">More Info</a> -->
<!-- 					  	</div> -->
<!-- 					  	<div class="clear"></div> -->
<!-- 					  </div> -->
<!-- 					    <div class="add-banner add-banner2"> -->
<!-- 					  	<img src="web/images/computer.png" alt="" /> -->
<!-- 					  	<div class="banner-desc"> -->
<!-- 					  		<h4>Computers</h4> -->
<!-- 					  	    <a href="#">More Info</a> -->
<!-- 					  	</div> -->
<!-- 					  	<div class="clear"></div> -->
<!-- 					  </div> -->
    	    	</div>
    	    	