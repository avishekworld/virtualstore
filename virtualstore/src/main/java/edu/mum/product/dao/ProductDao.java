package edu.mum.product.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.Util;

import edu.mum.admin.domain.Utilities;
import edu.mum.product.domain.Catagory;
import edu.mum.product.domain.Product;
import edu.mum.product.domain.ProductMedia;

@Transactional(propagation=Propagation.REQUIRED)
public class ProductDao implements IProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveProduct(Product product, Catagory category,String fileName) {
		
		product.setCatagory(category);
		
		sessionFactory.getCurrentSession().save(product);
		
		if(fileName!=null)
		{
			ProductMedia productMedia=new ProductMedia(product,Utilities.URL+Utilities.UPLOAD_FOLDER_NAME+fileName);
			
			sessionFactory.getCurrentSession().persist(productMedia);
		}
		
		//sessionFactory.getCurrentSession().persist(category);
		
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
