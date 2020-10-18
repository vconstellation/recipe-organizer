package com.recorg.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.recorg.config.HibernateUtil;
import com.recorg.entity.Recipe;

@Repository
public class RecipeDAOImpl implements RecipeDAO {
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public List<Recipe> getRecipes() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Recipe> theQuery = currentSession.createQuery("FROM Recipe", Recipe.class);
		
		List<Recipe> recipes = theQuery.getResultList();
		
		return recipes;
	}

	@Override
	public Recipe getRecipe(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Recipe recipe = currentSession.get(Recipe.class, theId);
		
		return recipe;
	}

	@Override
	public void saveRecipe(Recipe theRecipe) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(theRecipe);

	}

	@Override
	public void deleteRecipe(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Recipe> theQuery = currentSession.createQuery("DELETE FROM Recipe WHERE id = :recipeId");
		theQuery.setParameter("recipeId", theId);
		
		theQuery.executeUpdate();

	}

	@Override
	public List<Recipe> getPaginatedRecipes(int min, int max) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Recipe> theQuery = currentSession.createQuery("FROM Recipe");
		theQuery.setFirstResult(min);
		theQuery.setMaxResults(max);
		
		List<Recipe> recipes = theQuery.getResultList();
		
		return recipes;
	}

	@Override
	public Long getTotalNumber() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Long> theQuery = currentSession.createQuery("SELECT COUNT (r.id) FROM Recipe r");
		
		Long totalNumber = theQuery.uniqueResult();
		
		return totalNumber;
	}

}
