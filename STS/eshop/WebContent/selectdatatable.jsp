<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" />
<title>E-Shop project</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<%@ include file="leftMenu.jsp"%>
		<div class="content" align="center">
			<h1>${result}</h1>
			<form action="selectDataTable" method="post">
				Please select purchase to check your order
				<form:select name="tableTitleList" path="tableTitleList"
					items="${tableTitleList}">
				</form:select>
				<input type="submit" value="Select"></input>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
			<%
				ArrayList<String> list = (ArrayList<String>) request.getAttribute("list");
				if (list != null) {
			%>
			<table class="selecttable" border="1">
				<tr class="titleTR">
					<td>Id</td>
					<td>Name</td>
					<td>Amount</td>
				</tr>
				<%
					for (int i = 0; i < list.size(); i += 3) {
				%>
				<tr>
					<td><%=list.get(i)%></td>
					<td><%=list.get(i + 1)%></td>
					<td><%=list.get(i + 2)%></td>
				</tr>
				<%
					}
				%>
			</table>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>