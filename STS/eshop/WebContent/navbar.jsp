<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="/eshop">ElectroShop</a>
		</div>
		<div id="navbar" class="navbar-collapse">
			<p class="navbar-text">
				<a href="${eshopurl}/cart" class="navbar-link">View cart</a>
				<span class="badge">${totalItemsInCart}</span>
			</p>
			<s:url var="authUrl" value='j_spring_security_check' />
			<c:if test="${not empty param.login_error}">
				<font color="red">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</font>
			</c:if>
			 <div class="collapse navbar-collapse navbar-right">
      <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Login&nbsp;|&nbsp;Register <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="#" data-toggle="modal" data-target="#login">Login</a></li>
                        <li><a href="#" data-toggle="modal" data-target="#registration">Register</a></li>
                      
                    </ul>
                </li>
            </ul>      
			</div>
		<!--/.navbar-collapse -->
	</div>
</nav>