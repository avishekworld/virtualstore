package edu.mum.admin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.customer.domain.User;
import edu.mum.customer.service.IUserService;
import edu.mum.product.domain.Catagory;

@Transactional(propagation=Propagation.REQUIRED)
public interface IAdminService extends IUserService{
	
	public void registerCategory(Catagory category);

}
