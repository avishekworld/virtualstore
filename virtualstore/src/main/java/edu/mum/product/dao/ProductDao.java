package edu.mum.product.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.product.domain.Catagory;
import edu.mum.product.domain.Product;

@Transactional(propagation=Propagation.REQUIRED)
public class ProductDao implements IProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveProduct(Product product, Catagory category) {
		
		product.setCatagory(category);
		
		sessionFactory.getCurrentSession().persist(product);
		
		//sessionFactory.getCurrentSession().persist(category);
		
	}

}
