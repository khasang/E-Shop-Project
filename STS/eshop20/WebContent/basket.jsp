<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
${result}
<form:form action="processorder" modelAttribute="listOrders"> 

<table border=1>
	<tr>
		<th>Product name</th>
		<th>Price</th>
		<th>Count</th>
		<th>Price total</th>
	</tr>	
	<c:forEach var="basket" items="${listBasket}">
		<tr>
			<td>${basket.product.name}</td>
			<td>${basket.product.price}</td>
			<td>${basket.count}</td>
			<td>${basket.priceTotal}</td>		
			<td><a href="deleteorder/${basket.id}">Delete</a></td>
		</tr>
		
	</c:forEach>
	<tr><td colspan = "3">&nbsp;</td><td>${orderSum}</td><td><a href="#">Make order</a></td></tr>
</table>
</form:form>

</div>
</div>


</body>
</html>