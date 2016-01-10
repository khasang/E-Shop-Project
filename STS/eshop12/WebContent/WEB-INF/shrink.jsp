<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>shrink</title>
</head>
<body>
 <table border>
 <tr><th>Table name</th><th>Operation</th><th>Result</th></tr>
 <c:forEach items="${listTables}" var="operation">
 <tr>
 <td>${operation.tableName}</td>
 <td>${operation.operation}</td>
 <td>${operation.result}</td>
 </tr>
 
 </c:forEach>
 </table>
</body>
</html>