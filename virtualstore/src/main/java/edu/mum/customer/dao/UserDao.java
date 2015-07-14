package edu.mum.customer.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.admin.domain.RoleType;
import edu.mum.admin.domain.UserRole;
import edu.mum.customer.domain.PaymentInfo;
import edu.mum.customer.domain.User;
import edu.mum.customer.domain.UserProfile;

@Transactional(propagation=Propagation.REQUIRED)
public class UserDao implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveUser(User user, UserProfile userProfile) {
		
		
		sessionFactory.getCurrentSession().save(user);
		userProfile.setId(user.getId());
		sessionFactory.getCurrentSession().persist(userProfile);
		UserRole userRole=new UserRole(user.getUsername(),RoleType.ROLE_USER);
		sessionFactory.getCurrentSession().persist(userRole);

		
	}
	
	public User getUser(Long userId) {
		// TODO Auto-generated method stub
		return (User) sessionFactory.getCurrentSession().get( User.class, userId);
	}
	
	public void savePayment(PaymentInfo paymentInfo)
	{
		sessionFactory.getCurrentSession().persist(paymentInfo);

	}
	
}
