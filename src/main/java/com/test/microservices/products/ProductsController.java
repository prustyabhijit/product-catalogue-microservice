package com.test.microservices.products;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.microservices.exceptions.RecordNotFoundException;

@RestController
public class ProductsController {

	protected Logger logger = Logger.getLogger(ProductsController.class
			.getName());
	protected ProductsRepository productRepository;

	@Autowired
	public ProductsController(ProductsRepository productRepository) {
		this.productRepository = productRepository;

		logger.info("ProductRepository says system has "
				+ productRepository.countProducts() + " products");
	}

	@RequestMapping("/products/{productType}")
	public Product byType(@PathVariable("productType") String productType) {

		logger.info("products-service byType() invoked: " + productType);
		//Product product = productRepository.findByType(productType);
		Product product = productRepository.findByType(productType);
		logger.info("products-service byType() found: " + product);

		if (product == null)
			throw new RecordNotFoundException(productType);
		else {
			return product;
		}
	}
	
	@RequestMapping(value="/products/create", method = RequestMethod.POST)
	public List<Product> createProduct(@RequestBody Product products) {
		logger.info("products-service createProduct() invoked: " + products);
		productRepository.save(new Product(products.getName(), 
				products.getType(), products.getPrice()));
		return productRepository.findAll();
		
	}
	
	//search product for price
	@RequestMapping("/products/price/{productName}")
	public List<Product> findPriceByName(@PathVariable("productName") String productName) {

		logger.info("products-service findPriceByName() invoked: " + productName);
		//Product product = productRepository.findByType(productType);
		List<Product> product = productRepository.findPriceByName(productName);
		logger.info("products-service findPriceByName() found: " + product);

		if (product == null)
			throw new RecordNotFoundException(productName);
		else {
			return product;
		}
	}
	
	@RequestMapping(value="/products/delete/{productId}", method = RequestMethod.GET)
	public List<Product> deleteProduct(@PathVariable("productId") Long productId) {
		logger.info("products-service deleteProduct() invoked: " + productId);
		productRepository.delete(productId);
		return productRepository.findAll();	 
		 }
	
	}

	

