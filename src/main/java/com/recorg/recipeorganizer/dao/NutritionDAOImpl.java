package com.recorg.recipeorganizer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.recorg.recipeorganizer.entity.Nutrition;
import com.recorg.recipeorganizer.entity.Recipe;

import javax.persistence.EntityManager;

@Repository
public class NutritionDAOImpl implements NutritionDAO {
	
	private EntityManager entityManager;

	@Autowired
	public NutritionDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Nutrition> getNutritions() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Nutrition> theQuery = currentSession.createQuery("FROM Nutrition", Nutrition.class);
		
		List<Nutrition> theNutrition = theQuery.getResultList();
		
		return theNutrition;
	}

	//Method used for saving the object in the DB
	@Override
	public void saveNutrition(Nutrition theNutrition) {
		
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theNutrition);
	}

	@Override
	public void deleteNutrition(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Recipe> theQuery = currentSession.createQuery("DELETE FROM Nutrition WHERE id=:nutritionId");
		
		theQuery.setParameter("nutritionId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public Nutrition getNutrition(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);

		Nutrition theNutrition = currentSession.get(Nutrition.class, theId);
		
		
		return theNutrition;
	}

}
