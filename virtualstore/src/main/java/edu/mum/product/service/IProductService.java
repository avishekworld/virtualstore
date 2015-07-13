package edu.mum.product.service;

import java.util.List;

import edu.mum.product.domain.Product;

public interface IProductService {
	public  List<Product> getFeaturedProducts();
	public  List<Product> getRelatedProducts();
	public Product getProduct(Long productId);
	public int claculateRatings(Product product);
	
}
