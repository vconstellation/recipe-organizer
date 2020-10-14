package com.recorg.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.recorg.entity.RecipeStep;

@Repository
public class RecipeStepDAOImpl implements RecipeStepDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<RecipeStep> getRecipeSteps() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<RecipeStep> theQuery = session.createQuery("FROM RecipeStep");
		
		List<RecipeStep> recipeSteps = theQuery.getResultList();
		
		return recipeSteps;
	}

	@Override
	public RecipeStep getRecipeStep(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		RecipeStep recipeStep = session.get(RecipeStep.class, theId);
		
		return recipeStep;
	}

	@Override
	public List<RecipeStep> getPaginatedRecipeSteps(int min, int max) {

		Session session = sessionFactory.getCurrentSession();
		
		Query<RecipeStep> theQuery = session.createQuery("FROM RecipeStep");
		theQuery.setFirstResult(min);
		theQuery.setMaxResults(max);
		
		List<RecipeStep> recipeSteps = theQuery.getResultList();
		
		return recipeSteps;
	}

	@Override
	public Long getTotalNumber() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Long> theQuery = session.createQuery("SELECT COUNT (r.id) FROM RecipeStep r");
		
		Long totalNumber = theQuery.uniqueResult();
		
		return totalNumber;
	}

	@Override
	public void saveRecipeStep(RecipeStep theRecipeStep) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(theRecipeStep);
		
	}

	@Override
	public void deleteRecipeStep(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<RecipeStep> theQuery = session.createQuery("DELETE FROM RecipeStep WHERE id = :recipeStepId");
		theQuery.setParameter("recipeStepId", theId);
		
		theQuery.executeUpdate();
	}
	
	

}
