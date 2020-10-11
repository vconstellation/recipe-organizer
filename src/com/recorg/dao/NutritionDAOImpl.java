package com.recorg.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.recorg.entity.Nutrition;

@Repository
public class NutritionDAOImpl implements NutritionDAO {
	
	@Autowired
	private SessionFactory sessionFactory; 

	@Override
	public List<Nutrition> getNutritions() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Nutrition> theQuery = currentSession.createQuery("from nutrition", Nutrition.class);
		
		List<Nutrition> theNutrition = theQuery.getResultList();
		
		return theNutrition;
	}

	//Method used for saving the object in the DB
	@Override
	public void saveNutrition(Nutrition theNutrition) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theNutrition);
	}

	@Override
	public void deleteNutrition(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from nutrition where id=:nutritionId");
		
		theQuery.setParameter("nutritionId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public Nutrition getNutrition(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Nutrition theNutrition = currentSession.get(Nutrition.class, theId);
		
		
		return theNutrition;
	}

}
