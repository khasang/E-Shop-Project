<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>E-Shop project</title>
</head>
<body onload="document.regform.login.focus();">
	<%@ include file="header.jsp"%>
	<div class="container">
		<div class="content" align="center">
			<h1>Registration page</h1>			
			${result}
			<form:form action="adduser" method="post" name="regform" modelAttribute="User">
			<form:errors path="*" cssClass="error"/>			
			<table>
			<tr>
				<td><label for="login">Login</label></td>			
				<td><form:input path="login" id="login" onChange="document.regform.email.value = this.value+'@eshop.com'"/></td>
			</tr>
			<tr>	
			    <td><label for="password">Password</label></td>			    
				<td>
		 		 <form:password path="password" id="password"/>				 
				 <form:errors path="password" cssClass="error"/>				 				 
				</td>												
			</tr>
			<tr>	
		     <td><label for="password">Confirm</label></td>			    
		 	 <td>
		 	  <form:password path="confirmPassword" id="confirm"/>
		 	  <form:errors path="confirmPassword" cssClass="error"/>
		 	 </td>		 	 											
			</tr>			
			<tr>
				<td><label for="name">User name</label></td>			
				<td><form:input path="name" id="name"/></td>
			</tr>
			<tr>
				<td><label for="email">E-mail</label></td>			
				<td><form:input path="email" id="email"/>&nbsp;<input id="submit" type="submit" value="Done"/></td>
			</tr>										
			</table>	
			</form:form>
		</div>
	</div>	
</body>
</html>