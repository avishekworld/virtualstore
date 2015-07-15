package edu.mum.customer.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.admin.domain.UserRole;
import edu.mum.customer.domain.PaymentInfo;
import edu.mum.customer.domain.User;
import edu.mum.customer.domain.UserProfile;
import edu.mum.product.domain.Order;

@Transactional(propagation=Propagation.REQUIRED)
public interface IUserService {
	
	public void registerUser(User user, UserProfile userProfile, String roleType);
	public User getUser(Long userId);
	public UserRole getUserRole(Long userId);
	public User getUserByUsername(String username);
	public UserProfile getUserProfileByUserId(Long id);
	public PaymentInfo getPaymentInfo(Long paymentId);
	public void addPayment(PaymentInfo paymentInfo);
	public void recordOrder(Order order);
	public List<Order> getAllOrder(User user);

}
