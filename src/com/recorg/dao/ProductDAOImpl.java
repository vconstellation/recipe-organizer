package com.recorg.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.recorg.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getProducts() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Product> theQuery = currentSession.createQuery("from product", Product.class);
		
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
		
		Query theQuery = currentSession.createQuery("delete from product where id=:productId");
		
		theQuery.setParameter("productId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public Product getProduct(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Product theProduct = currentSession.get(Product.class, theId);
		
		return theProduct;
	}

}
