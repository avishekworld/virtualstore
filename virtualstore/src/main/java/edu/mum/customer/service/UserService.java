package edu.mum.customer.service;

import edu.mum.customer.dao.IUserDao;
import edu.mum.customer.domain.User;
import edu.mum.customer.domain.UserProfile;

public class UserService implements IUserService {

	private IUserDao userDao;
	

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}



	public void registerUser(User user, UserProfile userProfile) {
		
		userDao.saveUser(user, userProfile);
		
	}

}
