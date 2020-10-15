package com.recorg.dao;

import java.util.List;

import com.recorg.entity.Product;

public interface ProductDAO {
	
	public List<Product> getProducts();

	public void saveProduct(Product theProduct);

	public void deleteProduct(int theId);

	public Product getProduct(int theId);

	public List<Product> getPaginatedProducts(int min, int max);

	public Long getTotalNumber();

}
