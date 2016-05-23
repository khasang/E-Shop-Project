<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK REL="stylesheet" TYPE="text/css"
	HREF="<%=request.getContextPath()%>/css/style.css" TITLE="style" />
<title>shrink</title>
</head>
<body>
    
	<div class="container">
	<%@ include file="header.jsp"%>
		<%@ include file="leftMenu.jsp"%>
		
		<div class="content" align="center">
			<p align=center>Select a table for shrink:</p>
			<form:form action="ShrinkDataDB" modelAttribute="OptimizedTables">
				<table border="1">
					<tr>
						<th>Table name</th>
						<th>&nbsp;
					</tr>
					<c:forEach var="tableName" items="${listTables}">
						<tr>
  					    <td>${tableName}</td>
						<td><form:checkbox path="tablesList" value="${tableName}" checked="checked"/></td> 
						</tr>
					</c:forEach>
					<tr>
						<td colspan="2" align=""><input type="submit" value="OK"></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>