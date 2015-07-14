package edu.mum.customer.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.admin.domain.RoleType;
import edu.mum.admin.domain.UserRole;
import edu.mum.customer.domain.PaymentInfo;
import edu.mum.customer.domain.User;
import edu.mum.customer.domain.UserProfile;
import edu.mum.product.domain.Product;

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
	
	public UserRole loadUserRole(Long userId)
	{
		return (UserRole) sessionFactory.getCurrentSession().get( UserRole.class, userId);
	}

	@Override
	public User getUserByUsername(String username) {
//		String qString = "SELECT password FROM User U WHERE U.username=:UNAME";
//		Query q = sessionFactory.getCurrentSession().createQuery(qString);
//		q.setParameter("UNAME", username);
		//return (String)q.uniqueResult();
		
		String qString = "FROM User U WHERE U.username=:UNAME";
		Query q = sessionFactory.getCurrentSession().createQuery(qString);
		q.setParameter("UNAME", username);
		return (User)q.uniqueResult();
		
	}

	@Override
	public UserProfile getUserProfileByUserId(Long userid) {
		String qString = "FROM User U WHERE U.id=:UPID";
		Query q = sessionFactory.getCurrentSession().createQuery(qString);
		q.setParameter("UPID", userid);
		
		User u=(User)q.uniqueResult();
		UserProfile up=u.getUserProfile();
		
		return up;
	}
	
	public PaymentInfo loadPaymentInfo(Long paymentId)
	{
		return (PaymentInfo) sessionFactory.getCurrentSession().get( PaymentInfo.class, paymentId);
	}
	
	public void savePayment(PaymentInfo paymentInfo)
	{
		sessionFactory.getCurrentSession().persist(paymentInfo);

	}
	
}
