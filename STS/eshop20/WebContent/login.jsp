<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>E-Shop project</title>
</head>
<body   onload="document.loginForm.login.focus();">
	<%@ include file="header.jsp"%>
	<div class="container">
		<div class="content" align="center">
			<h1>Login page</h1>
			<s:url var="authUrl" value='j_spring_security_check' />
			<c:if test="${not empty param.login_error}">
 			 <font color="red">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</font>
			</c:if>			
			<form action="${authUrl}" method="post" name="loginform">
		        <table>   	
		        <tr>
				<td>Account:</td>
				<td><input type="text" name="login" id="login"/></td>
				</tr>
				<tr>
				<td>Password:</td>
				<td><input type="password" name="password" id="password"/>				
				<input type="submit" value="Log in"/>
				</td>
				</tr>				
				</table>
		        <security:csrfInput />
			</form>
			<a href="registration">Registration</a>
		</div>
	</div>
</body>
</html>