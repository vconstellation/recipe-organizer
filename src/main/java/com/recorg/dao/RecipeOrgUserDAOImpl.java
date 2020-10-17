package com.recorg.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.recorg.entity.RecipeOrgUser;

@Repository
public class RecipeOrgUserDAOImpl implements RecipeOrgUserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<RecipeOrgUser> getRecipeOrgUsers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<RecipeOrgUser> theQuery = currentSession.createQuery("FROM recipe_org_user", RecipeOrgUser.class);
		
		List<RecipeOrgUser> theUsers = theQuery.getResultList();
		
		return theUsers;
	}

	@Override
	public void saveRecipeOrgUser(RecipeOrgUser theRecipeOrgUser) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theRecipeOrgUser);
	}

	@Override
	public void deleteRecipeOrgUser(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("DELETE FROM recipe_org_user WHERE id=:recipeOrgUserId");
		
		theQuery.setParameter("recipeOrgUserId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public RecipeOrgUser getRecipeOrgUser(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		RecipeOrgUser theRecipeOrgUser = currentSession.get(RecipeOrgUser.class, theId);
		
		return theRecipeOrgUser;
	}

	@Override
	public List<RecipeOrgUser> getPaginatedRecipeOrgUsers(int min, int max) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<RecipeOrgUser> theQuery = currentSession.createQuery("FROM recipe_org_user");
		
		theQuery.setFirstResult(min);
		theQuery.setMaxResults(max);
		
		List<RecipeOrgUser> recipeOrgUsers = theQuery.getResultList();
		
		return recipeOrgUsers;
	}

	@Override
	public Long getTotalNumber() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Long> theQuery = currentSession.createQuery("SELECT COUNT (r.id) FROM recipe_org_user r");
		
		Long totalNumber = theQuery.uniqueResult();
		
		return totalNumber;
	}

}
