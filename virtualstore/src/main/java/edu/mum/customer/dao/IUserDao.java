package edu.mum.customer.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.customer.domain.PaymentInfo;
import edu.mum.customer.domain.User;
import edu.mum.customer.domain.UserProfile;

@Transactional(propagation=Propagation.REQUIRED)
public interface IUserDao {
	
	public void saveUser(User user,UserProfile userProfile);
	public User getUser(Long userId);
	public void savePayment(PaymentInfo paymentInfo);
	public PaymentInfo loadPaymentInfo(Long paymentId);
	
}
