<%@page import="org.springframework.context.annotation.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE>
<html>
<head>
<style>
@CHARSET "ISO-8859-1";

/* HEADER */

section.mainNav{
	border: 2px solid red;
	width: 100%;
}

section.mainNav div.links{
	
	border: 2px solid yellow;
	//background: black;
	width: 70%;
	display: inline-block;
}

section.mainNav div.links ul li a{
	font-size: xx-large;
}

section.mainNav div.search{
	
	border: 2px solid yellow;
	//background: gray;
	width: 20%;
	//float: right;
	display: inline-block;
	vertical-align: top;
	margin-left: 15px;
	
}
section.mainNav div.search input:FIRST-CHILD{
	//margin-top: 10px;
	width: 60%; 
	vertical-align: middle;
	padding-top: 10px;
	//height: 20%;
}

/*
Main section and right section
*/
section.mainSection{
	border: 1px solid red;
	display: inline-block;
	width: 70%;
	margin-left: 3%;
	
}

section.mainSection div.featuredProduct{
	border: 1px solid green;
	width: 30%;
	margin-left: 2%;
	margin-top: 10px;
	margin-bottom: 5px;
	display: inline-block;
	
}

div.featuredProductImageDiv{
	border: 2px solid gray;
}

div.featuredProductLinkDetails, div.featuredProductLinkAdd{
	border: 1px dashed blue;
	text-align: center;
	font-size: large;
}

div.featuredProductLinkDetails a, div.featuredProductLinkAdd a{
	font-size: large;
}

img.featuredProductImage{
	width: 200px;
	height: 200px;
}


/*
righSection 
*/
section.rightSection{
	border: 1px solid blue;
	width: 20%;
	float: right;
	margin-right: 3%;
	
}

div.relatedProduct{
	margin-top: 10px;
}

section.rightSection img{
	width: 80%;
}

section.rightSection div.relatedProductLink{
	border: 1px dashed blue;
	text-align: center;	
}
section.rightSection a{
	font-size: large;
}


/*
Footer
*/

section.footerSection{
	clear: both;
	border: 2px solid blue;
}


/* LOGiN PAGE*/
div.signin{
	border: 1px solid red;
	width: 50%;
	margin-left: 30%;
	margin-top: 3%;
}

/* shoppingCart*/
div.itemImage{
	border: 1px solid red;
	width: 30%;
	display: inline-block;
}

div.details{
	border: 1px solid green;
	width: 20%;
	display: inline-block;
	vertical-align: top;
	margin-top: 5%;
}

div.price{
	border: 1px solid gray;
	width: 10%;
	display: inline-block;
	vertical-align: top;
	margin-top: 5%;

}

div.quantityInShoppingCart{
	border: 1px solid blue;
	width: 30%;
	display: inline-block;
		vertical-align: top;
	margin-top: 5%;
	
}

div.subTotal{
	border: 1px solid blue;
	width: 30%;
	display: inline-block;
	margin-left: 30%;
	display: inline-block;
	font-size:x-large;
}

div.checkout{
	border: 1px solid blue;
	width: 30%;
	display: inline-block;
	//margin-left: 50%;
	display: inline-block;
	 
}

div.checkout a{
	font-size: x-large;	 
	text-decoration: none;
}
div.checkout a:hover{
	font-size: x-large;
	color: blue;	 
}

/* Imran*/
.rating {
		    float:left;
		    width:160px;
		}
		.rating span { float:right; position:relative; }
		.rating span input {
		    position:absolute;
		    top:0px;
		    left:0px;
		    opacity:0;
		}
		.rating span label {
		    display:inline-block;
		    width:30px;
		    height:30px;
		    text-align:center;
		    color:#FFF;
		    background:#ccc;
		    font-size:30px;
		    margin-right:2px;
		    line-height:30px;
		    border-radius:50%;
		    -webkit-border-radius:50%;
		}
		.rating span:hover ~ span label,
		.rating span:hover label,
		.rating span.checked label,
		.rating span.checked ~ span label {
		    background:#F90;
		    color:#FFF;
		
		}
		.userSelected{
		float:left;
		}
.rating-box {
background: url("../images/bkg_rating.png") repeat-x;
font-size: 0;
height: 13px;
line-height: 0;
overflow: hidden;
text-indent: -999em;
width: 70px;
}
 
.rating-box .rating {
background: url("../images/bkg_rating.png") repeat-x;
background-position: 0 100%;
float: left;
height: 13px;
}


</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>${pageTitle }</title>
</head>

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