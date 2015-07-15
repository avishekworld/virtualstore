package edu.mum.admin.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.customer.domain.User;
import edu.mum.customer.domain.UserProfile;
import edu.mum.product.domain.Catagory;

@Transactional(propagation=Propagation.REQUIRED)
public interface IAdminDao {
	
	public void saveCategory(Catagory category);

}
