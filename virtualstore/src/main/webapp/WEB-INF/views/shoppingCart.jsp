<%@include file="includes/header.jsp" %>


<body>

<%@include file="includes/mainNav.jsp" %>

<h1>${pageTitle }</h1>

<section class="mainSection"> 
	
	<c:forEach var="orderLine" items="${ order.orderLines}" >
		<div class="itemImage">
<%-- 		<img  width="200" height="200" alt="${ orderLine.product.name} " src="${orderLine.product.productMedias.get(0).getUrl() }"> --%>
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
			<br/>
			Condition Applies<a href="http://localhost:8080/virtualstore/productCondition/${orderLine.product.id }">Learn More</a>
			<br/>
			<a href="http://localhost:8080/virtualstore/RemoveFromShoppingCart/${orderLine.product.id }">Delete</a>
		</div>
		<div class="price">
			<h2>Price</h2>
			<p>${ orderLine.product.price }</p>
		</div>
		<div class="quantityInShoppingCart">
			<h2>Quantity</h2>
			<form action="http://localhost:8080/virtualstore/ChnageQuantityShoppingCart/${orderLine.product.id }" method="post">
				<input type="text" value="${ orderLine.quantity }" name="quantity"/>
				<input type="hidden" value="${ orderLine.product.id }" name="productID" style="width: 20%; display: inline;"/>
				<input type="submit" value="Chnage Quantity" style="width: 40%; display: inline;"/>	
			</form>
			
<%-- 			<a href="http://localhost:8080/virtualstore/ChnageQuantityShoppingCart/${orderLine.product.id }">Change Quantity</a> --%>
		</div>
	</c:forEach>
	
	<div class="subTotal">
	    <p> Subtotat: ${subtotatl }</p>
	</div>
	<div class="checkout">
	    <a href="http://localhost:8080/virtualstore/checkOut">Checkout</a>
	</div>	
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