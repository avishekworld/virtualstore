package edu.mum.product.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.product.domain.Product;

@Transactional(propagation=Propagation.MANDATORY)
public class ProductDAO  implements IProductDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Product> getFeaturedProducts() {
		String qString = "FROM Product P ORDER BY P.id DESC";
		Query q = sessionFactory.getCurrentSession().createQuery(qString);
		q.setMaxResults( 9);
		List<Product> featuredProducts = new ArrayList<Product>();
		featuredProducts = q.list();
		
		if( featuredProducts.size() >= 1  ){
			return featuredProducts;
		}
		return null;
	}//End

	@Override
	public List<Product> getRelatedProducts() {
		
		return getFeaturedProducts();
	}

	@Override
	public Product getProduct(Long productId) {
		return (Product) sessionFactory.getCurrentSession().get( Product.class, productId);
	}

}
