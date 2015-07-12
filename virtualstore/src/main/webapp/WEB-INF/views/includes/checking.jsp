<%
if( request.getSession().getAttribute("username") != null){
	
	
	if( request.getSession().getAttribute("username").equals("powner") ){
		
		String site = new String("http://localhost:8080/MumScrum/productOwner");
		response.sendRedirect( site);
	}else if( request.getSession().getAttribute("username").equals("tester")){
	
		
	
	}else if( request.getSession().getAttribute("username").equals("developer")){
		
	
	}else if( request.getSession().getAttribute("username").equals("smaster")){
		
	}
}else{

	String username = (String)request.getParameter("username");
	if( username != null){
		request.getSession().setAttribute("username", (String)request.getParameter("username"));
		String site = new String("http://localhost:8080/MumScrum/login");
		response.setHeader("Location", site); 	
	}
}
%>