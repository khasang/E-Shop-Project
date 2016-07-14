 
<c:set var="eshopurl" value="${pageContext.request.contextPath}"/>
<script src="resources/js/jquery-2.2.4.min.js"></script>
<script>
 $( document ).ready(function() {
	 $('[id^=btnminus]').on('click', function(){
	        val = $(this).parent().siblings('input').val() - 1;
	        resultVal = (val > 0) ? val : 1; 
	        $(this).parent().siblings('input').val(resultVal)
	})

	$('[id^=btnplus]').on('click', function(){
	        $(this).parent().siblings('input').val(parseInt($(this).parent().siblings('input').val()) + 1)
	})
 });
 </script> 
