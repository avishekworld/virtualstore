package edu.mum.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.admin.domain.RoleType;
import edu.mum.admin.domain.UserRole;
import edu.mum.admin.service.IAdminService;
import edu.mum.customer.controller.CustomerController;
import edu.mum.customer.domain.Address;
import edu.mum.customer.domain.User;
import edu.mum.customer.domain.UserProfile;
import edu.mum.product.domain.Catagory;

@Controller
public class AdminController {
	
	@Autowired
    private IAdminService adminService;
	
	@RequestMapping(value = "/createadmin", method = RequestMethod.GET)
    public String getAll(Model model,HttpServletRequest request ) {
    	
		if( request.getSession().getAttribute("islogged") != null && request.getSession().getAttribute("islogged").equals("true")){
					
					UserRole userRole=(UserRole)request.getSession().getAttribute("userRole");
					
					if(userRole.isAdmin())
					{
						return "registration";
					}
					
				}
		
        return "redirect:/home";
    }
	
	@RequestMapping(value="/createadmin", method=RequestMethod.POST)
	public String add(User user,UserProfile userProfile) {
		
		
		adminService.registerUser(user, userProfile, RoleType.ROLE_ADMIN);
		//return "redirect:/adminreg";
		return "redirect:/createadmin";
	}
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
    public String getC(Model model) {
    	
        return "category";
    }
	
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String addCategory( Catagory category) {
		
		
		adminService.registerCategory(category);
		
		return "redirect:/category";
	}

}
