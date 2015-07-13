<%@include file="includes/header.jsp" %>
<%@include file="includes/mainNav.jsp" %>

<body>

<h1>${pageTitle }</h1>

<section class="mainSection"> 
	
		
	<c:forEach var="orderLine" items="${ order.orderLines}" >
		<div class="itemImage"><img  width="200" height="200" alt="${ orderLine.product.name} " src="${orderLine.product.productMedias.get(0).getUrl() }"></div>
		<div> 
			<a href="http://localhost:8080/virtualstore/productDetails/${orderLine.product.id }">${ orderLine.product.name }</a>
			Condition Applies<a href="http://localhost:8080/virtualstore/productCondition/${orderLine.product.id }">Learn More</a>
			<a href="http://localhost:8080/virtualstore/RemoveFromShoppingCart/${orderLine.product.id }">Delete</a>
		</div>
		<div class="price">
			${ orderLine.product.price }
		</div>
		<div class="quantityInShoppingCart">
			<form action="http://localhost:8080/virtualstore/ChnageQuantityShoppingCart/${orderLine.product.id }" method="post">
				<input type="text" value="${ orderLine.quantity }" name="quantity"/>
				<input type="hidden" value="${ orderLine.product.id }" name="productID"/>
				<input type="submit" value="Chnage Quantity" />	
			</form>
			
<%-- 			<a href="http://localhost:8080/virtualstore/ChnageQuantityShoppingCart/${orderLine.product.id }">Change Quantity</a> --%>
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