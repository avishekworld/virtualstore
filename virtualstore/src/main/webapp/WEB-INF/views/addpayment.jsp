<%@include file="includes/header.jsp" %>
<%@include file="includes/mainNav.jsp" %>
    <body>
        <center>
		<section class="col-lg-6 col-md-5">
            <form action="payment" method="post">
            
                <h1>Add Payment</h1>
                
                <div class="line">Payment Name : <input type="text" id="paymentName" name="paymentName" /></div>

                <div class="line">Card Number : <input type="text" id="cardNumber" name="cardNumber" /></div>
                
                <div class="line">Expire Date : <input type="date" id="expireDate" name="expireDate" min="2015-7-14" /></div>

                <div class="line submit"><input type="submit" value="Submit" /></div>
 
                <p>Note: Please make sure your details are correct before submitting form and that all fields marked with * are completed!.</p>
            </form>
        </section>
		</center>
    </body>
<%@include file="includes/footer.jsp" %>