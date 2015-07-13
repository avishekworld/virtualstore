package edu.mum.product.dao;

import java.util.List;

import edu.mum.product.domain.Product;

public interface IProductDAO {

	//Gets the last nine products
	public List<Product> getFeaturedProducts();
	//Gets products related to what products you have purchased before
	public List<Product> getRelatedProducts();
	public Product getProduct(Long productId);

}
