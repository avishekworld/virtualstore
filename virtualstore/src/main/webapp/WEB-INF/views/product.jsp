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
        <form action="product" method="post" enctype="multipart/form-data" >
           
                <h1>Add product</h1>
                

                <div class="line">Product Name: <input type="text" id="name" name="name" value ="Laptop"/></div>
                <div class="line">price *: <input type="text" id="price" name="price" value = "2000" /></div>
                <div class="line">quantity *: <input type="text" id="quantity" name="quantity" value = "1" /></div>
                <div class="line">Category Name *: 
					<select  name = "catagoryName" >
					  <option  value="Arts">Arts</option>
					  <option  value="Electonics">Electonics</option>
					  <option  value="Men">Men</option>
					  <option  value="Women">Women</option>
					  <option  value="Computers">Computers</option>
					  <option  value="Clothing">Clothing</option>
					  <option  value="Toys">Toys</option>
					  <option value="Software">Software</option>
					</select>
					 </div>
				<div class="line">Image *: <input type="file" name="file" /></div>	 

               
                <div class="line submit"><input type="submit" value="Submit" /></div>
 
                <p>Note: Please make sure your details are correct before submitting form and that all fields marked with * are completed!.</p>
            </form>
        </div>
    </body>
</html>