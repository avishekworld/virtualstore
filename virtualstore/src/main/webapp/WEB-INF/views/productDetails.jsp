<%@include file="includes/header.jsp" %>
<%@include file="includes/mainNav.jsp" %>

<body>

<h1>${pageTitle }</h1>

<section class="mainSectionDetailsPage"> 
	<div class="productThumbnails">
		<c:forEach var="productMedia" items="${ product.productMedias}" >
			<img  width="200" height="200" alt="${ product.name} " src="${ productMedia.getUrl() }">
		</c:forEach>
	</div>
	
	<div class="productImageLarge">
		<img class="productImages" alt="${ product.name} " src="${product.productMedias.get(0).getUrl() }">
	</div>
	
	<div class="productDetails">
			<p>${product.name }</p>
			<p>Rating: ${rating } % satisfaction</p>
			<p>Price: ${product.price }</p>
			<p>In Stock: ${product.productInventory.quantity }</p>
			<c:forEach var="productDetail" items="${ product.details}" >
				<p> ${ productDetail }</p>
			</c:forEach>
			<p>${product.catagory.name }</p>
			<a href="http://localhost:8080/virtualstore/productReview/${product.id }">Customer Reviews</a> 
	</div>
	
	<div class="shipping">
		<!-- If logged in, then show shipping address -->
		<a href="http://localhost:8080/virtualstore/AddToShoppingCart/${product.id }">Add</a>
	</div>
	
</section>

<section class="sameCatagoryItems">
	Suggested same catagory items
</section>





</body>


<%@include file="includes/footer.jsp" %>