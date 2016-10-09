package com.test.microservices.products;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductsRepository extends JpaRepository<Product, Long> {
	
	public Product findByType(String productType);
	public List<Product> findPriceByName(String productName);

	@Query("SELECT count(*) from Product")
	public int countProducts();
}
