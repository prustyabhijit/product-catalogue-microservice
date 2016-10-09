package io.pivotal.microservices.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.test.microservices.products.ProductsConfiguration;



@SpringBootApplication
@Import(ProductsConfiguration.class)
class ProductsMain {
	public static void main(String[] args) {
		// Tell server to look for accounts-server.properties or
		// accounts-server.yml
		System.setProperty("spring.config.name", "products-server");
		SpringApplication.run(ProductsMain.class, args);
	}
}

