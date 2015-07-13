package edu.mum.admin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.customer.domain.User;

@Transactional(propagation=Propagation.REQUIRED)
public interface IAdminService {
	
	public void createAdmin(User user);

}
