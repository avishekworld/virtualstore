package edu.mum.review.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.customer.domain.User;
import edu.mum.review.domain.Review;

@Transactional(propagation=Propagation.REQUIRED)
public  class ReviewDao implements IReviewDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addReview(Review review, User user) {
		
		review.setUser(user);
		sessionFactory.getCurrentSession().save(review);

	}

}
