<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="The Electronic shop project">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <LINK rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" title="style" />   
    <title>The Electronic Shop</title>
    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
      <!-- Custom styles for this template -->
    <link href="resources/jumbotron.css" rel="stylesheet">   
   <script src="resources/js/holder.js"></script>
   <c:set var="eshopurl" value="${pageContext.request.contextPath}"/>
	<script src="resources/js/jquery-2.2.4.min.js"></script>
	<script>
 		$( document ).ready(function() {
	 		$('[id^=btnminus]').on('click', function(){
	        	val = $(this).parent().siblings('input').val() - 1;
	        	resultVal = (val > 0) ? val : 1; 
	        	$(this).parent().siblings('input').val(resultVal)
			})

			$('[id^=btnplus]').on('click', function(){
	        	$(this).parent().siblings('input').val(parseInt($(this).parent().siblings('input').val()) + 1)
			})
 		});
 	</script> 
  </head>

  <body>
  	<tiles:insertAttribute name="navbar" />
    <tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="footer" />
    <tiles:insertAttribute name="scripts" />
    

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!--  script src="resources/js/bootstrap.min.js"></script-->  
  </body>
</html>