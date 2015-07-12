package edu.mum.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.product.service.ProductService;
import edu.mum.service.TestUserService;

@Controller
public class ProductController {

	
	@Autowired
    private ProductService productService;
	
	@RequestMapping("/")
    public String redirectRoot(Model model) {
        return "home";
    }
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHome(Model model) {
        
		model.addAttribute("featuredProducts", productService.getFeaturedProducts());
		System.out.println("***** NO OF fetauredProducts  " + productService.getFeaturedProducts().size());
		
		return "home";
    }
	

}
