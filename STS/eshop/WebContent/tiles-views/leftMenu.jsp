
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<c:set var="eshopurl" value="${pageContext.request.contextPath}"/>
<form action="logout" id="logout" method="post">
<security:csrfInput />
</form>    
<div class="menu_left" align="center">
	<ol>
		<li><a href="${eshopurl}/basket">View Basket</a></li>				
		<security:authorize access="hasRole('ROLE_ADMIN')">
        <li><a href="${eshopurl}/admin/manageusers">Manage users</a></li> 			
		<li><a href="${eshopurl}/admin/backup">Backup DB</a></li>
		<li><a href="${eshopurl}/admin/showtables">Shrink Data DB</a></li>
		</security:authorize>		    
		<li><a href="#" onclick="document.getElementById('logout').submit();">Logout</a></li>
	</ol>
</div>