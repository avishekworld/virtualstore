<%@page import="edu.mum.admin.domain.UserRole"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/mainNav.jsp" %>
<body>
<center>
<section class="col-lg-6 col-md-5">
	<table class="table table-hover">
		<tr>
			<td><p>${ userProfile.firstName} ${ userProfile.lastName} </p></td>
			<td><p>${ userProfile.firstName} ${ userProfile.lastName} </p></td>
		</tr>
		<tr>
			<td><p>${ userProfile.shippingAddress.lineOne}</p></td>
			<td><p>${ userProfile.billingAddress.lineOne}</p></td>
		<tr>
		<tr>
			<td><p>${ userProfile.shippingAddress.lineTwo}</p></td>
			<td><p>${ userProfile.billingAddress.lineTwo}</p></td>
		</tr>
		<tr>
			<td><p>${ userProfile.shippingAddress.state}</p></td>
			<td><p>${ userProfile.billingAddress.state}</p></td>
		</tr>
		<tr>
			<td><p>${ userProfile.shippingAddress.zipCode}</p></td>
			<td><p>${ userProfile.billingAddress.zipCode}</p></td>
		</tr>
		<tr>
			<td><p>${ userProfile.phone}</p></td>
			<td><p>${ userProfile.phone}</p></td>
		</tr>
	</table>
	
	<section class="mainSection"> 
<c:forEach var="order" items="${ allOrders}" >
	<hr />	
	<c:forEach var="orderLine" items="${ order.orderLines}" >
		<div class="itemImage">
			<c:choose>
						<c:when test="${orderLine.product.productMedias.size() > 0 }">
							<img class="featuredProductImage" alt="${ product.name} " src="${orderLine.product.productMedias.get(0).getUrl() }">
						</c:when>
						<c:otherwise>
							<img class="featuredProductImage" alt="${ product.name} " src="http://localhost:8080/virtualstore/uploads/default.png">
						</c:otherwise>
			</c:choose>
		</div>
		<div class="details"> 
			<h2>Details</h2>
			<a href="http://localhost:8080/virtualstore/productDetails/${orderLine.product.id }">${ orderLine.product.name }</a>
		</div>
		<div class="price">
			<h2>Price</h2>
			<p>${ orderLine.product.price }</p>
		</div>
		<br />
	</c:forEach>
	<br />
	<hr />
</c:forEach>
</section>
	<hr />
	<a href="/virtualstore/payment">Add Payment</a>
	<%
	
	UserRole userRole=(UserRole)request.getSession().getAttribute("userRole");
	//is admin
	if( userRole.isAdmin()){
		
	%>		
		<a href="/virtualstore/createadmin">Add Admin User</a>
		<a href="/virtualstore/category">Add Category</a>		
		<a href="/virtualstore/product">Add Product</a>	
		
	<% 	
		}
	
		
	%>	
	
	<hr />
		
</section>

</center>

</body>

<%@include file="includes/footer.jsp" %>