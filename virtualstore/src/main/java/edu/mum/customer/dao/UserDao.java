package edu.mum.customer.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
		
		//User user2=new User("avishek", "password");
		//sessionFactory.getCurrentSession().persist(user2);
		
		sessionFactory.getCurrentSession().save(user);
		//sessionFactory.getCurrentSession().refresh(user);
		userProfile.setId(user.getId());
		//user.setUserProfile(userProfile);
		//userProfile.setUser(user);
		sessionFactory.getCurrentSession().persist(userProfile);
		//sessionFactory.getCurrentSession().save(user);
		
		//User user2=new User("avishek", "password");
		
		//sessionFactory.getCurrentSession().persist(user2);
		
	}

}
