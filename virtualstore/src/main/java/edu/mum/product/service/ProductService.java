package edu.mum.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.product.dao.IProductDao;
import edu.mum.product.domain.Catagory;
import edu.mum.product.domain.Product;
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


	@Override
	public  List<Product> getFeaturedProducts(){
		return productDao.getFeaturedProducts();
	}
	
	@Override
	public  List<Product> getRelatedProducts(){
		return productDao.getRelatedProducts();
	}

	@Override
	public Product getProduct(Long productId) {
		return productDao.getProduct( productId);
	}

	@Override
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
	
	

	public void registerProduct(Product product, Catagory category) {
		productDao.saveProduct(product, category);

		
	}

}
