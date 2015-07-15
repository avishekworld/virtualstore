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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">

<style>
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
/*---------------*/

section.mainSectionDetailsPage{
	border: 2px solid red;
}

div.productThumbnails{
	display:inline-block;
	width: 7%;
	margin-left: 2%; 
	border: 1px solid green;
}

div.productThumbnails img{
	width: 90%;
	margin-top: 20px;
}

div.productThumbnails img:HOVER{
	width: 300%;
	margin-top: 20px;
}


div.productImageLarge{
	display:inline-block;
	width: 30%;
	margin-left: 20%; 
	border: 2px solid yellow;
	height: 40%;
	z-index: -1000;
}

div.productImageLarge img{
	width: 95%;
	height: 95%;
	position: relative;
	z-index: 1999;
}


div.productDetails{
	display:inline-block;
	width: 20%;
	margin-left: 2%; 
	border: 2px solid blue;
	font-size: large;
}

div.shipping{
	display:inline-block;
	width: 10%;
	margin-left: 2%; 
	border: 2px solid green;
}

div.shipping a{
	font-size: x-large;
	text-decoration: none;
	
}

div.shipping a:HOVER{
	text-decoration: none;
	color: blue;
}

/*Imran*/
.rating_bar {
    /*this class creats 5 stars bar with empty stars */
    /*each star is 16 px, it means 5 stars will make 80px together */
    width: 80px;
    /*height of empty star*/
    height: 16px;
    /*background image with stars */
    background: url(../images/stars.png);
    /*which will be repeated horizontally */
    background-repeat: repeat-x;
    /* as we are using sprite image, we need to position it to use right star, 
    //0 0 is for empty */
    background-position: 0 0;
    /* align inner div to the left */
    text-align: left;
}
.rating_show {
    /* height of full star is the same, we won't specify width here */
    height: 16px;
    /* background image with stars */
    background: url(../images/stars.png);
    /* now we will position background image to use 16px from top, 
    //which means use full stars */
    background-position: 0 -16px;
    /* and repeat them horizontally */
    background-repeat: repeat-x;
}

</style>
    
<title>${pageTitle }</title>
</head>

<body>

<%@include file="includes/mainNav.jsp" %>

<h1>${pageTitle }</h1>

<section class="mainSectionDetailsPage"> 
	<div class="productThumbnails">
		<c:forEach var="productMedia" items="${ product.productMedias}" >
			<img  alt="${ product.name} " src="${ productMedia.getUrl() }">
		</c:forEach>
	</div>
	
	<div class="productImageLarge">
		<c:if test="${product.productMedias.size() > 0 }">
			<img class="productImages" alt="${ product.name} " src="${product.productMedias.get(0).getUrl() }">
		</c:if>
		
	</div>
	
	<div class="productDetails">
			<p>${product.name }</p> 
			<div class='rating_bar' title="${total_rating } out of 5.0 stars">
    			<div  class='rating_show'  style='width:${total_rating_width}%;'>
    			</div>
			</div>
			
			<p>Rating: ${rating } % satisfaction</p>
			<p>Price: ${product.price }</p>
			<p>In Stock: ${product.productInventory.quantity }</p>
			<c:forEach var="productDetail" items="${ product.details}" >
				<p> ${ productDetail }</p>
			</c:forEach>
			<p>${product.catagory.catagoryName }</p>
			<a href="http://localhost:8080/virtualstore/productReview/${product.id }">Add Review</a> 
	</div>
	
	<div class="shipping">
		<!-- If logged in, then show shipping address -->
		<a href="http://localhost:8080/virtualstore/AddToShoppingCart/${product.id }">Add to Cart</a>
	</div>
	
</section>

<section class="reviews">

<table>
   <c:forEach var="review" items="${all_reviews}" >
   	<tr>
   		<td>
    		<table>
    			<tr>
    				<td>
						<b>${review.user.username}</b> gave <b>${review.rating}.0/5.0</b> rating on ${review.date}											
					</td>
        			</tr>
        			<tr>
        				<td>${review.comment} </td>
    			</tr>
    		</table>
   		</td>
   	</tr>
   </c:forEach>
</table>
</section>

<section class="sameCatagoryItems">
	Suggested same catagory items
</section>





</body>


<%@include file="includes/footer.jsp" %>