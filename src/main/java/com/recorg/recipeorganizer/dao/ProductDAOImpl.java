package com.recorg.recipeorganizer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.recorg.recipeorganizer.entity.Product;
import com.recorg.recipeorganizer.entity.RecipeStep;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

@Repository
public class ProductDAOImpl implements ProductDAO {


	private EntityManager entityManager;

	@Autowired
	public ProductDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Product> getProducts() {
		
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Product> theQuery = currentSession.createQuery("FROM Product", Product.class);
		
		List<Product> theProducts = theQuery.getResultList();
		
		return theProducts;
	}

	@Override
	public void saveProduct(Product theProduct) {
		
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theProduct);
	}

	@Override
	public void deleteProduct(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("DELETE FROM Product WHERE id=:productId");
		
		theQuery.setParameter("productId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public Product getProduct(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Product theProduct = currentSession.get(Product.class, theId);
		
		return theProduct;
	}

	@Override
	public List<Product> getPaginatedProducts(int min, int max) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Product> theQuery = currentSession.createQuery("FROM Product");
		
		theQuery.setFirstResult(min);
		theQuery.setMaxResults(max);
		
		List<Product> products = theQuery.getResultList();
		
		return products;		
	}

	@Override
	public Long getTotalNumber() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Long> theQuery = currentSession.createQuery("SELECT COUNT (r.id) FROM Product r");
		
		Long totalNumber = theQuery.uniqueResult();
		
		return totalNumber;
	}

}
