package io.pivotal.microservices.products;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.test.microservices.products.Product;
import com.test.microservices.products.ProductsController;
import com.test.microservices.products.ProductsRepository;

public class ProductsControllerTests{

	protected static final String PRODUCT_NAME_1 = "Lenovo";
	protected static final String PRODUCT_TYPE_1 = "Laptops";
	
	protected static final Product theProduct = new Product(PRODUCT_NAME_1,
			PRODUCT_TYPE_1);

	@Autowired
	ProductsController productsController;
	
	protected TestProductsRepository testRepo = new TestProductsRepository();
	
	
	@Test
	public void validProductType() {
		Logger.getGlobal().info("Start validProductType test");
		Product product = productsController.byType(PRODUCT_TYPE_1);

		Assert.assertNotNull(product);
		Assert.assertEquals(PRODUCT_TYPE_1, product.getType());
		Assert.assertEquals(PRODUCT_NAME_1, product.getName());
		Logger.getGlobal().info("End validAccount test");
	}

	@Before
	public void setup() {
		productsController = new ProductsController(testRepo);
	}
	
	protected static class TestProductsRepository implements ProductsRepository {

		@Override
		public Product findByType(String productType) {
			if (productType.equals(PRODUCT_TYPE_1))
				return theProduct;
			else
				return null;
		}
		
		@Override
		public List<Product> findPriceByName(String productName) {
			List<Product> products = new ArrayList<Product>();

			if (PRODUCT_NAME_1.toLowerCase().indexOf(productName.toLowerCase()) != -1)
				products.add(theProduct);
			else
				return null;
			
			return products;
		}

		@Override
		public void deleteAllInBatch() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteInBatch(Iterable<Product> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Product> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Product> findAll(Sort arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Product> findAll(Iterable<Long> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void flush() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Product getOne(Long arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Product> List<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Product> S saveAndFlush(S arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Page<Product> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Product> S save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Product findOne(Long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean exists(Long id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void delete(Long id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Product entity) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Iterable<? extends Product> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int countProducts() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		
	}

	
}
