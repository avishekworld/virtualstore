<section>
	<ul style="display: inline; margin-left: 15px; font-size: large;">
		<li style="display: inline;  margin-left: 15px;"><a href="http://localhost:8080/virtualstore/home">Home</a></li>
		
		<sec:authorize access="hasRole('ROLE_PRODUCT_OWNER')" >
        	<li style="display: inline;  margin-left: 15px;"><a href="http://localhost:8080/MumScrum/productBacklogCreate">Create Product Backlog</a></li>
        	<li style="display: inline;  margin-left: 15px;"><a href="http://localhost:8080/MumScrum/productBacklogList/1"> List of product Backlogs</a></li>	
   		 </sec:authorize>
		
		<sec:authorize access="hasRole('ROLE_SCRUM_MASTER')" >
        	<li style="display: inline;  margin-left: 15px;"><a href="http://localhost:8080/MumScrum/releaseBacklogList/1"> List of product Backlogs</a></li>	
   		 </sec:authorize>
				
		<li style="display: inline;  margin-left: 15px;"><a href="/virtualstore/login">Login</a></li>
		 <li style="display: inline;  margin-left: 15px;"><a href="/virtualstore/home/j_spring_security_logout">logout</a></li>
	</ul>
</section>
<br>
<br>
