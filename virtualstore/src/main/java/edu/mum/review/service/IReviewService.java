package edu.mum.review.service;

import edu.mum.customer.domain.User;
import edu.mum.product.domain.Product;
import edu.mum.review.domain.Review;

public interface IReviewService {
	public void addReview(Review review,User user);

}
