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

import edu.mum.dao.UserDAO;
import edu.mum.domain.User;
import edu.mum.service.UserService;

@Controller
//@RequestMapping(value="/books")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String redirectRoot(Model model) {
    	
    	
        return "index";
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAll(Model model) {
    	
    	User user=userService.getUserDAO().getSampleUser();
    	
    	model.addAttribute("user", user);
    	
    	userService.createUser(user);
    	
        return "login";
    }


    @ExceptionHandler(value = NoSuchResourceException.class)
    public ModelAndView handle(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.getModel().put("e", e);
        mv.setViewName("noSuchResource");
        return mv;
    }
}
