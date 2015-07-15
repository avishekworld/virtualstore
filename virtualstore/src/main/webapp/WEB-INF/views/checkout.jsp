<%@include file="includes/header.jsp" %>
<%@include file="includes/mainNav.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <style type="text/css">
 
            body {font-family:Arial, Sans-Serif;}
 
            #container {width:300px; margin:0 auto;}
 
            /* Nicely lines up the labels. */
            form label {display:inline-block; width:140px;}
 
            /* You could add a class to all the input boxes instead, if you like. That would be safer, and more backwards-compatible */
            form input[type="text"],
            form input[type="password"],
            form input[type="email"] {width:160px;}
 
            form .line {clear:both;}
            form .line.submit {text-align:right;}
 
        </style>
    </head>
    <body>
    	
        <div id="container">
        
        <form action="checkout" method="post"  >
           
                <h1>Select Payment</h1>
                

                <div class="line">Amount: <input type="text" id="name" name="amount" value ="${subtotatl}" /></div>
                
					<c:if test="${payments.size() >0}">
						<div class="line">Payment *: 
						<select  name = "paymentId" >
							<c:forEach var="paymentInfo" items="${payments}">
								<option  value="${paymentInfo.id}">${paymentInfo.paymentName}</option>
							</c:forEach>
						</select>
						 </div>
	               
	                		<div class="line submit"><input type="submit" value="Submit" /></div>
                
                	</c:if>
                	<c:if test="${payments.size()==0}">
                			<a href="/virtualstore/payment">Add Payment</a>
                	</c:if>
 
                <p>Note: Please make sure your details are correct before submitting form and that all fields marked with * are completed!.</p>
            </form>
        </div>
    </body>
</html>