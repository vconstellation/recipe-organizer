package com.recorg.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.recorg.entity.Product;
import com.recorg.entity.RecipeStep;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getProducts() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Product> theQuery = currentSession.createQuery("FROM product", Product.class);
		
		List<Product> theProducts = theQuery.getResultList();
		
		return theProducts;
	}

	@Override
	public void saveProduct(Product theProduct) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theProduct);
	}

	@Override
	public void deleteProduct(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("DELETE FROM product WHERE id=:productId");
		
		theQuery.setParameter("productId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public Product getProduct(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Product theProduct = currentSession.get(Product.class, theId);
		
		return theProduct;
	}

	@Override
	public List<Product> getPaginatedProducts(int min, int max) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Product> theQuery = currentSession.createQuery("FROM product");
		
		theQuery.setFirstResult(min);
		theQuery.setMaxResults(max);
		
		List<Product> products = theQuery.getResultList();
		
		return products;		
	}

	@Override
	public Long getTotalNumber() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Long> theQuery = currentSession.createQuery("SELECT COUNT (r.id) FROM recipe r");
		
		Long totalNumber = theQuery.uniqueResult();
		
		return totalNumber;
	}

}
