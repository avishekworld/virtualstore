package edu.mum.review.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.customer.domain.User;
import edu.mum.product.domain.Product;
import edu.mum.review.domain.Review;

@Transactional(propagation = Propagation.REQUIRED)
public class ReviewDao implements IReviewDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addReview(Review review, User user) {

		review.setUser(user);
		sessionFactory.getCurrentSession().save(review);

	}

	@Override
	public List<Review> findByProduct(Product product) {
		// TODO Auto-generated method stub
		String qString = "FROM Review r Where r.product=:PID";// +product.getId();
		Query q = sessionFactory.getCurrentSession().createQuery(qString);
		q.setParameter("PID", product);
		List<Review> allReviews = new ArrayList<Review>();
		allReviews = q.list();
		return allReviews;
	}

	public Double calculateProductRatings(Product product) {
		String qString = "Select (sum(r.rating)/(count(r.id)*5))*5.00 as total_rating FROM Review r Where r.product=:pid Group by r.product";
		Query q = sessionFactory.getCurrentSession().createQuery(qString);
		q.setParameter("pid", product);
		Double result = (Double) q.uniqueResult();
		System.out.print("\n\n\n\n\n\n\n\nn\n\n-------result--" + result
				+ "-------------\n\n\n\n\nn\n");
		if(result==null)
		{
			result=0d;
		}
		else if(result>0)
		{
			result=Math.round(result*100)/100.0;
		}
		
		return  result;
	}
}
