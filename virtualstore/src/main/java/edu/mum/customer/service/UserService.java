package edu.mum.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.admin.domain.UserRole;
import edu.mum.customer.dao.IUserDao;
import edu.mum.customer.domain.PaymentInfo;
import edu.mum.customer.domain.User;
import edu.mum.customer.domain.UserProfile;
import edu.mum.product.domain.Order;

@Transactional(propagation=Propagation.REQUIRED)
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void registerUser(User user, UserProfile userProfile,String roleType) {
		userDao.saveUser(user, userProfile,roleType);
		
	}
	
	public User getUser(Long userId) {
		return userDao.getUser(userId);
	}
	
	public UserRole getUserRole(Long userId)
	{
		return userDao.loadUserRole(userId);
	}
	
	public PaymentInfo getPaymentInfo(Long paymentId)
	{
		return userDao.loadPaymentInfo(paymentId);
	}
	
	public void addPayment(PaymentInfo paymentInfo)
	{
		userDao.savePayment(paymentInfo);
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername( username);
	}

	@Override
	public UserProfile getUserProfileByUserId(Long id) {
		return userDao.getUserProfileByUserId(id);
	}
	
	public void recordOrder(Order order)
	{
		userDao.saveOrder(order);
	}
	
	public List<Order> getAllOrder(User user)
	{
		return userDao.loadAllOrder(user);
	}
	
	
}
