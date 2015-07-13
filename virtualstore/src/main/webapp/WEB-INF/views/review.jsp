<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Review</title>
<style  type="text/css">
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

</style>
</head>
<body>
<div id="container">
            <form action="/virtualstore/productR" method="post">
                <h1>Product Review</h1>
                <div class="line"><label for="product">${ product.name}</label></div>

<div class="line">
                	<div class="rating">
					    <span><input type="radio" name="rating" id="str5" value="5"><label for="str5"></label></span>
					    <span><input type="radio" name="rating" id="str4" value="4"><label for="str4"></label></span>
					    <span><input type="radio" name="rating" id="str3" value="3"><label for="str3"></label></span>
					    <span><input type="radio" name="rating" id="str2" value="2"><label for="str2"></label></span>
					    <span><input type="radio" name="rating" id="str1" value="1"><label for="str1"></label></span>
					 <div class="userSelected"></div>
					</div>
				</div>
 				<input type="hidden" name="product" value="${ product.id}"/>               
<!--                	<div class="line"><input type="text" name="comment" onfocus="if (this.value=='Enter comments here...') this.value = ''" value="Enter comments here..."/></div> -->
               	<div class="line"><textarea name="comment" onfocus="if (this.value=='Enter comments here...') this.value = ''">Enter comments here...</textarea></div> 
                
                <div class="line submit"><input type="submit" value="Submit" /></div>
 
            </form>
        </div>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
//  Check Radio-box
    $(".rating input:radio").attr("checked", false);
    $('.rating input').click(function () {
        $(".rating span").removeClass('checked');
        $(this).parent().addClass('checked');
    });

    $('input:radio').change(
    function(){
        var userRating = "Your rating : "+this.value;
        $(".userSelected").text(userRating);
    }); 
});
</script>
</body>
</html>