package edu.mum.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.admin.service.IAdminService;
import edu.mum.customer.domain.Address;
import edu.mum.customer.domain.User;
import edu.mum.customer.domain.UserProfile;

@Controller
public class AdminController {
	
	@Autowired
    private IAdminService adminService;
	
	@RequestMapping(value = "/createadmin", method = RequestMethod.GET)
    public String getAll(Model model) {
    	
        return "adminreg";
    }
	
	@RequestMapping(value="/createadmin", method=RequestMethod.POST)
	public String add(User user) {
		

		adminService.createAdmin(user);
		//return "redirect:/adminreg";
		return "adminreg";
	}

}
