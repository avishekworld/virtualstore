package edu.mum.product.service;


import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.product.domain.Order;
import edu.mum.product.domain.Product;
import edu.mum.product.domain.Catagory;
import edu.mum.product.domain.ProductInventory;
import edu.mum.product.domain.ProductJsonObject;

@Transactional(propagation=Propagation.REQUIRES_NEW)
public interface IProductService {
	public  List<Product> getFeaturedProducts();
	public  List<Product> getRelatedProducts();
	public Product getProduct(Long productId);
	public int claculateRatings(Product product);
	public float claculateSubtotatl(Order tempOrder);
	public ProductInventory getProductInventoryByProductId(Long id);
	public void registerProduct(Product product, int catagoryId,int quantity,String fileName);
	public  List<Catagory> getProductCategories();
	public ProductJsonObject getLatesProduct(int newProductId);
	


}
