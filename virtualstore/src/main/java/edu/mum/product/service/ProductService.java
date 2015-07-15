package edu.mum.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.product.dao.IProductDao;
import edu.mum.product.domain.Catagory;
import edu.mum.product.domain.Order;
import edu.mum.product.domain.OrderLine;
import edu.mum.product.domain.Product;
import edu.mum.product.domain.ProductInventory;
import edu.mum.product.domain.ProductJsonObject;
import edu.mum.review.domain.Review;

@Transactional(propagation=Propagation.REQUIRES_NEW)
public class ProductService implements IProductService{
	
	@Autowired
	private IProductDao productDao;
	 
	public ProductService() {
		// TODO Auto-generated constructor stub
	}
	

	public IProductDao getProductDao() {
		return productDao;
	}


	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}

	public ProductJsonObject getLatesProduct(int newProductId)
	{
		return productDao.loadLatestProduct(newProductId);
	}

	public  List<Product> getFeaturedProducts(){
		return productDao.getFeaturedProducts();
	}
	
	
	public  List<Product> getRelatedProducts(){
		return productDao.getRelatedProducts();
	}

	
	public Product getProduct(Long productId) {
		return productDao.getProduct( productId);
	}

	
	public int claculateRatings(Product product) {
		int ratingSum = 0;
		for (Review review : product.getReviews()) {
			ratingSum += review.getRating();
		}
		//Review rating is 
		if( ( ratingSum * 100 ) > 0){
			return ( ratingSum * 100 ) / ( product.getReviews().size() * 10 );
		}
		return 0;
	}
	
	

	public void registerProduct(Product product, int catagoryId,int quantity,String fileName) {
		productDao.saveProduct(product, catagoryId,quantity,fileName);

		
	}


	@Override
	public float claculateSubtotatl(Order order) {
		
		float sum = 0.0F;
		for (OrderLine orderLine : order.getOrderLines()) {
			sum += orderLine.getQuantity() * orderLine.getProduct().getPrice();
		}
		return sum;
	}
	
	public void modifyProduct(Product product) 
	{
		productDao.updateProduct(product);
	}


	@Override
	public ProductInventory getProductInventoryByProductId(Long productId) {
		return productDao.getProductInventoryByProductId(productId);
	}
	
	public  List<Catagory> getProductCategories()
	{
		return productDao.getCategories();
	}




}
