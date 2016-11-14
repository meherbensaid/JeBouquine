<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="template/header.jsp" %>

<!-- Authentification :  -->
<%-- <form:form method="POST" modelAttribute="utilisateur">       --%>
<!--         <table> -->
         
<!--             <tr> -->
<!--                 <td><label for="Login">Login: </label> </td> -->
<%--                 <td><form:input path="login" id="Login"/></td> --%>
              
<!--             </tr> -->
<!--             <tr> -->
<!--                 <td><label for="Mot_De_Passe">Mot_De_Passe: </label> </td> -->
<%--                 <td><form:input path="mot_De_Passe" id="mot_De_Passe"/></td> --%>
              
<!--             </tr>                      -->
<!--             <tr> -->
<!--                 <td colspan="3">   -->
<!--                             <input type="submit" value="S'inscrire" /> -->
<!--                 </td> -->
<!--             </tr> -->
            
<!--         </table> -->
<%--     </form:form> --%>
<!--     <br/> -->
<!--     <br/> -->


	  <div class="contact-form">
	  	<h3>Authentication : </h3>
		    <form:form method="post" modelAttribute="utilisateur">      
		    	<div>
			    	<form:input path="login" id="Login" name="userName" type="text" class="textbox textbox1" value="Login..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Login...';}" />
			    	<form:input path="mot_De_Passe" id="mot_De_Passe" name="userEmail" type="text" class="textbox" value="Password..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password...';}"/>
			    	<input type="submit" value="S'authetifier""  class="mybutton"/>
			   		<div class="clear"></div>
			    </div>
		    </form:form>
	  </div>
  </div>	



<%@include file="template/footer.jsp" %>