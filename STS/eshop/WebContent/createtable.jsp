<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK REL="stylesheet" TYPE="text/css"
	HREF="<%=request.getContextPath()%>/css/style.css" TITLE="style" />
<title>E-Shop project</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<%@ include file="leftMenu.jsp"%>
		<div class="content" align="center">
			<h1>${result}</h1>
			<form action="createDataTable" method="post">
				Please enter name of new purchase <input type="text" id="tableName" name="tableName" />
				<input type="submit" value="OK"></input>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
		</div>
	</div>
</body>
</html>