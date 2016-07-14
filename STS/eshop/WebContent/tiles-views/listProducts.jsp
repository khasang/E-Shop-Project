<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
<c:forEach var="category" items="${listCategories}">
	<div class="well well-sm">${category.name}</div>
	<div class="row">
		<c:forEach var="product" items="${category.product}">
			<div class="col-md-4">
				<div class="thumbnail">
					<div class="col-sm-6 col-md-4">
						<a href="#" class="thumbnail"><img src="holder.js/100x100" alt="100x100"></a>
					</div>
					<h2>${product.name}</h2>
					<p>${product.description}</p>
					<p>Price:${product.price}</p>
					<p>
						<a class="btn btn-default" href="${eshopurl}/cart/add/${product.id}" role="button">Add to cart&raquo;</a>
					</p>
				</div>
			</div>
		</c:forEach>
	</div>
</c:forEach>
	</div>