 <!-- Bootstrap core JavaScript
 ================================================== -->
 <!-- Placed at the end of the document so the pages load faster -->
<script src="resources/js/jquery-2.2.4.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/holder.js"></script> 
<script>
 $( document ).ready(function() {
    var pageURL = $(location).attr("pathname");
    
    if(pageURL.indexOf('register') > -1) {  	   	
    	$('#registration').modal();
    }
    
    if(pageURL.indexOf('loginpage') > -1) {  	   	
    	$('#login').modal();
    }
    
	 $('[id^=btnminus]').click(function(){
	        val = $(this).parent().siblings('[id^=quantity]').val() - 1;
	        resultVal = (val > 0) ? val : 1; 
	        $(this).parent().siblings('[id^=quantity]').val(resultVal);
	        productId = $(this).parent().siblings('[id^=productId]').val();
	        newQuantity = $(this).parent().siblings('[id^=quantity]').val();
	        updateCart(productId, newQuantity);
	})

	$('[id^=btnplus]').click(function(){
	        $(this).parent().siblings('[id^=quantity]').val(parseInt($(this).parent().siblings('[id^=quantity]').val()) + 1);
	        productId = $(this).parent().siblings('[id^=productId]').val();
	        newQuantity = $(this).parent().siblings('[id^=quantity]').val();
	        updateCart(productId, newQuantity);
	})
	
	$('[id^=quantity]').change(function(){
	    productId = $(this).siblings('[id^=productId]').val();
	    newQuantity = $(this).val();
	    updateCart(productId, newQuantity);
	})		
 });
  
 function updateCart(productId, newQuantity){
	 var updatedItem = {}
	 updatedItem["productId"] = productId;
	 updatedItem["newQuantity"] = newQuantity;	 
	  	 	 
	 $.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${home}cart/api/getUpdatedCart",
			data : JSON.stringify(updatedItem),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				updateView(data);				
			},
			error : function(e) {
				console.log("ERROR: ", e);
				error(e);
			}
		});
	 
	 
	  
		function error(data) {
			var json = "<h4>Ajax Response</h4><pre>"
					+ JSON.stringify(data, null, 4) + "</pre>";
	        $('#error_message').removeClass('hidden');			
		    $('#error').html(json);		    
		}
		
		function updateView(data){
			$('#amount'+data.productId).html(data.amount);
			$('#quantityTotal').html(data.quantityTotal);
			$('#amountTotal').html(data.amountTotal);
		}
	 
 }
 
 </script> 
 