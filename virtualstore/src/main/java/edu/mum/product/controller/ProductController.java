package edu.mum.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import edu.mum.product.domain.Catagory;
import edu.mum.product.domain.Product;
import edu.mum.product.service.IProductService;

@Controller
public class ProductController {

	@Autowired
    private IProductService productService;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getAll(Model model) {
    	
        return "product";
    }
	
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public String add(Product product, Catagory category) {
		
		
		productService.registerProduct(product, category);
		
		return "redirect:/product";
	}
	
	
}
