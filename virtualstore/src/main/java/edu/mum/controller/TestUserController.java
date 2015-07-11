package edu.mum.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.customer.domain.User;
import edu.mum.dao.TestUserDAO;
import edu.mum.service.TestUserService;

@Controller
//@RequestMapping(value="/books")
public class TestUserController {

    @Autowired
    private TestUserService testUserService;

    @RequestMapping("/")
    public String redirectRoot(Model model) {
    	
    	
        return "index";
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAll(Model model) {
    	
    	User user=testUserService.getTestUserDAO().getSampleUser();
    	
    	model.addAttribute("user", user);
    	
    	testUserService.createUser(user);
    	
        return "login";
    }
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHome(Model model) {
    	
    	
        return "home";
    }


    @ExceptionHandler(value = NoSuchResourceException.class)
    public ModelAndView handle(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.getModel().put("e", e);
        mv.setViewName("noSuchResource");
        return mv;
    }
}
