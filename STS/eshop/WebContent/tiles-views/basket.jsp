<div class="header">E-Shop project:View basket</div>
<div class="container">
<tiles:insertAttribute name="leftMenu" />
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