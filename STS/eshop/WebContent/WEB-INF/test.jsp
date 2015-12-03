<html>
<body>
	Congratulations! You are old enough to sign up for this site.
	<table>
		<c:forEach var="person" items="${people.people}">
			<tr>
				<td>${person.ID}</td>
				<td>${person.minute}</td>
				<td>${person.color}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>