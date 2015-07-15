package edu.mum.review.dao;

import java.util.List;

import edu.mum.customer.domain.User;
import edu.mum.product.domain.Product;
import edu.mum.review.domain.Review;

public interface IReviewDao {
	public void addReview(Review review, User user);
	public List<Review> findByProduct(Product product);
	public Double calculateProductRatings(Product product);
	

}
