package edu.mum.product.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import edu.mum.product.domain.Catagory;
import edu.mum.product.domain.Product;

@Transactional(propagation=Propagation.REQUIRED)
public interface IProductService {
	
	public void registerProduct(Product product, Catagory category);
	

}
