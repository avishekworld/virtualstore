package edu.mum.customer.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import edu.mum.admin.domain.PaymentResponse;
import edu.mum.admin.domain.Utilities;
import edu.mum.customer.dao.UserDao;
import edu.mum.customer.domain.Address;
import edu.mum.customer.domain.PayType;
import edu.mum.customer.domain.PaymentInfo;
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
		return "redirect:/registration";
	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String getPayment(Model model) {
    	
        return "addpayment";
    }
	
	
	        
    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String getCheckout(Model model) {
    	
    	//UserProfile userProfile=(UserProfile) request.getSession().getAttribute("userprofile");
    	
		User user=userService.getUser(1L);
		
		model.addAttribute("payments", user.getPaymentInfos());
    	
        return "checkout";
    }
    
    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String doCheckout(Model model,@RequestParam("amount") double amount,@RequestParam("paymentId") long paymentId) {
    	
    	//UserProfile userProfile=(UserProfile) request.getSession().getAttribute("userprofile");

		
		PaymentInfo paymentInfo=userService.getPaymentInfo(paymentId);
		
		RestTemplate paymentRest=new RestTemplate();
		
		PaymentResponse paymentResponse = paymentRest.getForObject(Utilities.URL+"/rest/paymentrequest/"+paymentId+"?amount="+amount, PaymentResponse.class);
		
		//PaymentResponse paymentResponse = paymentRest.postForObject(Utilities.URL+"/rest/paymentrequest", paymentInfo, PaymentResponse.class);
		User user=userService.getUser(1L);
		
		model.addAttribute("payments", user.getPaymentInfos());
		
		model.addAttribute("message", "Payment Status : "+paymentResponse.getPaymentSucess()+" - "+paymentResponse.getMessage());
		
        return "checkout";
    }
	
	@RequestMapping(value="/payment", method=RequestMethod.POST)
	public String addPayment(@RequestParam("cardNumber") String cardNumber,@RequestParam("paymentName") String paymentName,@RequestParam("expireDate") String expireDate,HttpServletRequest request) {
		
		//UserProfile userProfile=(UserProfile) request.getSession().getAttribute("userprofile");
		
		PaymentInfo paymentInfo=new PaymentInfo();
		paymentInfo.setCardNumber(cardNumber);
		paymentInfo.setPaymentName(paymentName);
		
		Date date=new Date();

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try 
		{
			date = formatter.parse(expireDate);
		} 
		catch (ParseException e) 
		{
			
			e.printStackTrace();
		}
		
		paymentInfo.setExpireDate(date);
		
		User user=userService.getUser(1L);
		
		UserProfile userProfile=user.getUserProfile();
		
		paymentInfo.setUser(userService.getUser(userProfile.getId()));
		
		paymentInfo.setPaymentAddress(userProfile.getBillingAddress());
		
		paymentInfo.setPayType(PayType.CREDIT_CARD);
		
		userService.addPayment(paymentInfo);
		
		return "addpayment";
	}
}
