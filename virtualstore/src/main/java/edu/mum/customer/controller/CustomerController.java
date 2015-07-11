package edu.mum.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String add(User user, UserProfile userProfile) {
		
		userService.registerUser(user, userProfile);
		return "redirect:/registration";
	}
}
