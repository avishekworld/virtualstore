package edu.mum.service;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.customer.domain.User;
import edu.mum.dao.UserDAO;

@Transactional(propagation=Propagation.REQUIRED)
public class UserService {
	
	private UserDAO userDAO;


	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	


	public UserDAO getUserDAO() {
		return userDAO;
	}




	public void createUser(User u)
	{
		userDAO.saveUser(u);
	}

}
