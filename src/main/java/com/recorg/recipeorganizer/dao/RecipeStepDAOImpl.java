package com.recorg.recipeorganizer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.recorg.recipeorganizer.entity.RecipeStep;

import javax.persistence.EntityManager;

@Repository
public class RecipeStepDAOImpl implements RecipeStepDAO {

	private EntityManager entityManager;

	@Autowired
	public RecipeStepDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<RecipeStep> getRecipeSteps() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<RecipeStep> theQuery = session.createQuery("FROM RecipeStep");
		
		List<RecipeStep> recipeSteps = theQuery.getResultList();
		
		return recipeSteps;
	}

	@Override
	public RecipeStep getRecipeStep(int theId) {
		
		Session session = entityManager.unwrap(Session.class);
		
		RecipeStep recipeStep = session.get(RecipeStep.class, theId);
		
		return recipeStep;
	}

	@Override
	public List<RecipeStep> getPaginatedRecipeSteps(int min, int max) {

		Session session = entityManager.unwrap(Session.class);
		
		Query<RecipeStep> theQuery = session.createQuery("FROM RecipeStep");
		theQuery.setFirstResult(min);
		theQuery.setMaxResults(max);
		
		List<RecipeStep> recipeSteps = theQuery.getResultList();
		
		return recipeSteps;
	}

	@Override
	public Long getTotalNumber() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<Long> theQuery = session.createQuery("SELECT COUNT (r.id) FROM RecipeStep r");
		
		Long totalNumber = theQuery.uniqueResult();
		
		return totalNumber;
	}

	@Override
	public void saveRecipeStep(RecipeStep theRecipeStep) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.save(theRecipeStep);
		
	}

	@Override
	public void deleteRecipeStep(int theId) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<RecipeStep> theQuery = session.createQuery("DELETE FROM RecipeStep WHERE id = :recipeStepId");
		theQuery.setParameter("recipeStepId", theId);
		
		theQuery.executeUpdate();
	}
	
	

}
