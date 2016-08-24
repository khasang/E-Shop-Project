 <!-- Registration Modal -->
<div class="modal fade" id="registration" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="registrationLabel">Register</h4>
            </div>
            <div class="modal-body">
                <form:form action="adduser" method="post" name="regform" modelAttribute="User">
			<form:errors path="*" cssClass="error"/>
                    <div class="form-group">
                        <label for="login">Login</label>
                        <!--  input type="text" class="form-control" id="login" placeholder="Login" -->
                        <form:input cssClass="form-control" path="login" id="login"  placeholder="Login" onChange="document.regform.email.value = this.value+'@eshop.com'"/>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <!-- input type="password" class="form-control" id="password" placeholder="Password"-->
                        <form:password cssClass="form-control"  path="password" id="password" placeholder="Login" />				 
				        <form:errors path="password" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword">Confirm</label>
                        <!-- input type="password" class="form-control" id="inputConfirmPassword" placeholder="Confirm"-->
                     	<form:password  cssClass="form-control"   path="confirmPassword" id="confirm"  placeholder="Confirm" />
		 	            <form:errors path="confirmPassword" cssClass="error"/>
                    </div>
                    
                     <div class="form-group">
                        <label for="name">User name</label>                        
                        <!-- input type="text" class="form-control" id="exampleUserName" placeholder="Login"-->
                       	<form:input path="name" id="name" cssClass="form-control" placeholder="user name"/> 
                    </div>
                                                           
                    <div class="form-group">
                        <label for="email">Email</label>                        
                        <!-- input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email"-->
                        <form:input type="email" path="email" id="email" cssClass="form-control" placeholder="E-mail"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Done</button>
 
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            </div>
            </form:form>
        </div>
    </div>
</div>
 