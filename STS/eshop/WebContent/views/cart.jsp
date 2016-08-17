<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<s:url var="home" value="/" scope="request"/>
<div class="container">
    <div id="error_message" class="alert alert-danger alert-dismissable fade in hidden" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        <strong id="error">&nbsp;</strong>
    </div>

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
                        <input type="hidden" id="productId${status.count}" value="${item.product.id}">
                        <span class="input-group-btn">
								  <button type="button" id="btnplus${status.count}" class="btn btn-default">+</button>
								</span>
                        <input type="text" id="quantity${status.count}" class="form-control" value="${item.quantity}">
                        <span class="input-group-btn">
							      <button type="button" id="btnminus${status.count}" class="btn btn-default">-</button>								
								</span>
                    </div>
                </td>
                <td class="col-lg-1" id="amount${item.product.id}">${item.amount}</td>
                <s:url value="/cart/delete/${item.product.id}" var="deleteUrl"/>
                <td><a class="btn btn-default" href="${deleteUrl}" role="button">Delete</a></td>

            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <th colspan="3" class="text-right">Total</th>
            <th id="quantityTotal">${totalItemsInCart}</th>
            <th id="amountTotal">${totalAmountInCart}</th>
            <th>&nbsp;</th>
        </tr>
        </tfoot>
    </table>
    <hr>
    <footer>
        <p>&copy; 2015-2016 Khasang</p>
    </footer>
</div>