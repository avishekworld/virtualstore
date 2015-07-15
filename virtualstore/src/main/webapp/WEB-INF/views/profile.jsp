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
	<a href="/virtualstore/payment">Add Payment</a>
	<%
	
	UserRole userRole=(UserRole)request.getSession().getAttribute("userRole");
	
	if( userRole.isAdmin()){
		
	%>		
		<a href="/virtualstore/createadmin">Add Admin User</a>
		<a href="/virtualstore/category">Add Category</a>		
		<a href="/virtualstore/product">Add Product</a>	
		
	<% 	
		}
	
		
	%>	
		
</section>

</center>

</body>

<%@include file="includes/footer.jsp" %>