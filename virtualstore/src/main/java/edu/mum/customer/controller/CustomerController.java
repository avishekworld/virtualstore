package edu.mum.customer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.customer.domain.Address;
import edu.mum.customer.domain.User;
import edu.mum.customer.domain.UserProfile;
import edu.mum.customer.service.IUserService;


@Controller
public class CustomerController {

	@Autowired
    private IUserService userService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getAll(Model model) {
    	
        return "registration";
    }
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String add(User user, UserProfile userProfile,Address billingAddress,Address shippingAddress) {
		
		userProfile.setBillingAddress(billingAddress);
		userProfile.setShippingAddress(shippingAddress);
		userService.registerUser(user, userProfile);
		return "redirect:/login";
	}
	
	
	@RequestMapping(value = "/registrationAtCheckout", method = RequestMethod.GET)
    public String registerAtCheckour(Model model) {
    	
        return "registrationAtCheckout";
    }
	
	@RequestMapping(value="/registrationAtCheckout", method=RequestMethod.POST)
	public String registerAtCheckout(User user, UserProfile userProfile,Address billingAddress,Address shippingAddress) {
		
		userProfile.setBillingAddress(billingAddress);
		userProfile.setShippingAddress(shippingAddress);
		userService.registerUser(user, userProfile);
		return "redirect:/shippingAndPayment";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login( HttpServletRequest request) {
		//If user is already logged in
		if( request.getSession().getAttribute("islogged") != null &&  request.getSession().getAttribute("islogged").equals("true")){
			return "redirect:/home";
		}

		return "/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login( Model model, @RequestParam("username") String username,  
					@RequestParam("password") String password, HttpServletRequest request) {
					
		User user = userService.getUserByUsername( username );
		
		if ( user != null && user.getPassword().equals( password ) ) {
			
			UserProfile userProfile = userService.getUserProfileByUserId( user.getId() );			
			request.getSession().setAttribute("islogged", "true");
			request.getSession().setAttribute("userProfile", userProfile);
			//request.getSession().setAttribute("userProfileID", userProfile.getId());
		}else{
			return "login";
		}
		
		return "redirect:/home";
	}
	
	@RequestMapping(value="/logout")
	public String logout( Model model, HttpServletRequest request) {
		
		request.getSession().removeAttribute("islogged");
		request.getSession().invalidate();
		return "redirect:/login";
	}
	
	
}
