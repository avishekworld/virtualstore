package edu.mum.product.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import edu.mum.product.dao.IProductDao;
import edu.mum.product.domain.Catagory;
import edu.mum.product.domain.Product;

@Transactional(propagation=Propagation.REQUIRED)
public class ProductService implements IProductService {

	@Autowired
	private IProductDao productDao;
	

	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}

	public void registerProduct(Product product, Catagory category) {
		productDao.saveProduct(product, category);

		
	}

}
