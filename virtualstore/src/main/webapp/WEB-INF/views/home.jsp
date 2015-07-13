<%@include file="includes/header.jsp" %>
<%@include file="includes/mainNav.jsp" %>

<body>

<h1>${pageTitle }</h1>

<section class="mainSection"> 
	<c:forEach var="product" items="${ featuredProducts}" >
		<div class="featuredProduct">
		
			<div class="featuredProductImageDiv">
				<img class="featuredProductImage" alt="${ product.name} " src="${product.productMedias.get(0).getUrl() }">
			</div>
			<div class="featuredProductLinkDetails"><a href="http://localhost:8080/virtualstore/productDetails/${product.id }">${ product.name}</a> </div>
			<div class="featuredProductLinkAdd"><a href="http://localhost:8080/virtualstore/AddToShoppingCart/${product.id }">Add</a> </div>
		</div>
	</c:forEach>
</section>


<section class="rightSection">
<c:forEach var="product" items="${ relatedProducts}" >
		<div class="relatedProduct" >
		
			<div class="relatedProduct">
				<img  alt="${ product.name} " src="${product.productMedias.get(0).getUrl() }">
			</div>
			<div class="relatedProduct"><a href="http://localhost:8080/virtualstore/productDetails/${product.id }">${ product.name}</a> </div>
		</div>
</c:forEach>
</section>

</body>


<%@include file="includes/footer.jsp" %>