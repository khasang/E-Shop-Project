<html>
	<body>
		${array}
		
		 <H1>Using the while Loop</H1>
    <%  
	out.println("Loop will run 5 times.<br>");
        int i = 1;

	// while loop that runs five times
        while (i<6) {
            out.println("we are in loop value is : "+i+"<br>");
	    i++;
        }
        out.println("Now we are out of while loop.");
    %>
	</body>
</html>