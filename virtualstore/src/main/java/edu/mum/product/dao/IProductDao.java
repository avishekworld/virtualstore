package edu.mum.product.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import edu.mum.product.domain.Catagory;
import edu.mum.product.domain.Product;

@Transactional(propagation=Propagation.REQUIRED)
public interface IProductDao {
	
	public void saveProduct(Product product, Catagory category);

}
