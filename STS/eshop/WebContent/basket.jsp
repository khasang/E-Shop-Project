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
<div class="header">E-Shop project:View basket</div>
<div class="container">
<%@ include file="leftMenu.jsp"%>
<div class="content" align="center">
${username}
<table border>
<tr>
<th>Product name</th>
<th>Count</th>
<th>Price total</th>
</tr>
<c:forEach var="basket" items="${listBasket}">
<tr>
<td>${basket.product.name}</td>
<td>${basket.count}</td>
<td>${basket.priceTotal}</td>
</tr>
</c:forEach>
</table>
</div>
</div>


</body>
</html>