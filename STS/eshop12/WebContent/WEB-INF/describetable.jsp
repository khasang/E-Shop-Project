<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK REL="stylesheet" TYPE="text/css"
	HREF="<%=request.getContextPath()%>/css/style.css" TITLE="style" />
<title>Describe table</title>
</head>
<body>
	<%@ include file="/WEB-INF/header.jsp"%>
	<div class="container">
		<%@ include file="/WEB-INF/leftMenu.jsp"%>
		<div class="content" align="center">
			<form action="describeTable" method="POST">
				Select table
				<form:select path="tablesInDB" name="tablesInDB"
					items="${tablesInDB}">
				</form:select>
				<input type="submit" name="submit" value="Select" />
			</form>
			<%
				ArrayList<String> list = (ArrayList<String>) request.getAttribute("listOfTableColumns");
				if (list != null) {
			%>
			Table columns:
			<%
				for (String column : list) {
			%>
			<%=column%>,
			<%
				}
			%>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>