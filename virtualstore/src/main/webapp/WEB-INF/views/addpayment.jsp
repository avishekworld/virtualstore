<!doctype html>
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
            <form action="payment" method="post">
            
                <h1>Add Payment</h1>
                
                <div class="line">Payment Name : <input type="text" id="paymentName" name="paymentName" /></div>

                <div class="line">Card Number : <input type="text" id="cardNumber" name="cardNumber" /></div>
                
                <div class="line">Expire Date : <input type="date" id="expireDate" name="expireDate" min="2015-7-14" /></div>

                <div class="line submit"><input type="submit" value="Submit" /></div>
 
                <p>Note: Please make sure your details are correct before submitting form and that all fields marked with * are completed!.</p>
            </form>
        </div>
    </body>
</html>