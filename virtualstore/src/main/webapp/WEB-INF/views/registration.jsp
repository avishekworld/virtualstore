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
            <form action="registration" method="post">
                <h1>Registration</h1>
                <div class="line"><label for="username">Username *: </label><input type="text" id="username" value = "someone"name="username" /></div>
                <div class="line"><label for="pwd">Password *: </label><input type="password" id="password" name = "password" value="123456" /></div>

                <div class="line"><label for="firstname">First Name *: </label><input type="text" id="firstName" name="firstName" value="barak" /></div>
                <div class="line"><label for="lastname">Last Name *: </label><input type="text" id="lastName" name="lastName" value = "obama" /></div>
                
                <div class="line"><label for="email">Email *: </label><input type="email" id="email" name="email" value="test@yahoo.com" /></div>

                <div class="line"><label for="tel">phone: </label><input type="text" id="phone" name="phone" value ="34345345" /></div>
<br />Billing Address<br />
                <div class="line"><label for="lineOne">Line one *: </label><input type="text" id="lineOne" name="lineOne" value = "141 4th st." /></div>
                <div class="line"><label for="lineTwo">Line Two *: </label><input type="text" id="lineTwo" name="lineTwo" value = "N/A" /></div>
                <div class="line"><label for="state">State *: </label><input type="text" id="state" name="state" value = "North Carolina." /></div>
                <div class="line"><label for="zipCode">zip code *: </label><input type="text" id="zipcode" name="zipCode" value = "53242" /></div>

<br />Shipping Address<br />
                <div class="line"><label for="lineOne">Line one *: </label><input type="text" id="lineone" name="lineOne" value = "140 4th st." /></div>
                <div class="line"><label for="lineTwo">Line Two *: </label><input type="text" id="linetwo" name="lineTwo" value = "N/A" /></div>
                <div class="line"><label for="state">State *: </label><input type="text" id="state" name="state" value = "North Carolina." /></div>
                <div class="line"><label for="zipCode">zip code *: </label><input type="text" id="zipcode" name="zipCode" value = "43242" /></div>

               
                <div class="line submit"><input type="submit" value="Submit" /></div>
 
                <p>Note: Please make sure your details are correct before submitting form and that all fields marked with * are completed!.</p>
            </form>
        </div>
    </body>
</html>