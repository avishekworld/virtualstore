package edu.mum.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.product.dao.IProductDAO;
import edu.mum.product.domain.Product;

@Transactional(propagation=Propagation.REQUIRES_NEW)
public class ProductService {

	private IProductDAO productDAO;
	 
	public ProductService() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductService(IProductDAO pDAO) {
		this.productDAO = pDAO;
	}
	
	public  List<Product> getFeaturedProducts(){
		return productDAO.getFeaturedProducts();
	}
}
