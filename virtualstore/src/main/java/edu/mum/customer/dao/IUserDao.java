package edu.mum.customer.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.admin.domain.UserRole;
import edu.mum.customer.domain.PaymentInfo;
import edu.mum.customer.domain.User;
import edu.mum.customer.domain.UserProfile;

@Transactional(propagation=Propagation.REQUIRED)
public interface IUserDao {
	
	public void saveUser(User user,UserProfile userProfile,String roleType);
	public User getUser(Long userId);
	public UserRole loadUserRole(Long userId);
	public User getUserByUsername(String username);
	public UserProfile getUserProfileByUserId(Long id);
	public void savePayment(PaymentInfo paymentInfo);
	public PaymentInfo loadPaymentInfo(Long paymentId);
	
}
