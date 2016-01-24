<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<LINK REL="stylesheet" TYPE="text/css"
	HREF="<%=request.getContextPath()%>/css/style.css" TITLE="style" />
<c:set var="eshopurl" value="${pageContext.request.contextPath}" />
<title>title</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<div class="container">
		<%@ include file="/WEB-INF/jsp/leftmenu.jsp"%>
		<div class="content" align="center">
			<form:form method="post" action="add" modelAttribute="user">
				<table>
					<tr>
						<td>Name:</td>
						<td><form:input path="username" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><form:input path="password" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Add User" /></td>
					</tr>
				</table>
			</form:form>
			<c:if test="${!empty userList}">
				<table border="1" width="590">
					<tr>
						<td>ID</td>
						<td>Name</td>
						<td>Password</td>
						<td>Roles</td>
						<td>Edit</td>
						<td>Delete</td>
					</tr>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td>${user.id}</td>
							<td>${user.username}</td>
							<td>${user.password}</td>
							<td>${user.userRoles}</td>
							<td><a href="${eshopurl}/admin/userpage/${user.id}">Edit</a></td>
							<td><a href="${eshopurl}/admin/delete/${user.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>