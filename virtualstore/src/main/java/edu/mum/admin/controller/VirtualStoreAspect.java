package edu.mum.admin.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import edu.mum.admin.domain.PaymentResponse;
import edu.mum.customer.domain.PaymentInfo;

@Aspect
public class VirtualStoreAspect {
	
	@Around("execution(* edu.mum.admin.controller.PaymentGateway.doPayment(..))")
	public Object calcDuration(ProceedingJoinPoint call) throws Throwable
	{
		PaymentResponse paymentResponse=(PaymentResponse)call.proceed();
		
		if(paymentResponse.isCompleted())
		{
			System.out.println("Product Payment Done. Send EMail to Customer ");
		}
		else 
		{
			System.out.println("Invalid Payment");
		}
		
		return paymentResponse;
	}
	
	@After("execution(* edu.mum.product.service.ProductService.registerProduct(..))")
	public void newProductAdded(JoinPoint joinPoint) {
		
		System.out.println("New Product Arrived. Send EMail to Customer ");
	}
}
