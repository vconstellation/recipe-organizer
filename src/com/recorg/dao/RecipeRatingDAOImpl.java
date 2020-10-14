package com.recorg.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.recorg.entity.RecipeRating;

@Repository
public class RecipeRatingDAOImpl implements RecipeRatingDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<RecipeRating> getRecipeRatings() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<RecipeRating> theQuery = session.createQuery("FROM RecipeRating");
		
		List<RecipeRating> recipeRatings = theQuery.getResultList();
		
		return recipeRatings;
	}

	@Override
	public RecipeRating getRecipeRating(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		RecipeRating recipeRating = session.get(RecipeRating.class, theId);
		
		return recipeRating;
	}

	@Override
	public List<RecipeRating> getPaginatedRecipeRatings(int min, int max) {

		Session session = sessionFactory.getCurrentSession();
		
		Query<RecipeRating> theQuery = session.createQuery("FROM RecipeRating");
		theQuery.setFirstResult(min);
		theQuery.setMaxResults(max);
		
		List<RecipeRating> recipeRatings = theQuery.getResultList();
		
		return recipeRatings;
	}

	@Override
	public Long getTotalNumber() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Long> theQuery = session.createQuery("SELECT COUNT (r.id) FROM RecipeRating r");
		
		Long totalNumber = theQuery.uniqueResult();
		
		return totalNumber;
	}

	@Override
	public void saveRecipeRating(RecipeRating theRecipeRating) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(theRecipeRating);
		
	}

	@Override
	public void deleteRecipeRating(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<RecipeRating> theQuery = session.createQuery("DELETE FROM RecipeRating WHERE id = :recipeRatingId");
		theQuery.setParameter("recipeRatingId", theId);
		
		theQuery.executeUpdate();
		
	}
	
	

}
