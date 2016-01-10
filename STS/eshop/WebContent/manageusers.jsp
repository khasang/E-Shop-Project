<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK REL="stylesheet" TYPE="text/css"
	HREF="<%=request.getContextPath()%>/css/style.css" TITLE="style" />
<title>Manage users</title>
</head>
<body>
<div class="header">E-Shop project:Manage users</div>
<div class="container">
<%@ include file="leftMenu.jsp"%>
<div class="content" align="center">
 <table border=1>
 <tr><th>Login</th><th>Role</th></tr>
 <c:forEach items="${listUsers}" var="user">
 <tr>
 <td>${user.login}</td>
 <td>
<form:form action="updateRole" modelAttribute="User"> 
<form:hidden path="login" value="${user.login}"/>
<security:csrfInput />
<form:select id="role" path="role">
<c:forEach var="item" items="${listUserRoles}">
    <c:choose>
        <c:when test="${user.role==item}">
            <form:option selected="true" value="${item}" label="${item}"/>            
        </c:when>
        <c:otherwise>          
                <form:option value="${item}" label="${item}"/>            
        </c:otherwise>
    </c:choose>
</c:forEach>
</form:select>
<input type="submit" value="Change">
</form:form>
 </td>
 </tr>
 </c:forEach>
 </table>
</div>
</div>
</div> 
</body>
</html>