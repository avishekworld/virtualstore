package edu.mum.product.dao;

import java.beans.FeatureDescriptor;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.product.dao.IProductDAO;
import edu.mum.product.domain.Product;

@Transactional(propagation=Propagation.MANDATORY)
public class ProductDAO  implements IProductDAO{
	
	private SessionFactory sessionFactory;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Product> getFeaturedProducts() {
		//ORDER BY P.id DESC LIMIT 9
		String qString = "FROM Product P ";
		Query q = sessionFactory.getCurrentSession().createQuery(qString);
		List<Product> featuredProducts = new ArrayList<Product>();
		
		featuredProducts = q.list();
		
		if( featuredProducts.size() >= 1  ){
			return featuredProducts;
		}
		
		return null;
	}

}
