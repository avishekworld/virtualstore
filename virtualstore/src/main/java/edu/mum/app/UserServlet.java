package edu.mum.app;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import edu.mum.customer.domain.User;
import edu.mum.service.TestUserService;


public class UserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
	    WebApplicationContext applicationContext =
	        WebApplicationContextUtils.getWebApplicationContext(context);
	    TestUserService userService = applicationContext.getBean(
	        "userService", TestUserService.class);
	    
	    User u=new User("Sir","secret");
	    
	    userService.createUser(u);
	    
	    request.setAttribute("user", u);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		//life
	}

}
