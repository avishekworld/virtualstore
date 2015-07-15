package edu.mum.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.admin.dao.IAdminDao;
import edu.mum.customer.dao.IUserDao;
import edu.mum.customer.domain.User;
import edu.mum.customer.service.UserService;
import edu.mum.product.domain.Catagory;

@Transactional(propagation=Propagation.REQUIRED)
public class AdminService extends UserService implements IAdminService{

	@Autowired
	private IAdminDao adminDao;
	

	
	public IAdminDao getAdminDao() {
		return adminDao;
	}


	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

	
	public void registerCategory(Catagory category) {
		adminDao.saveCategory(category);

	}

}
