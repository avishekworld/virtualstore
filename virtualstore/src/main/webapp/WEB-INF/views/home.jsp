<%@page import="edu.mum.admin.domain.UserRole"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/mainNav.jsp" %>

<body>

<div class="row">
<h1>${pageTitle }</h1>

</div>
<!-- <h1> -->
<%-- <c:if test="${islogged == 'true' }"> --%>
<!-- 	YOu are logged in  -->
<%-- </c:if> --%>
<!-- </h1> -->
<div class="row">
	
		<section class="mainSection"> 
			<c:forEach var="product" items="${ featuredProducts}" >
				<div class="featuredProduct">
				
					<div class="featuredProductImageDiv">
					<c:choose>
						<c:when test="${product.productMedias.size() > 0 }">
							<img class="featuredProductImage" alt="${ product.name} " src="${product.productMedias.get(0).getUrl() }">
						</c:when>
						<c:otherwise>
							<img class="featuredProductImage" alt="${ product.name} " src="http://localhost:8080/virtualstore/uploads/default.png">
						</c:otherwise>
					</c:choose>
					</div>
					<div class="featuredProductLinkDetails"><a href="http://localhost:8080/virtualstore/productDetails/${product.id }">${ product.name}</a> </div>	
					<div class="featuredProductLinkDetails">${ product.price}</div>
					<div class="featuredProductLinkAdd"><a href="http://localhost:8080/virtualstore/AddToShoppingCart/${product.id }">Add</a> </div>
					<%
						if( request.getSession().getAttribute("islogged") != null && request.getSession().getAttribute("islogged").equals("true"))
			        	{
		
							UserRole userRole=(UserRole)request.getSession().getAttribute("userRole");
							
							if( userRole.isAdmin())
							{
								
							%>		
								<div class="featuredProductLinkAdd"><a href="http://localhost:8080/virtualstore/product/${product.id }">Edit</a> </div>
								
							<% 	
							}
			        	}
						
							
						%>	
					
				</div>
			</c:forEach>
		</section>
	

		<section class="rightSection">
		<c:forEach var="product" items="${ relatedProducts}" >
				<div class="relatedProduct" >
				
					
					<div class="relatedProductImage">
					<c:choose>
						<c:when test="${product.productMedias.size() > 0 }">
							<img  alt="${ product.name} " src="${product.productMedias.get(0).getUrl() }">
						</c:when>
						<c:otherwise>
							<img class="featuredProductImage" alt="${ product.name} " src="http://localhost:8080/virtualstore/uploads/default.png">
						</c:otherwise>
					</c:choose>
					</div>
					
					<div class="relatedProductLink"><a href="http://localhost:8080/virtualstore/productDetails/${product.id }">${ product.name}</a> </div>
				</div>
		</c:forEach>
		</section>
	
</div><!-- row end -->
</body>


<%@include file="includes/footer.jsp" %>