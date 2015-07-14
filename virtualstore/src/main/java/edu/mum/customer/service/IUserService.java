package edu.mum.customer.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.customer.domain.User;
import edu.mum.customer.domain.UserProfile;

@Transactional(propagation=Propagation.REQUIRED)
public interface IUserService {
	
	public void registerUser(User user, UserProfile userProfile);
	public User getUser(Long userId);
	public User getUserByUsername(String username);
	public UserProfile getUserProfileByUserId(Long id);

}
