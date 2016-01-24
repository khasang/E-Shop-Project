<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="eshopurl" value="${pageContext.request.contextPath}" />
<div class="menu_left" align="center">
	<ol>
		<li><a href="${eshopurl}/newpurchase">New Purchase</a></li>
		<li><a href="${eshopurl}/cancelpurchase">Cancel Purchase</a></li>
		<li><a href="${eshopurl}/createorder">Create Order</a></li>
		<li><a href="${eshopurl}/vieworder">View Order</a></li>
		<li><a href="${eshopurl}/logout">Log out</a>
	</ol>
	<security:authorize access="hasRole('ROLE_ADMIN')">
		<div align="left">
			<h1>Admin menu</h1>
			<ol>

				<li><a href="${eshopurl}/admin/backup">Backup DB</a></li>
				<li><a href="${eshopurl}/admin/shrink">Shrink Data DB</a></li>
				<li><a href="${eshopurl}/admin/users">User Manager</a>
			</ol>
		</div>
	</security:authorize>
</div>
