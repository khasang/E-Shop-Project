<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK REL="stylesheet" TYPE="text/css"
	HREF="<%=request.getContextPath()%>/css/style.css" TITLE="style" />
<title>Insert title here</title>
</head>
<body>
<div class="header">E-Shop project:Backup</div>
<div class="container">
<%@ include file="leftMenu.jsp"%>
<div class="content" align="center">
<form method="post" action="BackupDB">
Path <input type="text" name="path" id="path" value="C:\\ProgramData\\MySQL\\MySQL Server 5.7\\Uploads">
<input type="submit" value="ok">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</div>
</div>
</body>
</html>