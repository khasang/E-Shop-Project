<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>  

		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Amount</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${listCart}" varStatus="status">
					<tr>
						<td>${item.product.name}</td>
						<td>${item.product.description}</td>
						<td>${item.product.price}</td>
						<td class="col-lg-2">
							<div class="input-group">
								<span class="input-group-btn">
								<button type="button" id="btnplus${status.step}" class="btn btn-default">+</button>
								</span> 
							     <input type="text" id="input${status.step}" class="form-control" value="${item.quantity}">							 
								<span class="input-group-btn">
								<button type="button" id="btnminus${status.step}" class="btn btn-default">-</button>								
								</span>
							</div>
						</td>
						<td class="col-lg-1">${item.amount}</td>
						<td> <a class="btn btn-default" href="${eshopurl}/cart/delete/${item.product.id}" role="button">Delete</a></td>

					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="3" class="text-right">Total</th>
					<th>${totalItemsInCart}</th>
					<th>${totalAmountInCart}</th>
					<th>&nbsp;</th>
				</tr>
			</tfoot>
		</table>
		<hr>
