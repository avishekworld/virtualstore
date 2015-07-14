<section class="mainNav">
<div class="links">
	<ul style="display: inline; margin-left: 15px; font-size: large;">
		<li style="display: inline;  margin-left: 15px;"><a href="http://localhost:8080/virtualstore/home">Home</a></li>

<%
	if( request.getSession().getAttribute("islogged") != null && request.getSession().getAttribute("islogged").equals("true")){
%>		
	<li style="display: inline;  margin-left: 15px;">Welcome ${userProfile.firstName }</li>
	<li style="display: inline;  margin-left: 15px;"><a href="/virtualstore/shoppingCart">Your Cart</a></li>
	<li style="display: inline;  margin-left: 15px;"><a href="/virtualstore/profile/${ userProfile.id}">Your Profile</a></li>
	
<% 	
	}
// 	else{
// 		//user is not logged in
// 		String site = new String("http://localhost:8080/virtualstore/login");
// 		response.sendRedirect( site);
// 	}
	
%>		
		<li style="display: inline;  margin-left: 15px;"><a href="/virtualstore/registration">Sign up</a></li>
		<li style="display: inline;  margin-left: 15px;"><a href="/virtualstore/login">Login</a></li>
		<li style="display: inline;  margin-left: 15px;"><a href="/virtualstore/logout">Logout</a></li>
	</ul>
</div>
<div class="search">
	<form action="search" >
		<input type="text" placeholder="Search for products"/>
		<input type="submit" value="Serch" />
	</form>
</div>
</section>
<div style="clear: both;"></div>
