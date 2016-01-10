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
			Insert data<br>
			<form action="insertdatatable" method="post">
				<p>
					<form:select name="tableTitleList" path="tableTitleList"
						items="${tableTitleList}">
					</form:select>
				</p>
				<p>
					Name <input type="text" id="name" name="name" />
				</p>
				<p>
					Amount <input type="text" id="amount" name="amount" />
				</p>
				<p></p>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<input type="submit" value="Insert"></input>
			</form>
		</div>
	</div>
</body>
</html>