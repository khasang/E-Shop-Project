<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>  
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
    <title>The Electronic Shop</title>
    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
      <!-- Custom styles for this template -->
    <link href="resources/jumbotron.css" rel="stylesheet">   
   <script src="resources/js/holder.js"></script> 
  </head>

  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
   
          <a class="navbar-brand" href="#">ElectroShop</a>          
        </div>
        <div id="navbar" class="navbar-collapse">
        <p class="navbar-text"><a href="#" class="navbar-link">View cart</a></p>        
     		<s:url var="authUrl" value='j_spring_security_check' />
			<c:if test="${not empty param.login_error}">
 			 <font color="red">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</font>
			</c:if>	      
          <form class="navbar-form navbar-right" action="${authUrl}" method="post">
            <div class="form-group">
            <input type="text" name="login" placeholder="Login" class="form-control">
            </div>         
            <div class="form-group">
              <input type="password" name="password" placeholder="Password" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
            <div class="form-group"> 
              <div class="navbar-collapse navbar-right"><a href="registration" class="navbar-link">Registration</a>              
              </div>
            </div>    
            
            <security:csrfInput />                 
          </form>                                    
        </div><!--/.navbar-collapse --> 
        </div>
    </nav>
     
     
    <div class="container">
      <!-- Example row of columns -->
      <c:forEach var="category" items="${listCategories}">
      <div class="well well-sm">      
       ${category.name}
      </div>
      <div class="row">           
      <c:forEach var="product" items="${category.product}">
          <div class="col-md-4">
          <div class = "thumbnail">
           <div class="col-sm-6 col-md-4">
             <a href="#" class="thumbnail">
             <img src="holder.js/100x100" alt="100x100">
             </a>
           </div>
          <h2>${product.name}</h2>
          <p>${product.description}</p>
          <p>Price:${product.price}</p>
          <p><a class="btn btn-default" href="#" role="button">Add to cart &raquo;</a></p>
          </div>
        </div>
       </c:forEach>               
      </div>
       </c:forEach>
      <hr>

      <footer>
        <p>&copy; 2015-2016 Khasang</p>
      </footer>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!--  script src="resources/js/bootstrap.min.js"></script-->  
  </body>
</html>
