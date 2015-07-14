package edu.mum.admin.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.admin.domain.RoleType;
import edu.mum.admin.domain.UserRole;
import edu.mum.customer.domain.User;
import edu.mum.product.domain.Catagory;

@Transactional(propagation=Propagation.REQUIRED)
public class AdminDao implements IAdminDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void saveAdmin(User user) {
		
		sessionFactory.getCurrentSession().save(user);
		UserRole userRole=new UserRole(user.getUsername(),RoleType.ROLE_ADMIN);
		sessionFactory.getCurrentSession().persist(userRole);
	}
	
	public void saveCategory(Catagory category) {

		sessionFactory.getCurrentSession().persist(category);
		
	}

}
