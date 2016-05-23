<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK REL="stylesheet" TYPE="text/css"
	HREF="<%=request.getContextPath()%>/css/style.css" TITLE="style" />
<title>View Basket</title>
</head>
<body>
<div class="header">E-Shop project:Product statistic</div>
<div class="container">
<%@ include file="leftMenu.jsp"%>
<div class="content" align="center">

<table border=1>
<tr>
	<th>Product name</th>
	<th>Views</th>
</tr>
<c:forEach var="productstatistic" items="${ }">
<tr>
	<td>${productstatistic.product.name}</td>
	<td>${productstatistic.viewCount}</td>
</tr>
</c:forEach>
</table>
</div>
</div>

</body>
</html>