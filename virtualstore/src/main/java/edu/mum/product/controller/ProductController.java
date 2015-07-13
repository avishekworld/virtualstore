package edu.mum.product.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.customer.domain.User;
import edu.mum.product.domain.Order;
import edu.mum.product.domain.OrderLine;
import edu.mum.product.domain.Product;
import edu.mum.product.service.IProductService;

@Controller
public class ProductController {

	
	@Autowired
    private IProductService productService;
	
	//private Order order = new Order();
	
	
	@RequestMapping("/")
    public String redirectRoot(Model model) {
        return "home";
    }
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHome(Model model, HttpServletRequest request) {
        
		
		model.addAttribute("pageTitle", "Home Page");
		model.addAttribute("featuredProducts", productService.getFeaturedProducts());
		model.addAttribute("relatedProducts", productService.getRelatedProducts());
		
		return "home";
    }
	
	@RequestMapping(value = "/productDetails/{productId}", method = RequestMethod.GET)
    public String productDetails(Model model, @PathVariable("productId") Long productId) {
        
		model.addAttribute("pageTitle", "Product Details Page");
		Product product = productService.getProduct( productId);
		int rating = productService.claculateRatings( product);
		model.addAttribute("product", product);
		model.addAttribute("rating", rating);
		
		return "productDetails";
    }
	
	
	
	@RequestMapping(value = "/AddToShoppingCart/{productId}", method = RequestMethod.GET)
    public String shoppingCartAdd(Model model, @PathVariable("productId") Long productId, HttpServletRequest request) {
		
		model.addAttribute("pageTitle", "Your Cart");
		
		Order tempOrder = (Order) request.getSession().getAttribute("order");
		if( tempOrder == null){
			tempOrder = new Order();
			//Current user is hard cooded
			User user = new User();
			user.setId(1L);
			tempOrder.setUser( user );
			
			OrderLine orderLine = new OrderLine();
			orderLine.setOrder(tempOrder);
			orderLine.setProduct( productService.getProduct(productId));
			orderLine.setQuantity( 1);
			
			tempOrder.getOrderLines().add( orderLine);
			request.getSession().setAttribute("order", tempOrder);
			
		}else{
			boolean productAlreadyInShoppingCar = false;
			for (OrderLine orderLine : tempOrder.getOrderLines()) {
				if( orderLine.getProduct().getId() == productId){
					productAlreadyInShoppingCar = true;
					break;
				}
			}
			
			if(  productAlreadyInShoppingCar ){
				//Do nothing, the product is already in the cart 
			}else{
				OrderLine orderLine = new OrderLine();
				orderLine.setOrder( tempOrder);
				orderLine.setProduct( productService.getProduct(productId));
				orderLine.setQuantity( 1);
				
				tempOrder.getOrderLines().add( orderLine);
				request.getSession().setAttribute("order", tempOrder);
			}
		}
		
		return "shoppingCart";
    }
	
	@RequestMapping(value = "/RemoveFromShoppingCart/{productId}", method = RequestMethod.GET)
    public String shoppingCartRemove(Model model, @PathVariable("productId") Long productId, HttpServletRequest request) {
		
		model.addAttribute("pageTitle", "Your Cart");
		
		Order tempOrder = (Order) request.getSession().getAttribute("order");
		if( tempOrder != null){
			//Removing OrderLIne from the product
			int index = 0;
			for (OrderLine orderLine : tempOrder.getOrderLines()) {
				if( orderLine.getProduct().getId() == productId){
					break;
				}
				index++;
			}
			//tempOrder.getOrderLines().remove( productService.getProduct(productId) );
			tempOrder.getOrderLines().remove(index);
			request.getSession().setAttribute("order", tempOrder);
		}
		return "shoppingCart";
    }
	
	@RequestMapping(value = "/ChnageQuantityShoppingCart/{productId}", method = RequestMethod.POST)
    public String shoppingCartChangeQuantity(Model model, @PathVariable("productId") Long productId, HttpServletRequest request,
    										@RequestParam("quantity") int quantity) {
		
		model.addAttribute("pageTitle", "Your Cart");
		
		Order tempOrder = (Order) request.getSession().getAttribute("order");
		if( tempOrder != null){
			//Removing OrderLIne from the product
			int index = 0;
			for (OrderLine orderLine : tempOrder.getOrderLines()) {
				if( orderLine.getProduct().getId() == productId){
					break;
				}
				index++;
			}
			//tempOrder.getOrderLines().remove( productService.getProduct(productId) );
			tempOrder.getOrderLines().get(index).setQuantity( quantity);
			request.getSession().setAttribute("order", tempOrder);
		}
		System.out.println("CHANGE QUANTITY-------------------------");
		return "redirect:/shoppingCart";
    }
	
	@RequestMapping(value = "/shoppingCart")
    public String shoppingCart(Model model, HttpServletRequest request) {
		
		model.addAttribute("pageTitle", "Your Cart");
		
		System.out.println("HERERRRRRRRRRRRRRRRRRRRRRRRR");
		return "shoppingCart";
    }
	
	
}
