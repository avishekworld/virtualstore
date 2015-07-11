package edu.mum.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.customer.domain.User;
import edu.mum.dao.TestUserDAO;

@Transactional(propagation=Propagation.REQUIRED)
public class TestUserService {
	
	@Autowired
	private TestUserDAO testUserDAO;



	public TestUserDAO getTestUserDAO() {
		return testUserDAO;
	}



	public void setTestUserDAO(TestUserDAO testUserDAO) {
		this.testUserDAO = testUserDAO;
	}






	public void createUser(User u)
	{
		testUserDAO.saveUser(u);
	}

}
