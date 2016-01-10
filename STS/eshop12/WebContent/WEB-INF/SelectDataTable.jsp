<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK REL="stylesheet" TYPE="text/css"
	HREF="<%=request.getContextPath()%>/css/style.css" TITLE="style" />
<title>E-Shop project</title>
</head>
<body>
	<%@ include file="/WEB-INF/header.jsp"%>
	<div class="container">
		<%@ include file="/WEB-INF/leftMenu.jsp"%>
		<div class="content" align="center">
			<h1>${result}</h1>
			<form action="selectDataTable" method="post">
				Select table <input type="text" id="tableName" name="tableName" />
				<input type="submit" value="Select"></input>
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