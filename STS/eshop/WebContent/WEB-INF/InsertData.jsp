<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert data in DB</title>
</head>
<body>
<div
		style="width: 200px; margin: 0 auto; border: 1px solid gray; padding-bottom: 15px;"
		align="center">
		<form action="webshop/insertDataTable" method="post">
			<p>Name</p>
			<input type="text" id="name" name="name" />
			<p>Amount</p>
			<input type="text" id="amount" name="amount" />
			<p></p>
			<input type="submit" value="Add"></input>
		</form>
	</div>
</body>
</html>