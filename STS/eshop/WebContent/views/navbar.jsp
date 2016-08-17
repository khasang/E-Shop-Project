<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="<s:url value="/"/>">ElectroShop</a>
		</div>
		<div id="navbar" class="navbar-collapse">
			<p class="navbar-text">
				<s:url value="/cart" var="cartUrl"/>
				<a href="${cartUrl}" class="navbar-link">View cart</a>
				<span class="badge">${totalItemsInCart}</span>
			</p>
			<s:url var="authUrl" value='j_spring_security_check' />
			<c:if test="${not empty param.login_error}">
				<font color="red">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</font>
			</c:if>
			<form class="navbar-form navbar-right" action="${authUrl}"
				method="post">
				<div class="form-group">
					<input type="text" name="login" placeholder="Login"
						class="form-control">
				</div>
				<div class="form-group">
					<input type="password" name="password" placeholder="Password"
						class="form-control">
				</div>
				<button type="submit" class="btn btn-success">Sign in</button>
				<div class="form-group">
					<div class="navbar-collapse navbar-right">
						<a href="registration" class="navbar-link">Registration</a>
					</div>
				</div>
				<security:csrfInput />
			</form>
		</div>
		<!--/.navbar-collapse -->
	</div>
</nav>