<%@include file="includes/header.jsp" %>
<%@include file="includes/mainNav.jsp" %>
<body>
	<center>
	<section class="col-lg-6 col-md-5">

	<form action="../product/${product.id}" method="post" >
	<table>
		<tr>
			<td>Product Name:</td>
			<td> <input type="text" id="name" name="name" value="${product.name}" /> </td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><input type="text" id="price" name="price" value="${product.price}" /> </td>
		</tr>
		
		
	</table>
	<input type="submit" value="update"/>
	</form>
	</section>
	</center>
</body>
<%@include file="includes/footer.jsp" %>