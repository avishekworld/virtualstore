package edu.mum.product.dao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;






import edu.mum.product.domain.Catagory;
import edu.mum.product.domain.Product;
import edu.mum.product.domain.ProductInventory;
import edu.mum.product.domain.ProductJsonObject;

@Transactional(propagation=Propagation.REQUIRED)
public interface IProductDao {
	
	public void saveProduct(Product product, int category,int quantity,String fileName);
	public  List<Product> getFeaturedProducts();
	public  List<Product> getRelatedProducts();
	public Product getProduct(Long productId);
	public ProductInventory getProductInventoryByProductId(Long productId);
	public  List<Catagory> getCategories();
	public  Catagory getCategory(int catagoryId);
	public ProductJsonObject loadLatestProduct(int newProductId);



}
