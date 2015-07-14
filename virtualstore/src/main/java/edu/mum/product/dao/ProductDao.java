package edu.mum.product.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.Util;

import edu.mum.admin.domain.Utilities;
import edu.mum.product.domain.Catagory;
import edu.mum.product.domain.Product;
import edu.mum.product.domain.ProductInventory;
import edu.mum.product.domain.ProductJsonObject;
import edu.mum.product.domain.ProductMedia;

@Transactional(propagation=Propagation.REQUIRED)
public class ProductDao implements IProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public ProductJsonObject loadLatestProduct(int newProductId)
	{
		String qString = "FROM Product P ORDER BY P.id DESC";
		Query q = sessionFactory.getCurrentSession().createQuery(qString);
		q.setMaxResults(newProductId);
		List<Product> newProducts =  q.list();
		
		Product latestProduct=newProducts.get(newProductId-1);
		
		String productDefaultImage="none";
		
		if(latestProduct.getProductMedias().size()>0)
		{
			productDefaultImage=latestProduct.getProductMedias().get(0).getUrl();
		}
		
		return new ProductJsonObject(latestProduct.getId(), latestProduct.getName(), latestProduct.getPrice(), latestProduct.getProductInventory().getQuantity(), productDefaultImage);
	}

	public void saveProduct(Product product, int catagoryId,int quantity,String fileName) {
		
		
		Catagory catagory=getCategory(catagoryId);
		
		ProductInventory productInventory=new ProductInventory(quantity,product);
		
		product.setCatagory(catagory);
		
		sessionFactory.getCurrentSession().save(product);
		
		sessionFactory.getCurrentSession().save(productInventory);
		
		if(fileName!=null)
		{
			ProductMedia productMedia=new ProductMedia(product,Utilities.URL+Utilities.UPLOAD_FOLDER_NAME+fileName);
			
			sessionFactory.getCurrentSession().persist(productMedia);
		}
		
		//sessionFactory.getCurrentSession().persist(category);
		
	}
	
	public  Catagory getCategory(int catagoryId)
	{
		String qString = "FROM Catagory c where c.id="+catagoryId;
		Query q = sessionFactory.getCurrentSession().createQuery(qString);
		Catagory catagory=(Catagory) q.list().get(0);
		return catagory;
	}
	

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


	public List<Product> getRelatedProducts() {
		
		return getFeaturedProducts();
	}

	
	public Product getProduct(Long productId) {
		return (Product) sessionFactory.getCurrentSession().get( Product.class, productId);
	}
	
	public  List<Catagory> getCategories()
	{
		String qString = "FROM Catagory C ";
		Query q = sessionFactory.getCurrentSession().createQuery(qString);
		return q.list();
	}

}
