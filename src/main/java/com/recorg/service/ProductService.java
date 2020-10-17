package com.recorg.service;

import java.util.List;

import com.recorg.entity.Product;

public interface ProductService {
	
	public List<Product> getProducts();
	
	public List<Product> getPaginatedProducts(int min, int max);
	
	public void saveProduct(Product theProduct);
	
	public void deleteProduct(int theId);
	
	public Product getProduct(int theId);
	
	public Long getTotalNumber();

}
