package com.recorg.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.recorg.config.HibernateUtil;
import com.recorg.entity.Nutrition;
import com.recorg.entity.Recipe;

@Repository
public class NutritionDAOImpl implements NutritionDAO {
	
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); 

	@Override
	public List<Nutrition> getNutritions() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Nutrition> theQuery = currentSession.createQuery("FROM nutrition", Nutrition.class);
		
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
		
		Query<Recipe> theQuery = currentSession.createQuery("DELETE FROM nutrition WHERE id=:nutritionId");
		
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
