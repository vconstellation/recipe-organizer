package com.recorg.recipeorganizer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.recorg.recipeorganizer.entity.RecipeOrgUser;

import javax.persistence.EntityManager;

@Repository
public class RecipeOrgUserDAOImpl implements RecipeOrgUserDAO {

	private EntityManager entityManager;

	@Autowired
	public RecipeOrgUserDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<RecipeOrgUser> getRecipeOrgUsers() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<RecipeOrgUser> theQuery = currentSession.createQuery("FROM RecipeOrgUser", RecipeOrgUser.class);
		
		List<RecipeOrgUser> theUsers = theQuery.getResultList();
		
		return theUsers;
	}

	@Override
	public void saveRecipeOrgUser(RecipeOrgUser theRecipeOrgUser) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theRecipeOrgUser);
	}

	@Override
	public void deleteRecipeOrgUser(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("DELETE FROM RecipeOrgUser WHERE id=:recipeOrgUserId");
		
		theQuery.setParameter("recipeOrgUserId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public RecipeOrgUser getRecipeOrgUser(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		RecipeOrgUser theRecipeOrgUser = currentSession.get(RecipeOrgUser.class, theId);
		
		return theRecipeOrgUser;
	}

	@Override
	public List<RecipeOrgUser> getPaginatedRecipeOrgUsers(int min, int max) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<RecipeOrgUser> theQuery = currentSession.createQuery("FROM RecipeOrgUser");
		
		theQuery.setFirstResult(min);
		theQuery.setMaxResults(max);
		
		List<RecipeOrgUser> recipeOrgUsers = theQuery.getResultList();
		
		return recipeOrgUsers;
	}

	@Override
	public Long getTotalNumber() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Long> theQuery = currentSession.createQuery("SELECT COUNT (r.id) FROM RecipeOrgUser r");
		
		Long totalNumber = theQuery.uniqueResult();
		
		return totalNumber;
	}

}
