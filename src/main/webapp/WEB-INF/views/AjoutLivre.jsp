<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="template/header.jsp" %>



	  <div class="contact-form">
	  	<h3>Ajouter Livre</h3>
		    <form:form method="post" modelAttribute="livre" enctype="multipart/form-data">  
		    
		    	<form:input path="Titre" id="Titre" type="text" class="textbox1" value="Titre..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Titre...';}" />
		    	<input name="Auteur" id="Auteur " type="text" class="textbox1" value="Auteur..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Auteur...';}" />
	            <input name="Categorie" id="Categorie" type="text" class="textbox1" value="Categorie..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Categorie...';}"/>
   				<form:input path="Langue" id="Langue" type="text" class="textbox1" value="Langue..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Langue...';}"/>    
		    	<form:input path="Langue_Origine" id="Langue_Origine" type="text" class="textbox1" value="Langue_Origine..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Langue_Origine...';}" />
		    	<form:input path="Edition_maison" id="Edition_maison" type="text" class="textbox1" value="Edition_maison..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Edition_maison...';}"/>    
		    	<form:input path="ISBN" id="ISBN " type="text" class="textbox1" value="ISBN..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'ISBN...';}" />
		    	<form:input path="Prix" id="Prix" type="text" class="textbox1" value="Prix..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Prix...';}"/>   
		    	<form:input path="Stock_Quantite" id="Stock_Quantite" type="text" class="textbox1" value="Stock_Quantite..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Stock_Quantite...';}" />
		    	<div class="clear"></div>
		    	<span><textarea name="userMsg" value="Description:" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Description';}"/>Decrire le livre... </textarea></span>
		    	<div class="clear"></div>		
		    	<input name="image" id="image" type="file"/>
	                	
			   <div>
			   		<input type="submit" value="Ajouter"  class="mybutton"/>
			   		<div class="clear"></div>
			  </div>
		    </form:form>
	  </div>


<!--     <h2>Ajouter Livre</h2> -->
  
<%--     <form:form method="POST" modelAttribute="livre"> --%>
      
        
<!--         <table> -->
<!--               <tr> -->
<!--                 <td><label for="titre">Titre: </label> </td> -->
<%--                 <td><form:input path="Titre" id="titre"/></td> --%>
              
<!--             </tr> -->
            
              
<!--             <td><label for="Description">Description: </label> </td> -->
<!--                 <td><input name="Description" id="Description"/></td> -->
<!--             <tr>             -->
            
            
<!--             <td><label for="Auteur">Auteur: </label> </td> -->
<!--                 <td><input name="Auteur" id="Auteur"/></td> -->
<!--             <tr> -->
            
              
<!--             <td><label for="Categorie">Categorie: </label> </td> -->
<!--                 <td><input name="Categorie" id="Categorie"/></td> -->
<!--             <tr>             -->
            
            
<!--               <tr> -->
<!--                 <td><label for="Stock_Quantite">Stock_Quantite: </label> </td> -->
<%--                 <td><form:input path="Stock_Quantite" id="Stock_Quantite"/></td> --%>
              
<!--             </tr> -->
            
<!--               <tr> -->
<!--                 <td><label for="Langue">Langue: </label> </td> -->
<%--                 <td><form:input path="Langue" id="Langue"/></td> --%>
              
<!--             </tr> -->
            
<!--               <tr> -->
<!--                 <td><label for="Langue_Origine">Langue_Origine: </label> </td> -->
<%--                 <td><form:input path="Langue_Origine" id="Langue_Origine"/></td> --%>
              
<!--             </tr> -->
            
<!--               <tr> -->
<!--                 <td><label for="Edition_maison">Edition_maison: </label> </td> -->
<%--                 <td><form:input path="Edition_maison" id="Edition_maison"/></td> --%>
              
<!--             </tr> -->
             
            
            
            
<!--              <td><label for="Date_Publication">Date_Publication: </label> </td> -->
<%--                 <td><form:input path="Date_Publication" id="Date_Publication"/></td> --%>
<!--             <tr> -->
            
            
<!--               <tr> -->
<!--                 <td><label for="titre">ISBN: </label> </td> -->
<%--                 <td><form:input path="ISBN" id="ISBN"/></td> --%>
              
<!--             </tr> -->
            
<!--             <tr> -->
<!--                 <td><label for="Prix">Prix: </label> </td> -->
<%--                 <td><form:input path="Prix" id="Prix"/></td> --%>
              
<!--             </tr> -->

            
            
         
<!--             <tr> -->
<!--                 <td colspan="3">   -->
<!--                             <input type="submit" value="ajouter" /> -->
<!--                 </td> -->
<!--             </tr> -->
<!--         </table> -->
<%--     </form:form> --%>
    <br/>
    <br/>
  
<%@include file="template/footer.jsp" %>