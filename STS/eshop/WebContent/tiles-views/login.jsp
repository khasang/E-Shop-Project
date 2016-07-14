<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

	<div class="container" onload="document.loginForm.login.focus();">
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