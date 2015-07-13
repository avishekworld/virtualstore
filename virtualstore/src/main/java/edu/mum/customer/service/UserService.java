package edu.mum.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.customer.dao.IUserDao;
import edu.mum.customer.domain.User;
import edu.mum.customer.domain.UserProfile;

@Transactional(propagation=Propagation.REQUIRED)
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}



	public void registerUser(User user, UserProfile userProfile) {
		userDao.saveUser(user, userProfile);
		
	}
	
	public User getUser(Long userId) {
		return userDao.getUser(userId);
	}

}
