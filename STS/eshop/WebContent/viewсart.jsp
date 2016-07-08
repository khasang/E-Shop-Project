 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"  isELIgnored="false"%>
 <!DOCTYPE html>
<html>
  <head>   
   <%@ include file="head.jsp"%>    
  </head>
  <body> 
   <%@ include file="navbar.jsp"%>
       
   <div class="container">
   
     <c:forEach var="item" items="${listCart}">
       <div class="row show-grid">
         <div class="col-md-1">${item.product.name}</div>
         <div class="col-md-1">${item.product.description}</div>
         <div class="col-md-1">${item.product.price}</div>
         <div class="col-md-1">${item.quantity}</div>
         <div class="col-md-1">${item.amount}</div>
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