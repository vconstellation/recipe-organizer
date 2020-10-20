package com.recorg.recipeorganizer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recorg.recipeorganizer.dao.ProductDAO;
import com.recorg.recipeorganizer.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDAO productDAO;

	@Autowired
	public ProductServiceImpl(ProductDAO theProductDAO) {
		productDAO = theProductDAO;
	}

	@Override
	@Transactional
	public List<Product> getProducts() {
		return productDAO.getProducts();
	}

	@Override
	@Transactional
	public void saveProduct(Product theProduct) {
		
		productDAO.saveProduct(theProduct);
	}

	@Override
	@Transactional
	public void deleteProduct(int theId) {

		productDAO.deleteProduct(theId);
	}

	@Override
	@Transactional
	public Product getProduct(int theId) {
		
		return productDAO.getProduct(theId);
	}

	@Override
	@Transactional
	public List<Product> getPaginatedProducts(int min, int max) {
		
		return productDAO.getPaginatedProducts(min, max);
	}

	@Override
	@Transactional
	public Long getTotalNumber() {
		
		return productDAO.getTotalNumber();
	}

}
