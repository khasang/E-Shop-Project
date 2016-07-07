<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>  

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
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!--  script src="resources/js/bootstrap.min.js"></script-->  
  </body>
</html>
