<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" />
<title>E-Shop project</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<div class="container">
		<%@ include file="/WEB-INF/jsp/leftmenu.jsp"%>
		<div class="content" align="center">
			<h1>${result}</h1>
		<h1>Purchase list</h1>
			<c:if test="${!empty purchaseList}">
				<table border="1" width="300">
					<tr>
						<td>ID</td>
						<td>Name</td>
						<td>Cancel</td>
					</tr>
					<c:forEach items="${purchaseList}" var="purchaser">
						<tr>
							<td>${purchaser.id}</td>
							<td>${purchaser.orderName}</td>
							<td><a href="cancelpurchase/${purchaser.id}">Canel</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>