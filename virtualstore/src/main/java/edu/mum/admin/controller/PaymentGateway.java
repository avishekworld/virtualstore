package edu.mum.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import edu.mum.admin.domain.PaymentResponse;
import edu.mum.admin.service.IAdminService;
import edu.mum.customer.domain.PaymentInfo;
import edu.mum.customer.service.IUserService;
import edu.mum.product.domain.ProductJsonObject;

@Controller
@EnableWebMvc
public class PaymentGateway {
	
	@Autowired
    private IUserService userService;
	
	@RequestMapping(value="/rest/paymentrequest", method=RequestMethod.GET,headers = "Accept=application/json",produces = "application/json")
	public @ResponseBody PaymentResponse getPaymentRequest()
	{
		
			return new PaymentResponse("false", "no payment info", 0);
		
	}
	
	@RequestMapping(value="/rest/paymentrequest", method=RequestMethod.POST,headers = "Accept=application/json",produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody PaymentResponse paymentRequest(@RequestBody PaymentInfo paymentInfo,@RequestBody Double amount)
	{
		if(amount<500)
		{
			return new PaymentResponse("true", "charged", System.currentTimeMillis());
		}
		else 
		{
			return new PaymentResponse("false", "amount limit cross", 0);
		}
	}

}
