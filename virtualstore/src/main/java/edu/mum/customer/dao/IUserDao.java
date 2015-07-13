package edu.mum.customer.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.customer.domain.User;
import edu.mum.customer.domain.UserProfile;

@Transactional(propagation=Propagation.REQUIRED)
public interface IUserDao {
	
	public void saveUser(User user,UserProfile userProfile);
	public User getUser(Long userId);
}
