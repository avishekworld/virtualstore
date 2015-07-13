package edu.mum.review.dao;

import edu.mum.customer.domain.User;
import edu.mum.review.domain.Review;

public interface IReviewDao {
	public void addReview(Review review, User user);
	//public List<Review> findByProduct(Product product);
	

}
