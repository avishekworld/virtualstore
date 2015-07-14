package edu.mum.product.service;


import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.product.domain.Order;
import edu.mum.product.domain.Product;
import edu.mum.product.domain.Catagory;
import edu.mum.product.domain.ProductInventory;

@Transactional(propagation=Propagation.REQUIRES_NEW)
public interface IProductService {
	public  List<Product> getFeaturedProducts();
	public  List<Product> getRelatedProducts();
	public Product getProduct(Long productId);
	public int claculateRatings(Product product);
	public void registerProduct(Product product, Catagory category,String fileName);
	public float claculateSubtotatl(Order tempOrder);
	public ProductInventory getProductInventoryByProductId(Long id);
	


}
