package com.test.microservices.products;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;

	@Id
	protected Long id;

	@Column(name = "name")
	protected String name;
	
	@Column(name = "type")
	protected String type;
	
	protected BigDecimal price;

	protected static Long getNextId() {
		synchronized (nextId) {
			return nextId++;
		}
	}

	protected Product() {
		
	}

	public Product(String name, String type) {
		id = getNextId();
		this.name = name;
		this.type=type;
	}
	
	public Product(String name, String type, BigDecimal price) {
		id = getNextId();
		this.name = name;
		this.type=type;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	
	protected void setId(long id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return name + " [" + type + "]: $" + price;
	}

}
